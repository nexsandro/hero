create table user (

    cd_user varchar(255) not null,
    no_user varchar(255) not null,
    nu_vers number(10) not null
    
);

create table role (
    cd_role varchar(255) not null,
    no_role varchar(255)
);

create table user_role (
    cd_user varchar(255) not null,
    cd_role varchar(255) not null
);

create table locl (
    cd_lock varchar(255) not null
);

create unique index ip_user on user (cd_user); 
alter table user add constraint pk_user primary key (cd_user);

create unique index ip_role on role (cd_role); 
alter table role add constraint pk_role primary key (cd_role);

create unique index ip_user_role on user_role (cd_user, cd_role);
alter table user_role add constraint pk_user_role primary key (cd_user,cd_role);

create unique index ip_lock on lock (cd_lock); 
alter table lock add constraint pk_lock primary key (cd_lock);

alter table user_role add constraint fk_user foreign key (cd_user) references user (cd_user);
alter table user_role add constraint fk_role foreign key (cd_role) references role (cd_role);
