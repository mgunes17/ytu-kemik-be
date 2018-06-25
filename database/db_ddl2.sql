create database kemik_havadis_data;

create sequence crawler.common_sequnce;

create sequence crawler.hibernate_sequence;

create sequence label.hibernate_sequence;

create table manager.user_info
(
  id           bigint      not null
    constraint user_info_pkey
    primary key,
  username     varchar(50) not null
    constraint user_info_username_key
    unique,
  name         varchar(50),
  surname      varchar(50),
  password     varchar(30),
  ticket       varchar(50),
  user_type    varchar(50),
  created_date timestamp   not null
);

create table crawler.main_tweet
(
  id             bigint       not null
    constraint main_tweet_pkey
    primary key,
  tweet          varchar(300) not null,
  screen_name    varchar(100) not null,
  username       varchar(100) not null,
  favorite_count numeric,
  retweet_count  numeric,
  tweeted_date   timestamp,
  is_favorited   boolean,
  is_retweeted   boolean,
  is_retweet     boolean,
  lang           varchar(50),
  created_date   timestamp    not null
);

create table crawler.labeled_main_tweet
(
  id            bigint      not null
    constraint labeled_main_tweet_pkey
    primary key,
  project_name  varchar(50) not null,
  main_tweet_id bigint      not null
    constraint labeled_main_tweet_main_tweet_id_fkey
    references main_tweet,
  created_date  timestamp   not null,
  constraint labeled_main_tweet_project_name_main_tweet_id_key
  unique (project_name, main_tweet_id)
);

create table crawler.twitter_user
(
  id              bigint       not null
    constraint twitter_user_pkey
    primary key,
  twitter_id      bigint       not null
    constraint twitter_user_twitter_id_key
    unique,
  name            varchar(255),
  screen_name     varchar(255) not null
    constraint twitter_user_screen_name_key
    unique,
  followers_count numeric,
  following_count numeric
);

create table crawler.twitter_user_relation
(
  id          bigint not null
    constraint twitter_user_relation_pkey
    primary key,
  follower_id bigint not null
    constraint twitter_user_relation_follower_id_fkey
    references twitter_user,
  followed_id bigint not null
    constraint twitter_user_relation_followed_id_fkey
    references twitter_user,
  constraint twitter_user_relation_follower_id_followed_id_key
  unique (follower_id, followed_id),
  constraint twitter_user_relation_check
  check (follower_id <> followed_id)
);

create table label.labeled_simple_data
(
  id                bigint not null
    constraint labeled_simple_data_pkey
    primary key,
  id_from_source    varchar(50),
  source_type       varchar(50),
  content           varchar(500),
  project_name      varchar(50),
  label             varchar(50),
  is_certain        boolean,
  labeled_date      timestamp,
  data_created_date timestamp
);

create table label.label_info
(
  id                     bigint not null
    constraint label_info_pkey
    primary key,
  labeled_simple_data_id bigint
    constraint label_info_labeled_simple_data_id_fkey
    references labeled_simple_data,
  username               varchar(50),
  label                  varchar(50),
  created_date           timestamp,
  constraint label_info_username_labeled_simple_data_id_key
  unique (username, labeled_simple_data_id)
);
