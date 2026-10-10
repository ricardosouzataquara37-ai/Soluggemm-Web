/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solugemmDao;

import br.com.solugem.model.Cargo;
import br.com.solugem.model.Conexao;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




/**
 *
 * @author principal
 */
public class CargoDao {
    
    private static List<Cargo> listaCargo = new ArrayList<>();
    // -----------------------------

    public List<Cargo> listarTodos() {
        String sql = "SELECT idCargo, nomeCargo, salario FROM cargo";
        List<Cargo> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cargo c = new Cargo(
                    rs.getInt("idCargo"),
                    rs.getString("nomeCargo"),
                    rs.getDouble("salario") // Ajuste o tipo conforme seu modelo
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cargos: " + e.getMessage());
        }
        return lista;
    }
 
    
    //-------------------------------
    
    public List<Cargo> listarTodos2() {
        return listaCargo;
    }
    
    // método auxiliar
    private static List<Cargo> listarCargoMain = new ArrayList<>();  
     
     public void salvar(Cargo cargo){
         listarCargoMain.add(cargo);
     }
    
    
}
