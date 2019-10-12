drop table rel_user_wordsgroup;
drop table rel_wordsgroup_word;
drop table ignored_word_in_a_list;
drop table user_account;
drop table wordsGroup;
drop table words;


CREATE TABLE user_account  (
    id int(50) NOT NULL,
    name char(50) NOT NULL,
    pass char(50) NOT NULL,
    DATE TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE wordsGroup  (
    id int(50) NOT NULL,
    name char(50) NOT NULL,
    DATE TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE rel_user_wordsgroup  (
    id_user int(50) NOT NULL,
    id_words_group int(50) NOT NULL,
    DATE TIMESTAMP NOT NULL,
    PRIMARY KEY (id_user,id_words_group),
    FOREIGN KEY(id_user) REFERENCES user_account(id),
    FOREIGN KEY(id_words_group) REFERENCES wordsGroup(id)
);

CREATE TABLE words  (
    word char(50) NOT NULL,
    meaning char(50) NOT NULL,
    DATE TIMESTAMP NOT NULL,
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
    DATE TIMESTAMP NOT NULL,
    PRIMARY KEY (id_user,id_words_group,word),
    FOREIGN KEY(id_user) REFERENCES user_account(id),
    FOREIGN KEY(id_words_group) REFERENCES wordsGroup(id),
    FOREIGN KEY(word) REFERENCES words(word)
);