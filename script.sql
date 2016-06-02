drop table words;
drop table hit_miss;

CREATE TABLE words  (
        word char(50) NOT NULL,
        meaning char(50) NOT NULL,
	DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (word)
);
CREATE TABLE hit_miss (
        word char(50) NOT NULL,
        hit BOOLEAN NOT NULL,
	DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (word),
        FOREIGN KEY(word) REFERENCES words(word)
);
insert into words values ('hello','hola',CURRENT_TIMESTAMP)
update words set word='adios' , MEANING='CALABAZA' , DATE='CURRENT_TIMESTAMP' where word='hello'