/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.model;

/**
 *
 * @author principal
 */
public class MaterialUtilizado {
    private int idOs;
    private int idMaterialUtilizado;
    private double precoMaterial;
    private int qtdMaterial;
    private double totalMaterialUtilizado;
    private Material material;

    public int getIdOs() {
        return idOs;
    }

    public void setIdOs(int idOs) {
        this.idOs = idOs;
    }
    
    

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    
    

    public int getIdMaterialUtilizado() {
        return idMaterialUtilizado;
    }

    public void setIdMaterialUtilizado(int idMaterialUtilizado) {
        this.idMaterialUtilizado = idMaterialUtilizado;
    }

    public double getPrecoMaterial() {
        return precoMaterial;
    }

    public void setPrecoMaterial(double precoMaterial) {
        this.precoMaterial = precoMaterial;
    }

    public int getQtdMaterial() {
        return qtdMaterial;
    }

    public void setQtdMaterial(int qtdMaterial) {
        this.qtdMaterial = qtdMaterial;
    }

    public double getTotalMaterialUtilizado() {
        return totalMaterialUtilizado;
    }

    public void setTotalMaterialUtilizado(double totalMaterialUtilizado) {
        this.totalMaterialUtilizado = totalMaterialUtilizado;
    }
    
    
}
