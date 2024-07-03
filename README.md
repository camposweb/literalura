# Projeto Literalura

## Proposta do projeto

Este projeto foi uma desafio (Challenge) proposto na capacitação 
ONE - Oracle Next Education, promovida pela Oracle com a Alura, 
no qual foi desenvolvido o programa de pesquisa de livros, adicionando os livros no banco de dados postgresql, 
a API utilizada foi a [Gutendex](https://gutendex.com/). Decidi realizar os commits pela
especificação [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/), uma conversão
simples para utilizar nas mensagens de commit.

O programa contém as seguintes funcionalidades:

1. Busca de livro por título
2. Listagem de todos os livros
3. Listagem com base no idioma
4. Listagem de todos os autores
5. Listagem de autores por livro
6. Listagem de autores vivos por ano
7. Listagem de quantidade de livros por idioma
8. Listagem de autores vivos por ano DATABASE
9. Top 10 com mais downloads
10. Busca de autores por nomes

A seguir listei alguns livros para o usuário popular o banco de dados:

````
dom casmurro

el clavo

contos

contos infantis

tragedias

niebla

poemas

paternidad

el deseo

la odisea

la vita nuova

ottavia

agide

la tempesta

la sorella

````


### Banco de dados

Recomendo instalar o [Docker](https://www.docker.com/products/docker-desktop/) para utilizar o banco de dados PostgresSQL.
Com o Docker instalado segue o script para executar um container PostgreSQL:

````docker
docker container run --name postgre-sql -v postgres_sql:/var/lib/postgresql/data -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -p 5432:5432 -d postgres:latest
````

### Variáveis de ambiente

Criei uma variável de ambiente, pois não é recomendável utilizar chaves de acesso de forma explícita seja ele em softwares
no modo desenvolvimento quanto em produção.

Links para configurar variáveis de ambiente:

[link 1](https://www.baeldung.com/intellij-idea-environment-variables)

[link 2](https://www.jetbrains.com/help/objc/add-environment-variables-and-program-arguments.html)