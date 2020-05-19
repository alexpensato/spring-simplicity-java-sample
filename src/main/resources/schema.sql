CREATE SEQUENCE IF NOT EXISTS college_id_seq START 3;

CREATE TABLE IF NOT EXISTS college (
  id integer DEFAULT nextval('college_id_seq') PRIMARY KEY,
  name varchar(50) NOT NULL,
  name_of_city varchar(100)
);

CREATE SEQUENCE IF NOT EXISTS student_id_seq START 7;

CREATE TABLE IF NOT EXISTS student (
  id integer DEFAULT nextval('student_id_seq') PRIMARY KEY,
  name varchar(50) NOT NULL,
  college_id integer REFERENCES college (id),
  address varchar(100)
);

CREATE SEQUENCE IF NOT EXISTS book_id_seq START 5;

CREATE TABLE IF NOT EXISTS book (
  id integer DEFAULT nextval('book_id_seq') PRIMARY KEY,
  title varchar(50) NOT NULL,
  discipline varchar(100)
);

CREATE SEQUENCE IF NOT EXISTS book_id_seq START 5;

CREATE TABLE IF NOT EXISTS book (
  id integer DEFAULT nextval('book_id_seq') PRIMARY KEY,
  title varchar(50) NOT NULL,
  author varchar(50) NOT NULL,
  isbn varchar(14) NULL
);

