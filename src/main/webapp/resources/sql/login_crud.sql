create database login_crud;
use login_crud;
create table member(
	id varchar(30) primary key,
    pw varchar(30),
    age int
);