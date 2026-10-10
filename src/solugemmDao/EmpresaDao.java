/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solugemmDao;

import br.com.solugem.model.Cargo;
import br.com.solugem.model.Empresa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author principal
 */
public class EmpresaDao {
    private static List<Empresa> listaEmpresa = new ArrayList<>();
    
    
    static {
        listaEmpresa.add(new Empresa(1,"53019145000109","Solugemm Gardênia","solugemm@solugemm.com","21998556556"));
        listaEmpresa.add(new Empresa(4,"53019145000109","Solugemm Serviços técnicos(Pechincha)","contato@solugemm.com","21998556556"));
        listaEmpresa.add(new Empresa(5,"53019145000109","Solugemm Serviços técnicos(Piedade)","solugemm@solugemm.com","21998556556"));
    }
    
    public List<Empresa> listarTodos() {
        return listaEmpresa;
    }
    
   // método auxiliar teste main
    private static List<Empresa> listarEmpresaMain = new ArrayList<>();  
     
     public void salvar(Empresa empresa){
         listarEmpresaMain.add(empresa);
     }
     



}