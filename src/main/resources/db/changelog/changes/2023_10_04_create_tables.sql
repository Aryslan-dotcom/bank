create table categories
(
    id   bigserial
        primary key,
    link varchar(255),
    name varchar(255)
);

create table colors
(
    id   bigserial
        primary key,
    name varchar(255)
);

create table commentaries
(
    id         bigserial
        primary key,
    author     varchar(255),
    bad        varchar(255),
    commentary varchar(255),
    good       varchar(255)
);

create table images
(
    id   bigserial
        primary key,
    link varchar(255)
);

create table categories_images
(
    category_id bigint not null
        constraint fk7ierrw60orgp11ghb05w8rcge
            references categories,
    images_id   bigint not null
        unique
        constraint fkiawwclx7q23gbk2rim4ksolev
            references images
);

create table instalments
(
    months integer,
    id     bigserial
        primary key
);

create table items_phone
(
    id                    bigserial
        primary key,
    brand_phones          varchar(255),
    characteristic_phones varchar(255),
    description_phone     varchar(255),
    memory_phones         varchar(255),
    name                  varchar(255),
    price                 varchar(255)
);

create table items_phone_colors
(
    colors_id     bigint not null
        unique
        constraint fkm0nbcxrw91wk55kj2482vubmu
            references colors,
    item_phone_id bigint not null
        constraint fk9w0sxjmd831u7t9bt8666292k
            references items_phone
);

create table items_phone_commentary_phones
(
    commentary_phones_id bigint not null
        unique
        constraint fk3o5598kgay1c8qm7r77ufi90h
            references commentaries,
    item_phone_id        bigint not null
        constraint fkac9umw3in2l933ip1sd47s2jl
            references items_phone
);

create table items_phone_images_list
(
    images_list_id bigint not null
        unique
        constraint fkhrbshgwghod18exr1j6vp2fu2
            references images,
    item_phone_id  bigint not null
        constraint fkilu3lt8jv3mugfibynxdg1upu
            references items_phone
);

create table permissions
(
    id   bigserial
        primary key,
    role varchar(255)
);

create table prices
(
    price integer,
    id    bigserial
        primary key
);

create table sellers
(
    id            bigserial
        primary key,
    item_phone_id bigint
        constraint fk4v8i20qlnu6llimn17j6qtimn
            references items_phone,
    name          varchar(255),
    number        varchar(255)
);

create table users
(
    id        bigserial
        primary key,
    email     varchar(255),
    full_name varchar(255),
    password  varchar(255)
);

create table users_permissions
(
    permissions_id bigint not null
        constraint fkbehn7jld0v03jhyjntnwsn8r7
            references permissions,
    users_id       bigint not null
        constraint fkdpu20yuy0omsw55t5vcnt6td2
            references users
);