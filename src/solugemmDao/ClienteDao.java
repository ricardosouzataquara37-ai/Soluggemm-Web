/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solugemmDao;

import br.com.solugem.model.Cliente;
import br.com.solugem.model.Conexao;
import br.com.solugem.model.Endereco;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author principal
 */
public class ClienteDao {
    
    
    public void salvar(Cliente cliente) {
    String sqlCliente = "INSERT INTO cliente (nome,identificacao,telefone,dataNascimento,idade,sexo,email) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String sqlEndereco = "INSERT INTO endereco (cep,rua,numero,bairro, cidade,estado,casa,numeroApartamento,bloco, idCliente) VALUES (?, ?, ?,?,?,?,?,?,?,?)";
    
    Connection conn = null;
    try {
        conn = Conexao.getConnection();
        conn.setAutoCommit(false); 

        PreparedStatement psCli = conn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
        psCli.setString(1, cliente.getNome());
        psCli.setString(2, cliente.getCPF());
        psCli.setString(3, cliente.getTel());
        psCli.setDate(4, java.sql.Date.valueOf(cliente.getDataNascimento()));
        psCli.setInt(5, cliente.getIdade());
        psCli.setString(6, cliente.getSexo());
        psCli.setString(7, cliente.getEmail());

        psCli.executeUpdate();

       
        ResultSet rs = psCli.getGeneratedKeys();
        int idCliente = 0;
        if (rs.next()) idCliente = rs.getInt(1);

       
        PreparedStatement psEnd = conn.prepareStatement(sqlEndereco);
        psEnd.setString(1, cliente.getEndereco().getCep());
        psEnd.setString(2, cliente.getEndereco().getRua());
        psEnd.setString(3, cliente.getEndereco().getNumero());
        psEnd.setString(4, cliente.getEndereco().getBairro());
        psEnd.setString(5, cliente.getEndereco().getCidade());
        psEnd.setString(6, cliente.getEndereco().getEstado());
        psEnd.setString(7, cliente.getEndereco().getCasa());
        psEnd.setString(8, cliente.getEndereco().getNumeroApartamento());
        psEnd.setString(9, cliente.getEndereco().getBloco());
        psEnd.setInt(10, idCliente);
        psEnd.executeUpdate();

        conn.commit(); 
    } catch (SQLException e) {
        if (conn != null) try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
    } finally {
       
    }
}
    
    
    
   public List<Cliente> consultarTodos() {
    String sql = "SELECT c.*, end.idEndereco, end.cep, end.rua,end.numero,end.bairro, end.cidade,end.Estado,end.casa,end.numeroApartamento,end.bloco " +
                 "FROM cliente c JOIN endereco end ON c.idCliente = end.idCliente";
       
       
    List<Cliente> lista = new ArrayList<>();

    
    try (Connection conn = Conexao.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Cliente c = new Cliente();
            
            c.setIdCliente(rs.getInt("idCliente"));
            c.setNome(rs.getString("nome"));
            c.setCPF(rs.getString("identificacao"));
            java.sql.Date dataSql = rs.getDate("dataNascimento");
            if (dataSql != null) {
                LocalDate dataNascimento = dataSql.toLocalDate();
                c.setDataNascimento(dataNascimento);
            }
            c.setSexo(rs.getString("sexo"));
            c.setIdade(rs.getInt("idade"));
            c.setEmail(rs.getString("email"));
                       
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
            
            c.setEndereco(endereco);
            
            lista.add(c);
            
            
        
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar funcionários: " + e.getMessage());
    }
    
    return lista;
}
    
