drop table rel_user_wordsgroup;
drop table rel_wordsgroup_word;
drop table ignored_word_in_a_list;
drop table user_account;
drop table wordsGroup;
drop table words;


CREATE TABLE user_account  (
    id int(50) AUTO_INCREMENT,
    name char(50) NOT NULL,
    pass char(50) NOT NULL,
    date_insert TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE wordsGroup  (
    id int(50) AUTO_INCREMENT,
    name char(50) NOT NULL,
    date_insert TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE rel_user_wordsgroup  (
    id_user int(50) NOT NULL,
    id_words_group int(50) NOT NULL,
    date_insert TIMESTAMP NOT NULL,
    PRIMARY KEY (id_user,id_words_group),
    FOREIGN KEY(id_user) REFERENCES user_account(id),
    FOREIGN KEY(id_words_group) REFERENCES wordsGroup(id)
);

CREATE TABLE words  (
    word char(50) NOT NULL,
    meaning char(50) NOT NULL,
    date_insert TIMESTAMP NOT NULL,
    PRIMARY KEY (word)
);

CREATE TABLE rel_wordsgroup_word  (
    id_words_group int(50) NOT NULL,
    word char(50) NOT NULL,
    PRIMARY KEY (id_words_group,word),
    FOREIGN KEY(id_words_group) REFERENCES wordsGroup(id),
    FOREIGN KEY(word) REFERENCES words(word)
);

CREATE TABLE ignored_word_in_a_list (
    id_user int(50) NOT NULL,
    id_words_group int(50) NOT NULL,
    word char(50) NOT NULL,
    date_insert TIMESTAMP NOT NULL,
    PRIMARY KEY (id_user,id_words_group,word),
    FOREIGN KEY(id_user) REFERENCES user_account(id),
    FOREIGN KEY(id_words_group) REFERENCES wordsGroup(id),
    FOREIGN KEY(word) REFERENCES words(word)
);

INSERT INTO user_account 
    (name, pass, date_insert) values
    ("pedro","caracola",now());
    
INSERT INTO user_account 
    (name, pass, date_insert) values
    ("paco","zorro",now());
    
INSERT INTO words 
    (word, meaning, date_insert) values
    ("epojé","epoca",now());
INSERT INTO words 
    (word, meaning, date_insert) values
    ("agora","plaza",now());
    
INSERT INTO wordsGroup 
    (name, date_insert) values
    ("Palabras que no me se pero acabaré sabiendo",now());    
    
INSERT INTO ignored_word_in_a_list 
    (id_user, id_words_group, word, date_insert) VALUES 
    (1, 1, "epojé", now());
    
DELETE FROM ignored_word_in_a_list WHERE id_user=1 and id_words_group=1 and word="epojé";

mysql –u root –p

GRANT ALL ON GRv0uSguq8.* TO GRv0uSguq8@`remotemysql.com` IDENTIFIED BY `BL0y8JnMPB`;