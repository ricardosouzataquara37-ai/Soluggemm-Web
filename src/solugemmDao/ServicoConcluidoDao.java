/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solugemmDao;

import br.com.solugem.model.ServicoConcluido;
import br.com.solugem.model.TipoDeServico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author principal
 */
public class ServicoConcluidoDao {
    /**
    private static List<ServicoConcluido> listaServConcluido = new ArrayList<>();
     
     public void salvar(ServicoConcluido servCon){
         listaServConcluido.add(servCon);
     }
     
     public void excluir(String tipoServico){
         for(ServicoConcluido sc : listaServConcluido){
             if(sc.getTipoServico().equals(tipoServico)){
                 listaServConcluido.remove(sc);
             }
         }
     }
     
     public List<ServicoConcluido> listar(){
         return listaServConcluido;
     }
     
     public  void remover(int indice){
        if(indice >= 0 && indice < listaServConcluido.size()){
            this.listaServConcluido.remove(indice);
        }
     }
     * 
     */
}
