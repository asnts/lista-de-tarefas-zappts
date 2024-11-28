# Bem vindo(a) ao sistema de listas de tarefas 📝 #

## Esta aplicação tem como objetivo o gerenciamento de tarefas onde é possivel:

### • Adicionar tarefas ➕
### • Editar e atualizar tarefas 🔄
### • Excluir tarefas ❌

## Tecnologias

### • Spring Boot
### • Spring MVC
### • Database H2

## Como executar esta aplicação:

### • Clonar repositorio git:

` git clone https://github.com/asnts/lista-de-tarefas-zappts.git `


### • Construir o projeto:
` $ ./mvnw clean package `

### • Executar esta aplicação:
` $ java -jar target/lista-de-tarefas-0.0.1-SNAPSHOT.jar `
### • Acessar API:
A API poderá ser acessada em: localhost:8080
O Swagger desta aplicação está disponivel em: http://localhost:8080/swagger-ui/index.html

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


### • listar Tarefas

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

### • Atualizar Tarefas

` $  http PUT :8080/tarefas/1 `

```yaml
{
"id": "1",
"titulo": "Titulo da tarefa",
"descricao": "Descrição da tarefa",
"status" : "CONCLUIDA",
"data criacao": "2024-11-27T19:48:15.626675",
"data conclusao": "null"
} 

``` 


### • Excluir Tarefas

` $  http DELETE :8080/tarefas/1 `

```yaml
[]

``` 