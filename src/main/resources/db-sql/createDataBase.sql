-- SQL запрос для генерации базы данных --

------------------------------------------------------------------------------------------------------------------------

-- Пользователь --
CREATE TABLE users (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	login           	VARCHAR(20)         NOT NULL,
  	password        	VARCHAR(30)         NOT NULL,
  	username            VARCHAR(15)         NOT NULL,
  	create_account  	TIMESTAMP           NOT NULL,
  	signature       	VARCHAR(50),
  	last_login 			TIMESTAMP
);

------------------------------------------------------------------------------------------------------------------------

-- Настройки тем--
CREATE TABLE theme_modes (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	color               VARCHAR(10)
);

-- Настройки пользователя --
CREATE TABLE settings (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	user_id             INT                 NOT NULL,
  	theme_mode_id	    INT                 NOT NULL,
  	is_mkd     	        BOOLEAN,
  	FOREIGN KEY (user_id)
  	    REFERENCES users (id),
	FOREIGN KEY (theme_mode_id)
	    REFERENCES theme_modes (id)
);

------------------------------------------------------------------------------------------------------------------------

-- Заметки --
CREATE TABLE notes (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	notesname        	VARCHAR(30)         NOT NULL,
  	text     	        VARCHAR(300),
  	create_date_time	VARCHAR(3000)
);

-- Пользователи_заметки --
CREATE TABLE users_notes (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	user_id             INT                 NOT NULL,
  	note_id     	    INT                 NOT NULL,
  	is_creator          BOOLEAN,
  	is_author           BOOLEAN,
  	is_reader           BOOLEAN,
	FOREIGN KEY (user_id)
	    REFERENCES users (id),
	FOREIGN KEY (note_id)
	    REFERENCES notes (id)
);

------------------------------------------------------------------------------------------------------------------------

-- Книги --
CREATE TABLE books (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	bookname        	VARCHAR(30)         NOT NULL,
  	create_date_time	TIMESTAMP           NOT NULL,
  	description     	VARCHAR(300),
  	finish_date_time	TIMESTAMP,
  	last_login 			TIMESTAMP
);

-- Пользователи_книги --
CREATE TABLE users_books (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	user_id             INT                 NOT NULL,
  	book_id     	    INT                 NOT NULL,
  	is_creator          BOOLEAN,
  	is_author           BOOLEAN,
  	is_reader           BOOLEAN,
	FOREIGN KEY (user_id)
	    REFERENCES users (id),
	FOREIGN KEY (book_id)
	    REFERENCES books (id)
);

------------------------------------------------------------------------------------------------------------------------

-- Главы --
CREATE TABLE chapters (
  	id              	BIGINT GENERATED    BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	book_id       		INT                 NOT NULL,
  	name        		VARCHAR(30),
  	text     			VARCHAR(40000),
  	create_date_time	TIMESTAMP,
  	last_update 		TIMESTAMP,
	FOREIGN KEY (book_id)
	    REFERENCES books (id)
);

------------------------------------------------------------------------------------------------------------------------

-- Персонажи --
CREATE TABLE characters (
  	id              	BIGINT GENERATED    BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
  	book_id       		INT                 NOT NULL,
	  	name        		VARCHAR(30)         NOT NULL,
  	characteristic     	VARCHAR(300),
	age 				INT,
  	create_date_time	TIMESTAMP,
  	last_update 		TIMESTAMP,
	FOREIGN KEY (book_id)
	    REFERENCES books (id)
);

CREATE TABLE chapters_characters (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	characters_id       INT,
  	chapters_id     	INT,
  	FOREIGN KEY (chapters_id)
	    REFERENCES chapters (id),
	FOREIGN KEY (characters_id)
	    REFERENCES characters (id)
);

------------------------------------------------------------------------------------------------------------------------

-- Места --
CREATE TABLE place_types (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	name                VARCHAR(10),
  	chapters_id     	INT
);
CREATE TABLE place (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	book_id       		INT NOT NULL,
  	place_type_id       INT NOT NULL,
	name        		VARCHAR(30),
  	description     	VARCHAR(300),
  	foundation          VARCHAR(100),
  	collapse            VARCHAR(100),
  	population          INT,
  	area				INT,
  	faith               VARCHAR(100),
  	create_date_time	TIMESTAMP,
  	last_update 		TIMESTAMP,
	FOREIGN KEY (book_id)
	    REFERENCES books (id),
	FOREIGN KEY (place_type_id)
	    REFERENCES place_types (id)
);

CREATE TABLE chapters_place (
  	id              	INT GENERATED       BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	place_id        	INT,
  	chapters_id     	INT,
	FOREIGN KEY (chapters_id)
	    REFERENCES chapters (id),
	FOREIGN KEY (place_id)
	    REFERENCES place (id)
);