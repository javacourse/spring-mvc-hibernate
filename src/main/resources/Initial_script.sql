if (not exists(select 1 from rdb$relations where rdb$relation_name = 'person')) then
then
begin
drop table person;
end;
go;
create table Person (
    personId int not null,
    firstName varchar(255),
    lastName varchar(255),
    departamentId int not null,
    primary key (personId)
)
go;
if (not exists(select 1 from rdb$relations where rdb$relation_name = 'Departament')) then
then
begin
drop table Departament;
end;
go;
create table Departament (
    departamentId int not null,
    depName varchar(255),
    primary key (departamentId)
);
go;
ALTER TABLE PERSON ADD CONSTRAINT FK_Person_Departament FOREIGN KEY (DEPARTAMENTID) REFERENCES DEPARTAMENT (DEPARTAMENTID)   ON UPDATE CASCADE
  ON DELETE CASCADE
go;
if (not exists(select 1 from rdb$relations where rdb$relation_name = 'users')) then
then
begin
drop table users;
end;
go;
create table users (username varchar(20),password varchar(20) ,enabled int )
go
if (not exists(select 1 from rdb$relations where rdb$relation_name = 'authorities')) then
then
begin
drop table authorities;
end;
go;
create table authorities (username varchar(20),authority varchar(20))
go

insert into users(username, password, enabled) values ('admin','admin',1);
go
insert into authorities(username,authority) values ('admin','ROLE_USER');
go
insert into authorities(username,authority) values ('admin','ROLE_ADMIN');
go
insert into users(username, password, enabled) values('guest','guest',1);
go
insert into authorities(username,authority) values ('guest','ROLE_USER');
go
commit;
