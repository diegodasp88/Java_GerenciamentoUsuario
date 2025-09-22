# Gerenciador de Usuários em Java

Projeto de estudo desenvolvido em **Java**, utilizando **Maven** para gerenciamento de dependências e **MySQL** como banco de dados. O sistema realiza operações completas de **CRUD** (Create, Read, Update, Delete) para gerenciamento de usuários, contemplando dois tipos distintos: **Cliente** e **Admin**.

---

## Tecnologias Utilizadas

- Java 17+  
- Maven  
- MySQL  
- JDBC (para conexão com o banco de dados)  

---

## Funcionalidades

- Cadastro de usuários (Cliente e Admin)  
- Consulta de usuários por ID ou listagem completa  
- Atualização de informações de usuários  
- Exclusão de usuários  
- Diferenciação de permissões entre Cliente e Admin  

---

## Modelagem de Dados

Todos os usuários possuem os seguintes atributos básicos:  

- **Nome**  
- **E-mail**  
- **Senha**  

O sistema está preparado para permitir expansão futura, caso novos tipos de usuários ou atributos sejam necessários.

---

## Estrutura do Projeto

O projeto segue uma organização modular com Maven, contendo pacotes como:

- `app` — contém a classe principal (com main) 
- `model` — contém classes de entidades (usuário, cliente, admin)  
- `dao` — contém classes responsáveis pelas operações CRUD  
- `view` — contém a parte de interação (menus, prints, interface de console) 

---

## Como Executar

1. Clone o repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   
2. Configure o banco de dados MySQL e atualize as credenciais na classe de conexão `(ConexaoBD)`.

3. Compile e execute a aplicação usando Maven:

```bash
mvn clean compile exec:java
```

--- 

## Observações
Este projeto é de caráter acadêmico e de estudo, focado em:
- Aplicação de POO em Java
- Uso do Maven
- Conexão com banco de dados relacional
- Implementação de operações CRUD

---

## Licença
Este projeto é livre para estudos e melhorias.
