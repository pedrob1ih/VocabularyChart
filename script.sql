drop table words;
drop table wordsGroup;
drop table hit_miss;

CREATE TABLE wordsGroup  (
        id int(50) NOT NULL,
        name char(50) NOT NULL,
        DATE TIMESTAMP NOT NULL,
        PRIMARY KEY (id)
);

CREATE TABLE words  (
        idWordGoup int(50) NOT NULL,
        word char(50) NOT NULL,
        meaning char(50) NOT NULL,
        DATE TIMESTAMP NOT NULL,
        ignoredWord BOOLEAN NOT NULL,
        PRIMARY KEY (word,idWordGoup),
        FOREIGN KEY(idWordGoup) REFERENCES wordsGroup(id)
);

CREATE TABLE hit_miss (
        word char(50) NOT NULL,
        hit BOOLEAN NOT NULL,
        DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (word),
        FOREIGN KEY(word) REFERENCES words(word)
);