
CREATE DATABASE IF NOT EXISTS `shiro`  DEFAULT CHARACTER SET utf8 ;

USE `shiro`;

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `roles` WRITE;

insert  into `roles`(`role_name`) values ('Admin'),('User');

UNLOCK TABLES;

DROP TABLE IF EXISTS `roles_permissions`;

CREATE TABLE `roles_permissions` (
  `role_name` varchar(255) NOT NULL,
  `permission` varchar(255) NOT NULL,
  PRIMARY KEY (`role_name`,`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `roles_permissions` WRITE;

insert  into `roles_permissions`(`role_name`,`permission`) values ('Admin','user:view'),('Admin','user:edit'),('User','user:view');

UNLOCK TABLES;

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `username` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  UNIQUE KEY `user_roles_uq` (`username`,`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_roles` WRITE;

insert  into `user_roles`(`username`,`role_name`) values ('admin','Admin'),('admin','User'),('user','User');

UNLOCK TABLES;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;

insert  into `users`(`username`,`PASSWORD`) values ('admin','2CSU8F1pF7oC96qilonMtES7c/IDgIdssF0fN1N7eJI='),('user','4XLFZU28EteM4YUKT3lWum5aPSrEDwkl/G1pHrtU9r8=');

UNLOCK TABLES;
