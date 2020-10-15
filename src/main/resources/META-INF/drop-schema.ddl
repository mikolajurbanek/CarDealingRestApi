
    alter table cars 
       drop constraint FKagkqfnmm6spabkbuwufmfg57x

    alter table users_cars 
       drop constraint FK3bcwnsx8frmbma7x5u4ts6dyn

    alter table users_cars 
       drop constraint FKmelc9vq85xbujff73aublnu62

    drop table if exists car_dealers cascade

    drop table if exists cars cascade

    drop table if exists users cascade

    drop table if exists users_cars cascade

    drop sequence if exists hibernate_sequence
