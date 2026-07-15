# Sistema de Gerenciamento de Concessionária

Projeto desenvolvido para as disciplinas de Projeto de Desenvolvimento de Software (PDS) e Programação com Acesso a Banco de Dados (PABD).

## Equipe

Code Motors

## Integrantes

* Sara dos Santos Forte
* Jéssica Luanna Ferreira de Macedo
* José Eugênio da silva Bisneto
* Manoel Tomé de Mâcedo Bisneto 

## Objetivo

O Sistema de Concessionária de Veículos foi desenvolvido com o objetivo de auxiliar no gerenciamento de uma concessionária, permitindo o cadastro e controle de marcas, automóveis, clientes, vendedores e vendas.
O sistema foi implementado em Java utilizando os conceitos de Programação Orientada a Objetos e integração com banco de dados relacional MySQL. A aplicação funciona por meio de uma interface de texto (console), permitindo a realização das operações de cadastro, consulta, atualização e remoção de dados.

## Histórias de Usuário 
1. Como usuário, desejo cadastrar clientes para manter seus dados organizados no sistema.
2. Como usuário, desejo consultar clientes cadastrados para localizar informações rapidamente.
3. Como usuário, desejo cadastrar automóveis para controlar os veículos disponíveis para venda.
4. Como usuário, desejo consultar automóveis cadastrados para verificar disponibilidade e características dos veículos.
5. Como usuário, desejo cadastrar vendedores para gerenciar a equipe comercial da concessionária.
6. Como usuário, desejo registrar vendas para controlar as negociações realizadas.
7. Como usuário, desejo cadastrar marcas para organizar os automóveis por fabricante.
8. Como usuário, desejo consultar o histórico de vendas para acompanhar o desempenho comercial da concessionária.

## Tecnologias Utilizadas

* Java
* JDBC
* MySQL
* Git
* GitHub
* Eclipse IDE

## Funcionalidades

### Marca

* Cadastrar marca
* Listar marcas
* Atualizar marca
* Excluir marca

### Cliente

* Cadastrar cliente
* Listar clientes
* Atualizar cliente
* Excluir cliente

### Automóvel

* Cadastrar automóvel
* Listar automóveis
* Atualizar automóvel
* Excluir automóvel

### Vendedor

* Cadastrar vendedor
* Listar vendedores
* Atualizar vendedor
* Excluir vendedor

### Venda

* Cadastrar venda
* Listar vendas
* Atualizar venda
* Excluir venda

## Instruções de Execução

### Pré-requisitos

* Java JDK 17 ou superior
* MySQL Server
* Eclipse IDE (ou outra IDE Java)

### Configuração do Banco

1. Criar o banco de dados:

```sql
CREATE DATABASE concessionaria;
```

2. Executar o script SQL disponibilizado no projeto para criação das tabelas e inserção dos dados iniciais.

3. Verificar as configurações de conexão presentes nas classes DAO:

```java
private String url = "jdbc:mysql://localhost:3306/concessionaria";
private String user = "root";
private String password = "123456";
```

### Execução

1. Clonar o repositório:

```bash
git clone https://github.com/sarasforte/sistema-concessionaria.git
```

2. Importar o projeto para a IDE.

3. Executar a classe Main.java.

4. Utilizar o menu principal para acessar os módulos do sistema.

## Estrutura do Banco de Dados

Entidades implementadas:

* Marca
* Automóvel
* Cliente
* Vendedor
* Venda

Relacionamentos:

* Marca → Automóvel
* Cliente → Venda
* Vendedor → Venda
* Automóvel → Venda

## Repositório

O desenvolvimento foi realizado utilizando Git e GitHub, com controle de versões, commits e gerenciamento das atividades através do GitHub Projects.

