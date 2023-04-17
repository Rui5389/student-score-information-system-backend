create database studentdb  CHARACTER SET UTF8;
use studentdb;

drop table if exists manager;
CREATE TABLE `manager`(
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `user_name` varchar(50) NOT NULL COMMENT '用户名',
                          `pwd` varchar(50) NOT NULL COMMENT '密码',
                          PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '管理员表';
INSERT INTO manager(user_name, pwd) values('admin', '123456');

drop table if exists student;
CREATE TABLE `student`(
                          `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `no` varchar(50) NOT NULL COMMENT '学号',
                          `real_name` varchar(50) NOT NULL COMMENT '学生姓名',
                          `enroll_name` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入学日期',
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `uk_no` (`no`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '学生表';

drop table if exists score;
CREATE TABLE `score`(
                        `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `student_id` bigint NOT NULL COMMENT '外键：student表的id',
                        `exam_name` varchar(50) NOT NULL COMMENT '考试名称',
                        `cn_score` decimal(5,2) DEFAULT NULL COMMENT '语文成绩',
                        `en_score` decimal(5,2) DEFAULT NULL COMMENT '英语成绩',
                        `math_score` decimal(5,2) DEFAULT NULL COMMENT '数学成绩',
                        PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '成绩表';