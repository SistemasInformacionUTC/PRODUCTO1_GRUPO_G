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
  company_id                 bigint,
  procesador_id                  bigint,
  constraint pk_computer primary key (id))
;
create table procesador (
  id                    serial not null,
  marca                      varchar(255),
  capacidad                  bigint not null,
  peso               bigint not null,
  constraint pk_procesador primary key (id))
;

create sequence company_seq start with 1000;

create sequence computer_seq start with 1000;
create sequence procesador_seq start with 1000;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);

alter table computer add constraint fk_computer_procesador_2 foreign key (procesador_id) references procesador (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);
create index ix_computer_procesador_1 on computer (procesador_id);
# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

drop table if exists computer;
drop table if exists procesador ;
SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists computer_seq;
drop sequence if exists procesador_seq ;
