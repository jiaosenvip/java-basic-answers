drop database if exists `companySys`;

create database if not exists `companySys` default character set utf8;

use `companySys`;

create table `company`
(
	`company_name` varchar(50),
	`city` varchar(10),
	primary key (`company_name`)
) engine=InnoDB default charset=utf8;

create table `work`
(
	`per_name` varchar(10),
	`company_name` varchar(50),
	`city` varchar(10),
	primary key (`per_name`),
	foreign key (`company_name`) references `company`(`company_name`)
) engine=InnoDB default charset=utf8;

create table `employ`
(
	`id` int not null,
	`person_name` varchar(10),
	`street` varchar(100),
	`city` varchar(10),
	primary key (`id`),
	foreign key (`person_name`) references `work`(`per_name`)
) engine=InnoDB default charset=utf8;

insert into `company`
values
('实验楼','成都'),
('腾讯','深圳'),
('阿里巴巴','杭州');

insert into `work`
values
('李明','实验楼','成都'),
('王力','腾讯','北京'),
('张强','阿里巴巴','上海');

insert into `employ`
values
(1,'李明','湖北省武汉市武昌区和平大道','武汉'),
(2,'王力','天津市和平区开封道','天津'),
(3,'张强','杭州市西湖区余杭塘路','杭州');