create database Seguro
go
use Seguro
go

create table Seguros
(
	idSeguro int identity (1,1) not null,
	nif varchar (9) not null,
	nombre varchar (9) not null,
	ape1 varchar (9) not null,
	ape2 varchar (9) null,
	edad int null,
	numHijos int null,
	fechaCreacion datetime not null,

	-----------------pk-------------------------
	constraint PK_Seguros primary key (idSeguro)
)
go

insert into Seguros(nif ,nombre ,ape1 ,ape2 ,edad,numHijos,fechaCreacion)
values('00000000T','Pepe','Phone','Monroe',25,1,GETDATE())

select * from Seguros