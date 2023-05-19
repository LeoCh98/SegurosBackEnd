drop database Seguros;
CREATE DATABASE Seguros;

USE Seguros;

create table Marca (
  nombre varchar(10) not null,
  idMarca integer AUTO_INCREMENT,
  Primary key(idMarca)
);

create table Modelo (
  nombre varchar(10) not null,
  idModelo integer AUTO_INCREMENT,
  marca integer not null,
  Primary key(idModelo)
);

create table Usuario (
  cedula varchar(10) not null,
  clave varchar(10) not null,
  tipo integer not null,
  Primary key(cedula)
);

create table Cliente (
  nombre varchar(10) not null,
  cedula varchar(10) not null,
  tarjeta integer,
  telefono varchar(8),
  correo varchar(25),
  usuario varchar(10) not null,
  Primary key(cedula)
);

create table Poliza (
  nombre varchar(25) not null,
  idPoliza integer not null AUTO_INCREMENT,
  placa varchar(9) not null,
  costo integer not null,
  modeloId integer,
  clienteId varchar(10),
  Primary key(idPoliza)
);

alter table Modelo add foreign key (marca) references Marca(idMarca);
alter table Cliente add foreign key (usuario) references Usuario(cedula);
alter table Poliza add foreign key (clienteId) references Cliente(cedula);
alter table Poliza add foreign key (modeloId) references Modelo(idModelo);

insert into Marca(nombre,idMarca) values ('Toyota',idMarca);
insert into Marca(nombre,idMarca) values ('Nissan',idMarca);
insert into Marca(nombre,idMarca) values ('Mitsubishi',idMarca);

insert into Modelo(nombre,idModelo,marca) values ('Fortuner', idModelo, 1);
insert into Modelo(nombre,idModelo,marca) values ('Tercel', idModelo, 1);
insert into Modelo(nombre,idModelo,marca) values ('Hilux', idModelo, 1);
insert into Modelo(nombre,idModelo,marca) values ('Sentra', idModelo, 2);
insert into Modelo(nombre,idModelo,marca) values ('Pathfinder', idModelo, 2);
insert into Modelo(nombre,idModelo,marca) values ('Frontier', idModelo, 2);
insert into Modelo(nombre,idModelo,marca) values ('Montero', idModelo, 3);
insert into Modelo(nombre,idModelo,marca) values ('Eclipse', idModelo, 3);
insert into Modelo(nombre,idModelo,marca) values ('Outlander', idModelo, 3);

insert into Usuario(cedula,clave,tipo) values ('1111','1111',0);
insert into Usuario(cedula,clave,tipo) values ('2222','2222',1);
insert into Usuario(cedula,clave,tipo) values ('3333','3333',1);
insert into Usuario(cedula,clave,tipo) values ('4444','4444',1);

insert into Cliente(nombre,cedula,tarjeta,telefono, correo, usuario) values ('Marcos','1111',123,'admin','admin','1111');
insert into Cliente(nombre,cedula,tarjeta,telefono, correo, usuario) values ('Juan','2222',123,null,null,'2222');
insert into Cliente(nombre,cedula,tarjeta,telefono, correo, usuario) values ('Maria','3333',123,null,null,'3333');
insert into Cliente(nombre,cedula,tarjeta,telefono, correo, usuario) values ('Steven','4444',123,null,null,'4444');

insert into Poliza(nombre,idPoliza,placa,costo,clienteId,modeloId) values ('Responsabilidad Civil',idPoliza,'111111',10000,'3333',1);
insert into Poliza(nombre,idPoliza,placa,costo,clienteId,modeloId) values ('Danno a Personas',idPoliza,'222222',20000,'3333',6);
insert into Poliza(nombre,idPoliza,placa,costo,clienteId,modeloId) values ('Danno a Bienes',idPoliza,'333333',30000,'3333',3);
insert into Poliza(nombre,idPoliza,placa,costo,clienteId,modeloId) values ('Gastos Legales',idPoliza,'444444',40000,'3333',5);
insert into Poliza(nombre,idPoliza,placa,costo,clienteId,modeloId) values ('Gastos Legales',idPoliza,'333333',40000,'3333',7);
insert into Poliza(nombre,idPoliza,placa,costo,clienteId,modeloId) values ('Gastos Legales',idPoliza,'111111',40000,'4444',6);