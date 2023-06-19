drop table if exists users;

create table users(
    id varchar(36) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    constraint pk_user primary key (id)
)