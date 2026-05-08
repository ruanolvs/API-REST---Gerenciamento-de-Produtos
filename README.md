# API REST - Gerenciamento de Produtos

Sistema de CRUD desenvolvido com Spring Boot para gerenciar produtos. Criei este projeto durante meus estudos de back-end para praticar operações RESTful e arquitetura em camadas.

## O que tem aqui

Uma API REST que permite:
- Listar produtos
- Buscar produto específico por ID
- Criar novos produtos (o ID é gerado automaticamente)
- Atualizar produtos (completo ou parcial)
- Deletar produtos

## Tecnologias usadas

- Java 17
- Spring Boot 4.0.6
- Maven
- Lombok
- -Spring Doc Openai
- -Spring web

## Como rodar na sua máquina

Clone o repositório:
```bash
git clone https://github.com/ruanolvs/API-REST---Gerenciamento-de-Produtos.git
cd API-REST---Gerenciamento-de-Produtos
```

Execute:
```bash
./mvnw spring-boot:run
```

A API vai estar rodando em `http://localhost:8080`

## Endpoints

**Listar todos os produtos:**

**Buscar por ID:**

**Criar produto:**

POST /v1/produtos
{
"nome": "Mouse",
"preco": 50.00,
"quantidade": 20
}

**Atualizar completo (PUT):**
PUT /v1/produtos/1
{
"nome": "Mouse Gamer",
"preco": 150.00,
"quantidade": 15
}

**Atualizar parcial (PATCH):**
PATCH /v1/produtos/1
{
"preco": 120.00
}

**Deletar:**
DELETE /v1/produtos/1

## Estrutura do projeto

O código está organizado em camadas:
- **Controller**: recebe as requisições HTTP
- **Service**: contém a lógica de negócio
- **DTO**: objetos usados na comunicação com a API
- **Entity**: representação dos dados

## Sobre

Desenvolvido por Ruan Oliveira como parte dos estudos em desenvolvimento back-end com Spring Boot.
