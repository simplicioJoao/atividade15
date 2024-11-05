# Sistema de Gerenciamento de Matrículas

Esta é uma aplicação Spring Boot para gerenciar matrículas de alunos em cursos, utilizando um relacionamento Many-to-Many entre as entidades `Aluno` e `Curso`. A aplicação permite realizar operações de CRUD e gerenciar as matrículas de alunos em diversos cursos.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.35
- H2 Database (em memória)
- Spring Data JPA
- Postman (para testes de API)

## Funcionalidades

- **Aluno**: Criar, listar e matricular em cursos.
- **Curso**: Criar, listar e visualizar alunos matriculados.
- **Matrícula**: Adicionar e remover matrículas de alunos em cursos específicos.

## Configuração e Execução da Aplicação

### Pré-requisitos

- Java 17 ou superior
- Maven

### Passo a Passo para Rodar a Aplicação

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/simplicioJoao/atividade15.git
   ```

2. **Compile e instale as dependências**:

   ```bash
   mvn clean install
   ```

3. **Inicie a aplicação**:

   ```bash
   mvn spring-boot:run
   ```

   A aplicação será executada no endereço: `http://localhost:8080`.

### Acessando o Console H2

1. No navegador, acesse: `http://localhost:8080/h2-console`.
2. Configure a conexão com os seguintes valores:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: `password`
3. Clique em **Connect** para visualizar e manipular os dados diretamente no banco.

## Utilização dos Endpoints

### 1. Criar um Novo Aluno

- **URL**: `POST /alunos`
- **Body (JSON)**:
  ```json
  {
    "nome": "João Silva",
    "email": "joao.silva@example.com"
  }
  ```

### 2. Criar um Novo Curso

- **URL**: `POST /cursos`
- **Body (JSON)**:
  ```json
  {
    "nome": "Matemática Avançada",
    "descricao": "Curso de matemática para alunos avançados"
  }
  ```

### 3. Matricular um Aluno em um Curso

- **URL**: `POST /alunos/{id}/cursos/{cursoId}`
- **Exemplo**: `POST /alunos/1/cursos/1`
- **Descrição**: Matricula o aluno com ID `{id}` no curso com ID `{cursoId}`.

### 4. Remover um Aluno de um Curso

- **URL**: `DELETE /alunos/{id}/cursos/{cursoId}`
- **Exemplo**: `DELETE /alunos/1/cursos/1`
- **Descrição**: Remove o aluno com ID `{id}` do curso com ID `{cursoId}`.

### 5. Listar Todos os Cursos de um Aluno

- **URL**: `GET /alunos/{id}/cursos`
- **Exemplo**: `GET /alunos/1/cursos`
- **Descrição**: Lista todos os cursos em que o aluno com ID `{id}` está matriculado.

### 6. Listar Todos os Alunos Matriculados em um Curso

- **URL**: `GET /cursos/{id}/alunos`
- **Exemplo**: `GET /cursos/1/alunos`
- **Descrição**: Lista todos os alunos matriculados no curso com ID `{id}`.

## Testando a API no Postman

1. **Crie uma nova requisição** no Postman para cada endpoint.
2. Defina o método HTTP (POST, GET, DELETE) e a URL correspondente.
3. Para requisições `POST`, defina o corpo da requisição como JSON.
4. Envie as requisições e verifique as respostas.
