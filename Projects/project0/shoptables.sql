drop table if exists roles;
create table roles(
	id serial primary key,
	role text
);

insert into roles(role) values('system');
insert into roles(role) values('employee');
insert into roles(role) values('customer');

drop table if exists users;
create table users(
	id serial primary key,
	firstname varchar(15) not null,
	lastname varchar(15) not null,
	username varchar(15) not null,
	password varchar(15) not null,
	role_type integer default(3)
);

--mock data
insert into users (firstname, lastname, username, password) values ('Natal', 'Summerlie', 'nsummerlie0', '0nycXpoQ');
insert into users (firstname, lastname, username, password) values ('Jeno', 'Jowsey', 'jjowsey1', '4EaIoG');
insert into users (firstname, lastname, username, password) values ('Rycca', 'MacKeig', 'rmackeig2', '8f1QVjpJ');
insert into users (firstname, lastname, username, password) values ('Renell', 'Offener', 'roffener3', 'BsLMXycPmar');
insert into users (firstname, lastname, username, password) values ('Taffy', 'Ridgley', 'tridgley4', '9aOsShw3EV');

drop table if exists employees;
create table employees(
	id serial primary key,
	firstname varchar(15) not null,
	lastname varchar(15) not null,
	username varchar(15) not null,
	password varchar(15) not null,
	role_type integer default(2)
);

insert into employees (firstname, lastname, username, password) values ('Thain', 'Blakiston', 'tblakiston0', 'XV4Asj');
insert into employees (firstname, lastname, username, password) values ('Farr', 'Peller', 'fpeller1', 'XSOSRLZ');
insert into employees (firstname, lastname, username, password) values ('Abby', 'Worster', 'aworster2', 'Bbe7FBDJO');

drop table if exists system;
create table system(
	id serial primary key,
	rolename varchar(15) not null,
	username varchar(15) not null,
	password varchar(15) not null,
	role_type integer default(1)
);

insert into system (rolename, username, password) values ('System', 'systemacc', '12345');
select * from users u where id=1;

drop table if exists menu;
create table menu(
	id serial primary key,
	itemname varchar(20) not null,
	itemprice float not null,
	servingsleft integer not null
);
