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

http://api.worldbank.org/v2/country/{CODIGO_DO_PAIS}/indicator/SI.POV.DDAY?format=json

Note a variável “CODIGO_DO_PAIS” na URL

Os possíveis códigos de país (CODIGO_DO_PAI S) estão descritos aqui:


http://api.worldbank.org/v2/country


##Requisitos técnicos

Obrigatórios:

• O back-end deve ser escrito em Java;

• O front-end deve ser escrito em Angular versão 9;

• Expor uma API REST no microsserviço de back-end;

• Fazer com que o front-end consuma a API REST do back-end;

• A API REST a ser criada no back-end deve ser documentada e permitir acesso via SwaggerUI;

• Fazer com que a aplicação funcione com docker, onde os containers sejam regidos por docker-compose;

• Testes automatizados e efetivos;

##Desejáveis:

• Escrever o back-end utilizando o framework Quarkus;
 
• A atividade de Desenvolvimento deverá ser “commitada” no GitHub ou GitLab, não serão aceitos commits feitos após o prazo;

• Escrever em um documento Word ou ReadMe com:

    o Passos a serem seguidos para inicializar a aplicação via docker;

    o História(s) de usuário que darão origem à aplicação contendo:

             - Até 3 critérios de aceitação
             - Até 5 cenários de testes