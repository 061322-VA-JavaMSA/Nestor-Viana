drop table if exists roles;
create table roles(
	id serial primary key,
	role text
);

insert into roles(role) values('system');
insert into roles(role) values('employee');
insert into roles(role) values('customer');

drop table if exists customers;
create table customers(
	id serial primary key,
	firstname varchar(15) not null,
	lastname varchar(15) not null,
	username varchar(15) unique not null,
	password varchar(15) not null,
	role_type integer default(3)
);

--mock data
insert into customers (firstname, lastname, username, password) values ('Natal', 'Summerlie', 'nsummerlie0', '0nycXpoQ');
insert into customers (firstname, lastname, username, password) values ('Jeno', 'Jowsey', 'jjowsey1', '4EaIoG');
insert into customers (firstname, lastname, username, password) values ('Rycca', 'MacKeig', 'rmackeig2', '8f1QVjpJ');
insert into customers (firstname, lastname, username, password) values ('Renell', 'Offener', 'roffener3', 'BsLMXycPmar');
insert into customers (firstname, lastname, username, password) values ('Taffy', 'Ridgley', 'tridgley4', '9aOsShw3EV');
insert into customers (firstname, lastname, username, password) values ('user', 'pass', 'user', 'pass');

drop table if exists employees;
create table employees(
	id serial primary key,
	firstname varchar(15) not null,
	lastname varchar(15) not null,
	username varchar(15) unique not null,
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
	item_name varchar(20) unique not null,
	item_description varchar(50) not null,
	item_price float not null
);

insert into menu (item_name, item_description, item_price) values ('small ice cream cup','2 scoops of two different flavors', 3.60);
insert into menu (item_name, item_description, item_price) values ('large ice cream cup','4 scoops of two different flavors', 5.00);
insert into menu (item_name, item_description, item_price) values ('ice cream cone', '4 scoops of two different flavors on a wafer cone', 5.60);

drop table if exists flavors;
create table flavors(
	id serial primary key,
	flavor varchar(20) unique not null
);

insert into flavors (flavor) values ('chocolate');
insert into flavors (flavor) values ('vanilla');
insert into flavors (flavor) values ('strawberry');
insert into flavors (flavor) values ('cookies & cream');
insert into flavors (flavor) values ('mint chocolate chip');
insert into flavors (flavor) values ('neapolitan');
insert into flavors (flavor) values ('pistachio');
insert into flavors (flavor) values ('rocky road');

--drop table if exists menu_flavors;
--create table menu_flavors(
--	id serial primary key,
--	
--);

drop table if exists orders;
create table orders( 
	id serial primary key,
	customerUsername varchar(20) not null,
	menuId int not null references menu(id),
	flavor1Id int not null references flavors(id),
	flavor2Id int not null references flavors(id)
);
