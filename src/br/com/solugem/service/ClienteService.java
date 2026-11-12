/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.service;

import br.com.solugem.dao.ClienteDao;
import br.com.solugem.model.Cliente;
import java.util.List;

public class ClienteService {
    
    private final ClienteDao clienteDao = new ClienteDao();

    public void salvar(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório.");
        }
        if (cliente.getCPF() == null || cliente.getCPF().trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF do cliente é obrigatório.");
        }
        clienteDao.salvar(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteDao.consultarTodos();
    }

    public Cliente buscarPorCpf(String cpf) {
        return clienteDao.consultar(cpf);
    }

    public void atualizar(Cliente cliente) {
        clienteDao.atualizar(cliente);
    }

    public void remover(int idCliente) {
        clienteDao.remover(idCliente);
    }
}