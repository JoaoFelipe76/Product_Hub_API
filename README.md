# API RESTful para Registro de Produtos em Spring Boot

## Sobre
Esta é uma API RESTful desenvolvida em **Spring Boot** para o registro de produtos. A API inclui autenticação utilizando **tokens JWT** para acesso seguro. Apenas usuários autenticados podem realizar requisições GET, enquanto usuários com o papel de administrador têm permissões para criar, atualizar e excluir produtos.

## Funcionalidades
- **Registro de Produtos**: Permite a criação e gerenciamento de produtos no sistema.
- **Autenticação Segura**: Utiliza **tokens JWT** para autenticar e autorizar usuários.
- **Permissões**:
  - **Usuários Autenticados**: Podem realizar requisições GET para consultar produtos.
  - **Administradores**: Têm permissões para criar (`POST`), atualizar (`PUT`) e excluir (`DELETE`) produtos.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento da API RESTful.
- **JWT (JSON Web Tokens)**: Tokens para autenticação e autorização segura.

## Endpoints Principais
- **Produtos**:
  - `GET /produtos`: Retorna a lista de produtos disponíveis para usuários autenticados.
  - `POST /produtos`: Adiciona um novo produto (requer papel de administrador).
  - `PUT /produtos/{id}`: Atualiza um produto existente (requer papel de administrador).
  - `DELETE /produtos/{id}`: Remove um produto (requer papel de administrador).

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/JoaoFelipe76/api-produto-spring-boot.git
