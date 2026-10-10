/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.model;

/**
 *
 * @author principal
 */
public class FuncionarioServico {
    private int idOs;
    private int idFuncionarioServico;
    private String horaInicioServico;
    private String horaFimServico;
    private String observacaoFuncionario;
    private Funcionario funcionario;

    public int getIdOs() {
        return idOs;
    }

    public void setIdOs(int idOs) {
        this.idOs = idOs;
    }
    
    

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    

    public int getIdFuncionarioServico() {
        return idFuncionarioServico;
    }

    public void setIdFuncionarioServico(int idFuncionarioServico) {
        this.idFuncionarioServico = idFuncionarioServico;
    }

    public String getHoraInicioServico() {
        return horaInicioServico;
    }

    public void setHoraInicioServico(String horaInicioServico) {
        this.horaInicioServico = horaInicioServico;
    }

    public String getHoraFimServico() {
        return horaFimServico;
    }

    public void setHoraFimServico(String horaFimServico) {
        this.horaFimServico = horaFimServico;
    }

    public String getObservacaoFuncionario() {
        return observacaoFuncionario;
    }

    public void setObservacaoFuncionario(String observacaoFuncionario) {
        this.observacaoFuncionario = observacaoFuncionario;
    }
    
    
}
