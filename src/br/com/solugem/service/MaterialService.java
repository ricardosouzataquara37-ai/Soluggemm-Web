/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.service;

import br.com.solugem.dao.MaterialDao;
import br.com.solugem.model.Material;
import java.util.List;

public class MaterialService {
    
    private final MaterialDao materialDao = new MaterialDao();

    public void salvar(Material material) {
        if (material.getNome() == null || material.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do material não pode ser vazio.");
        }
        if (material.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço do material deve ser maior que zero.");
        }
        materialDao.salvarMaterialComFabricante(material);
    }

    public List<Material> listarTodos() {
        return materialDao.consultarTodos();
    }

    public Material buscarPorCodigo(String codigo) {
        return materialDao.consultar(codigo);
    }

    public void atualizar(Material material) {
        materialDao.atualizar(material);
    }

    public void remover(int idMaterial) {
        materialDao.remover(idMaterial);
    }
}
