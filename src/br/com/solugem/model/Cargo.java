/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.model;

/**
 *
 * @author principal
 */
public class Cargo {
    
    private int idCargo;
    private String cargo;
    private double salario;
    
    public Cargo(){
        
    }
    
    public Cargo(int idCargo, String nomeCargo, double salario) {
        this.idCargo = idCargo;
        this.cargo = nomeCargo;
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return this.cargo; 
    }
    
    // metodo alternativo -----------------
    
    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Cargo other = (Cargo) obj;
   
    return this.idCargo == other.idCargo;
}
    
    // ------------------------------------

    public int getIdCardo() {
        return idCargo;
    }

    public void setIdCardo(int idCardo) {
        this.idCargo = idCardo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    
}
