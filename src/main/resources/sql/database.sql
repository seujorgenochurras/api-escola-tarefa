DROP DATABASE  IF EXISTS bruno_feio;
CREATE DATABASE IF NOT EXISTS bruno_feio;
USE bruno_feio;

create table client(
id varchar(36) primary key not null,
name varchar(200) not null,
age int not null,
zip_code varchar(20) not null,
street_name varchar(200) not null,
address_number varchar(20) not null,
additional_info varchar(200) not null,
gender varchar(20) not null
);

create table seller(
id varchar(36) primary key not null,
name varchar(200) not null,
zip_code varchar(20) not null,
street_name varchar(200) not null,
address_number varchar(20) not null,
additional_info varchar(200) not null
);

create table product(
id varchar(36) primary key not null,
name varchar(200) not null,
description text,

seller_fk varchar(36) not null,
price numeric(9, 2) not null,
country varchar(100) not null,
quantity numeric(9,3) not null,
quantified_as char(3),
stock integer,
on_sale boolean,

foreign key (seller_fk) references seller(id)
);

create table product_order(
id varchar(36) not null primary key,
seller_fk varchar(36) not null,
client_fk varchar(36) not null,
total_price numeric(9,2) not null,
order_status varchar(30) not null,
amount integer not null,

foreign key (seller_fk) references seller(id),
foreign key (client_fk) references client(id)
);


select * from client;