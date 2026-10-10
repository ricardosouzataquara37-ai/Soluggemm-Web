# Solugemm - Sistema de Gestão de Ordens de Serviço

## Status do projeto
✅ Em desenvolvimento

## Sobre o projeto
O **Solugemm** é um sistema desktop desenvolvido para facilitar a gestão de atendimentos em empresas de serviços.
 O software automatiza o cadastro de clientes, funcionários, materiais e tipos de serviço, centralizando o registro
 de Ordens de Serviço (OS). Com foco em eficiência e integridade de dados, o sistema realiza cálculos automáticos de 
valores e descontos, além de oferecer mecanismos de busca rápida para consultas contábeis e operacionais.

## Tecnologias Aplicadas
- **Linguagem:** Java (JDK 17.0.15)
- **Interface Gráfica:** Java Swing
- **Banco de Dados:** MySQL Community Server
- **Ferramenta de Modelagem/Admin:** MySQL Workbench 8.0
- **Conexão:** JDBC Driver (Connector/J)
- **IDE:** Apache NetBeans IDE

## Funcionalidades Principais
- **Gestão de Cadastros:** Clientes, funcionários, materiais, tipos de serviço e dados da empresa.
- **Automação de OS:** Preenchimento automático de dados do cliente e endereço via CPF/CNPJ e CEP.
- **Cálculos Automáticos:** O sistema calcula automaticamente subtotais de peças, mão de obra, valores totais com/sem descontos.
- **Regras de Negócio:** Aplicação inteligente de descontos por valor de serviço (5% acima de R$ 1.000) e fidelidade.
- **Sistema de Buscas:** Consultas rápidas por código, CPF/CNPJ, nome ou data.
- **Controle de Acesso:** Permissões distintas para **Dono** (acesso total) e **Atendente** (gestão de clientes e ordens).

## Time de Desenvolvedores
- **Ricardo de Souza Roncate da Gama**

## Objetivo do Software
Proporcionar uma solução robusta para o registro, controle e consulta de ordens de serviço agendadas, garantindo que a 
empresa tenha relatórios precisos de materiais utilizados, serviços prestados e dados para fins contábeis.

## Como utilizar
1. Certifique-se de ter o **MySQL Server** e o **Workbench** instalados e configurados.
2. Execute o script de criação do banco de dados (disponível na pasta `/database`).
3. Compile e execute o projeto utilizando o JDK 17+.
4. As credenciais de acesso seguirão os perfis cadastrados no banco de dados.

---
*Projeto desenvolvido como atividade acadêmica para a disciplina de Análise e Desenvolvimento de Sistemas.*