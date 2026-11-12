/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.service;

import br.com.solugem.dao.TipoDeServicoDao;
import br.com.solugem.model.TipoDeServico;
import java.util.List;

public class TipoDeServicoService {

    private final TipoDeServicoDao tipoDeServicoDao = new TipoDeServicoDao();

    public void salvar(TipoDeServico tipoServico) {
        if (tipoServico.getDescricao() == null || tipoServico.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do tipo de serviço é obrigatória.");
        }
        if (tipoServico.getPrecoServico() <= 0) {
            throw new IllegalArgumentException("O preço do serviço deve ser maior que zero.");
        }
        tipoDeServicoDao.salvar(tipoServico);
    }

    public List<TipoDeServico> listarTodos() {
        return tipoDeServicoDao.consultarTodos();
    }

    public TipoDeServico buscarPorCodigo(String codigo) {
        return tipoDeServicoDao.consultar(codigo);
    }

    public void atualizar(TipoDeServico tipoServico) {
        tipoDeServicoDao.atualizar(tipoServico);
    }

    public void remover(int idTds) {
        tipoDeServicoDao.remover(idTds);
    }
}
