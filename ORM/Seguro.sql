create database Seguro
go
use Seguro
go

create table Seguros
(
	idSeguro int identity (1,1) not null,
	nif varchar (9) not null,
	nombre varchar (15) not null,
	ape1 varchar (20) not null,
	ape2 varchar (20) null,
	edad int null,
	numHijos int null,
	fechaCreacion datetime not null,

	-----------------pk-------------------------
	constraint PK_Seguros primary key (idSeguro)
)
go


create procedure insertarSeguro @nif varchar(9) ,@nombre varchar(15),@ape1 varchar(20),@ape2 varchar(20),@edad int,@numHijos int
as
begin
	insert into Seguros(nif ,nombre ,ape1 ,ape2 ,edad,numHijos,fechaCreacion)
	values(@nif,@nombre,@ape1,@ape2,@edad,@numHijos,GETDATE())
end
go
execute insertarSeguro '12000000B','Nene','Monroy','Monroe',25,1
go
insert into Seguros(nif ,nombre ,ape1 ,ape2 ,edad,numHijos,fechaCreacion)
values('00000000T','Pepe','Phone','Monroe',25,1,GETDATE())

select * from Seguros