/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solugemmDao;

import br.com.solugem.model.Cargo;
import br.com.solugem.model.Conexao;
import br.com.solugem.model.Empresa;
import br.com.solugem.model.Endereco;
import br.com.solugem.model.Funcionario;
import br.com.solugem.model.Telefone;
//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author principal
 */
public class FuncionarioDao {
   
    public void salvar(Funcionario funcionario) {
    String sqlFuncionario = "INSERT INTO funcionario (nome,matricula,identificacao,telefone,dataNascimento,sexo,idade,email, idCargo, idEmpresa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
    String sqlEndereco = "INSERT INTO endereco (cep,rua,numero,bairro, cidade,estado,casa,numeroApartamento,bloco, idFuncionario) VALUES (?, ?, ?,?,?,?,?,?,?,?)";
    
    Connection conn = null;
    try {
        conn = Conexao.getConnection();
        conn.setAutoCommit(false); 
        
        int idCargo = funcionario.getCargo().getIdCardo();
        int idEmpresa = funcionario.getEmpresa().getIdEmpresa();

      
        PreparedStatement psFunc = conn.prepareStatement(sqlFuncionario, Statement.RETURN_GENERATED_KEYS);
        psFunc.setString(1, funcionario.getNome());
        psFunc.setString(2, funcionario.getMatricula());
        psFunc.setString(3, funcionario.getIdentificacao());
        psFunc.setString(4, funcionario.getTel());
        psFunc.setDate(5, java.sql.Date.valueOf(funcionario.getDataNascimento()));
        psFunc.setString(6, funcionario.getSexo());
        psFunc.setInt(7, funcionario.getIdade());
        psFunc.setString(8, funcionario.getEmail());

        psFunc.setInt(9, idCargo);
        psFunc.setInt(10, idEmpresa);
        psFunc.executeUpdate();

       
        ResultSet rs = psFunc.getGeneratedKeys();
        int idFuncionario = 0;
        if (rs.next()) idFuncionario = rs.getInt(1);

       
        PreparedStatement psEnd = conn.prepareStatement(sqlEndereco);
        psEnd.setString(1, funcionario.getEndereco().getCep());
        psEnd.setString(2, funcionario.getEndereco().getRua());
        psEnd.setString(3, funcionario.getEndereco().getNumero());
        psEnd.setString(4, funcionario.getEndereco().getBairro());
        psEnd.setString(5, funcionario.getEndereco().getCidade());
        psEnd.setString(6, funcionario.getEndereco().getEstado());
        psEnd.setString(7, funcionario.getEndereco().getCasa());
        psEnd.setString(8, funcionario.getEndereco().getNumeroApartamento());
        psEnd.setString(9, funcionario.getEndereco().getBloco());
        psEnd.setInt(10, idFuncionario);
        psEnd.executeUpdate();

        conn.commit(); 
    } catch (SQLException e) {
        if (conn != null) try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        throw new RuntimeException("Erro ao salvar funcionário: " + e.getMessage());
    } finally {
        
    }
}
    
    
    
   public List<Funcionario> consultarTodos() {
    String sql = "SELECT f.*, c.nomeCargo, e.razaoSocial,end.idEndereco, end.cep, end.rua,end.numero,end.bairro, end.cidade,end.Estado,end.casa,end.numeroApartamento,end.bloco " +
                 "FROM funcionario f " +
                 "JOIN cargo c ON f.idCargo = c.idCargo " +
                 "JOIN empresa e ON f.idEmpresa = e.idEmpresa " +
                 "JOIN endereco end ON f.idFuncionario = end.idFuncionario";
       
       
    List<Funcionario> lista = new ArrayList<>();

    
    try (Connection conn = Conexao.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Funcionario f = new Funcionario();
            
            f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setNome(rs.getString("nome"));
            f.setMatricula(rs.getString("matricula"));
            f.setIdentificacao(rs.getString("identificacao"));
            java.sql.Date dataSql = rs.getDate("dataNascimento");
            if (dataSql != null) {
                // A conversão acontece aqui:
                LocalDate dataNascimento = dataSql.toLocalDate();
                f.setDataNascimento(dataNascimento);
            }
            f.setSexo(rs.getString("sexo"));
            f.setIdade(rs.getInt("idade"));
            f.setEmail(rs.getString("email"));
            f.setSenha(rs.getString("senha"));
            
            Empresa empresa = new Empresa();
            empresa.setRazaoSocial(rs.getString("razaoSocial"));
            
            Cargo cargo = new Cargo();
            cargo.setCargo(rs.getString("nomeCargo"));
            
            Endereco endereco = new Endereco();
            endereco.setCep(rs.getString("cep"));
            endereco.setRua(rs.getString("rua"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));
            endereco.setCasa(rs.getString("casa"));
            endereco.setNumeroApartamento(rs.getString("numeroApartamento"));
            endereco.setBloco(rs.getString("bloco"));
            
            f.setEmpresa(empresa);
            f.setCargo(cargo);
            f.setEndereco(endereco);
            
            lista.add(f);
            
            
        
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar funcionários: " + e.getMessage());
    }
    
    return lista;
}
    
