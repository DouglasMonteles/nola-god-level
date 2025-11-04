# Projeto

Projeto desenvolvido com as tecnologias:

- backend: Springboot;
- frontend: Angular;
- banco de dados: PostgreSQL (relacional);

Linguagens de programação utilizadas:

- backend: Java;
- frontend: Typescript;
- banco de dados: SQL;

# Como utilizar a aplicação

Existem algumas formas de configurar e executar esse projeto, são elas:

## Acessando diretamente a url da aplicação

O deploy da aplicação foi realizado e ela está disponível no endereço:

- <a href="https://nola-god-level.vercel.app">https://nola-god-level.vercel.app</a>

Pelo fato dela está sendo executa em um ambiente gratuito, a primeira requisição de busca pode levar alguns segundos, já que após 30 minutos de inatividade, os containers entram em suspensão.

### Deploy

A aplicação está utilizando serviços gratuitos em três ambientes diferentes, são elas:

- Versel: Hospeda o frontend da aplicação (html, css e javascript);
- Render: Hospeda o backend da aplicação (java);
- Railway: Hospeda o banco de dados da aplicação (PostgreSQL);

Em todos, está habilitado o CI/CD, que tratar de atualizar o ambiente de produção aqui que o um novo recuso for aprovado na branch principal.

## Utilizando o docker

Podemos iniciar a aplicação utilizando o docker, que está dividido em containers de desenvolvimento e containers de produção. A principal diferença está no *Live Reload*, presente somente no desenvolvimento.

### Ambiente de desenvolvimento

Para subir o ambiente de desenvolvimento, siga os passos:

- Crie um `.env`  na raiz do projeto com o conteúdo do `.dev.example.env`;
- Execute o comando: `docker compose --profile=initialization -f docker-compose-dev.yml up --build`;

Utilize a flag `--profile=initialization` somente na primeira execução, pois ela inicia o script que popula o banco de dados.

### Ambiente de produção

Esse ambiente também serve para quem só precisa testar as funcionalidades da aplicação de forma local. Para isso, siga os passos:

- Crie um `.env`  na raiz do projeto com o conteúdo do `.prod.example.env`;
- Execute o comando: `docker compose --profile=initialization -f docker-compose-prod.yml up --build`;

Utilize a flag `--profile=initialization` somente na primeira execução, pois ela inicia o script que popula o banco de dados.

## Acessar localmente a aplicação

Após os containers iniciarem, a página web estará disponível. 

- Acesse a página web em: <a href="http://localhost:4200">http://localhost:4200</a>
- O backend pode ser acessado em: <a href="https://nola-god-level-893w.onrender.com">https://nola-god-level-893w.onrender.com</a>



