CREATE TABLE IF NOT EXISTS college (
  id integer AUTO_INCREMENT NOT NULL,
  name varchar(50) NOT NULL,
  name_of_city varchar(100),
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS student (
  id integer AUTO_INCREMENT NOT NULL,
  name varchar(50) NOT NULL,
  college_id integer REFERENCES college (id),
  address varchar(100),
  PRIMARY KEY (`id`)
);