  public Funcionario consultar(String matricula) {
            String sql = "SELECT f.*, c.nomeCargo, e.razaoSocial,end.idEndereco, end.cep, end.rua,end.numero,end.bairro, end.cidade,end.Estado,end.casa,end.numeroApartamento,end.bloco " +
                 "FROM funcionario f " +
                 "JOIN cargo c ON f.idCargo = c.idCargo " +
                 "JOIN empresa e ON f.idEmpresa = e.idEmpresa " +
                 "JOIN endereco end ON f.idFuncionario = end.idFuncionario " +
                 "WHERE f.matricula = ?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

      
        ps.setString(1, matricula);
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
               
                Funcionario f = new Funcionario();
                
               f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setNome(rs.getString("nome"));
            f.setMatricula(rs.getString("matricula"));
            f.setIdentificacao(rs.getString("identificacao"));
            f.setTel(rs.getString("telefone"));
            java.sql.Date dataSql = rs.getDate("dataNascimento");
            if (dataSql != null) {
               
                LocalDate dataNascimento = dataSql.toLocalDate();
                f.setDataNascimento(dataNascimento);
            }
            f.setSexo(rs.getString("sexo"));
            f.setIdade(rs.getInt("idade"));
            f.setEmail(rs.getString("email"));
            f.setSenha(rs.getString("senha"));
            
            Empresa empresa = new Empresa();
            empresa.setRazaoSocial(rs.getString("razaoSocial"));
            
            Cargo cargo = new Cargo();
            cargo.setCargo(rs.getString("nomeCargo"));
            
            Endereco endereco = new Endereco();
            endereco.setCep(rs.getString("cep"));
            endereco.setRua(rs.getString("rua"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));
            endereco.setCasa(rs.getString("casa"));
            endereco.setNumeroApartamento(rs.getString("numeroApartamento"));
            endereco.setBloco(rs.getString("casa"));
            
            f.setEmpresa(empresa);
            f.setCargo(cargo);
            f.setEndereco(endereco);
                
                return f; 
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar funcionário pela matrícula: " + e.getMessage());
    }
    
    return null; 
}
 public Funcionario consultarUsuario(String matricula, String senha) {
    
    String sql = "SELECT  * FROM funcionario f  WHERE f.matricula = ? AND f.senha = ?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, matricula);
        ps.setString(2, senha); 
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Funcionario f = new Funcionario();
                
                  f.setIdFuncionario(rs.getInt("idFuncionario"));
                  f.setNome(rs.getString("nome"));
                  f.setMatricula(rs.getString("matricula"));
                  f.setIdentificacao(rs.getString("identificacao"));
                 
                  f.setSenha(rs.getString("senha"));
                return f;
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao autenticar usuário: " + e.getMessage());
    }
    
    return null; 
}
    
   // Update 
   public void atualizar(Funcionario funcionario) {
    String sqlFuncionario = "UPDATE funcionario SET nome = ?, matricula = ?,identificacao = ?,telefone = ?, dataNascimento = ?,sexo = ?,idade = ?,email = ?,idCargo = ?,idEmpresa = ? WHERE idFuncionario = ?";
    String sqlEndereco = "UPDATE endereco SET cep = ?, rua = ?,numero = ?,bairro = ?, cidade = ?,estado = ?,casa = ?,numeroApartamento = ?,bloco = ? WHERE idFuncionario = ?";
    Connection conn = null;
    try  {
        conn = Conexao.getConnection();
        conn.setAutoCommit(false); 

        try (PreparedStatement ps = conn.prepareStatement(sqlFuncionario)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getMatricula());
            ps.setString(3, funcionario.getIdentificacao());
            ps.setString(4, funcionario.getTel());
            ps.setDate(5, java.sql.Date.valueOf(funcionario.getDataNascimento()));
            ps.setString(6, funcionario.getSexo());
            ps.setInt(7, funcionario.getIdade());
            ps.setString(8, funcionario.getEmail());
            ps.setInt(9, funcionario.getCargo().getIdCardo());
            ps.setInt(10, funcionario.getEmpresa().getIdEmpresa());
            ps.setInt(11, funcionario.getIdFuncionario()); 
            ps.executeUpdate();
        }

        try (PreparedStatement psEnd = conn.prepareStatement(sqlEndereco)) {
            psEnd.setString(1, funcionario.getEndereco().getCep());
            psEnd.setString(2, funcionario.getEndereco().getRua());
            psEnd.setString(3, funcionario.getEndereco().getNumero());
            psEnd.setString(4, funcionario.getEndereco().getBairro());
            psEnd.setString(5, funcionario.getEndereco().getCidade());
            psEnd.setString(6, funcionario.getEndereco().getEstado());
            psEnd.setString(7, funcionario.getEndereco().getCasa());
            psEnd.setString(8, funcionario.getEndereco().getNumeroApartamento());
            psEnd.setString(9, funcionario.getEndereco().getBloco());
            
            psEnd.setInt(10, funcionario.getIdFuncionario());
            psEnd.executeUpdate();
        }

        conn.commit(); 
        System.out.println("Dados atualizados com sucesso!");

    } catch (SQLException e) {
        // Se algo der errado, desfaz tudo para evitar inconsistência
        try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage());
    }
}

    
 public void remover(int idFuncionario) {
    String sqlEndereco = "DELETE FROM endereco WHERE idFuncionario = ?";
    String sqlFuncionario = "DELETE FROM funcionario WHERE idFuncionario = ?";

    try (Connection conn = Conexao.getConnection()) {
        conn.setAutoCommit(false); 

       
        try (PreparedStatement psEnd = conn.prepareStatement(sqlEndereco)) {
            psEnd.setInt(1, idFuncionario);
            psEnd.executeUpdate();
        }

       
        try (PreparedStatement psFunc = conn.prepareStatement(sqlFuncionario)) {
            psFunc.setInt(1, idFuncionario);
            psFunc.executeUpdate();
        }

        conn.commit(); 
        System.out.println("Funcionário removido com sucesso!");

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao remover funcionário: " + e.getMessage());
    }
}   

 
    
    
}
