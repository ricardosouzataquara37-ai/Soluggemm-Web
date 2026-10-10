/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solugemmDao;

import br.com.solugem.model.Conexao;
import br.com.solugem.model.TipoDeServico;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class TipoDeServicoDao {
    private static List<TipoDeServico> tds = new ArrayList<>();
 

public void salvar(TipoDeServico tipoServ) {
   
    String sql = "INSERT INTO tipo_de_servico (descricao, codigo, precoServico) VALUES (?, ?, ?)";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, tipoServ.getDescricao());
        ps.setString(2, tipoServ.getCodigo());
        ps.setDouble(3, tipoServ.getPrecoServico());

        ps.executeUpdate();
        System.out.println("Tipo de Serviço salvo com sucesso no banco!");

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao salvar tipo de serviço no banco: " + e.getMessage());
    }
}
   
public List<TipoDeServico> consultarTodos(String codigo) {
    String sql = "SELECT * FROM tipo_de_servico WHERE codigo = ?";
    List<TipoDeServico> lista = new ArrayList<>();

    try (Connection conn = Conexao.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, codigo);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoDeServico tds = new TipoDeServico();
                
                // Mapeamento dos campos do banco para o objeto
                tds.setIdTds(rs.getInt("idTDS"));
                tds.setDescricao(rs.getString("descricao"));
                tds.setCodigo(rs.getString("codigo"));
                tds.setPrecoServico(rs.getDouble("precoServico"));
                
                lista.add(tds);
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar tipos de serviço: " + e.getMessage());
    }

    return lista;
}
 
    public List<TipoDeServico> consultarTodos() {
    String sql = "SELECT * FROM tipo_de_servico";
    List<TipoDeServico> lista = new ArrayList<>();

    try (java.sql.Connection conn = Conexao.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql);
         java.sql.ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            TipoDeServico tds = new TipoDeServico();
            tds.setIdTds(rs.getInt("idTDS"));
            tds.setDescricao(rs.getString("descricao"));
            tds.setCodigo(rs.getString("codigo"));
            tds.setPrecoServico(rs.getDouble("precoServico"));
            
            lista.add(tds);
        }
    } catch (java.sql.SQLException e) {
        throw new RuntimeException("Erro ao buscar todos os tipos de serviço: " + e.getMessage());
    }

    return lista;
}

   public TipoDeServico consultar(String codigo) {
    String sql = "SELECT * FROM tipo_de_servico WHERE codigo = ?";

    try (java.sql.Connection conn = Conexao.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, codigo);

        try (java.sql.ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                // Instancia o objeto e preenche com os dados encontrados
                TipoDeServico tds = new TipoDeServico();
                tds.setIdTds(rs.getInt("idTDS"));
                tds.setDescricao(rs.getString("descricao"));
                tds.setCodigo(rs.getString("codigo"));
                tds.setPrecoServico(rs.getDouble("precoServico"));
                
                return tds;
            }
        }
    } catch (java.sql.SQLException e) {
        throw new RuntimeException("Erro ao buscar tipo de serviço pelo código: " + e.getMessage());
    }

    return null; 
}
 
 public void atualizar(TipoDeServico tipoServico) {
    String sql = "UPDATE tipo_de_servico SET descricao = ?, codigo = ?, precoServico = ? WHERE idTDS = ?";

    try (java.sql.Connection conn = Conexao.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, tipoServico.getDescricao());
        ps.setString(2, tipoServico.getCodigo());
        ps.setDouble(3, tipoServico.getPrecoServico());
        
        ps.setInt(4, tipoServico.getIdTds());

        int linhasAfetadas = ps.executeUpdate();
        
        if (linhasAfetadas > 0) {
            System.out.println("Serviço atualizado com sucesso no banco!");
        } else {
            System.out.println("Nenhum serviço encontrado com esse ID para atualizar.");
        }

    } catch (java.sql.SQLException e) {
        throw new RuntimeException("Erro ao atualizar serviço no banco: " + e.getMessage());
    }
}
 
   public void remover(int idServico) {
    String sql = "DELETE FROM tipo_de_servico WHERE idTDS = ?";

    try (java.sql.Connection conn = Conexao.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idServico);
        
        int linhasAfetadas = ps.executeUpdate();
        
        if (linhasAfetadas > 0) {
            System.out.println("Material removido com sucesso!");
        } else {
            System.out.println("Nenhum material encontrado com este ID.");
        }

    } catch (java.sql.SQLException e) {
        throw new RuntimeException("Erro ao remover material: " + e.getMessage());
    }
}
 
 



}

