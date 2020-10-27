DROP DATABASE if exists NotesDB;
CREATE DATABASE NotesDB;

USE NotesDB;

CREATE TABLE users (
    username VARCHAR(20) NOT NULL,
    password VARCHAR (20) NOT NULL,
    firstname VARCHAR(20), 
    lastname VARCHAR(20),
    email VARCHAR(40),
    CONSTRAINT PK_username PRIMARY KEY (username));

INSERT INTO users (username, password)
VALUES ("admin", "password");

INSERT INTO users (username, password, firstname, lastname, email)
VALUES ("grigory", "password", "Stamen", "Grigorov", "stamen@hero.com");

INSERT INTO users (username, password, firstname, lastname, email)
VALUES ("smithster", "password", "John", "Smith", "smithster@outlook.com");

COMMIT;

