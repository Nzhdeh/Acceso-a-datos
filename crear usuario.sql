create login pepito with password='qq',
default_database=Ejemplos

use Ejemplos

create user pepito for login pepito
grant execute, insert, update, delete,
select to pepito

select * from Regalos
select * from Personas
SELECT Nombre,Altura FROM Personas