drop table if exists users_roles;

create table users_roles(
    user_id varchar(255) not null,
    role_id varchar(255) not null,
    primary key (user_id, role_id),
    constraint pc_user_fk foreign key (user_id) references users(id),
    constraint pc_role_fk foreign key (role_id) references roles(id)
)