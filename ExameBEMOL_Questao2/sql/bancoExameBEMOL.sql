create database bancoExameBEMOL;
use bancoExameBEMOL;
create table paciente(
  cpf varchar(11) primary key not null,
  nome varchar(40),
  dtnascto date
  );

insert into paciente values(99999999999,'teste','1994-05-10');
select * from paciente;