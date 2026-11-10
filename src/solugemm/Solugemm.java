/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package solugemm;


import br.com.solugem.model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import br.com.solugem.dao.ClienteDao;
import br.com.solugem.dao.FuncionarioDao;
import br.com.solugem.dao.MaterialDao;
import br.com.solugem.dao.TipoDeServicoDao;

import br.com.solugem.dao.ClienteDao;
import br.com.solugem.model.Cliente;
import java.util.List;
/**
 *
 * @author principal
 */
public class Solugemm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
       ClienteDao clienteDao = new ClienteDao();

        System.out.println("=== INICIANDO TESTES DO CRUD DE CLIENTE VIA CONSOLE ===");

        // 1. TESTE DE CADASTRO (SALVAR)
        System.out.println("\n--- 1. Cadastrando novo cliente ---");
        Cliente novoCliente = new Cliente();
        novoCliente.setNome("Carlos Alberto da Silva");
        novoCliente.setEmail("carlos.silva@email.com");
        novoCliente.setTelefone("(21) 98888-7777");
        

        try {
            clienteDao.salvar(novoCliente); 
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }

        // 2. TESTE DE CONSULTA (LISTAR TODOS)
        System.out.println("\n--- 2. Consultando todos os clientes cadastrados ---");
        try {
            List<Cliente> clientes = clienteDao.consultarTodos();
            for (Cliente c : clientes) {
                System.out.println("ID: " + c.getIdCliente() + " | Nome: " + c.getNome() + " | Email: " + c.getEmail() + " | Telefone: " + c.getTelefone());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        // 3. TESTE DE ATUALIZAÇÃO (UPDATE)
        System.out.println("\n--- 3. Atualizando o último cliente cadastrado ---");
        try {
            List<Cliente> clientes = clienteDao.consultarTodos();
            if (!clientes.isEmpty()) {
                Cliente clienteParaAtualizar = clientes.get(clientes.size() - 1); // Pega o último
                clienteParaAtualizar.setNome("Carlos Alberto Atualizado");
                clienteParaAtualizar.setEmail("carlos.novo@email.com");
                
                clienteDao.atualizar(clienteParaAtualizar);
                System.out.println("Cliente atualizado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }

        // 4. TESTE DE EXCLUSÃO (DELETE) - Opcional para não limpar sua base de testes
        /*
        System.out.println("\n--- 4. Removendo um cliente ---");
        try {
            List<Cliente> clientes = clienteDao.consultarTodos();
            if (!clientes.isEmpty()) {
                int idParaRemover = clientes.get(clientes.size() - 1).getIdCliente();
                clienteDao.remover(idParaRemover);
                System.out.println("Cliente removido com ID: " + idParaRemover);
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }
        */

        System.out.println("\n=== TESTES CONCLUÍDOS COM SUCESSO! ===");
    
        
        
        
        
        
        
        
       /**-----------------------------------------------------
       Instruções ------------------------
       * Usuarios: 
       * Dono: login(matricula): 2004 senha: user2004
       * Atendente: login(matricula): 1003 senha: user1003
       * Material cadastrado pata teste de consulta: 1111 e 1112
       * Serviço cadastrado para teste de consulta: 1111 e 1112
       * Funcionários cadastrados para teste de consulta, busca por matricula: 0001,0002,1003 e 2004
       * Cliente cadastrado para teste de consulta, busca por CPF: 12345678900
       * -------------------------------------------------------
       *--------------------------------------------------------
       */
        
       
    
    } 
}
        
        
        
        
    