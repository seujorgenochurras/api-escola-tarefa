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
name varchar(200) not null,
is_seller boolean not null

);

create table client_personal_info (
id int not null primary key auto_increment,
client_id varchar(40) not null,
name varchar(140) not null,
phoneNumber varchar(140) not null,
email varchar(140) not null,
CPF varchar(18) not null,
foreign key (client_id) references client(token)
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
select * from product;
select * from product_order;
SELECT * FROM product p WHERE p.is_active = true
