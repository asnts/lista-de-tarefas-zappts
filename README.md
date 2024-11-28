# Bem vindo(a) ao sistema de listas de tarefas 📝 #

## Esta aplicação tem como objetivo o gerenciamento de tarefas na qual é possivel:

### • Adicionar tarefas ➕
### • Atualizar tarefas 🔄
### • Listar tarefas 📃
### • Excluir tarefas ❌

## Tecnologias

### • [Spring Boot](https://spring.io/projects/spring-boot)
### • [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
### • [SpringDoc OpenAPI](https://www.baeldung.com/spring-rest-openapi-documentation)
### • [Database H2](https://www.h2database.com/html/main.html) 

## Como executar esta aplicação:

### • Clonar repositorio git:

` git clone https://github.com/asnts/lista-de-tarefas-zappts.git `


### • Construir o projeto:
` $ ./mvnw clean package `

### • Executar esta aplicação:
` $ java -jar target/lista-de-tarefas-0.0.1-SNAPSHOT.jar `
### • Acessar API:
#### A API poderá ser acessada em: localhost:8080
#### O Swagger desta aplicação está disponivel em: http://localhost:8080/swagger-ui/index.html

## API Endpoints
#### Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta Postman:

### • Criar Tarefa

` $  http POST :8080/tarefas `
 

```yaml
{
"id": " ",
"titulo": "Titulo da tarefa",
"descricao": "Descrição da tarefa",
"status" : "PENDENTE",
"data criacao": " ",
"data conclusao": " "
} 

``` 
#### Obs 1: Tanto o id, quanto a data de criação e conclusão não precisam ser preenchidas pois o sistema preenche automaticamente; <br> 
#### Obs 2: Os únicos formatos de status aceitos são: PENDENTE, EM_ANDAMENTO E CONCLUIDA todos em letra maiúscula. Se não seguir este formato receberá um erro de bad request


### • Listar Tarefas

` $  http GET :8080/tarefas `

```yaml
{
"id": "1",
"titulo": "Titulo da tarefa",
"descricao": "Descrição da tarefa",
"status" : "PENDENTE",
"data criacao": "2024-11-27T19:48:15.626675",
"data conclusao": "null"
} 

``` 

### • listar Tarefas Paginadas

` $  http GET :8080/tarefas?page=0&size=2 `

```yaml
{
  "content": [
    {
      "id": 1,
      "titulo": "Ajustar paginacao",
      "descricao": "Tarefas paginadas",
      "status": "CONCLUIDA",
      "dataCriacao": "2024-11-28T18:11:19.65611",
      "dataConclusao": "2024-11-28T18:17:25.017979"
    },
    {
      "id": 2,
      "titulo": "Ajustar response",
      "descricao": "Operacoes com sucesso ou nao",
      "status": "EM_ANDAMENTO",
      "dataCriacao": "2024-11-28T18:11:37.291006",
      "dataConclusao": null
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 2,
    "sort": {
      "empty": true,
      "unsorted": true,
      "sorted": false
    },
    "offset": 0,
    "unpaged": false,
    "paged": true
  },
  "last": false,
  "totalPages": 5,
  "totalElements": 10,
  "first": true,
  "size": 2,
  "number": 0,
  "sort": {
    "empty": true,
    "unsorted": true,
    "sorted": false
  },
  "numberOfElements": 2,
  "empty": false
}

``` 


### • Atualizar Tarefas

` $  http PUT :8080/tarefas/1 `

```yaml
{
"id": "1",
"titulo": "Titulo da tarefa",
"descricao": "Descrição da tarefa",
"status" : "EM_ANDAMENTO",
"data criacao": "2024-11-27T19:48:15.626675",
"data conclusao": "null"
} 

``` 


### • Excluir Tarefas

` $  http DELETE :8080/tarefas/1 `

```yaml
[]

``` 

## Configuração do Banco de Dados

#### Este projeto utiliza o banco de dados **H2** em modo persistente para gerenciar as informações. 

### Configuração:

#### As propriedades deste banco estão configuradas no arquivo application.properties

### Acesso:

#### Para acessar o banco de dados desta aplicação acesse:

`  $ http://localhost:8080/h2-console `

#### Use o seguinte URL JDBC: 

`  $ jdbc:h2:file:./data/lista_de_tarefas `

#### Usuario:

`  sa `

#### Senha:

Deixe em branco ou configure uma de sua escolha 

#### Para verificar os dados:

`   SELECT * FROM Tarefas; `




