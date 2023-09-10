DROP DATABASE bruno_feio;
CREATE DATABASE bruno_feio;
USE bruno_feio;

create table client(
id varchar(36) primary key not null,
name varchar(200) not null,
age int not null,
zipCode varchar(20) not null,
streetName varchar(200) not null,
addressNumber varchar(20) not null,
additionalInfo varchar(200) not null,
gender varchar(20) not null
);

create table seller(
id varchar(36) primary key not null,
name varchar(200) not null,
zipCode varchar(20) not null,
streetName varchar(200) not null,
addressNumber varchar(20) not null
);

create table product(
id varchar(36) primary key not null,
name varchar(200) not null,

description text default "",

seller_fk varchar(36) not null,
price numeric(9, 2) not null,
country varchar(100) not null,
quantity numeric(9,3) not null,
quantified_as char(3),

foreign key (seller_fk) references seller(id)
);
