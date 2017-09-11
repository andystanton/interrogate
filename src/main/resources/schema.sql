DROP TABLE IF EXISTS interrogate.user;
CREATE TABLE interrogate.user
(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(1024) NOT NULL,
    email varchar(1024) NOT NULL,
    PRIMARY KEY (id)
);