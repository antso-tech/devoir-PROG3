-- Active: 1760942016873@@localhost@5432@users
CREATE TABLE USERS (
    id_users SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(8) NOT NULL
);

INSERT INTO USERS (name, firstname, birthdate, email, password) VALUES ('March', 'Jeanne', '1999-4-8', 'Jeanne@gmail.com','j3anM@');


SELECT * FROM USERS;



