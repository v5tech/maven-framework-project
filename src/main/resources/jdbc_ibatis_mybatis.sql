
USE `jdbc_ibatis_mybatis`;

DROP TABLE IF EXISTS `product`;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

insert  into `category`(`id`,`name`) values (1,'手机'),(2,'平板电脑'),(3,'笔记本');

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `categoryid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category` (`categoryid`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


insert  into `product`(`id`,`name`,`price`,`description`,`categoryid`) values (1,'ipad2',3000,'ipad2',2),(2,'ipad3',4000,'ipad3',2),(3,'ipad4',3000,'ipad4',2),(4,'SONY手机',79,'SONY手机,手机中的战斗机!',1),(5,'Surface平板电脑',4680,'Surface平板电脑',2);
