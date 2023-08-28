CREATE TABLE banks
(
    id         bigserial primary key,
    name       varchar(30) NOT NULL,
    created_at timestamp default current_timestamp,
    update_at  timestamp default current_timestamp
);

CREATE TABLE users
(
    id         bigserial primary key,
    name       varchar(25) NOT NULL,
    surname    varchar(25),
    lastname   varchar(25) NOT NULL,
    created_at timestamp default current_timestamp,
    update_at  timestamp default current_timestamp
);

CREATE TABLE accounts
(
    id            bigserial primary key,
    number_IBAN   varchar(40) NOT NULL,
    number        varchar     NOT NULL,
    bank_id       integer     NOT NULL references banks (id),
    user_id       integer     NOT NULL references users (id),
    balance       numeric(8, 2),
    currency_type varchar(5)  NOT NULL,
    created_at    timestamp default current_timestamp,
    update_at     timestamp default current_timestamp
);

CREATE TABLE transactions
(
    id              bigserial primary key,
    type            varchar(15),
    status          varchar(15),
    from_account_id integer references accounts (id),
    to_account_id   integer references accounts (id),
    count           numeric(8, 2),
    created_at      timestamp default current_timestamp,
    update_at       timestamp default current_timestamp
);

CREATE TABLE banks_users
(
    bank_id integer references banks (id),
    user_id integer references users (id)
);