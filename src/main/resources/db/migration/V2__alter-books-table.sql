drop table if exists categories;

ALTER TABLE books
    ADD COLUMN quantity int default 0,
    ADD COLUMN price decimal(4, 2),
    ADD COLUMN description TEXT;

create table categories (
    name varchar(50) unique,
    primary key (name)
);
