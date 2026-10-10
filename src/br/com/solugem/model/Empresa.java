/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.model;

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
    private List<Telefone> telefones;
    private String telefone;
    
    public Empresa(){
        
    }
    
    
    public Empresa(int id,String cnpj, String razaoSocial, String email, String telefome ){
         this.cnpj = cnpj;
         this.razaoSocial = razaoSocial;
         this.email = email;
         this.idEmpresa = id;
         this.telefone = telefone;
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
