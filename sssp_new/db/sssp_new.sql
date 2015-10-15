/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.49-community : Database - sssp_new
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sssp_new` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sssp_new`;

/*Table structure for table `sssp_departments` */

DROP TABLE IF EXISTS `sssp_departments`;

CREATE TABLE `sssp_departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sssp_departments` */

insert  into `sssp_departments`(`id`,`department_name`) values (1,'开发部'),(2,'测试部'),(3,'交易部'),(4,'后勤部'),(5,'总裁办');

/*Table structure for table `sssp_employees` */

DROP TABLE IF EXISTS `sssp_employees`;

CREATE TABLE `sssp_employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birth` date DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1by80iowxwcoway8hwu8aytt8` (`department_id`),
  CONSTRAINT `FK_1by80iowxwcoway8hwu8aytt8` FOREIGN KEY (`department_id`) REFERENCES `sssp_departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `sssp_employees` */

insert  into `sssp_employees`(`id`,`birth`,`create_time`,`email`,`last_name`,`department_id`) values (1,'2015-10-08','2015-10-23 09:40:24','aa@qq.com','aa',1),(2,'2015-10-10','2015-10-10 09:40:26','aa@qq.com','bbb',4),(3,'2015-10-01','2015-10-15 09:40:28','aa@qq.com','cc',3),(4,'2015-10-28','2015-10-15 09:40:30','aa@qq.com','dd',4),(5,'2015-11-06','2015-10-21 09:40:32','aa@qq.com','ee',5),(6,'2015-10-14','2015-10-28 09:40:35','aa@qq.com','ff',1),(7,'2015-10-13','2015-10-25 09:40:37','aa@qq.com','gg',2),(8,'1991-12-29','2015-10-11 11:47:43','aaa@qq.com','aaa',1),(9,'2015-11-06','2015-10-11 12:12:49','aa@qq.com','ee',2),(10,'2015-11-06','2015-10-11 12:12:56','aa@qq.com','ee',4),(11,'2015-10-08','2015-10-11 12:13:10','aa@qq.com','aa',2),(12,'2015-10-08','2015-10-11 12:13:19','aa@qq.com','aaaa',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
