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
public class OrdemServico {
    private int idOs;
    private LocalDate data;
    private double totalMaoObramaterial;
    private double desconto;
    private double totalMaoObraComDesc;
    private Cliente cliente;
    private Empresa empresa;
    private Endereco endereco;
    private List<MaterialUtilizado> listaMatUtilizado = new ArrayList<>();
    private List<ServicoConcluido> listaServConcluido = new ArrayList<>();
    private List<FuncionarioServico> listaFuncionarioServico = new ArrayList<>(); 
    
    // MaterialUtilizado
    
    
     public void salvarMaterial(MaterialUtilizado matUtil){
         listaMatUtilizado.add(matUtil);
     }
     
     
     public void excluirMaterial(String material){
         for(MaterialUtilizado mu : listaMatUtilizado){
             if(mu.getMaterial().equals(material)){
                 listaMatUtilizado.remove(mu);
             }
         }
     }
     
     public List<MaterialUtilizado> listarMaterial(){
         return listaMatUtilizado;
     }
   
     public  void removerMaterial(int indice){
        if(indice >= 0 && indice < listaMatUtilizado.size()){
            this.listaMatUtilizado.remove(indice);
        }
     }
   
  //-----------------
  //ServicoConcluido   
    public void salvarServico(ServicoConcluido servCon){
         listaServConcluido.add(servCon);
     }
     
     public void excluirSErvico(String tipoServico){
         for(ServicoConcluido sc : listaServConcluido){
             if(sc.getTipoServico().equals(tipoServico)){
                 listaServConcluido.remove(sc);
             }
         }
     }
     
     public List<ServicoConcluido> listarServico(){
         return listaServConcluido;
     }
     
     public  void removerServico(int indice){
        if(indice >= 0 && indice < listaServConcluido.size()){
            this.listaServConcluido.remove(indice);
        }
     }
    
  // ----------------------- 
  //funcionarioServico
   
     public void salvarFuncServ(FuncionarioServico funcServ){
         listaFuncionarioServico.add(funcServ);
     }
     public void excluirFuncServ(String matricula){
         for(FuncionarioServico fs : listaFuncionarioServico){
             if(fs.getFuncionario().getMatricula().equals(matricula)){
                 listaFuncionarioServico.remove(fs);
             }
         }
     }
     
     public List<FuncionarioServico> listarFuncServ(){
         return listaFuncionarioServico;
     }
     
     public  void remover(int indice){
        if(indice >= 0 && indice < listaFuncionarioServico.size()){
            this.listaFuncionarioServico.remove(indice);
        }
     }  
     
  
    public int getIdOs() {
        return idOs;
    }

    public void setIdOs(int idOs) {
        this.idOs = idOs;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getTotalMaoObramaterial() {
        return totalMaoObramaterial;
    }

    public void setTotalMaoObramaterial(double totalMaoObramaterial) {
        this.totalMaoObramaterial = totalMaoObramaterial;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getTotalMaoObraComDesc() {
        return totalMaoObraComDesc;
    }

    public void setTotalMaoObraComDesc(double totalMaoObraComDesc) {
        this.totalMaoObraComDesc = totalMaoObraComDesc;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
 
}
