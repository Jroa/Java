drop table Empleado if exists;
create table Empleado(
	idEmpleado integer primary key identity,
	nombre varchar(50),
	apellido varchar(50),
	numDocumento varchar(20)
);