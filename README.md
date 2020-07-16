## Calculadora
Repositório referente ao projeto de "calculadora" da disciplina de laboratório de engenharia de software, Fatec São José dos Campos.

## 1º Passo
Criar um "schema" no banco como o nome de "calculadora";
Mudar a senha no persistence xml na tag <property name="javax.persistence.jdbc.password" value="SUASENHA" />

CREATE TABLE `resultado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `operacao` varchar(255) DEFAULT NULL,
  `resultado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

## 2º Passo
Fazer um INSERT de usuario na tabela usuário

INSERT INTO `calculadora`.`usuario`
(
`nome`,
`senha`,
`email`)
VALUES
(
'guilherme@email.com',
1234,
'guilherme@email.com);

## 3º Passo

Subir a aplicação na pasta do projeto, através do terminal executar o comando "gradle apprun" para a aplicação ficar disponível no endereço - "localhost:8080/calculadora"

## Estrutura

A estrutura de pastas do projeto está em padrão MVC, onde o Model é representado pelo "usuario" e "resultado" juntamente com "usuarioDAO" e "resultadoDAO" integrados
com o Hibernate para criação das tabelas no banco e execução das operações referentes ao banco de dados.
Views estão presentes as telas de login e calculadora (calc.jsp, login.jsp) e o index.
Controller estão presentes "calc.java" responsável pelos cálculos executados na aplicação, "login.java" responsável pela validação do usuário e "resultado.controller" responsável pela geração de um array de JSON retornando do banco as operações salvas.
