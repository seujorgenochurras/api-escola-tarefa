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