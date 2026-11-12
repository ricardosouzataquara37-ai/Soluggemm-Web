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
import br.com.solugem.dao.OrdemServicoDao;
import br.com.solugem.model.Cliente;
import br.com.solugem.service.OrdemServicoService;
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
        
      

        System.out.println("=== INICIANDO TESTES DO CRUD DE CLIENTE VIA CONSOLE ===");
        
          
        ClienteDao clienteDao = new ClienteDao();
        
        // 1. TESTE DE CADASTRO (SALVAR)
        System.out.println("\n--- 1. Cadastrando novo cliente ---");
        Cliente novoCliente = new Cliente();
        novoCliente.setNome("Carlos Pedro da Costa");
        novoCliente.setEmail("carlos.silva@email.com");
        novoCliente.setTelefone("(21) 98888-7777");
        novoCliente.setCPF("10354657688");
        novoCliente.setSexo("M");
        novoCliente.setDataNascimento(LocalDate.of(1990, 1, 1));
        
        Endereco endCliente = new Endereco();
        endCliente.setCep("22775-040");
        endCliente.setRua("Estrada do Gabinal");
        endCliente.setNumero("100");
        endCliente.setBairro("Taquara");
        endCliente.setCidade("Rio de Janeiro");
        endCliente.setEstado("RJ");
        endCliente.setCasa("C10");
        
        novoCliente.setEndereco(endCliente);
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
                clienteParaAtualizar.setNome("Carlos Alberto Aaaa");
                clienteParaAtualizar.setEmail("carlos.novo@email.com");
                
                clienteDao.atualizar(clienteParaAtualizar);
                System.out.println("Cliente atualizado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    /**
        // 4. TESTE DE EXCLUSÃO (DELETE) 
        
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
        // //
        */
        System.out.println("\n=== TESTES CONCLUÍDOS COM SUCESSO! ===");
    
       // =========================================================================
       // =========================================================================        
        
        System.out.println("=== INICIANDO TESTES DO CRUD DE FUNCIONÁRIO VIA CONSOLE ==="); 
        
        FuncionarioDao funcionarioDao = new FuncionarioDao();

        // 1. TESTE DE CADASTRO (SALVAR)
        System.out.println("\n--- 1. Cadastrando novo funcionário ---");
        try {
            Funcionario novoFunc = new Funcionario();
            novoFunc.setNome("Ana Paula Costa 2121");
            novoFunc.setMatricula("MAT2027");
            novoFunc.setIdentificacao("123456789");
            novoFunc.setTelefone("(21) 97777-6666");
            novoFunc.setDataNascimento(LocalDate.of(1995, 5, 15));
            novoFunc.setSexo("F");
            novoFunc.setIdade(31);
            novoFunc.setEmail("ana.paula@email.com");
            novoFunc.setSenha("123456");

            Empresa empresa = new Empresa();
            empresa.setIdEmpresa(1); 
            novoFunc.setEmpresa(empresa);

            Cargo cargo = new Cargo();
            cargo.setIdCardo(11); 
            novoFunc.setCargo(cargo);

            // Endereço do Funcionário
            Endereco endereco = new Endereco();
            endereco.setCep("22775-040");
            endereco.setRua("Estrada do Gabinal");
            endereco.setNumero("312");
            endereco.setBairro("Freguesia");
            endereco.setCidade("Rio de Janeiro");
            endereco.setEstado("RJ");
            endereco.setCasa("C02"); 
            endereco.setNumeroApartamento("");
            endereco.setBloco("");
            novoFunc.setEndereco(endereco);

            funcionarioDao.salvar(novoFunc);
            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }

        // 2. TESTE DE CONSULTA (LISTAR TODOS)
        System.out.println("\n--- 2. Consultando todos os funcionários cadastrados ---");
        try {
            List<Funcionario> funcionarios = funcionarioDao.consultarTodos();
            for (Funcionario f : funcionarios) {
                System.out.println("ID: " + f.getIdFuncionario() + 
                                   " | Nome: " + f.getNome() + 
                                   " | Matrícula: " + f.getMatricula() + 
                                   " | Telefone: " + f.getTelefone() + 
                                   " | Empresa: " + (f.getEmpresa() != null ? f.getEmpresa().getRazaoSocial() : "N/A") +
                                   " | Cargo: " + (f.getCargo() != null ? f.getCargo().getCargo() : "N/A"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }

        // 3. TESTE DE CONSULTA POR MATRÍCULA
        System.out.println("\n--- 3. Consultando funcionário específico por Matrícula ---");
        try {
            Funcionario fConsultado = funcionarioDao.consultar("2221");
            if (fConsultado != null) {
                System.out.println("Encontrado: " + fConsultado.getNome() + " - E-mail: " + fConsultado.getEmail());
            } else {
                System.out.println("Funcionário não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta por matrícula: " + e.getMessage());
        }

        // 4. TESTE DE ATUALIZAÇÃO (UPDATE)
        System.out.println("\n--- 4. Atualizando dados do funcionário ---");
        try {
            Funcionario fAtualizar = funcionarioDao.consultar("2221");
            if (fAtualizar != null) {
                fAtualizar.setNome("Ana Paula Costa Atualizada aass");
                fAtualizar.setEmail("ana.atualizada@email.com");
                
                Cargo cargo = new Cargo();
                cargo.setIdCardo(11); 
                fAtualizar.setCargo(cargo);

                Empresa empresa = new Empresa();
                empresa.setIdEmpresa(1); 
                fAtualizar.setEmpresa(empresa);
                
                funcionarioDao.atualizar(fAtualizar);
            } else {
                System.out.println("Funcionário não encontrado para atualizar.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
        }

        System.out.println("\n=== TESTES DE FUNCIONÁRIO CONCLUÍDOS! ===");
    
    
    
    // =========================================================================
    // =========================================================================        
     
        System.out.println("=== INICIANDO TESTES DO CRUD DE MATERIAL VIA CONSOLE ===");
        
        MaterialDao materialDao = new MaterialDao();

        // 1. TESTE DE CADASTRO (SALVAR MATERIAL E FABRICANTE)
        System.out.println("\n--- 1. Cadastrando novo material e fabricante ---");
        try {
            Fabricante fabricante = new Fabricante();
            fabricante.setNome("Bosch Ferramentas");
            fabricante.setCnpj("53123456000189");
            Material novoMaterial = new Material();
            novoMaterial.setNome("Furadeira Impacto 600W 22");
            novoMaterial.setPreco(350.00);
            novoMaterial.setCodigo("7223");
            novoMaterial.setFabricante(fabricante);

            materialDao.salvarMaterialComFabricante(novoMaterial);
            System.out.println("Material e Fabricante cadastrados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar material: " + e.getMessage());
        }

        // 2. TESTE DE CONSULTA (LISTAR TODOS)
        System.out.println("\n--- 2. Consultando todos os materiais cadastrados ---");
        try {
            List<Material> materiais = materialDao.consultarTodos();
            for (Material m : materiais) {
                System.out.println("ID: " + m.getIdMaterial() + 
                                   " | Nome: " + m.getNome() + 
                                   " | Preço: R$ " + m.getPreco() + 
                                   " | Código: " + m.getCodigo() + 
                                   " | Fabricante: " + (m.getFabricante() != null ? m.getFabricante().getNome() : "N/A"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar materiais: " + e.getMessage());
        }

        // 3. TESTE DE CONSULTA POR CÓDIGO
        System.out.println("\n--- 3. Consultando material específico por Código ---");
        try {
            Material mConsultado = materialDao.consultar("1125");
            if (mConsultado != null) {
                System.out.println("Encontrado: " + mConsultado.getNome() + " - Preço: R$ " + mConsultado.getPreco());
            } else {
                System.out.println("Material não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta por código: " + e.getMessage());
        }

        // 4. TESTE DE ATUALIZAÇÃO (UPDATE)
        System.out.println("\n--- 4. Atualizando dados do material ---");
        try {
            Material mAtualizar = materialDao.consultar("1125");
            if (mAtualizar != null) {
                mAtualizar.setNome("Furadeira Impacto 750W Profissional");
                mAtualizar.setPreco(420.00);
                
                if (mAtualizar.getFabricante() != null) {
                    mAtualizar.getFabricante().setNome("Bosch Industrial");
                }
                
                materialDao.atualizar(mAtualizar);
            } else {
                System.out.println("Material não encontrado para atualizar.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar material: " + e.getMessage());
        }

        System.out.println("\n=== TESTES DE MATERIAL CONCLUÍDOS! ===");    
        
    // =========================================================================
    // =========================================================================   
       
    System.out.println("=== INICIANDO TESTES DO CRUD DE TIPO DE SERVIÇO VIA CONSOLE ===");
    
        
        TipoDeServicoDao servicoDao = new TipoDeServicoDao();

        // 1. TESTE DE CADASTRO (SALVAR)
        System.out.println("\n--- 1. Cadastrando novo tipo de serviço ---");
        try {
            TipoDeServico novoServico = new TipoDeServico();
            novoServico.setDescricao("Instalação de Aquecedor a Gás aa");
            novoServico.setCodigo("1132");
            novoServico.setPrecoServico(250.00);

            servicoDao.salvar(novoServico);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar tipo de serviço: " + e.getMessage());
        }

        // 2. TESTE DE CONSULTA (LISTAR TODOS)
        System.out.println("\n--- 2. Consultando todos os tipos de serviço cadastrados ---");
        try {
            List<TipoDeServico> servicos = servicoDao.consultarTodos();
            for (TipoDeServico s : servicos) {
                System.out.println("ID: " + s.getIdTds() + 
                                   " | Código: " + s.getCodigo() + 
                                   " | Descrição: " + s.getDescricao() + 
                                   " | Preço: R$ " + s.getPrecoServico());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar tipos de serviço: " + e.getMessage());
        }

        // 3. TESTE DE CONSULTA ESPECÍFICA POR CÓDIGO
        System.out.println("\n--- 3. Consultando tipo de serviço específico por Código ---");
        try {
            TipoDeServico sConsultado = servicoDao.consultar("2545");
            if (sConsultado != null) {
                System.out.println("Encontrado: " + sConsultado.getDescricao() + " - Preço: R$ " + sConsultado.getPrecoServico());
            } else {
                System.out.println("Tipo de serviço não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro na consulta por código: " + e.getMessage());
        }

        // 4. TESTE DE ATUALIZAÇÃO (UPDATE)
        System.out.println("\n--- 4. Atualizando dados do tipo de serviço ---");
        try {
            TipoDeServico sAtualizar = servicoDao.consultar("2545");
            if (sAtualizar != null) {
                sAtualizar.setDescricao("Instalação e Manutenção de Aquecedor a Gás");
                sAtualizar.setPrecoServico(300.00);
                
                servicoDao.atualizar(sAtualizar);
            } else {
                System.out.println("Tipo de serviço não encontrado para atualizar.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar tipo de serviço: " + e.getMessage());
        }

        System.out.println("\n=== TESTES DE TIPO DE SERVIÇO CONCLUÍDOS! ===");
    
    // =========================================================================
    // =========================================================================   
        System.out.println("=== INICIANDO TESTES DA ORDEM DE SERVIÇO VIA CONSOLE ===");

    
        OrdemServicoDao osDao = new OrdemServicoDao();
        OrdemServicoService osService = new OrdemServicoService();

       
        try {
            // 1. Instancia a Ordem de Serviço
            OrdemServico os = new OrdemServico();
            os.setData(LocalDate.now());

            Empresa empresa = new Empresa();
            empresa.setIdEmpresa(1);
            os.setEmpresa(empresa);

            Cliente cliente = new Cliente();
            cliente.setIdCliente(35); 
            os.setCliente(cliente);

            Endereco endereco = new Endereco();
            endereco.setCep("22775-040");
            endereco.setRua("Av. das Américas");
            endereco.setNumero("500");
            endereco.setBairro("Barra da Tijuca");
            endereco.setCidade("Rio de Janeiro");
            endereco.setEstado("RJ");
            endereco.setCasa("c20");
            endereco.setNumeroApartamento("101");
            endereco.setBloco("B");
            os.setEndereco(endereco);

            // 2. Adiciona 2 Materiais (exemplo de valor alto para passar de R$ 1000)
            Material mat1 = new Material();
            mat1.setIdMaterial(3); // ID de material existente no banco
            MaterialUtilizado mu1 = new MaterialUtilizado();
            mu1.setMaterial(mat1);
            mu1.setPrecoMaterial(400.00);
            mu1.setQtdMaterial(1);
            os.salvarMaterial(mu1);

            // 3. Adiciona 2 Tipos de Serviço (cuja soma com os materiais ultrapasse R$ 1000)
            TipoDeServico tds1 = new TipoDeServico();
            tds1.setIdTds(2); 
            ServicoConcluido sc1 = new ServicoConcluido();
            sc1.setTipoServico(tds1);
            sc1.setPreco(700.00);
            sc1.setQtdTipoServico(1);
            os.salvarServico(sc1);

            // 4. Adiciona um Funcionário responsável pela execução
            Funcionario func = new Funcionario();
            func.setIdFuncionario(19); 
            FuncionarioServico fs = new FuncionarioServico();
            fs.setFuncionario(func);
            fs.setHoraInicioServico("08:00");
            fs.setHoraFimServico("12:00");
            fs.setObservacaoFuncionario("Serviço executado com sucesso.");
            os.salvarFuncServ(fs);

            // 5. Processa os cálculos e regras de negócio através da camada de Service
            osService.calcularTotaisEJB(os);

            System.out.println("\n--- RESULTADO DOS CÁLCULOS (SERVICE) ---");
            System.out.println("Total Geral (Sem Desconto): R$ " + os.getTotalMaoObramaterial());
            System.out.println("Desconto Aplicado (5%): R$ " + os.getDesconto());
            System.out.println("Total Final (Com Desconto): R$ " + os.getTotalMaoObraComDesc());

            // 6. Salva no Banco de Dados via DAO (Transação ACID Completa)
            boolean salvo = osDao.salvarOs(os);
            if (salvo) {
                System.out.println("\nOrdem de Serviço salva com sucesso no banco de dados!");
            }

        } catch (Exception e) {
            System.out.println("Erro ao testar Ordem de Serviço: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n=== TESTES DE ORDEM DE SERVIÇO CONCLUÍDOS ===");


    // =========================================================================
    // =========================================================================   


    // =========================================================================
    // =========================================================================       
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
        
        
        
        
    