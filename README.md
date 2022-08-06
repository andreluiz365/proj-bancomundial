# proj-bancomundial
proj api consulta banco mundial

##Contextualização

O Banco Mundial https://www.worldbank.org/  mantém uma série de indicadores econômicos disponibilizados na web como arquivos para download e APIs.

Um desses dados é o indicador que avalia a quantidade de pessoas em situação de extrema pobreza no mundo, vivendo com até $ 1,90/dia (dólar).

Este desafio consiste em construir uma aplicação que apresente os indicadores de determinado país (um por vez), ordenados por ano.

A aplicação deve permitir que o usuário digite o código do país para em seguida solicitar os índices históricos. Ou seja, quando o usuário entrar no sistema, irá visualizar um formulário, após o preenchimento e submissão desse, será apresentada uma tabela com o resultado obtido da API do Banco Mundial.

##Estruturação da aplicação

A aplicação deve ser dividida em dois programas:

a. Aplicação front-end para viabilização de interação com o usuário;

b. Microsserviço para desempenhar o papel de back-end.

Este será responsável por solicitar os dados à API do Banco Mundial e retornar para o front-end.

O front-end não deve se comunicar diretamente com a API do Banco Mundial.

##Detalhes da API de indicadores de pobreza do Banco Mundial

A API a ser consumida é a seguinte:

http://api.worldbank.org/v2/country/{id}/indicator/SI.POV.DDAY?format=json

Note a variável “id” na URL

Os possíveis códigos de país (CODIGO_DO_PAI S) estão descritos aqui:


http://api.worldbank.org/v2/country


##Requisitos técnicos

Obrigatórios:

- [X] O back-end deve ser escrito em Java;

- [X] O front-end deve ser escrito em Angular versão 9;

- [X] Expor uma API REST no microsserviço de back-end;

- [X] Fazer com que o front-end consuma a API REST do back-end;

- [X] A API REST a ser criada no back-end deve ser documentada e permitir acesso via SwaggerUI;

- [X] Fazer com que a aplicação funcione com docker, onde os containers sejam regidos por docker-compose;

- [] Testes automatizados e efetivos;

##Desejáveis:

- [X] Escrever o back-end utilizando o framework Quarkus;
 
- [X] A atividade de Desenvolvimento deverá ser “commitada” no GitHub ou GitLab, não serão aceitos commits feitos após o prazo;

• Escrever em um documento Word ou ReadMe com:

- [X]o Passos a serem seguidos para inicializar a aplicação via docker;


## incializando a aplicação 

### fase 1
Faça o clone do projeto
```shell script
$ git clone https://github.com/andreluiz365/proj-bancomundial.git proj-bancomundial
```

### fase 2 
Entre na pasta raiz do projeto

```shell script
$ cd proj-bancomundial
```

### fase 3

```shell script
$ cd backend
```

### fase 4 
Executar o comando do maven para gerar o artefato que será publicado no docker

```shell script
$ cd mvn clean install
```

### fase 5
Voltar para pasta raiz

```shell script
$ cd ..
```

OBS: Replicar Passo 3, 4 e 5 para o api e getapi

### fase 6
Execute o comando para levantar toda infraestrutura necessária

```shell script
$ docker-compose up --build
```

Acompanhar logs: 
```shell script
$ docker-compose logs -f
```

# Metodo para consumir Endpoints

## capturar info de paises
**uri de requisição:**
```
http://localhost:8080/api/v1/paises
```
**param de vars:**

param | default | format | type | description | exemple
--- | --- | --- | --- | --- | ---  
paginaAtual | default  | X  | number  | num pag exibição | 2
porPagina | default | X | number | num de item pag | 50 

**via curl:**
```shell script
curl -X GET "http://localhost:8080/api/v1/paises?paginaAtual=1&porPagina=50" -H  "accept: */*"
```