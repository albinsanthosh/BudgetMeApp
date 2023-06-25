DROP SCHEMA IF EXISTS `budgetme`;

CREATE SCHEMA `budgetme`;

use `budgetme`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date,
  `category` varchar(45) DEFAULT NULL,
  `detail` varchar(45) DEFAULT NULL,
  `spent` double,
  `month` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `planning`;

CREATE TABLE `planning` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  `planned` double,
  `month` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
