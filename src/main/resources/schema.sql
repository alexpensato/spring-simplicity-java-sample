CREATE SEQUENCE IF NOT EXISTS college_id_seq START 3;

CREATE TABLE IF NOT EXISTS college (
  id integer DEFAULT nextval('college_id_seq') PRIMARY KEY,
  name varchar(50) NOT NULL,
  name_of_city varchar(100)
);

GRANT USAGE, SELECT ON SEQUENCE college_id_seq TO pensato;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE college TO pensato;

CREATE SEQUENCE IF NOT EXISTS student_id_seq START 7;

CREATE TABLE IF NOT EXISTS student (
  id integer DEFAULT nextval('student_id_seq') PRIMARY KEY,
  name varchar(50) NOT NULL,
  college_id integer REFERENCES college (id),
  address varchar(100)
);

GRANT USAGE, SELECT ON SEQUENCE student_id_seq TO pensato;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE student TO pensato;

CREATE SEQUENCE IF NOT EXISTS book_id_seq START 5;

CREATE TABLE IF NOT EXISTS book (
  id integer DEFAULT nextval('book_id_seq') PRIMARY KEY,
  title varchar(50) NOT NULL,
  author varchar(50) NOT NULL,
  isbn varchar(14) NULL
);

GRANT USAGE, SELECT ON SEQUENCE book_id_seq TO pensato;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE book TO pensato;

CREATE SEQUENCE IF NOT EXISTS professor_id_seq START 1;

CREATE TABLE IF NOT EXISTS professor (
  id integer DEFAULT nextval('professor_id_seq') PRIMARY KEY,
  name varchar NOT NULL,
  beginDate date NOT NULL
);

GRANT USAGE, SELECT ON SEQUENCE professor_id_seq TO pensato;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE professor TO pensato;
