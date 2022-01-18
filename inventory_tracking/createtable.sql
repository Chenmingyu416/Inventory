
CREATE DATABASE `inventory`;

USE  `inventory`;

/*Table structure for inventory_info` */

DROP TABLE IF EXISTS `inventory_info`;


CREATE TABLE `inventory_info`(
  `goodId` varchar(20)  NOT NULL,
  `goodName` varchar(100) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `supplier` varchar(100) DEFAULT NULL,
  `count` int(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`goodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert  into `inventory_info`
(`goodId`,`goodName`,`type`,`supplier`,`count`,`price`) values
    ('001','Coca-Cola','baverage','Coca-Cola Company',100,3),
    ('002','Zara','Cloth','Inditex',40,26),
    ('003','Harry Potter','Books','XinHua bookstore',20,15);

