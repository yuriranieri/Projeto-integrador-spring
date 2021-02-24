## MUNDOMÁTICA
## Projeto Integrador (PI) versão API com Spring Boot
### Faculdade SENAI - 2020.2
Este Projeto é um cadastro simples de perguntas e respostas, com foco em melhorar a didática dos professores em sala de aula, e ao mesmo tempo, tornar a Matemática uma matéria 
divertida e fácil de se aprender. No primeiro momento este jogo será desenvolvido apenas para os alunos do Ensino Fundamental I.

Esse projeto, foi desenvolvido para treinar meus conhecimentos em Spring Boot. Ele foi baseado no PI que realmente foi desenvolvido na 2° fase da faculdade SENAI, 
o qual, está disponivel nesse [respositorio](https://github.com/yuriranieri/Projeto-Integrador-PI) onde possui mais informações. O PI, feito no SENAI, é um projeto completo 
com interfaces gráficas e para conectar com Banco de Dados somente o JDBC então decidi ciar um API REST com a mesma ideia porém desenvolvida com Spring Boot

Foi utilizado como SGBD (Sistema Gerenciador de Banco de Dados) o *`PostgreSql`*. [Baixar PostgreSQL](https://www.postgresql.org/download/). 

Para gerar um projeto Spring utilizei o [Spring Tools 4 for Eclipse](https://spring.io/tools). Na criação do projeto adicionei as seguintes dependencias: 
- *`Spring Web`* que utiliza *`Spring MVC`*
- *`Spring Data JPA`* 
- *`PostgreSQL Driver`* que faz a conexão com o banco de dados através do JDBC
- *`Validation`* que utiliza Bean Validation com Hibernate validator

Para realizar a conexão com o banco é necessário criar um DATABASE no PostgreSQL e em seguida ir no arquivo *`application.properties`* e modificar a URL, o username e a senha.

Para testar a API utilizei a ferramenta *`Postman`* [Baixar Postman](https://www.postman.com/downloads/), e passei as URL de cada método HTTP (get, post, put, delete).

------------------------------------

## Autor
- Yuri Ranieri
- yurifranieri@gmail.com
