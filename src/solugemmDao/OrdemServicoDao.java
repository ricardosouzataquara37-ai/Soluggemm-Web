/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solugemmDao;

import br.com.solugem.model.Conexao;
import br.com.solugem.model.FuncionarioServico;
import br.com.solugem.model.MaterialUtilizado;
import br.com.solugem.model.OrdemServico;
import br.com.solugem.model.ServicoConcluido;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author principal
 */
public class OrdemServicoDao {
    
     private static List<OrdemServico> listaOs = new ArrayList<>();  
   /**  
     public void salvar(OrdemServico os){
         listaOs.add(os);
     } */
     // -----------------------------------------------------------
     
     
    public boolean salvarOs(OrdemServico os) {
         String sqlEndereco = "INSERT INTO endereco (cep,rua,numero,bairro,cidade,Estado,casa,numeroApartamento,bloco) VALUES (?,?,?,?,?,?,?,?,?)";
         String sqlOS = "INSERT INTO ordem_servicos_agendado(data,idEmpresa,idEndereco,idCliente) VALUES (?,?,?,?)";
         String sqlMat = "INSERT INTO material_utilizado (precoMaterial, qtdMaterial, idOS, idMaterial) VALUES ( ?, ?, ?, ?)";
         String sqlServ = "INSERT INTO servico_concluido (qtdTipoServico, preco, idOS, idTDS) VALUES ( ?, ?, ?, ?)";
         String sqlFunc = "INSERT INTO funcionario_servico (horaInicioServico, horaFimServico, observacaoDoFuncionario, idOS, idFuncionario) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = Conexao.getConnection()) {
        conn.setAutoCommit(false); // Inicia a transação

        // 1. Salvar Endereço e pegar ID
        int idEnderecoGerado = 0;
        try (PreparedStatement psEnd = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS)) {
            psEnd.setString(1, os.getEndereco().getCep());
            psEnd.setString(2, os.getEndereco().getRua());
            psEnd.setString(3, os.getEndereco().getNumero());
            psEnd.setString(4, os.getEndereco().getBairro());
            psEnd.setString(5, os.getEndereco().getCidade());
            psEnd.setString(6, os.getEndereco().getEstado());
            psEnd.setString(7, os.getEndereco().getCasa());
            psEnd.setString(8, os.getEndereco().getNumeroApartamento());
            psEnd.setString(9, os.getEndereco().getBloco());
            psEnd.executeUpdate();
            try (ResultSet rs = psEnd.getGeneratedKeys()) {
                if (rs.next()) idEnderecoGerado = rs.getInt(1);
            }
        }

        // 2. Salvar OS e pegar ID (usando idEnderecoGerado)
        int idOSGerado = 0;
        try (PreparedStatement psOS = conn.prepareStatement(sqlOS, Statement.RETURN_GENERATED_KEYS)) {
            psOS.setDate(1, java.sql.Date.valueOf(os.getData())); // Verifique se sua data é LocalDate
          //  psOS.setDouble(2, os.getTotalMaoObramaterial());
            psOS.setInt(2, os.getEmpresa().getIdEmpresa());
            psOS.setInt(3, idEnderecoGerado);
            psOS.setInt(4, os.getCliente().getIdCliente());
            psOS.executeUpdate();
            try (ResultSet rs = psOS.getGeneratedKeys()) {
                if (rs.next()) idOSGerado = rs.getInt(1);
            }
        }

        // 3. Salvar Materiais (usando idOSGerado)
        try (PreparedStatement psMat = conn.prepareStatement(sqlMat)) {
            for (MaterialUtilizado m : os.listarMaterial()) {
                psMat.setDouble(1, m.getPrecoMaterial());
                psMat.setInt(2, m.getQtdMaterial());
               // psMat.setDouble(3, m.getTotalMaterialUtilizado());
                psMat.setInt(3, idOSGerado);
                psMat.setInt(4, m.getMaterial().getIdMaterial());
                psMat.addBatch(); // Otimização: adiciona ao lote
            }
            psMat.executeBatch();
        }

        // 4. Salvar Serviços (usando idOSGerado)
        try (PreparedStatement psServ = conn.prepareStatement(sqlServ)) {
            for (ServicoConcluido s : os.listarServico()) {
                psServ.setInt(1, s.getQtdTipoServico());
                psServ.setDouble(2, s.getPreco());
              //  psServ.setDouble(3, s.getTotalMaoObra());
                psServ.setInt(3, idOSGerado);
                psServ.setInt(4, s.getTipoServico().getIdTds());
                psServ.addBatch();
            }
            psServ.executeBatch();
        }

        // 5. Salvar Funcionários (usando idOSGerado)
        try (PreparedStatement psFunc = conn.prepareStatement(sqlFunc)) {
            for (FuncionarioServico f : os.listarFuncServ()) {
                psFunc.setString(1, f.getHoraInicioServico());
                psFunc.setString(2, f.getHoraFimServico());
                psFunc.setString(3, f.getObservacaoFuncionario());
                psFunc.setInt(4, idOSGerado);
                psFunc.setInt(5, f.getFuncionario().getIdFuncionario());
                psFunc.addBatch();
            }
            psFunc.executeBatch();
        }

         conn.commit(); // Salva tudo no banco
         return true;
         

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao salvar OS completa: " + e.getMessage());
    }
}
     
    
    
    
    
    
}
