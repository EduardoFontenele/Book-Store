create table authors(
    id int not null,
    name varchar(255) not null,
    primary key (id)
);

create table books(
    id int not null,
    name varchar(255) not null,
    author_id int,
    primary key (id),
    foreign key (author_id) references authors(id)
)