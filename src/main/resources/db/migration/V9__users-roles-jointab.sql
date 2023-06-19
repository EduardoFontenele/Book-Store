drop table if exists users_roles;
drop table if exists roles;

create table roles (
    id varchar(36) not null,
    role varchar(30) not null,
    constraint pk_role primary key (id)
);

create table users_roles(
    user_id varchar(36) not null,
    role_id varchar(30) not null,
    primary key (user_id, role_id),
    constraint pc_user_fk foreign key (user_id) references users(id),
    constraint pc_role_fk foreign key (role_id) references roles(id)
)