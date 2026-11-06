/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.dao;

import br.com.solugem.model.Empresa;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para gerenciamento de Empresas/Filiais utilizando dados em memória (estáticos).
 * @author principal
 */
public class EmpresaDao {
    
    // Lista estática para manter as empresas e filiais carregadas em memória
    private static List<Empresa> listaEmpresa = new ArrayList<>();
    
    static {
        listaEmpresa.add(new Empresa(1, "53019145000109", "Solugemm Gardênia", "solugemm@solugemm.com", "21998556556"));
        listaEmpresa.add(new Empresa(4, "53019145000109", "Solugemm Serviços técnicos(Pechincha)", "contato@solugemm.com", "21998556556"));
        listaEmpresa.add(new Empresa(5, "53019145000109", "Solugemm Serviços técnicos(Piedade)", "solugemm@solugemm.com", "21998556556"));
    }
    
    // Retorna a lista de empresas em memória
    public List<Empresa> listarTodos() {
        return listaEmpresa;
    }
     
    // Adiciona uma nova empresa temporariamente na lista em memória
    public void salvar(Empresa empresa) {
        listaEmpresa.add(empresa);
    }
}