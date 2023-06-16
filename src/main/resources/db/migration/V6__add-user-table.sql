drop table if exists users;

create table users (
    id int not null auto_increment,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    primary key (id)
);