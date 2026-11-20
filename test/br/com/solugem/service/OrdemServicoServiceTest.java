/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.solugem.service;

import br.com.solugem.model.MaterialUtilizado;
import br.com.solugem.model.OrdemServico;
import br.com.solugem.model.ServicoConcluido;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author principal
 */
public class OrdemServicoServiceTest {

    public OrdemServicoServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void deveCalcularTotaisEAplicarDescontoDeCincoPorCentoAcimaDeMil() {
        OrdemServicoService service = new OrdemServicoService();
        OrdemServico os = new OrdemServico();

        MaterialUtilizado material = new MaterialUtilizado();
        material.setPrecoMaterial(400.0);
        material.setQtdMaterial(2); // 400 * 2 = 800.0

        ServicoConcluido servico = new ServicoConcluido();
        servico.setPreco(300.0);
        servico.setQtdTipoServico(1); // 300 * 1 = 300.0

        // Total bruto esperado: 800.0 + 300.0 = 1100.0 (> 1000.0)
        // Desconto esperado (5% de 1100.0): 55.0
        // Total com desconto esperado: 1100.0 - 55.0 = 1045.0
        os.salvarMaterial(material);
        os.salvarServico(servico);

        service.calcularTotaisEJB(os);

        assertEquals(1100.0, os.getTotalMaoObramaterial(), 0.001);
        assertEquals(55.0, os.getDesconto(), 0.001);
        assertEquals(1045.0, os.getTotalMaoObraComDesc(), 0.001);
    }

    @Test
    public void naoDeveAplicarDescontoQuandoTotalForMenorOuIgualAMil() {
        OrdemServicoService service = new OrdemServicoService();
        OrdemServico os = new OrdemServico();

        MaterialUtilizado material = new MaterialUtilizado();
        material.setPrecoMaterial(250.0);
        material.setQtdMaterial(2); // 500.0

        ServicoConcluido servico = new ServicoConcluido();
        servico.setPreco(500.0);
        servico.setQtdTipoServico(1); // 500.0 -> Total exato: 1000.0

        os.salvarMaterial(material);
        os.salvarServico(servico);

        service.calcularTotaisEJB(os);

        assertEquals(1000.0, os.getTotalMaoObramaterial(), 0.001);
        assertEquals(0.0, os.getDesconto(), 0.001);
        assertEquals(1000.0, os.getTotalMaoObraComDesc(), 0.001);
    }

    @Test
    public void naoDeveFalharQuandoOrdemServicoForNula() {
        OrdemServicoService service = new OrdemServicoService();
        try {
            service.calcularTotaisEJB(null);
        } catch (Exception e) {
            fail("Não lançar exceção quando OrdemServico for nula: " + e.getMessage());
        }
    }
}