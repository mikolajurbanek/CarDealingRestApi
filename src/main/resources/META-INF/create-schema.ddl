create sequence hibernate_sequence start 1 increment 1

    create table car_dealers (
       id  bigserial not null,
        location varchar(255),
        name varchar(255),
        phoneNumber varchar(255),
        primary key (id)
    )

    create table cars (
       id  bigserial not null,
        automat_gear boolean not null,
        brand varchar(255),
        color varchar(255),
        model varchar(255),
        year int4 not null,
        dealer_id int8,
        primary key (id)
    )

    create table users (
       id int8 not null,
        name varchar(255),
        surname varchar(255),
        primary key (id)
    )

    create table users_cars (
       users_id int8 not null,
        cars_id int8 not null,
        primary key (users_id, cars_id)
    )

    alter table cars 
       add constraint FKagkqfnmm6spabkbuwufmfg57x 
       foreign key (dealer_id) 
       references car_dealers

    alter table users_cars 
       add constraint FK3bcwnsx8frmbma7x5u4ts6dyn 
       foreign key (cars_id) 
       references cars

    alter table users_cars 
       add constraint FKmelc9vq85xbujff73aublnu62 
       foreign key (users_id) 
       references users
