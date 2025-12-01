-- Active: 1760942016873@@localhost@5432@users
CREATE TABLE STUDENT (
    id_student SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    student_group VARCHAR(50) 
);

INSERT INTO STUDENT (name, firstname, birthdate, student_group) VALUES ('March', 'Jeanne', '1999-4-8', 'K2');

SELECT * FROM STUDENT;



