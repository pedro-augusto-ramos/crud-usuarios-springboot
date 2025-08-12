
# Projeto - Gerenciamento de Usuários em Spring Boot - API REST

Esta API realiza o gerenciamento de usuários, fazendo o cadastro, atualizando os dados, buscando os usuários e removendo eles. 
Foi realizado com spring boot, arquitura em camadas, banco H2 Database e Git.
## Objetivo do Projeto
O projeto surgiu a partir dos meus estudos em  Spring Boot e muita curiosidade de como era feita uma API REST. Para isso li a documentação, artigos e videos na internet, e, decidi fazer sozinho a minha API, colocando o máximo de conhecimentos para fazer um primeiro projeto legal.

**Detalhe**: O projeto anterior de crud de usuários em java puro me ajudou em algumas coisas nesse aqui.
## Funcionalidades

- Criar um novo usuario
- Busca um usuario
- Busca pelo id do usuario
- Atualiza pelo id do usuario
- Deleta pelo id do usuario


## Estrutura utilizada
O projeto foi estruturado na arquitetura de camadas (entities, repository, service, controller)

com.pedroramos.crudusuarios

├── controller        → Camada de controle (respostas da API)

├── model            → Modelo de dados para o banco.

├── repository        → Persistencia de dados no H2

├── service           → Regras de negócio

└── exceptions        → Exceções personalizadas





## Tecnologias utilizadas

Nesse projeto utilizei:

- Java 21
- Spring Boot 3.5.4
- Spring Data JPA  e Hibernate
- Lombok (redução de código boilerplate)
- Maven
- Git (utilizei o padrao de commit e o padrao de branchs)
- Banco de dados H2 Database


## Uso/Exemplos

**Todos os testes que realizei foram no Insomnia.**

### Criar Usuario (POST /usuarios)
```
{
    "nome": "Pedro", 
    "email": "pedro@email.com", 
    "idade": 22
}

```
- Envio de um usuário  com os campos, nome, email e idade (String, String, Integer)
- Obs: Não é necessario passar o id na hora de cadastrar, o banco autogera um id de forma incrementável.

### Buscar Usuario (GET /usuarios)
```
[
  {
    "id": 1,
    "nome": "Pedro",
    "email": "pedro@email.com",
    "idade": 22
  }
]
```
- Retorna todos os usuários dentro do banco de dados.

### Buscar Usuario pelo Id (GET /usuarios/{id})
```
 {
    "id": 1,
    "nome": "Pedro",
    "email": "pedro@email.com",
    "idade": 22
  }
```
- Ele retorna o usuario achado com base no id passado, podendo lançar uma exceção e uma mensagem se não achar o usuario.

### Atualizar o Usuario pelo ID (PUT /usuarios/{id})

- Ele recebe um id e um novo objeto de Usuario, setando novos valores e modificando o usuario antigo no repository.

### Remover o Usuario pelo ID (DELETE /usuarios/{id})

- Ele recebe um id que irá passar por uma validação de existencia e irá remover aquele usuario do banco em memoria.
## Tratamento de Erros e HTTP
Um dos maiores desafios de projeto foi o tratamento de erros e respostas HTTP, pesquisei muito e apliquei o que eu sabia para chegar nisso. Esse desafio me deu uma visão diferente sobre tratamento de erros e foi muito legal. Os erros cobertos foram:
    
    - Usuario não encontrado
    - Nenhum usuario registrado
    - Dados inválidos no cadastro

- Além de validações de campos obrigatorios (nome, email, idade).

- Além de respostas HTTP que façam sentido ao endpoint, tanto na hora de sucesso quando na hora de entender qual tipo de erro ocorreu.
## Aprendizados

- Este projeto foi bem desafiador e necessitou de muito pensamento lógico, análitico e muita pesquisa autodidata. Algumas horas falhava alguns itens e outras vinha a correção, com tudo isso esses foram meus aprendizados:
    
    - Uso do git com commits bem estruturas e branch para cada função que fiz
    - Aprendizado sobre API REST, tratamento de respostas HTTP, envio de respostas com ResponseEntity
    - Conceitos web
    - Generics em Java
    - Como o JPA trabalha e como usar banco de dados SQL
    - Tratamento de exceções personalizadas
    - Banco H2 Database
    - Programação orientada a objetos
    - Separação de responsabilidades
    - Validações
    - Arquitetura em camadas



## Autor

- [@pedro-augusto-ramos](https://github.com/pedro-augusto-ramos)


## Proximos passos

- Melhorar o projeto atual com mais features no futuro
- Construir novos projetos para fortalecer meu aprendizado