  public Cliente consultar(String cpf) {
            String sql = "SELECT c.*,end.idEndereco, end.cep, end.rua,end.numero,end.bairro, end.cidade,end.Estado,end.casa,end.numeroApartamento,end.bloco " +
                 "FROM cliente c " +
                 "JOIN endereco end ON c.idCliente = end.idCliente " +
                 "WHERE c.identificacao = ?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

      
        ps.setString(1, cpf);
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
               
                Cliente c = new Cliente();
                
            c.setIdCliente(rs.getInt("idCliente"));
            c.setNome(rs.getString("nome"));
            c.setCPF(rs.getString("identificacao"));
            c.setTel(rs.getString("telefone"));
            java.sql.Date dataSql = rs.getDate("dataNascimento");
            if (dataSql != null) {
               
                LocalDate dataNascimento = dataSql.toLocalDate();
                c.setDataNascimento(dataNascimento);
            }
            c.setSexo(rs.getString("sexo"));
            c.setIdade(rs.getInt("idade"));
            c.setEmail(rs.getString("email"));
            
            Endereco endereco = new Endereco();
            endereco.setCep(rs.getString("cep"));
            endereco.setRua(rs.getString("rua"));
            endereco.setNumero(rs.getString("numero"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("Estado"));
            endereco.setCasa(rs.getString("casa"));
            endereco.setNumeroApartamento(rs.getString("numeroApartamento"));
            endereco.setBloco(rs.getString("bloco"));
          
            c.setEndereco(endereco);
                
                return c; 
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao buscar cliente pe CPF: " + e.getMessage());
    }
    
    return null; 
}
  
 
 
    
   // Update 
   public void atualizar(Cliente cliente) {
    String sqlCliente = "UPDATE cliente SET nome = ?,identificacao = ?,telefone = ?, dataNascimento = ?,idade = ?,sexo = ?,email = ? WHERE idCliente = ?";
    String sqlEndereco = "UPDATE endereco SET cep = ?, rua = ?,numero = ?,bairro = ?, cidade = ?,estado = ?,casa = ?,numeroApartamento = ?,bloco = ? WHERE idCliente = ?";
    Connection conn = null;
    try  {
        conn = Conexao.getConnection();
        conn.setAutoCommit(false); 

        try (PreparedStatement ps = conn.prepareStatement(sqlCliente)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCPF());
            ps.setString(3, cliente.getTel());
            ps.setDate(4, java.sql.Date.valueOf(cliente.getDataNascimento()));
            ps.setInt(5, cliente.getIdade());
            ps.setString(6, cliente.getSexo());
            ps.setString(7, cliente.getEmail());
            ps.setInt(8, cliente.getIdCliente()); 
            ps.executeUpdate();
        }

        try (PreparedStatement psEnd = conn.prepareStatement(sqlEndereco)) {
            psEnd.setString(1, cliente.getEndereco().getCep());
            psEnd.setString(2, cliente.getEndereco().getRua());
            psEnd.setString(3, cliente.getEndereco().getNumero());
            psEnd.setString(4, cliente.getEndereco().getBairro());
            psEnd.setString(5, cliente.getEndereco().getCidade());
            psEnd.setString(6, cliente.getEndereco().getEstado());
            psEnd.setString(7, cliente.getEndereco().getCasa());
            psEnd.setString(8, cliente.getEndereco().getNumeroApartamento());
            psEnd.setString(9, cliente.getEndereco().getBloco());
            
            psEnd.setInt(10, cliente.getIdCliente());
            psEnd.executeUpdate();
        }

        conn.commit(); 
        System.out.println("Dados atualizados com sucesso!");

    } catch (SQLException e) {
        
        try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        throw new RuntimeException("Erro ao atualizar funcionário: " + e.getMessage());
    }
}

    
 public void remover(int idCliente) {
    String sqlEndereco = "DELETE FROM endereco WHERE idCliente = ?";
    String sqlCliente = "DELETE FROM cliente WHERE idCliente = ?";

    try (Connection conn = Conexao.getConnection()) {
        conn.setAutoCommit(false); 

       
        try (PreparedStatement psEnd = conn.prepareStatement(sqlEndereco)) {
            psEnd.setInt(1, idCliente);
            psEnd.executeUpdate();
        }

       
        try (PreparedStatement psFunc = conn.prepareStatement(sqlCliente)) {
            psFunc.setInt(1, idCliente);
            psFunc.executeUpdate();
        }

        conn.commit(); 
        System.out.println("Funcionário removido com sucesso!");

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao remover funcionário: " + e.getMessage());
    }
}   

    




    
}
