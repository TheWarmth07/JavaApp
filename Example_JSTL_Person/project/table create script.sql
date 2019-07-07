-- dropping all the tables, starting with the ORDERS table
drop table person;


-- creating the SALESPERSON table
create table person (
	person_id number(10),
	first_name varchar2(20) not null,
	last_name varchar2(20) not null,
	email_address varchar2(20) not null,
	create_date date,
	constraint person_id_pk primary key(person_id));