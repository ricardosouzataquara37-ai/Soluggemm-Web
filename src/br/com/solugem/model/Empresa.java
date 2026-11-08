/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author principal
 */
public class Empresa {
    private int idEmpresa;
    private String cnpj;
    private String razaoSocial;
    private String email;
    private Endereco endereco;
    private List<Funcionario> funcionarios;
    private List<Telefone> telefones = new ArrayList<>(); // Inicializada para evitar null
    private String telefone;
    
    public void adicionarTelefone(Telefone t) {
        if (this.telefones == null) {
            this.telefones = new ArrayList<>();
        }
        this.telefones.add(t);
    }
    
    public Empresa(){
        
    }
    
    
   public Empresa(int id, String cnpj, String razaoSocial, String email, String telefone) {
        this.idEmpresa = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.telefone = telefone; // Corrigido
    }
    
    @Override
    public String toString() {
        return this.razaoSocial; 
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
    
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    public void adicionarTelefone(Telefone t){
        this.telefones.add(t);
    }
    
    
    
}
