/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solugemmDao;

import br.com.solugem.model.FuncionarioServico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author principal
 */
public class FuncionarioServicoDao {
    /**
    private static List<FuncionarioServico> listaFuncionarioServico = new ArrayList<>();
     
     public void salvar(FuncionarioServico funcServ){
         listaFuncionarioServico.add(funcServ);
     }
     public void excluir(String matricula){
         for(FuncionarioServico fs : listaFuncionarioServico){
             if(fs.getFuncionario().getMatricula().equals(matricula)){
                 listaFuncionarioServico.remove(fs);
             }
         }
     }
     
     public List<FuncionarioServico> listar(){
         return listaFuncionarioServico;
     }
     
     public  void remover(int indice){
        if(indice >= 0 && indice < listaFuncionarioServico.size()){
            this.listaFuncionarioServico.remove(indice);
        }
     }
     */
}
