create database ventas;

use ventas;

create table local
(
loc_id int not null auto_increment primary key,
loc_nom varchar(50) not null
);


create table vendedor
(
ven_id int not null auto_increment primary key,
ven_nom varchar(50) not null,
ven_ape varchar(50) not null,
ven_tel varchar(20) null,
ven_dir varchar(500) null,
ven_fec_nac datetime null,
ven_sexo bool not null,
loc_id int not null
);