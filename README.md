# Teste Java Developer

API desenvolvida para o case técnico da TGID. Ela tem como objetivo persistir informações sobre os clientes, as empresas e realizar transações.

## Visão Geral

Este documento fornece informações sobre os endpoints da API para a aplicação.

## Diagrama de Classes

![Modelagem de Dados - TGID](https://github.com/user-attachments/assets/821c6b30-a65b-4ee6-a223-c99f058a0bd4)

## Utilização

1. Clone o repositório:
   ```bash
   git clone https://github.com/guilherme-SN/teste-java-developer-tgid.git
   ```
2. Configure as variáveis de ambiente:
   ```bash
   # Para Linux/MacOS
   export DB_NAME=nome_do_banco
   export DB_USERNAME=usuario
   export DB_PASSWORD=senha
   
   # Para Windows
   set DB_NAME=nome_do_banco
   set DB_USERNAME=usuario
   set DB_PASSWORD=senha
   ```
3. Rode o projeto com o maven:
   ```bash
   mvn spring-boot:run
   ```

## URL Base

[http://localhost:8080](http://localhost:8080)

## Endpoints

### Criar uma Taxa

- **URL**: `/api/taxes`
- **Método**: `POST`
- **Descrição**: Cria uma nova taxa.
- **Corpo da Requisição**:

    ```json
    {
        "type": "Tipo da taxa",
        "percentual": 0.05
    }
    ```

### Obter Taxa por ID

- **URL**: `/api/taxes/{id}`
- **Método**: `GET`
- **Descrição**: Recupera os detalhes de uma taxa pelo seu ID.
- **Parâmetros**:

    - **Parâmetro de Caminho**:
        - `id` (Long): O ID da taxa.


### Criar uma Empresa

- **URL**: `/api/companies`
- **Método**: `POST`
- **Descrição**: Cria uma nova empresa.
- **Corpo da Requisição**:

    ```json
    {
        "cnpj": "12.345.678/0000-00",
        "name": "Nome da empresa",
        "balance": 100000.00,
        "taxesId": [1, 2]
    }
    ```

### Obter Empresa por ID

- **URL**: `/api/companies/{id}`
- **Método**: `GET`
- **Descrição**: Recupera os detalhes de uma empresa pelo seu ID.
- **Parâmetros**:

    - **Parâmetro de Caminho**:
        - `id` (Long): O ID da empresa.


### Criar um Cliente

- **URL**: `/api/clients`
- **Método**: `POST`
- **Descrição**: Cria um novo cliente.
- **Corpo da Requisição**:

    ```json
    {
        "cpf": "123.456.789-00",
        "name": "Nome do cliente",
        "companiesId": [1, 2]
    }
    ```

### Obter Cliente por ID

- **URL**: `/api/clients/{id}`
- **Método**: `GET`
- **Descrição**: Recupera os detalhes de um cliente pelo seu ID.
- **Parâmetros**:

    - **Parâmetro de Caminho**:
        - `id` (Long): O ID do cliente.


### Realizar uma Transação

- **URL**: `/api/transactions`
- **Método**: `POST`
- **Descrição**: Inicia uma transação entre um cliente e uma empresa.
- **Corpo da Requisição**:

    ```json
    {
        "clientId": 2,
        "companyId": 3,
        "type": "WITHDRAWAL",
        "amount": 1000.00
    }
    ```
