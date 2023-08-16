CREATE DATABASE booklist;

USE booklist;

CREATE TABLE books 
(
    id          BIGINT NOT NULL,
    author_name VARCHAR(255),
    description LONGTEXT,
    isbn        VARCHAR(255),
    title       VARCHAR(255),
    created_at  DATETIME NOT NULL,
    updated_at  DATETIME NOT NULL,
    PRIMARY KEY (id)
) engine=MyISAM;

SELECT * FROM books;

DESC books;

DELETE FROM books;