API-WEB-JAVA-SPRINGBOOT
Este é um projeto de uma API WEB desenvolvida em Java utilizando o framework Spring Boot. A API é responsável por gerenciar um sistema de cadastro de produtos.

Funcionalidades
A API possui as seguintes funcionalidades:

Cadastrar um produto
Listar todos os produtos cadastrados
Consultar um produto pelo ID
Atualizar um produto pelo ID
Excluir um produto pelo ID
Tecnologias Utilizadas
Java 8
Spring Boot 2.5.0
Maven 3.8.1
Banco de Dados H2 (para ambiente de desenvolvimento)
Banco de Dados PostgreSQL (para ambiente de produção)
Como executar
Para executar o projeto, siga os passos abaixo:

Faça o clone deste repositório: git clone https://github.com/carl0sfelipe/API-WEB-JAVA-SPRINGBOOT.git
Entre na pasta do projeto: cd API-WEB-JAVA-SPRINGBOOT
Execute o comando: mvn spring-boot:run
A aplicação estará disponível no endereço http://localhost:8080.

Configurações do Banco de Dados
Para ambiente de desenvolvimento, o banco de dados utilizado é o H2. As configurações podem ser encontradas no arquivo application-dev.properties.

Para ambiente de produção, o banco de dados utilizado é o PostgreSQL. As configurações podem ser encontradas no arquivo application-prod.properties.

Documentação da API
A documentação da API pode ser acessada através do link http://localhost:8080/swagger-ui.html. Essa documentação foi gerada automaticamente através do Swagger.

Frontend do projeto API-WEB-JAVA-SPRINGBOOT
Este é o projeto frontend para consumir a API desenvolvida em Java utilizando o framework Spring Boot. O frontend foi desenvolvido utilizando a biblioteca React.

Funcionalidades
O frontend possui as seguintes funcionalidades:

Listar todos os produtos cadastrados
Consultar um produto pelo ID
Cadastrar um novo produto
Atualizar um produto existente
Excluir um produto existente
Tecnologias Utilizadas
React 17.0.2
React Router 5.2.0
Axios 0.21.1
Bootstrap 5.1.0
Como executar
Para executar o projeto, siga os passos abaixo:

Faça o clone deste repositório: git clone https://github.com/carl0sfelipe/API-WEB-JAVA-SPRINGBOOT.git
Entre na pasta do projeto frontend: cd API-WEB-JAVA-SPRINGBOOT/frontend
Execute o comando: npm install
Execute o comando: npm start
A aplicação estará disponível no endereço http://localhost:3000.

Configurações
As configurações da API são definidas no arquivo src/services/api.js. Se necessário, você pode alterar o valor da constante BASE_URL para apontar para a URL da sua API.
