drop database if exists addrook_db;
create database addrook_db;
use addrook_db;

drop table if exists sys_user;
CREATE TABLE sys_user(
     id INT(10) auto_increment comment'主键',
     name VARCHAR(255) comment'姓名',
     cellphone VARCHAR(255) UNIQUE COMMENT'手机号码',
     password VARCHAR(255) COMMENT'登录密码',
     email VARCHAR(255) UNIQUE COMMENT'电子邮件',
     address VARCHAR(500) COMMENT'联系地址',
     avatar VARCHAR(255) COMMENT'头像',
     createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment'创建时间',
     updateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP COMMENT'修改时间',
     primary key(id)
) engine=INNODB charset=utf8mb4 comment='用户信息表';