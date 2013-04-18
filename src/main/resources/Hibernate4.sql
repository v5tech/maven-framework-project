
USE `hibernate4`;

DROP TABLE IF EXISTS `t_employee`;

DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deptname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert  into `t_department`(`id`,`deptname`) values (1,'测试部');

CREATE TABLE `t_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empname` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFDCF5A19E8E64914` (`deptid`),
  CONSTRAINT `FKFDCF5A19E8E64914` FOREIGN KEY (`deptid`) REFERENCES `t_department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert  into `t_employee`(`id`,`empname`,`location`,`sex`,`deptid`) values (1,'李四','陕西汉中','女',1);
