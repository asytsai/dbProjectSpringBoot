create table book (
        id bigint not null,
        isbn varchar(255),
        publisher varchar(255),
        title varchar(255),
        primary key (id)
    );

create sequence book_seq start with 1 increment by 1;

--select next value for book_seq;