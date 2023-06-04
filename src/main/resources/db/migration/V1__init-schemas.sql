drop table if exists books;
drop table if exists authors;

create table authors(
                        id int unique not null AUTO_INCREMENT,
                        name varchar(255) not null,
                        primary key (id)
);

create table books(
                      id int unique not null AUTO_INCREMENT,
                      name varchar(255) not null,
                      author_id int,
                      primary key (id),
                      foreign key (author_id) references authors(id)
)