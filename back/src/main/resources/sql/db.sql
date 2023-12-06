DROP DATABASE IF EXISTS bruno_feio;
CREATE DATABASE IF NOT EXISTS bruno_feio;
USE bruno_feio;

create table address(
id int not null primary key auto_increment,
cep_code varchar(20) not null,
street_name varchar(200) not null,
address_number varchar(20) not null,
neightboorhood varchar(150) not null,
city varchar(120) not null,
state varchar(120) not null,
additional_info varchar(200) not null
);

create table client(
token varchar(40) primary key not null,
username varchar(200) not null,
is_seller boolean not null

);

create table client_info (
id int not null primary key auto_increment,
client_token varchar(40) not null,
name varchar(140) not null,
phone_number varchar(140) not null,
email varchar(140) not null,
CPF varchar(18) not null,
foreign key (client_token) references client(token)
);

create table client_address(
id int not null primary key auto_increment,
client_fk varchar(40) not null,
address_fk int not null,
foreign key (client_fk) references client(token),
foreign key (address_fk) references address(id)
);

create table product(
id int primary key not null,
name varchar(200) not null,
description text,
category varchar(100) not null,

seller_fk varchar(40) not null,
price numeric(9, 2) not null,
is_active boolean,

foreign key (seller_fk) references client(token)
);



create table product_order(
id int not null primary key,
seller_fk varchar(40) not null,
product_fk int not null,

client_fk varchar(40) not null,
total_price numeric(9,2) not null,
order_status varchar(30) not null,
amount integer not null,
address_fk int not null,

foreign key (product_fk) references product(id),
foreign key (seller_fk) references client(token),
foreign key (client_fk) references client(token),
foreign key (address_fk) references address(id)
);

select * from client;
select * from client_info;
select * from product;
select * from product_order;
SELECT * FROM product p WHERE p.is_active = true;
select * from client where token = "601f1889667efaebb33b8c12572835da3f027f78";
select * from client_info where client_token = "601f1889667efaebb33b8c12572835da3f027f78";
