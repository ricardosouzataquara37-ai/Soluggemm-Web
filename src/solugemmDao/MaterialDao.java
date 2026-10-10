/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solugemmDao;

import br.com.solugem.model.Conexao;
import br.com.solugem.model.Fabricante;
import br.com.solugem.model.Material;
//import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.sql.Connection; // O IMPORT CORRETO
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author principal
 */
public class MaterialDao {
    
    private static List <Material> listaMaterial = new ArrayList<>();
    
    public void salvarMaterialComFabricante(Material material) {
    String sqlFabricante = "INSERT INTO fabricante (nome, cnpj) VALUES (?, ?)";
    String sqlMaterial = "INSERT INTO material (nome, preco, codigo, idFabricante) VALUES (?, ?, ?, ?)";

    try (java.sql.Connection conn = Conexao.getConnection()) {
        conn.setAutoCommit(false); // Inicia a transação

       
        int idFabricanteGerado = 0;
        try (java.sql.PreparedStatement psFab = conn.prepareStatement(sqlFabricante, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            psFab.setString(1, material.getFabricante().getNome());
            psFab.setString(2, material.getFabricante().getCnpj());
            psFab.executeUpdate();

            try (java.sql.ResultSet rs = psFab.getGeneratedKeys()) {
                if (rs.next()) {
                    idFabricanteGerado = rs.getInt(1);
                }
            }
        }

        
        try (java.sql.PreparedStatement psMat = conn.prepareStatement(sqlMaterial)) {
            psMat.setString(1, material.getNome());
            psMat.setDouble(2, material.getPreco());
            psMat.setString(3, material.getCodigo());
            psMat.setInt(4, idFabricanteGerado);
            psMat.executeUpdate();
        }

        conn.commit(); 
        System.out.println("Material e Fabricante salvos com sucesso!");

    } catch (java.sql.SQLException e) {
        
        throw new RuntimeException("Erro ao salvar: " + e.getMessage());
    }
}
   
public List<Material> consultarTodos() {
    // Usamos um JOIN para unir as tabelas material e fabricante
    String sql = "SELECT m.idMaterial, m.nome, m.preco, m.codigo, f.idFabricante AS id_fabricante, f.nome AS nome_fabricante, f.cnpj " +
                 "FROM material m " +
                 "JOIN fabricante f ON m.idFabricante = f.idFabricante";

    List<Material> lista = new ArrayList<>();

    try (Connection conn = Conexao.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            // 1. Criamos o Fabricante
            Fabricante fab = new Fabricante();
            fab.setIdFabricante(rs.getInt("id_fabricante"));
            fab.setNome(rs.getString("nome_fabricante"));
            fab.setCnpj(rs.getString("cnpj"));

            Material m = new Material();
            m.setIdMaterial(rs.getInt("idMaterial"));
            m.setNome(rs.getString("nome"));
            m.setPreco(rs.getDouble("preco"));
            m.setCodigo(rs.getString("codigo"));
            m.setFabricante(fab); // Associando o objeto criado acima

            lista.add(m);
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar materiais no banco: " + e.getMessage());
    }

    return lista;
}    
 //qqq   
   public Material consultar(String codigo) {
    String sql = "SELECT m.idMaterial, m.nome, m.preco, m.codigo, f.idFabricante AS id_fabricante, f.nome AS nome_fabricante, f.cnpj " +
                 "FROM material m " +
                 "JOIN fabricante f ON m.idFabricante = f.idFabricante " +
                 "WHERE m.codigo = ?";

    try (java.sql.Connection conn = Conexao.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, codigo);

        try (java.sql.ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
               
                Fabricante fab = new Fabricante();
                fab.setIdFabricante(rs.getInt("id_fabricante"));
                fab.setNome(rs.getString("nome_fabricante"));
                fab.setCnpj(rs.getString("cnpj"));

                Material m = new Material();
                m.setIdMaterial(rs.getInt("idMaterial"));
                m.setNome(rs.getString("nome"));
                m.setPreco(rs.getDouble("preco"));
                m.setCodigo(rs.getString("codigo"));
                m.setFabricante(fab);

                return m;
            }
        }
    } catch (java.sql.SQLException e) {
        throw new RuntimeException("Erro ao buscar material pelo código: " + e.getMessage());
    }

    return null; // Retorna null se não encontrar nenhum material com esse código
}
 //qqq   
 public void atualizar(Material material) {
    String sqlMaterial = "UPDATE material SET nome = ?, preco = ?, codigo = ? WHERE idMaterial = ?";
    String sqlFabricante = "UPDATE fabricante SET nome = ?, cnpj = ? WHERE idFabricante = ?";

    try (java.sql.Connection conn = Conexao.getConnection()) {
        conn.setAutoCommit(false); 

       
        try (java.sql.PreparedStatement psFab = conn.prepareStatement(sqlFabricante)) {
            psFab.setString(1, material.getFabricante().getNome());
            psFab.setString(2, material.getFabricante().getCnpj());
            psFab.setInt(3, material.getFabricante().getIdFabricante());
            psFab.executeUpdate();
        }

        try (java.sql.PreparedStatement psMat = conn.prepareStatement(sqlMaterial)) {
            psMat.setString(1, material.getNome());
            psMat.setDouble(2, material.getPreco());
            psMat.setString(3, material.getCodigo());
            psMat.setInt(4, material.getIdMaterial()); 
            psMat.executeUpdate();
        }

        conn.commit(); 
        System.out.println("Material e Fabricante atualizados com sucesso!");

    } catch (java.sql.SQLException e) {
        throw new RuntimeException("Erro ao atualizar material no banco: " + e.getMessage());
    }
}
 //qqq
     public void remover(int idMaterial) {
    String sql = "DELETE FROM material WHERE idMaterial = ?";

    try (java.sql.Connection conn = Conexao.getConnection();
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idMaterial);
        
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
