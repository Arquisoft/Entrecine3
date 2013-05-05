# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table TClientes (
  id_cliente                integer auto_increment not null,
  dni                       varchar(255),
  nombre                    varchar(255),
  apellidos                 varchar(255),
  email                     varchar(255),
  fecha_nacimiento          datetime,
  constraint pk_TClientes primary key (id_cliente))
;

create table TDatos_bancarios (
  idDatos_bancarios         integer auto_increment not null,
  num_tarjeta               integer,
  nombre                    varchar(255),
  apellidos                 varchar(255),
  pin                       integer,
  Fecha_caducidad           datetime,
  idCliente                 integer,
  constraint pk_TDatos_bancarios primary key (idDatos_bancarios))
;

create table TDetalles_Ventas (
  id_detalles_venta         integer auto_increment not null,
  id_venta                  integer,
  id_proyeccion             integer,
  butaca                    integer,
  precio                    float,
  constraint pk_TDetalles_Ventas primary key (id_detalles_venta))
;

create table TPeliculas (
  idPeliculas               integer auto_increment not null,
  titulo                    varchar(255),
  duracion                  datetime,
  genero                    varchar(255),
  descripcion               varchar(255),
  imagen                    varchar(255),
  constraint pk_TPeliculas primary key (idPeliculas))
;

create table TProyecciones (
  idProyecciones            integer auto_increment not null,
  fecha_proyeccion          datetime,
  idPeliculas               integer,
  idSalas                   integer,
  idTipoProyeccion          integer,
  constraint pk_TProyecciones primary key (idProyecciones))
;

create table TSalas (
  idSalas                   integer auto_increment not null,
  num_sala                  integer,
  num_butacas               integer,
  tipo_sala                 varchar(255),
  constraint pk_TSalas primary key (idSalas))
;

create table TTipo_Proyeccion (
  idTipoProyeccion          integer auto_increment not null,
  nombre                    varchar(255),
  precio                    double,
  constraint pk_TTipo_Proyeccion primary key (idTipoProyeccion))
;

create table TVentas (
  id_venta                  integer auto_increment not null,
  id_cliente                integer,
  precio_total              float,
  fecha_venta               datetime,
  constraint pk_TVentas primary key (id_venta))
;

alter table TDatos_bancarios add constraint fk_TDatos_bancarios_cliente_1 foreign key (idCliente) references TClientes (id_cliente) on delete restrict on update restrict;
create index ix_TDatos_bancarios_cliente_1 on TDatos_bancarios (idCliente);
alter table TProyecciones add constraint fk_TProyecciones_pelicula_2 foreign key (idPeliculas) references TPeliculas (idPeliculas) on delete restrict on update restrict;
create index ix_TProyecciones_pelicula_2 on TProyecciones (idPeliculas);
alter table TProyecciones add constraint fk_TProyecciones_sala_3 foreign key (idSalas) references TSalas (idSalas) on delete restrict on update restrict;
create index ix_TProyecciones_sala_3 on TProyecciones (idSalas);
alter table TProyecciones add constraint fk_TProyecciones_tipoProyeccion_4 foreign key (idTipoProyeccion) references TTipo_Proyeccion (idTipoProyeccion) on delete restrict on update restrict;
create index ix_TProyecciones_tipoProyeccion_4 on TProyecciones (idTipoProyeccion);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table TClientes;

drop table TDatos_bancarios;

drop table TDetalles_Ventas;

drop table TPeliculas;

drop table TProyecciones;

drop table TSalas;

drop table TTipo_Proyeccion;

drop table TVentas;

SET FOREIGN_KEY_CHECKS=1;

