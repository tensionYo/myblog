create database blog;

use blog;

drop table if exists t_blog;

drop table if exists t_comment;

drop table if exists t_tag;

drop table if exists t_type;

drop table if exists t_user;

create table t_blog
(
  id              int  auto_increment primary key ,
  title           varchar(64)           ,
  content         varchar(128)          ,
  firstPicture    varchar(32)           ,
  flag            varchar(32)           ,
  views           INT(32)               ,
  appreciation    boolean               ,
  shareStatement  boolean               ,
  commentables    boolean               ,
  published       boolean               ,
  recomend        boolean               ,
  createTime      DATE                  ,
  updateTime      DATE


) default charset = utf8 comment 'blog信息表';

create table t_comment
(
  id              int  auto_increment primary key ,
  nickname        varchar(64)           ,
  email           varchar(64)           ,
  content         varchar(128)          ,
  avatar          varchar(64)           ,
  createTime      DATE                  ,
  updateTime      DATE


) default charset = utf8 comment 'comment信息表';


create table t_tag
(
  id              int  auto_increment primary key ,
  name            varchar(64)
) default charset = utf8 comment 'tag信息表';

create table t_type
(
  id              int  auto_increment primary key ,
  name            varchar(64)
) default charset = utf8 comment 'type信息表';

create table t_user
(
  id              int  auto_increment primary key ,
  nickname        varchar(64)           ,
  username        varchar(64)           ,
  password        varchar(32)           ,
  email           varchar(64)           ,
  avatar          varchar(64)           ,
  type            int(32)               ,
  createTime      DATE                  ,
  updateTime      DATE
) default charset = utf8 comment 'user信息表';

insert into t_user (
  avatar, password, updateTime,
  nickname, email, createTime, type,
  username)
  values (
  'https://unsplash.it/100/100?image=1005',
  '123456',
  '2017-10-15 12:36:23',
   '管理员', 'hh@163.com',
  '2017-10-15 12:36:04', '1', 'admin');

insert into t_type(name)
values ('日语');

insert into t_tag(name)
values ('分类6');