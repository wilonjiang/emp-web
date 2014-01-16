DROP TABLE IF EXISTS `user`;
create table `user`(
	id int auto_increment not null,
	userName varchar(32) not null,
	aliasesName varchar(54),
	password varchar(128) not null,
	userType char(1) not null,
	userState char(1) not null,
	createTime timestamp not null,
	primary key(id)
);