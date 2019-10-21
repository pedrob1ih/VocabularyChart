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

/*USUARIOS*/
INSERT INTO user_account 
    (name, pass, date_insert) values
    ("pedro","caracola",now());
    
INSERT INTO user_account 
    (name, pass, date_insert) values
    ("paco","zorro",now());
/*END_USUARIOS  */  

/*WORDS*/
    /*Lista de vocabulario uno*/
        INSERT INTO words 
            (word, meaning, date_insert) values
            ("epojé","epoca",now());
        INSERT INTO words 
            (word, meaning, date_insert) values
            ("agora","plaza",now());
        INSERT INTO words 
            (word, meaning, date_insert) values
            ("tâches","tareas",now());
    /*END_Lista de vocabulario uno  */  

    /*Lista de vocabulario dos*/
        INSERT INTO words 
            (word, meaning, date_insert) values
            ("amont","rio arriba",now());
        INSERT INTO words 
            (word, meaning, date_insert) values
            ("affichage","objetivo",now());
    /*END_Lista de vocabulario dos*/

    /*Lista de vocabulario tres*/
        INSERT INTO words 
            (word, meaning, date_insert) values
            ("aujourd'hui","hoy",now());
        INSERT INTO words 
            (word, meaning, date_insert) values
            ("bonjour","hola",now());
        INSERT INTO words 
            (word, meaning, date_insert) values
            ("tant","tanto",now());
    /*END_Lista de vocabulario tres   */ 
/*END_WORDS */   

/*WORDS_GROUP*/
    INSERT INTO wordsGroup 
        (name, date_insert) values
        ("Lista de vocabulario uno",now());
    INSERT INTO wordsGroup 
        (name, date_insert) values
        ("Lista de vocabulario dos",now());
    INSERT INTO wordsGroup 
        (name, date_insert) values
        ("Lista de vocabulario tres",now());    
/*END_WORDS_GROUP*/

/*rel_user_wordsgroup*/
    INSERT INTO rel_user_wordsgroup 
        (id_user, id_words_group, date_insert) VALUES
        (1, 1, now());
    INSERT INTO rel_user_wordsgroup 
        (id_user, id_words_group, date_insert) VALUES
        (1, 2, now());
    INSERT INTO rel_user_wordsgroup 
        (id_user, id_words_group, date_insert) VALUES
        (2, 3, now());    
/*END_rel_user_wordsgroup*/

/*rel_wordsgroup_word*/

    /*Lista de vocabulario uno*/
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (1, "epojé");
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (1, "agora");
    /*END_Lista de vocabulario uno    */

    /*Lista de vocabulario dos*/
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (2, "amont");
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (2, "affichage");    
    /*END_Lista de vocabulario dos*/

    /*Lista de vocabulario tres*/
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (3, "aujourd'hui");
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (3, "bonjour"); 
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (3, "tant");             
    /*END_Lista de vocabulario tres   */ 
    /*palabra que esta en todas las listas   */ 
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (1, "tâches");  
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (2, "tâches");              
        INSERT INTO rel_wordsgroup_word 
            (id_words_group, word) values
            (3, "tâches");                          
    /*END_palabra que esta en todas las listas   */ 
/*END_rel_wordsgroup_word*/    
    
INSERT INTO ignored_word_in_a_list 
    (id_user, id_words_group, word, date_insert) VALUES 
    (1, 1, "epojé", now());
INSERT INTO ignored_word_in_a_list 
    (id_user, id_words_group, word, date_insert) VALUES 
    (1, 2, "amont", now());    
