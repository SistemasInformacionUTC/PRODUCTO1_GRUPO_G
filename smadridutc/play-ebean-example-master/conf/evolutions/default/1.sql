# --- First database schema

# --- !Ups

create table company (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table computer (
  id                        bigint not null,
  name                      varchar(255),
  introduced                timestamp,
  discontinued              timestamp,
  company_id                bigint,
  constraint pk_computer primary key (id))
;

create table memoriaram (
  id                        bigint not null,
 
  capacidad                 int,
  tamaño                    int,
 
  constraint pk_memoriaram primary key (id))
;


create sequence company_seq start with 1000;

create sequence computer_seq start with 1000;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;


alter table computer add constraint fk_computer_memoriaram_2 foreign key (company_id) references memoriaram (id) on delete restrict on update restrict;


create index ix_computer_company_1 on computer (company_id);


create index ix_computer_memoriaram_1 on computer (memoriaram_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

drop table if exists computer;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists computer_seq;
rop sequence if exists memoriaram_seq;

