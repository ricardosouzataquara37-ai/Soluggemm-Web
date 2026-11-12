/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.service;

import br.com.solugem.dao.FuncionarioDao;
import br.com.solugem.model.Funcionario;
import java.util.List;

public class FuncionarioService {

    private final FuncionarioDao funcionarioDao = new FuncionarioDao();

    public void salvar(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do funcionário é obrigatório.");
        }
        if (funcionario.getMatricula() == null || funcionario.getMatricula().trim().isEmpty()) {
            throw new IllegalArgumentException("A matrícula do funcionário é obrigatória.");
        }
        funcionarioDao.salvar(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioDao.consultarTodos();
    }

    public Funcionario buscarPorMatricula(String matricula) {
        return funcionarioDao.consultar(matricula);
    }

    public void atualizar(Funcionario funcionario) {
        funcionarioDao.atualizar(funcionario);
    }

    public void remover(int idFuncionario) {
        funcionarioDao.remover(idFuncionario);
    }
}