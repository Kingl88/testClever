create table roles
(
    id   bigserial primary key NOT NULL,
    name varchar(20)
);
create table users
(
    id       bigserial   NOT NULL primary key,
    name     varchar(20) NOT NULL,
    lastname varchar(40) NOT NULL,
    surname  varchar(40) NOT NULL,
    email    varchar(50) NOT NULL,
    role_id  bigint,
    CONSTRAINT fk_role_id foreign key (role_id) references roles (id)
);
