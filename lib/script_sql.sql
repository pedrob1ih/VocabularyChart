CREATE TABLE word_table  (
	word char(50) NOT NULL,
	meaning char(50) NOT NULL,
	insertion_date date NOT NULL,
	PRIMARY KEY (word)
);
CREATE TABLE hit_miss (
	word char(50) NOT NULL,
	hit_miss BOOLEAN NOT NULL,
	hit_miss_date date NOT NULL,
	PRIMARY KEY (word),
	FOREIGN KEY(word) REFERENCES word_table(word)
);


tabla word (word (pk), meaning , insertion_date )
tabla hit_miss (word (pk), hit_miss , hit_miss_date)
