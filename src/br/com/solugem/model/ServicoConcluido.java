/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.model;

/**
 *
 * @author principal
 */
public class ServicoConcluido {
    private int idOs;
    private int idServicoConcluido;
    private int qtdTipoServico;
    private double preco;
    private double totalMaoObra;
    private TipoDeServico tipoServico;

    public int getIdOs() {
        return idOs;
    }

    public void setIdOs(int idOs) {
        this.idOs = idOs;
    }
    
    

    public TipoDeServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoDeServico tipoServico) {
        this.tipoServico = tipoServico;
    }
    
    

    public int getIdServicoConcluido() {
        return idServicoConcluido;
    }

    public void setIdServicoConcluido(int idServicoConcluido) {
        this.idServicoConcluido = idServicoConcluido;
    }

    public int getQtdTipoServico() {
        return qtdTipoServico;
    }

    public void setQtdTipoServico(int qtdTipoServico) {
        this.qtdTipoServico = qtdTipoServico;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTotalMaoObra() {
        return totalMaoObra;
    }

    public void setTotalMaoObra(double totalMaoObra) {
        this.totalMaoObra = totalMaoObra;
    }
    
    
}
