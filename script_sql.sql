CREATE TABLE words  (
	word char(50) NOT NULL,
	meaning char(50) NOT NULL,
	insertion_date date NOT NULL,
	PRIMARY KEY (word)
);
CREATE TABLE hit_miss (
	word char(50) NOT NULL,
	hit BOOLEAN NOT NULL,
	hitDate date NOT NULL,
	PRIMARY KEY (word),
	FOREIGN KEY(word) REFERENCES words(word)
);


tabla words (word (pk), meaning , insertion_date )
tabla hit_miss (word (pk), hit_miss , hit_miss_date)
