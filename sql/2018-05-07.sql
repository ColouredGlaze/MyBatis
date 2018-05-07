create database mybatis;
USE mybatis;
drop table if exists student;
CREATE TABLE `student` (
  `id` varchar(32) NOT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `stu_age` tinyint DEFAULT NULL,
  `gmt_create` datetime default current_timestamp,
  `gmt_modified` datetime on update current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
select * from student;