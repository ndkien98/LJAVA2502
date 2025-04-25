create database antino;
use antino;
create table user (
                      id int primary key auto_increment,
                      username nvarchar(20),
                      full_name nvarchar(50),
                      age int
);

insert user (username, full_name, age)
values ('admin','Nguyen Van A',25),
('user','Nguyen Van B',20)