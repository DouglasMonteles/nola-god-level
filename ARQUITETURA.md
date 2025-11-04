# Arquitetura do Sistema

1. Visão Geral

O sistema é composto por uma arquitetura em três camadas (three-tier architecture), dividida em frontend, backend e banco de dados, todos executados de forma isolada e integrada através de contêineres Docker orquestrados pelo Docker Compose.

A comunicação entre as camadas ocorre por meio de requisições HTTP e APIs RESTful, com dados trafegando no formato JSON.

2. Frontend – Angular
 
- Tecnologia: Angular
- Função: Responsável pela interface com o usuário (UI), exibindo dados e capturando interações.
- Comunicação: Envia requisições HTTP ao backend através do serviço HttpClient, utilizando o apiUrl definido em variáveis de ambiente (environment.ts).
- Build: O aplicativo é compilado em TypeScript e servido via servidor Node interno ou via Nginx (dependendo do ambiente).

Principais características:

- Arquitetura modular (módulos, componentes e serviços);
- Consumo de endpoints REST do backend;
- Rotas gerenciadas pelo RouterModule do Angular;
- Uso de interceptors para autenticação e headers de segurança.


3. Backend – Spring Boot

- Tecnologia: Spring Boot (Java)
- Função: Responsável pela lógica de negócio, validação de dados e exposição das APIs REST consumidas pelo frontend.

Camadas internas:

- Controller: Recebe e responde às requisições HTTP;
- Service: Contém as regras de negócio;
- Repository: Comunicação direta com o banco de dados via JPA/Hibernate;
- Model: Representa as entidades do domínio.

Recursos adicionais:

- Spring Data JPA para abstração de persistência;
- Liquibase para versionamento de banco;
- Spring Security (autenticação);
- Profiles para separar ambientes (dev, prod).


4. Banco de Dados – PostgreSQL

- Tecnologia: PostgreSQL
- Função: Armazena dados relacionais de forma persistente.
- O backend se conecta por meio do driver JDBC, com a URL e credenciais configuradas via variáveis de ambiente application.properties.

Exemplo de configuração:

```
spring:
  datasource:
    url: jdbc:postgresql://postgres:5432/meubanco
    username: usuario
    password: senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

5. Infraestrutura – Docker e Docker Compose

- Docker: Cada componente (frontend, backend e banco de dados) é empacotado em um contêiner isolado, garantindo portabilidade e reprodutibilidade do ambiente.
- Docker Compose: Faz a orquestração desses contêineres, definindo dependências, redes e volumes em um único arquivo docker-compose.yml.


Exemplo simplificado:

```
version: '3.8'
services:
  backend:
    build: ./backend
    container_name: backend
    environment:
      - SPRING_PROFILES_ACTIVE=dev
      - DB_HOST=postgres
    ports:
      - "8080:8080"
    depends_on:
      - postgres
    networks:
      - app-network

  frontend:
    build: ./frontend
    container_name: frontend
    ports:
      - "4200:80"
    depends_on:
      - backend
    networks:
      - app-network

  postgres:
    image: postgres:16
    container_name: postgres
    environment:
      - POSTGRES_USER=usuario
      - POSTGRES_PASSWORD=senha
      - POSTGRES_DB=meubanco
    volumes:
      - db-data:/var/lib/postgresql/data
    networks:
      - app-network

networks:
  app-network:
    driver: bridge

volumes:
  db-data:
```


6. Fluxo de Comunicação

- O usuário acessa a aplicação Angular pelo navegador (porta 4200).
- O frontend envia requisições HTTP (ex: GET /api/produtos) para o backend Spring Boot (porta 8080).
- O backend processa a requisição, aplica as regras de negócio e consulta o PostgreSQL.
- O resultado é retornado em formato JSON para o frontend, que atualiza a interface.

7. Benefícios da Arquitetura

- Separação clara de responsabilidades;
- Facilidade de manutenção e escalabilidade;
- Reprodutibilidade do ambiente com Docker;
- Deploy simplificado (um comando docker-compose up);
- Independência entre as camadas (pode-se substituir ou atualizar partes sem afetar o todo).