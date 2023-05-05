## :bank: Projeto Banco - Backend (Spring Boot)

### :page_facing_up: Introdução

Este projeto é uma aplicação web desenvolvida em Spring Boot para gerenciar operações bancárias. Ele possui um backend RESTful API que se comunica com um frontend em React para realizar as operações de gerenciamento.

### :wrench: Dependências

As principais dependências do projeto incluem:

- Spring Boot Starter Data JPA: para facilitar o acesso ao banco de dados usando o JPA
- Spring Boot Starter Validation: para validação de dados e objetos
- Spring Boot Starter Web: para criar aplicativos web usando o Spring MVC
- Spring Boot DevTools: para facilitar o desenvolvimento e depuração
- MySQL Connector/J: para conectar-se ao banco de dados MySQL
- H2 Database: para usar o banco de dados em memória H2
- Lombok: para reduzir a quantidade de código boilerplate
- SpringFox Swagger2: para gerar documentação da API usando o Swagger
- SpringDoc OpenAPI Starter WebMvc UI: para gerar documentação da API usando o OpenAPI

### :hammer_and_wrench: Build

O projeto é construído usando o Maven. O plugin `spring-boot-maven-plugin` é usado para criar um arquivo JAR executável. A configuração do plugin exclui a dependência do Lombok do artefato final.

---

## :gear: Instruções de instalação e execução

### :computer: Frontend (React)

1. Clone o repositório do projeto.
2. Navegue até o diretório do projeto React e instale as dependências com `npm install` ou `yarn`.
3. Execute o aplicativo em modo de desenvolvimento com `npm start` ou `yarn start`.
4. Acesse o aplicativo no navegador em `http://localhost:3000`.

### :computer: Backend (Spring Boot)

1. Clone o repositório do projeto.
2. Navegue até o diretório do projeto Spring Boot e construa o projeto com `mvn clean install`.
3. Execute o aplicativo com `mvn spring-boot:run` ou execute o arquivo JAR gerado no diretório `target`.
4. A API estará disponível em `http://localhost:8080`. A documentação da API gerada pelo Swagger ou OpenAPI pode ser acessada em `http://localhost:8080/swagger-ui.html` ou `http://localhost:

## :bank: Projeto Banco - Frontend (React)

### :page_facing_up: Introdução

Este projeto é uma aplicação web desenvolvida em React para gerenciar operações bancárias. Ele possui um frontend que se comunica com um backend em Spring Boot para realizar as operações de gerenciamento.

### :wrench: Dependências

As principais dependências do projeto incluem:

- React e ReactDOM (versão 18.2.0)
- React Router DOM (versão 6.11.1)
- Axios (versão 1.4.0) para realizar chamadas API
- Bibliotecas de teste, incluindo Testing Library (Jest e React)

### :computer: Scripts

Os scripts disponíveis no projeto incluem:

- `start`: Inicia o servidor de desenvolvimento do React
- `build`: Cria uma versão de produção otimizada do aplicativo
- `test`: Executa os testes do aplicativo
- `eject`: Ejeta a configuração do projeto do CRA (Create React App)

---
