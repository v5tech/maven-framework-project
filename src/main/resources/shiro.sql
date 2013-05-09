
CREATE DATABASE IF NOT EXISTS `shiro`  DEFAULT CHARACTER SET utf8 ;

USE `shiro`;

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `roles` WRITE;

insert  into `roles`(`role_name`) values ('role1'),('role2');

UNLOCK TABLES;

DROP TABLE IF EXISTS `roles_permissions`;

CREATE TABLE `roles_permissions` (
  `role_name` varchar(255) NOT NULL,
  `permission` varchar(255) NOT NULL,
  PRIMARY KEY (`role_name`,`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `roles_permissions` WRITE;

insert  into `roles_permissions`(`role_name`,`permission`) values ('role1','permission1'),('role1','permission2'),('role2','permission1');

UNLOCK TABLES;

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `username` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  UNIQUE KEY `user_roles_uq` (`username`,`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_roles` WRITE;

insert  into `user_roles`(`username`,`role_name`) values ('user1','role1'),('user1','role2'),('user2','role2');

UNLOCK TABLES;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;

insert  into `users`(`username`,`PASSWORD`) values ('user1','+XdzYjFKiLoNffcB7Wvr0KNXe+M77+crq8QMOd5lqx8='),('user2','KmOs0a5jkpeDq5F5tNEjVish+AkcBdLvTw+thmq1x8k=');

UNLOCK TABLES;
