## Sistema Cartao Identificacao

Objetivo:

Esta aplicação foi desenvolvida com a **finalidade de ser uma API REST** responsável por gerenciar as informações dos empregados através de cartões de identificação, por meio de requisições HTTP, tornado possível inserir novos cartões no sistema, obter apenas um cartão ou a lista de todos os cartões, alterar um cartão ou deletar um cartão.

### Das tecnologias utilizadas no desenvolvimento:
1. Foi utilizado a **linguagem de programação Java**, dado seu paradigma orientado a objetos, que nos possibilita uma melhor modelagem dos requisitos de negócio.
2. Além da linguagem Java foi utilizado o **framework Spring Boot** sendo ele uma das mais importantes bibliotecas para desenvolvimento de aplicações seguras, resilientes e escaláveis do mercado.
3. Para armazenar as informações dos funcionários foi utilizado o **SGBD MySQL**, sendo ele um banco de dados relacional, e um dos mais utilizados mundialmente.

#### Modo de uso:
**Método**: POST - **Endpoint:** http://localhost:8080/cartaoidentificacao/save
**Descrição**: Endpoint utilizado para cadastrar um novo cartão de identificação ou atualizar um cartão de identificação já existente.

**Request:**: 
```json
1. Exemplo de requisição para inserção de novo cartão:
Body: {
    "nome": "Jose Afonso Silva",
    "cpf": "111.222.333-99",
    "email": "email@email.com",
    "telefone": "(61)9.9999-9999",
    "tipo_sanguineo": "B-",
    "alergias": [
        { "nome": "Lactose" },
    ],
    "saude": [
        { "problemaMedico": "Hipertensão" }
    ]
}

1. Exemplo de requisição para atualização de cartão (o campo id_matricula deve vir preenchido):
Body: {
    "id_matricula": "1", 
    "nome": "Jose Afonso Silva",
    "cpf": "111.222.333-99",
    "email": "email@email.com",
    "telefone": "(61)9.9999-9999",
    "tipo_sanguineo": "B-",
    "alergias": [
        { "nome": "Lactose" },
    ],
    "saude": [
        { "problemaMedico": "Hipertensão" }
    ]
}

```
**Response:**:
```json
1. Ao ser invocada esta requisição retorna o cartão de identificação do funcionario com o campo id_matricula:
Body: {
    "nome": "Jose Afonso Silva",
    "cpf": "111.222.333-99",
    "email": "email@email.com",
    "telefone": "(61)9.9999-9999",
    "tipo_sanguineo": "B-",
    "alergias": [
        { "nome": "Lactose" },
    ],
    "saude": [
        { "problemaMedico": "Hipertensão" }
    ]
}

```
**Método**: GET - **Endpoint:** http://localhost:8080/cartaoidentificacao?id=id_matricula
**Descrição**: Endpoint utilizado para buscar informações de um cartão de identificação existente.

http://localhost:8080/cartaoidentificacao?id=5
**Request:**: 
```json
1. Exemplo de requisição para buscar o cartão de identificação de um funcionario com a matricula 5:

http://localhost:8080/cartaoidentificacao?id=5

```
**Response:**:
```json
1. Ao ser invocada esta requisição retorna o cartão de identificação do funcionario:
{
    "id_matricula": "5", 
    "nome": "Jose Afonso Silva",
    "cpf": "111.222.333-99",
    "email": "email@email.com",
    "telefone": "(61)9.9999-9999",
    "tipo_sanguineo": "B-",
    "alergias": [
        { "nome": "Lactose" },
    ],
    "saude": [
        { "problemaMedico": "Hipertensão" }
    ]
}

```
**Método**: GET - **Endpoint:** http://localhost:8080/cartaoidentificacao/listartodos
**Descrição**: Endpoint utilizado para buscar todos os cartões de identificação disponiveis na base dados.

**Response:**:
Ao ser invocada esta requisição retorna uma lista de cartões:
```json
[
    {
        "id_matricula": "1", 
        "nome": "Pedro Antonio de Oliveira",
        "cpf": "111.222.333-99",
        "email": "email@email.com",
        "telefone": "(61)9.9999-9999",
        "tipo_sanguineo": "A-",
        "alergias": [
            { "nome": "Frutos do Mar" },
        ],
        "saude": []
    },
    {
        "id_matricula": "2", 
        "nome": "Jose Afonso Silva",
        "cpf": "111.222.333-99",
        "email": "email@email.com",
        "telefone": "(61)9.9999-9999",
        "tipo_sanguineo": "B-",
        "alergias": [
            { "nome": "Lactose" },
        ],
        "saude": [
            { "problemaMedico": "Hipertensão" }
        ]
    }
    {
        "id_matricula": "3", 
        "nome": "Maria Antonio Gonçalves",
        "cpf": "111.222.333-99",
        "email": "email@email.com",
        "telefone": "(61)9.9999-9999",
        "tipo_sanguineo": "O-",
        "alergias": [],
        "saude": []
    }

]

```
**Método**: DELETE - **Endpoint:** http://localhost:8080/cartaoidentificacao?id=id_matricula

**Descrição**: Endpoint utilizado para excluir um determinado cartão de identificação baseado no id_matricula informado.

**Request:**:
    http://localhost:8080/cartaoidentificacao?id=1

**Response:**
```
Cartão excluído com sucesso
```
