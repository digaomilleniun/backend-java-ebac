create sequence sq_cliente
start 1
increment 1
owned by tb_cliente.id;

create table tb_cliente (
	id bigint,
	nome varchar(50) not null,
	cpf bigint not null,
	tel bigint not null,
	endereco varchar(50) not null,
	numero bigint not null,
	cidade varchar(50) not null,
	estado varchar(50) not null,
	constraint pk_id_cliente primary key(id)
);

select * from tb_cliente;
drop table tb_cliente;

insert into tb_cliente values('Rodrigo', 102030);