create table tb_pessoa2 (
	id bigint not null,
	nome varchar(50) not null,
	idade integer not null constraint check_idade2 CHECK (idade > 0 and idade < 120),
	sexo varchar(1) not null CHECK (sexo IN ('M', 'F')),
	id_estado bigint,
	cpf bigint not null,
	constraint pk_id_pessoa2 primary key(id),
	constraint fk_id_estado_pessoa2 foreign key(id_estado) references tb_estado2(id)
);

create table tb_estado2 (
	id bigint not null,
	nome varchar(50) not null,
	sigla varchar(2) not null,
	constraint pk_id_estado2 primary key(id)
);

drop table tb_pessoa2;


select * from tb_pessoa2;

select * from tb_estado;

insert into tb_estado
values(4, 't', 'teste');


alter table tb_pessoa2 add constraint uq_cpf_pessoa2 unique(cpf);

insert into tb_pessoa2 values(nextval('sq_pessoa2'), 'Rodrigo',36,'M', 1, 102030);
insert into tb_pessoa2 values(nextval('sq_pessoa2'), 'Rodrigo2',36,'M', 1, 102040);

select currval('sq_pessoa2');
select nextval('sq_pessoa2');

delete from tb_pessoa2;
delete from tb_estado2;

select * from tb_estado2;
select * from tb_pessoa2;

insert into tb_estado2 (id,sigla,nome) values(nextval('sq_estado_2'),'SP', 'São Paulo');
insert into tb_estado2 (id,sigla,nome) values(nextval('sq_estado_2'),'RJ', 'Rio de Janeiro');

create sequence sq_pessoa2
start 1
increment 1
owned by tb_pessoa2.id;

create sequence sq_estado_2
start 1
increment 1
owned by tb_estado2.id;

select * from tb_pessoa;
select * from tb_estado;

select * 
from tb_pessoa p, tb_estado e
where p.id_estado = e.id;

select p.nome, e.nome
from tb_pessoa p, tb_estado e
where p.id_estado = e.id;

select p.nome as nome_pessoa, e.nome as nome_estado
from tb_pessoa as p, tb_estado as e
where p.id_estado = e.id;

select p.nome as nome_pessoa, e.nome as nome_estado
from tb_pessoa as p
inner join tb_estado as e on p.id_estado = e.id;

select p.nome as nome_pessoa, e.nome as nome_estado
from tb_pessoa as p
left join tb_estado as e on p.id_estado = e.id;

select p.nome as nome_pessoa, e.nome as nome_estado
from tb_pessoa as p
right join tb_estado as e on p.id_estado = e.id;

select p.nome as nome_pessoa, e.nome as nome_estado
from tb_pessoa as p
full join tb_estado as e on p.id_estado = e.id;

select p.nome as nome_pessoa, e.nome as nome_estado
from tb_pessoa as p
cross join tb_estado as e;
