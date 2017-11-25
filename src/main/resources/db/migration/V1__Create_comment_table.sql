 CREATE DATABASE IF NOT EXISTS commentdb;
 CREATE TABLE IF NOT EXISTS commentdb.comment (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  comment varchar(255),
  name varchar(255),
  time_stamp bigint(20),
  PRIMARY KEY (id)
);