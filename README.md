# Solugemm - Sistema de Gestão de Ordens de Serviço (Java Web)

## Sobre o Projeto
O **Solugemm** é um sistema corporativo desenvolvido em Java para a gestão completa de atendimentos e Ordens de Serviço (OS) em empresas prestadoras de serviços. O projeto adota uma **arquitetura em camadas profissional (Model, DAO e Service)**, aplicando rigorosamente os princípios **SOLID**, **transações ACID** via JDBC e garantindo total integridade com o banco de dados relacional MySQL.

## 🛠️ Arquitetura e Tecnologias Aplicadas
* **Linguagem:** Java (JDK 17+)
* **Arquitetura:** Padrão em Camadas (Model / DAO / Service)
* **Persistência & Segurança:** JDBC nativo, `PreparedStatement`, `try-with-resources` e controle transacional manual (`setAutoCommit(false)`, `commit` e `rollback`).
* **Interface Gráfica / Camada Web:** Tecnologias Java Web (ex: Servlets, JSP / Thymeleaf)
* **Banco de Dados:** MySQL Community Server / MySQL Workbench
* **Servidor de Aplicação:** Apache Tomcat
* **Ferramentas & IDE:** Apache NetBeans IDE, Git & GitHub

## 🚀 Funcionalidades Principais
* **Gestão Completa (CRUD):** Controle estruturado de Clientes, Funcionários, Materiais, Fabricantes, Tipos de Serviço e Empresas.
* **Ordem de Serviço Transacional:** Abertura de OS integrando múltiplos itens de forma atômica (Endereço, Materiais Utilizados, Serviços Concluídos e Alocação de Funcionários).
* **Regras de Negócio Centralizadas (`Service`):** 
  * Cálculo automatizado de subtotais e totais gerais.
  * Aplicação inteligente de **5% de desconto automático** para Ordens de Serviço com valor superior a R$ 1.000,00.
* **Integridade Referencial:** Proteção de chaves estrangeiras (`Foreign Keys`) e tratamento robusto de restrições de schema (`Data Truncation`).

## 👨‍💻 Desenvolvedor
* **Ricardo de Souza Roncate da Gama**

## 📦 Como Executar o Projeto
1. **Banco de Dados:** Certifique-se de ter o MySQL Server configurado e execute o script de criação do schema do banco `solugemm`.
2. **Servidor:** Configure um servidor compatível (como o Apache Tomcat) em sua IDE.
3. **Deploy:** Importe o projeto no **Apache NetBeans IDE**, realize o build e faça o deploy da aplicação no servidor web.
4. **Acesso:** Abra o navegador e acesse a aplicação através da URL local configurada.

---
*Projeto desenvolvido como atividade acadêmica para a disciplina de Análise e Desenvolvimento de Sistemas.*