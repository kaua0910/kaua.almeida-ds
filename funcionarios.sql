create database funcionarios;
use funcionarios;

create table funcionarios(
id int auto_increment primary key,
nome varchar(100) not null,
funcao varchar(100)not null,
creat_at timestamp default current_timestamp,
salario decimal(10,2),
email varchar(150),
data_admissao Date,
status enum('ativo', 'inativo'),
departamento_id int


);


