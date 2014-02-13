drop table if exists article;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   id                   int not null auto_increment,
   title                varchar(100) not null comment '标题',
   abstruct             char(10) comment '1 work 简介 ',
   content              text comment '内容与项目描述',
   creattime            timestamp not null default CURRENT_TIMESTAMP,
   modtime              timestamp not null,
   author               varchar(50),
   hits                 int default 0,
   htmlFilePath         varchar(100),
   statu                int not null,
   nav_id               int,
   type                 int not null default 0 comment '0 博客 1 work',
   icon                 varchar(100) comment '封面图像',
   primary key (id)
);
drop table if exists navigation;

/*==============================================================*/
/* Table: navigation                                            */
/*==============================================================*/
create table navigation
(
   id                   int not null auto_increment,
   name                 varchar(20) not null,
   sequence             int default 0,
   statu                int default 0 comment '0 有效 1 失效',
   parent_id            int default 0 comment '父类',
   primary key (id)
);
drop table if exists photos;

/*==============================================================*/
/* Table: photos                                                */
/*==============================================================*/
create table photos
(
   id                   int not null auto_increment,
   name                 varchar(200),
   filepath             varchar(200) not null,
   statu               int default 0 comment '0 有效 1 删除',
   aritcle_id           int,
   remark               varchar(500),
   creattime            timestamp not null default CURRENT_TIMESTAMP,
   type                 int default 0 comment '0 图片 1 文件',
   primary key (id)
);
drop table if exists tag;

/*==============================================================*/
/* Table: tag                                                   */
/*==============================================================*/
create table tag
(
   id                   int not null auto_increment,
   content              varchar(500) not null,
   type                 int not null default 0 comment '0 blog 1 work',
   creattime           timestamp not null default CURRENT_TIMESTAMP,
   aritcle_id           int(11) NOT NULL,
   primary key (id)
);
