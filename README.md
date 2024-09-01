# Teste Java Developer

API desenvolvida para o case técnico da TGID. Ela tem como objetivo persistir informações sobre os clientes, as empresas e realizar transações.

## Visão Geral

Este documento fornece informações sobre os endpoints da API para a aplicação.

## Diagrama de Classes



## Utilização



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
        "percentual": <percentual da taxa>
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
        "cnpj": "XX.XXX.XXX/XXXX-XX",
        "name": "Nome da empresa",
        "balance": <saldo>,
        "taxesId": [<ID das taxas>]
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
        "cpf": "XXX.XXX.XXX-XX",
        "name": "Nome do cliente",
        "companiesId": [<ID das empresas>]
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
        "clientId": <ID do cliente>,
        "companyId": <ID da empresa>,
        "amount": <quantidade>
    }
    ```
