drop table if exists books_categories;

create table books_categories (
    category_id varchar(50) not null,
    book_id int not null,
    primary key (category_id, book_id),
    constraint pc_category_fk foreign key (category_id) references categories(name),
    constraint pc_book_id_fk foreign key (book_id) references books(id)
)