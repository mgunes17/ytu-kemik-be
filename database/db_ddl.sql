-- Database: kemik_havadis_data

-- DROP DATABASE kemik_havadis_data;

CREATE DATABASE kemik_havadis_data
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Turkish_Turkey.1254'
    LC_CTYPE = 'Turkish_Turkey.1254'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


CREATE TABLE manager.user_info (
	id bigint PRIMARY KEY,
	username varchar(50) UNIQUE NOT NULL,
	name varchar(50),
	surname varchar(50),
	password varchar(30),
	ticket varchar(50),
	user_type varchar(50),
	created_date timestamp without time zone NOT NULL
);

CREATE TABLE crawler.main_tweet (
	id bigint PRIMARY KEY,
	tweet varchar(300) NOT NULL,
	screen_name varchar(100) NOT NULL,
	username varchar(100) NOT NULL,
	favorite_count numeric,
	retweet_count numeric,
	tweeted_date timestamp,
	is_favorited boolean,
	is_retweeted boolean,
	is_retweet boolean,
	lang varchar(50),
	created_date timestamp without time zone NOT NULL
);

CREATE TABLE crawler.labeled_main_tweet (
	id BIGINT PRIMARY KEY,
	project_name varchar(50) NOT NULL,
    main_tweet_id BIGINT references crawler.main_tweet(id) NOT NULL,
	created_date timestamp without time zone  NOT NULL,
	UNIQUE(project_name, main_tweet_id)
);

CREATE TABLE label.labeled_simple_data (
	id BIGINT PRIMARY KEY,
	id_from_source varchar(50),
	source_type varchar(50),
	content varchar(500),
	project_name varchar(50),
	label varchar(50),
	is_certain boolean,
	labeled_date timestamp,
	data_created_date timestamp
);

CREATE TABLE label.label_info (
	id BIGINT PRIMARY KEY,
	labeled_simple_data_id BIGINT references label.labeled_simple_data(id),
	username varchar(50),
	project_name varchar(50),
	label varchar(50),
	labeled_date timestamp,
	crated_date timestamp,
	UNIQUE (project_name, username, labeled_simple_data_id)
);

CREATE SEQUENCE crawler.common_sequnce START 101;

CREATE SEQUENCE hibernate_sequence START 1;

CREATE SEQUENCE crawler.hibernate_sequence START 1;

CREATE SEQUENCE label.hibernate_sequence START 1;