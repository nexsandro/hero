create table tb_user (

    cd_user varchar(255) not null,
    no_user varchar(255) not null,
    nu_vers number(10) not null,
    sq_mngr varchar(255)
    
);

create table role (
    cd_role varchar(255) not null,
    no_role varchar(255)
);

create table user_role (
    cd_user varchar(255) not null,
    cd_role varchar(255) not null
);

create table lock (
    cd_lock varchar(255) not null
);

create table tb_tag (
    cd_tag number(10) not null,
    no_tag varchar(255) not null,
);

create sequence se_tag start with 1 increment by 1;

create unique index ip_user on tb_user (cd_user); 
alter table tb_user add constraint pk_user primary key (cd_user);

create unique index ip_role on role (cd_role); 
alter table role add constraint pk_role primary key (cd_role);

create unique index ip_user_role on user_role (cd_user, cd_role);
alter table user_role add constraint pk_user_role primary key (cd_user,cd_role);

create unique index ip_lock on lock (cd_lock); 
alter table lock add constraint pk_lock primary key (cd_lock);

create unique index ip_tag on tb_tag (cd_tag); 
alter table tb_tag add constraint pk_tag primary key (cd_tag);

alter table tb_user add constraint fk_user_01 foreign key (sq_mngr) references tb_user (cd_user);

alter table user_role add constraint fk_user foreign key (cd_user) references tb_user (cd_user);
alter table user_role add constraint fk_role foreign key (cd_role) references role (cd_role);

create table TB_MDIC_KEYW (SQ_KEYW int identity not null, TX_DESC varchar(255) null, CD_KEY varchar(255) not null, NU_VERS int not null, primary key (SQ_KEYW));
create table TB_MDIC_TERM (SQ_TERM int identity not null, tx_text varchar(255) null, SQ_KEYW int not null, NU_VERS int not null, primary key (SQ_TERM));
alter table TB_MDIC_TERM add constraint FKD18D3F9D31E19234 foreign key (SQ_KEYW) references TB_MDIC_KEYW;

