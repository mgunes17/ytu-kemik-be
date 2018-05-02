CREATE KEYSPACE kemik_havadis_test
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '3'}
AND durable_writes = true;

USE kemik_havadis_test;

CREATE TABLE user_info (
	username text PRIMARY KEY,
	name text,
	surname text,
	password text,
	ticket text,
	user_type text,
	created_date timestamp
);

CREATE TABLE intact_tweet (
	id bigint PRIMARY KEY,
	tweet text,
	screen_name text,
	username text,
	favorite_count int,
	retweet_count int,
	created_date timestamp,
	is_favorited boolean,
	is_retweeted boolean,
	is_retweet boolean,
	lang text,
	crawled_date timestamp,
	label_project_name set<text>
);

CREATE TABLE labeled_simple_data (
	id uuid PRIMARY KEY,
	id_from_source text,
	source_type text,
	content text,
	project_name text,
	label text,
	is_certain boolean,
	labeled_date timestamp,
	data_created_date timestamp
);

CREATE TABLE label_info (
	data_uuid uuid,
	username text,
	project_name text,
	label text,
	labeled_date timestamp,
	PRIMARY KEY (project_name, username, data_uuid)
);