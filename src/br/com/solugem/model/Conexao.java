/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author principal
 */
public class Conexao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public static Connection getConnection()throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/solugemm","ricardo", "vasco");
        }catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado: " + e.getMessage());
        }
    }
    
    public void desconectar(){
        try{
            conn.close();
            
        }catch(SQLException sqle){
            
        }
    }
}
