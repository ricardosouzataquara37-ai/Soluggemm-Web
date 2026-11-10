  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author principal
 */
public class Cliente {
    private int idCliente;
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;
    private int idade;
    private String sexo;
    private String email;
    private Endereco endereco;
    private String telefone; // Atributo unificado para a coluna do banco de dados relacional
    private List<Telefone> telefones = new ArrayList<>(); // Lista para escalabilidade futura

   
    private AcumuloServico saldoFidelidade;

   
 /**   
    // verificar identificação
    public boolean validarDocumento(){
        String docLimpo = this.CPF.replaceAll("[^0-9]","");
        int tamanho = docLimpo.length();
        return (tamanho == 11 || tamanho == 14);
    }
 */ 
    
    public AcumuloServico getSaldoFidelidade() {
        return saldoFidelidade;
    }

    public void setSaldoFidelidade(AcumuloServico saldoFidelidade) {
        this.saldoFidelidade = saldoFidelidade;
    }
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

   

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

   

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // metodos 
    
    public String toString(){
        return this.nome;
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
    
    public void adicionarTelefone(Telefone t) {
        if (this.telefones == null) {
            this.telefones = new ArrayList<>();
        }
        this.telefones.add(t);
    }

    // Método corrigido para atribuir a String do telefone atual (compatível com o banco)
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
    
    
    
    
    
    
    
    
}
