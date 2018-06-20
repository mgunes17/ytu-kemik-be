-- Database: kemik_havadis_data

-- DROP DATABASE kemik_havadis_data;

CREATE DATABASE kemik_havadis_data
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA manager
    AUTHORIZATION postgres;
CREATE SCHEMA label
    AUTHORIZATION postgres;
CREATE SCHEMA crawler
    AUTHORIZATION postgres;


CREATE TABLE manager.user_info (
	id BIGINT PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	name VARCHAR(50),
	surname VARCHAR(50),
	password VARCHAR(30),
	ticket VARCHAR(50),
	user_type VARCHAR(50),
	created_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE crawler.main_tweet (
	id BIGINT PRIMARY KEY,
	tweet VARCHAR(600) NOT NULL,
	screen_name VARCHAR(100) NOT NULL,
	username VARCHAR(100) NOT NULL,
	favorite_count NUMERIC,
	retweet_count NUMERIC,
	tweeted_date TIMESTAMP,
	is_favorited BOOLEAN,
	is_retweeted BOOLEAN,
	is_retweet BOOLEAN,
	lang VARCHAR(50),
	created_date TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

CREATE TABLE crawler.labeled_main_tweet (
	id BIGINT PRIMARY KEY,
	project_name VARCHAR(50) NOT NULL,
    main_tweet_id BIGINT REFERENCES crawler.main_tweet(id) NOT NULL,
	created_date TIMESTAMP WITHOUT TIME ZONE  NOT NULL,
	UNIQUE(project_name, main_tweet_id)
);

CREATE TABLE crawler.twitter_user (
	id BIGINT PRIMARY KEY,
	twitter_id BIGINT NOT NULL UNIQUE, 
	name VARCHAR(255),
	screen_name VARCHAR(255) NOT NULL UNIQUE,
	followers_count NUMERIC,
	following_count NUMERIC
);

CREATE TABLE crawler.twitter_user_relation (
	id BIGINT PRIMARY KEY,
	follower_id BIGINT NOT NULL REFERENCES crawler.twitter_user(id),
	followed_id BIGINT NOT NULL REFERENCES crawler.twitter_user(id),
	UNIQUE(follower_id, followed_id),
	CHECK(follower_id <> followed_id)
);

CREATE TABLE label.labeled_simple_data (
	id BIGINT PRIMARY KEY,
	id_from_source VARCHAR(50),
	source_type VARCHAR(50),
	content VARCHAR(500),
	project_name VARCHAR(50),
	label VARCHAR(50),
	is_certain BOOLEAN,
	labeled_date TIMESTAMP,
	data_created_date TIMESTAMP
);

CREATE TABLE label.label_info (
	id BIGINT PRIMARY KEY,
	labeled_simple_data_id BIGINT REFERENCES label.labeled_simple_data(id),
	username VARCHAR(50),
	label VARCHAR(50),
	created_date TIMESTAMP,
	UNIQUE (username, labeled_simple_data_id)
);

CREATE SEQUENCE crawler.common_sequnce START 101;

CREATE SEQUENCE hibernate_sequence START 1;

CREATE SEQUENCE crawler.hibernate_sequence START 1;

CREATE SEQUENCE label.hibernate_sequence START 1;