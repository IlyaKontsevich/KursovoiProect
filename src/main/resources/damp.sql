create table doctors
(
    id   serial not null
        constraint curators_pk
            primary key,
    name varchar
);

create table rooms
(
    id          serial  not null
        constraint croup_pkey
            primary key,
    name        varchar not null,
    size        integer not null,
    free_places integer
);

create table employees
(
    id           serial  not null
        constraint employees_pk
            unique,
    name         varchar not null,
    mobile_phone varchar not null,
    position     varchar not null
);

create unique index employs_mobile_phone_uindex
    on employees (mobile_phone);

create table patients
(
    id        serial  not null
        constraint students_pk
            primary key,
    name      varchar,
    room_id   integer
        constraint students_croup_id_fk
            references rooms
            on update cascade on delete cascade,
    diagnosis varchar,
    doctor_id integer not null
        constraint patients_doctors_id_fk
            references doctors
            on update cascade on delete cascade
);

create unique index students_name_uindex
    on patients (name);