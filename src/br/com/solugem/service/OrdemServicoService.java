/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.solugem.service;

/**
 *
 * @author principal
 */

import br.com.solugem.model.MaterialUtilizado;
import br.com.solugem.model.OrdemServico;
import br.com.solugem.model.ServicoConcluido;

/**
 * Camada de Regra de Negócio para Ordem de Serviço.
 * Responsável por calcular totais, somas de materiais/serviços e aplicação de descontos.
 * @author principal
 */
public class OrdemServicoService {

    /**
     * Calcula o valor total dos materiais, serviços, aplica a regra de desconto 
     * se ultrapassar R$ 1000,00 e atualiza os campos correspondentes na Ordem de Serviço.
     */
    public void calcularTotaisEJB(OrdemServico os) {
        if (os == null) {
            return;
        }

        double totalMateriais = 0.0;
        double totalServicos = 0.0;

        // Soma os preços dos materiais utilizados na OS
        if (os.listarMaterial() != null) {
            for (MaterialUtilizado mu : os.listarMaterial()) {
                totalMateriais += (mu.getPrecoMaterial() * mu.getQtdMaterial());
            }
        }

        // Soma os preços dos serviços concluídos na OS
        if (os.listarServico() != null) {
            for (ServicoConcluido sc : os.listarServico()) {
                totalServicos += (sc.getPreco() * sc.getQtdTipoServico());
            }
        }

        // Total geral bruto (Mão de obra + Materiais)
        double totalGeralOs = totalMateriais + totalServicos;
        os.setTotalMaoObramaterial(totalGeralOs);

        double desconto = 0.0;
        double totalComDesconto = totalGeralOs;

        // Requisito Funcional: Desconto de 5% para Ordens de Serviço acima de R$ 1000,00
        if (totalGeralOs > 1000.00) {
            desconto = totalGeralOs * 0.05; // 5% de desconto
            totalComDesconto = totalGeralOs - desconto;
        }

        // Define os valores calculados no objeto de domínio OrdemServico
        os.setDesconto(desconto);
        os.setTotalMaoObraComDesc(totalComDesconto);
    }
}
