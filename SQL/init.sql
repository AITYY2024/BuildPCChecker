-- DB作成 --
CREATE DATABASE bpc_db;

-- cpuテーブル作成 --
CREATE TABLE cpu (
id serial primary key,
product_id varchar(255) unique,
url varchar(255),
product_name varchar(255),
price int,
release_date date,
core varchar(255),
freq varchar(255),
socket varchar(255),
gen varchar(255)
);

-- gpuテーブル作成 --
CREATE TABLE gpu(
id	serial	primary key
,product_id	varchar(255)	unique
,url	varchar(255)
,product_name	varchar(255)
,price	int
,release_date	date
,chip	varchar(255)
,vram	varchar(255)
);

-- memoryテーブル作成 --
CREATE TABLE memory(
id	serial	primary key
,product_id	varchar(255) unique
,url varchar(255)
,product_name varchar(255)
,price int
,release_date date
,capacity varchar(255)
,count varchar(255)
,spec varchar(255)
);

-- mbテーブル作成 --
CREATE TABLE mb(
id serial primary key
,product_id	varchar(255) unique
,url varchar(255)
,product_name varchar(255)
,price int
,release_date date
,formfactor varchar(255)
,chipset varchar(255)
,socket varchar(255)
,ram_spec varchar(255)
);

-- ssdテーブル作成 --
CREATE TABLE ssd(
id	serial primary key
,product_id varchar(255) unique
,url varchar(2000)
,product_name varchar(255)
,price int
,release_date date
,capacity varchar(255)
,spec_size varchar(255)
,interface varchar(255)
);

-- psuテーブル作成 --
CREATE TABLE psu(
id	serial primary key
,product_id varchar(255) unique
,url varchar(2000)
,product_name varchar(255)
,price int
,release_date date
,capacity varchar(255)
,formfactor varchar(255)
,spec_80plus varchar(255)
);

-- osテーブル作成 --
CREATE TABLE os(
id	serial primary key
,product_id varchar(255) unique
,url varchar(2000)
,product_name varchar(255)
,price int
,release_date date
);

-- presetテーブル作成 --
create table preset( 
    preset_id serial primary key
    , preset_name varchar (255) not null
    , user_id int
    , cpu_id varchar (255)
    , cpu_name varchar (255)
    , cpu_url text
    , gpu_id varchar (255)
    , gpu_name varchar (255)
    , gpu_url text
    , ram_id varchar (255)
    , ram_name varchar (255)
    , ram_url text
    , mb_id varchar (255)
    , mb_name varchar (255)
    , mb_url text
    , ssd_id varchar (255)
    , ssd_name varchar (255)
    , ssd_url text
    , psu_id varchar (255)
    , psu_name varchar (255)
    , psu_url text
    , os_id varchar (255)
    , os_name varchar (255)
    , os_url text
    , total_amount int not null
    , description text
    , update_at date
);

-- 互換性テーブル作成 --
CREATE TABLE compatible(
id serial PRIMARY KEY 
,cpu_generation varchar(255)	not null
,chipset_name	varchar(255)	not null
);

-- usersテーブル作成 --
CREATE TABLE users(
id serial PRIMARY KEY
,user_name	varchar(255) not null
,password	varchar(255) not null
,role	int	not null
);
