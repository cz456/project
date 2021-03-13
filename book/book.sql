create table book
(
    id           int auto_increment
        primary key,
    bookName     varchar(128) null,
    bookNumber   int          null,
    rent         double       null,
    kinds        varchar(128) null,
    introduction varchar(128) null,
    author       varchar(128) null,
    url          varchar(128) null,
    urls         varchar(128) null
);

create table bookcategory
(
    id       int auto_increment
        primary key,
    bookType varchar(128) null,
    bookCode varchar(128) null
);

create table bookdetails
(
    id       int auto_increment
        primary key,
    bookId   int        null,
    personId int        null,
    bookDate timestamp  null,
    state    varchar(1) null
);

create table person
(
    id          int auto_increment
        primary key,
    name        varchar(128) null,
    loginNumber varchar(128) null,
    passWord    varchar(128) null,
    role        varchar(128) null,
    state       varchar(1)   null,
    note        varchar(128) null
);

create table user
(
    id          int auto_increment
        primary key,
    userName    varchar(128) null,
    loginNumber varchar(128) null,
    phoneNumber varchar(128) null,
    mailbox     varchar(128) null,
    note        varchar(128) null
);

