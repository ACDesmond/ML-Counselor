-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: mlc
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `start` text NOT NULL,
  `end` text NOT NULL,
  `time` int(11) NOT NULL,
  `self_designed` text,
  `one` int(11) NOT NULL,
  `two` double NOT NULL,
  `three` int(11) NOT NULL,
  `four` int(11) NOT NULL,
  `five` int(11) NOT NULL,
  `six` int(11) NOT NULL,
  `seven` int(11) NOT NULL,
  `eight` int(11) NOT NULL,
  `nine` int(11) NOT NULL,
  `ten` int(11) NOT NULL,
  `eleven` int(11) NOT NULL,
  `twelve` int(11) NOT NULL,
  `thirteen` double NOT NULL,
  `fourteen` double NOT NULL,
  `fifteen` double NOT NULL,
  `sixteen` double NOT NULL,
  `seventeen` double NOT NULL,
  `eighteen` double NOT NULL,
  `nineteen` double NOT NULL,
  `twenty` double NOT NULL,
  `twentyone` double NOT NULL,
  `twentytwo` double NOT NULL,
  `twentythree` double NOT NULL,
  `twentyfour` int(11) NOT NULL,
  `twentyfive` tinytext NOT NULL,
  `twentysix` int(11) NOT NULL,
  `twentyseven` year(4) NOT NULL,
  `twentyeight` int(11) NOT NULL,
  `twentynine_province` tinytext,
  `twentynine_city` tinytext,
  `thirty` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_Id` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES (1,1,'16-Aug-2019 11:33:57','16-Aug-2019 11:36:54',177,'',1,1500,1,1,1,1,1,1,2,2,2,2,0,1000,300,0,100,10,20,50,0,100,0,4,'',1,2012,1,'江苏省','南京市',4),(2,2,'16-Aug-2019 11:34:28','16-Aug-2019 11:37:22',174,'',1,3000,1,1,2,3,2,1,2,2,2,1,50000,1500,300,300,300,100,20,100,3000,500,100,5,'',1,2014,1,'江苏省','南京市',4),(3,3,'16-Aug-2019 11:35:27','16-Aug-2019 11:38:38',191,'',1,1000,1,1,1,1,1,1,4,2,2,2,0,1400,0,200,500,50,100,300,0,300,0,5,'',1,2013,1,'江苏省','淮安市',4),(4,4,'16-Aug-2019 11:35:33','16-Aug-2019 11:40:20',287,'',5,1500,1,1,1,1,1,1,1,2,1,1,10000,1000,100,2000,300,50,60,50,1000,2500,1000,7,'',1,2012,1,'江苏省','南京市',4),(5,5,'16-Aug-2019 11:34:30','16-Aug-2019 11:45:31',661,'',5,2500,1,1,2,1,2,1,4,1,2,1,0,800,0,0,200,100,100,0,0,0,0,10,'',1,2012,1,'江西省','景德镇市',4),(6,6,'16-Aug-2019 11:41:18','16-Aug-2019 11:46:52',334,'',1,3000,1,3,1,1,1,1,4,1,2,1,0,2000,500,0,200,200,60,50,0,200,50,5,'购物',2,2014,1,'江苏省','南京市',4),(7,7,'16-Aug-2019 11:48:23','16-Aug-2019 11:50:42',139,'',1,2000,1,1,2,3,2,1,2,2,2,1,0,1000,0,150,200,100,50,500,2000,500,0,7,'',1,2013,1,'江苏省','南京市',4),(8,8,'16-Aug-2019 11:54:29','16-Aug-2019 11:55:18',49,'',1,10000,1,1,1,1,2,1,3,2,1,2,1000,1000,1000,100,100,10,100,1000,1000,1000,19900,10,'无',1,2001,2,'浙江省','台州市',2),(9,9,'16-Aug-2019 11:48:41','16-Aug-2019 11:55:18',397,'',2,5000,3,2,2,3,3,2,2,2,1,2,5000,5000,1000,2000,2000,500,20,1000,5000,1000,2000,8,'一类',2,2039,8,'北京市','北京市',2),(10,10,'16-Aug-2019 12:02:20','16-Aug-2019 12:09:42',442,'',2,10000,3,2,2,3,4,3,2,2,2,1,0,2000,1000,8000,2000,500,200,1000,2000,0,1600,10,'',1,2039,8,'北京市','北京市',2),(11,11,'16-Aug-2019 12:07:47','16-Aug-2019 12:09:54',127,'',1,1500,1,1,1,1,1,1,1,1,1,1,150,1500,200,0,200,150,50,150,0,200,30,10,'',1,2012,1,'江苏省','南京市',4),(12,12,'16-Aug-2019 12:03:45','16-Aug-2019 12:10:45',420,'',1,2000,3,1,3,3,5,2,2,3,2,2,0,1500,200,200,1000,600,150,100,0,1000,0,8,'0',1,2041,3,'辽宁省','大连市',4),(13,13,'16-Aug-2019 12:11:32','16-Aug-2019 12:21:34',602,'',1,1000,1,1,1,1,1,1,4,1,1,1,8000,2000,2000,500,500,500,200,200,0,0,300,8,'',1,2053,11,'重庆市','重庆市',3),(14,14,'16-Aug-2019 12:22:30','16-Aug-2019 12:26:03',213,'',1,10000,1,1,2,1,1,2,2,2,1,2,5000,2000,1000,1300,500,50,40,200,2000,200,200,7,'',1,2019,4,'上海市','上海市',5),(15,15,'16-Aug-2019 12:24:14','16-Aug-2019 12:37:05',771,'',1,2000,1,1,1,1,2,2,4,2,3,1,3000,1500,4000,4000,1000,2000,150,1200,5000,50,300,9,'',2,2015,4,'江苏省','苏州市',1),(16,16,'16-Aug-2019 12:45:00','16-Aug-2019 12:48:03',183,'',1,1800,1,1,2,3,2,2,2,2,2,1,2000,1000,200,50,300,50,100,100,3000,500,100,1,'',1,2014,1,'江苏省','苏州市',4),(17,17,'16-Aug-2019 12:57:10','16-Aug-2019 13:02:35',325,'',1,2200,1,1,1,1,1,1,1,2,1,1,0,1000,500,100,100,40,50,200,2000,100,40,5,'无',2,2012,1,'江苏省','南京市',4),(18,18,'16-Aug-2019 12:58:02','16-Aug-2019 13:04:01',359,'',3,10000,3,1,2,3,2,4,4,3,2,2,1000,3000,500,500,500,500,300,2000,30000,500,100,8,'',1,2013,9,'北京市','北京市',3),(19,19,'16-Aug-2019 13:27:52','16-Aug-2019 13:32:56',304,'',1,6000,2,2,2,2,2,2,1,1,1,2,3000,2000,1000,1000,500,500,100,200,3000,500,100,9,'',1,2039,4,'江苏省','苏州市',3),(20,20,'16-Aug-2019 13:28:32','16-Aug-2019 13:36:46',494,'',1,5000,2,2,3,3,5,4,2,3,3,4,3000,500,500,300,200,100,100,100,5000,100,300,10,'',2,2001,3,'江苏省','扬州市',5),(21,21,'16-Aug-2019 14:29:42','16-Aug-2019 14:35:01',319,'',1,5000,2,1,1,1,1,1,2,2,2,1,0,1000,1000,1000,1000,200,100,0,0,200,200,5,'无',2,2019,4,'北京市','北京市',3),(22,22,'16-Aug-2019 14:31:38','16-Aug-2019 14:35:53',255,'',5,2000,1,3,1,1,1,1,2,2,1,2,500,500,1000,0,300,100,100,0,10000,1000,0,3,'服装和饮食',2,2013,1,'北京市','北京市',4),(23,23,'16-Aug-2019 14:34:25','16-Aug-2019 14:40:20',355,'',1,5000,2,1,2,2,1,3,1,3,1,2,10000,2000,1000,1000,200,200,100,50,10000,200,0,8,'',1,2038,6,'江苏省','扬州市',3),(24,24,'16-Aug-2019 14:44:32','16-Aug-2019 14:46:49',137,'',1,6000,2,2,2,3,3,2,2,2,2,1,20000,2000,2000,1000,500,500,100,100,20000,0,100,6,'',2,2031,3,'江苏省','扬州市',4),(25,25,'16-Aug-2019 14:42:52','16-Aug-2019 14:48:53',361,'',1,2000,1,2,1,3,5,2,2,2,1,1,2000,1000,1000,3000,1000,1000,500,3000,10000,200,1000,1,'',2,2043,6,'江苏省','扬州市',4),(26,26,'16-Aug-2019 14:48:23','16-Aug-2019 14:51:21',178,'',1,5000,2,2,2,3,5,4,2,2,2,2,10000,3000,1000,15000,1500,1000,500,1000,10000,500,500,8,'餐饮',2,2030,4,'江苏省','南京市',4),(27,27,'16-Aug-2019 14:51:38','16-Aug-2019 14:55:12',214,'',1,6000,1,1,2,3,2,1,1,2,1,1,0,1000,1000,1000,500,500,100,200,5000,1000,100,5,'',2,2041,3,'江苏省','扬州市',4),(28,28,'16-Aug-2019 14:55:48','16-Aug-2019 15:00:23',275,'',1,3000,4,1,2,2,1,1,1,1,1,1,100,1000,300,200,200,50,70,50,1000,100,10,8,'没有',1,2014,1,'江苏省','苏州市',4),(29,29,'16-Aug-2019 15:05:52','16-Aug-2019 15:10:37',285,'',1,20000,2,1,2,3,3,4,1,3,3,3,0,1500,500,600,1000,1000,200,100,20000,2000,0,8,'',1,2044,8,'上海市','上海市',5),(30,30,'16-Aug-2019 15:05:19','16-Aug-2019 15:11:41',382,'',1,5000,1,1,2,1,1,1,1,2,1,1,10000,2000,500,1000,1000,300,150,200,5000,100,100,8,'',2,2044,5,'江苏省','扬州市',5),(31,31,'16-Aug-2019 15:09:22','16-Aug-2019 15:13:04',222,'',1,3000,2,1,1,3,4,2,2,1,2,2,5000,3000,1000,400,200,400,200,200,5000,200,200,7,'',1,2036,3,'江苏省','扬州市',4),(32,32,'16-Aug-2019 15:34:38','16-Aug-2019 15:37:25',167,'',1,10000,2,2,2,3,5,1,2,4,4,4,0,2000,200,6000,500,600,200,200,10000,500,500,6,'',1,2040,3,'江苏省','扬州市',4),(33,33,'16-Aug-2019 15:45:28','16-Aug-2019 15:56:06',638,'',1,7000,2,2,2,3,5,1,2,3,3,2,6000,1600,400,300,200,1500,30,100,3000,300,100,8,'无',1,2050,4,'江苏省','扬州市',4),(34,34,'16-Aug-2019 15:52:25','16-Aug-2019 15:56:29',244,'',1,5000,3,1,2,3,4,3,2,2,2,2,5000,2000,1000,1000,300,100,100,1000,10000,50,500,8,'',2,2040,3,'江苏省','扬州市',4),(35,35,'16-Aug-2019 15:55:56','16-Aug-2019 16:00:28',272,'',1,7000,3,1,2,3,4,2,1,2,2,2,0,3000,1000,500,500,100,200,200,5000,200,0,7,'',2,2036,2,'江苏省','扬州市',4),(36,36,'16-Aug-2019 16:56:19','16-Aug-2019 17:00:23',244,'',1,8000,3,1,1,1,2,2,4,1,1,1,0,8000,5000,1000,1000,1000,200,100,10000,100,100,10,'',2,2037,3,'江苏省','扬州市',4),(37,37,'16-Aug-2019 16:54:06','16-Aug-2019 17:00:56',410,'',1,4000,2,2,2,3,4,3,1,2,2,2,2000,1500,1000,200,300,500,80,50,50000,100,0,7,'',2,2035,4,'江苏省','扬州市',2),(38,38,'16-Aug-2019 18:19:17','16-Aug-2019 18:25:23',366,'',1,8000,3,1,2,3,4,2,2,3,2,1,1000,2000,500,500,500,100,200,300,2000,200,200,8,'',1,2044,3,'江苏省','扬州市',4),(39,39,'16-Aug-2019 18:22:46','16-Aug-2019 18:28:35',349,'',1,7000,3,3,2,3,4,2,2,2,2,2,0,1500,500,500,500,300,100,0,5000,200,500,7,'',1,2042,3,'山东省','淄博市',4),(40,40,'16-Aug-2019 19:09:59','16-Aug-2019 19:14:53',294,'',1,15000,3,1,2,3,4,2,2,3,2,2,5000,1000,300,2000,500,100,100,200,1000,200,200,9,'',1,2045,3,'江苏省','扬州市',3),(41,41,'16-Aug-2019 20:19:48','16-Aug-2019 20:30:28',640,'',1,3000,2,1,2,3,5,3,2,3,3,3,5000,20,50,80,200,150,150,50,3000,300,200,8,'无',1,2042,5,'江苏省','扬州市',5),(42,42,'16-Aug-2019 21:30:12','16-Aug-2019 21:33:53',221,'',1,7000,2,2,1,1,1,1,2,2,1,1,30000,3000,1000,400,2000,100,100,1580,10000,200,0,7,'购物',2,2032,4,'江苏省','扬州市',5),(43,43,'16-Aug-2019 21:36:28','16-Aug-2019 21:40:00',212,'',1,0,1,2,2,2,3,1,1,2,1,1,3000,1000,200,10000,200,500,50,100,3000,0,500,3,'无',1,2043,5,'江苏省','南京市',4),(44,44,'16-Aug-2019 21:39:48','16-Aug-2019 21:47:30',462,'',1,10000,1,3,2,3,4,2,4,2,2,2,3000,3000,3000,10000,2000,1000,500,0,3000,500,1000,10,'购买衣服首饰等',2,2044,3,'贵州省','贵阳市',3),(45,45,'17-Aug-2019 06:25:34','17-Aug-2019 06:31:34',360,'',1,2000,1,1,2,1,1,2,1,1,1,1,0,500,500,200,1000,200,100,100,2000,100,200,6,'',2,2040,5,'江苏省','扬州市',4),(46,46,'17-Aug-2019 10:39:23','17-Aug-2019 10:45:12',349,'',1,3500,3,2,2,1,2,1,1,1,3,1,1000,1000,500,200,200,50,70,80,15000,2000,1000,7,'',2,2037,3,'江苏省','淮安市',4),(47,47,'17-Aug-2019 10:52:53','17-Aug-2019 10:57:38',285,'',1,2000,1,1,1,1,3,1,1,1,1,1,1000,50,1000,0,1000,1000,200,100,5000,500,100,8,'买玩具',2,2022,4,'江苏省','淮安市',4),(48,48,'17-Aug-2019 11:29:14','17-Aug-2019 11:36:32',438,'',1,18000,4,2,1,3,5,4,2,2,1,2,10000,2000,500,500,500,500,150,500,400,100,200,9,'没有',1,2040,5,'江苏省','苏州市',5),(49,49,'17-Aug-2019 19:49:52','17-Aug-2019 19:54:42',290,'',1,5000,2,2,1,3,3,2,4,2,2,1,18000,3000,1000,2000,1000,600,160,100,5000,109,100,5,'喜欢买饰品',2,2032,4,'江苏省','淮安市',4),(50,50,'17-Aug-2019 19:56:02','17-Aug-2019 20:00:15',253,'',1,10700,1,2,1,2,4,1,1,2,1,1,0,1500,300,6500,500,250,100,0,7000,0,0,1,'无',1,2027,2,'江苏省','南京市',4),(51,51,'17-Aug-2019 20:21:24','17-Aug-2019 20:27:08',344,'',1,5000,2,1,1,1,1,1,4,2,1,1,50000,3000,500,1000,3000,500,200,100,10000,100,100,7,'无',2,2042,4,'广东省','广州市',4),(52,52,'17-Aug-2019 20:30:53','17-Aug-2019 20:35:22',269,'',1,8000,3,1,2,2,4,2,4,2,1,2,0,4000,1000,1000,3000,100,50,0,3000,0,200,8,'',2,2037,5,'广东省','汕头市',3),(53,53,'17-Aug-2019 20:31:34','17-Aug-2019 20:36:14',280,'',1,10000,3,3,2,3,5,1,2,2,2,1,0,3000,500,8000,200,500,128,500,20000,100,0,10,'没有',2,2039,3,'广东省','深圳市',4),(54,54,'17-Aug-2019 20:31:52','17-Aug-2019 20:37:33',341,'',1,3000,1,3,2,3,5,1,1,2,1,1,0,2000,1000,1000,1000,700,120,0,3000,500,500,7,'',2,2042,6,'广东省','广州市',3),(55,55,'17-Aug-2019 20:32:53','17-Aug-2019 20:40:12',439,'',1,8000,2,1,2,3,3,2,2,2,2,2,3000,2000,500,500,100,300,200,200,5000,1000,500,8,'',2,2043,3,'广东省','深圳市',3),(56,56,'17-Aug-2019 20:36:34','17-Aug-2019 20:40:27',233,'',3,5000,1,2,2,3,5,4,2,2,2,1,1000,3000,500,2000,1000,500,100,100,3000,100,200,7,'有',1,2044,9,'广东省','深圳市',3),(57,57,'17-Aug-2019 20:36:37','17-Aug-2019 20:42:03',326,'',1,5000,1,1,1,1,1,2,3,2,3,2,20000,2500,1500,1500,500,300,200,200,10000,1000,1000,4,'',2,2021,9,'江苏省','南通市',3),(58,58,'17-Aug-2019 20:36:12','17-Aug-2019 20:43:04',412,'',1,2000,4,1,2,2,3,3,1,3,2,2,6000,800,200,500,3000,200,20,1500,5000,500,300,4,'网购，不必要的生活用品',2,2028,4,'广东省','广州市',4),(59,59,'17-Aug-2019 20:39:33','17-Aug-2019 20:43:44',251,'',1,4000,1,3,1,4,3,2,4,1,1,1,70000,1000,1000,2000,300,1000,200,20,10000,500,300,8,'有',2,2041,3,'广东省','广州市',2),(60,60,'17-Aug-2019 20:39:35','17-Aug-2019 20:44:06',271,'',1,5000,1,2,1,3,2,4,1,1,2,1,0,5000,500,500,5000,3000,1000,500,10000,200,1000,6,'',2,2045,5,'广东省','广州市',4),(61,61,'17-Aug-2019 20:32:31','17-Aug-2019 20:45:31',780,'',2,10000,3,2,2,2,4,2,1,2,2,1,20000,2000,500,5000,500,300,100,100,20000,500,500,8,'',2,2036,9,'广东省','广州市',2),(62,62,'17-Aug-2019 20:43:26','17-Aug-2019 20:47:05',219,'',1,5000,4,1,1,3,5,1,2,3,2,3,10000,4000,2000,2000,6000,1000,500,600,20000,500,600,8,'',2,2036,5,'广东省','汕头市',3),(63,63,'17-Aug-2019 20:42:24','17-Aug-2019 20:47:07',283,'',1,50000,1,2,1,3,2,2,1,1,2,2,2000,6000,2000,3000,1000,2000,500,5000,30000,2000,300,8,'旅游',2,2040,3,'广东省','深圳市',5),(64,64,'17-Aug-2019 20:44:16','17-Aug-2019 20:48:02',226,'',1,15000,1,2,2,1,1,1,2,1,1,2,0,2000,500,15000,2000,2000,100,200,10000,100,200,6,'',1,2033,5,'广东省','广州市',6),(65,65,'17-Aug-2019 20:35:10','17-Aug-2019 20:48:40',810,'',1,7000,1,2,2,3,4,2,1,2,1,1,1000,2000,2007,3000,500,300,60,5000,10000,500,300,10,'',2,2044,5,'广东省','广州市',4),(66,66,'17-Aug-2019 20:46:54','17-Aug-2019 20:50:56',242,'',1,5000,2,1,3,3,5,3,2,3,2,2,5000,2000,500,500,300,50,50,0,2000,500,100,7,'',2,2040,2,'广东省','佛山市',2),(67,67,'17-Aug-2019 20:48:58','17-Aug-2019 20:52:55',237,'',1,10000,2,2,2,3,1,1,1,1,1,2,10000,4000,500,6000,2000,800,400,200,5000,1000,500,4,'有',2,2036,4,'广东省','广州市',4),(68,68,'17-Aug-2019 20:50:47','17-Aug-2019 20:53:31',164,'',1,5000,2,2,2,3,3,3,2,3,2,3,1500,60,200,1000,300,300,100,500,30000,300,400,6,'',1,2029,2,'广东省','广州市',5),(69,69,'17-Aug-2019 20:54:37','17-Aug-2019 21:00:07',330,'',1,5000,2,1,2,3,4,4,2,3,1,1,5000,2000,1000,500,500,300,100,100,3000,200,500,5,'500',2,2045,4,'广东省','佛山市',3),(70,70,'17-Aug-2019 20:56:38','17-Aug-2019 21:01:28',290,'',1,7000,1,2,2,3,4,1,2,1,1,4,0,340,50,150,200,600,250,0,2000,0,0,6,'wu',1,2032,5,'广东省','深圳市',5),(71,71,'17-Aug-2019 20:57:56','17-Aug-2019 21:01:53',237,'',1,20000,3,1,3,4,5,4,3,4,2,4,500,1000,200,500,1000,200,100,100,5000,100,100,9,'无',1,2042,5,'广东省','广州市',6),(72,72,'17-Aug-2019 20:59:20','17-Aug-2019 21:04:06',286,'',1,10000,3,2,2,3,3,2,1,2,2,2,13000,3000,2000,5000,3000,200,100,100,10000,1000,500,8,'',2,2037,2,'广东省','广州市',4),(73,73,'17-Aug-2019 21:00:12','17-Aug-2019 21:04:36',264,'',1,20000,1,3,2,3,5,4,4,2,1,1,30000,1000,500,8000,2000,2000,200,300,5000,200,1000,9,'无',1,2043,2,'广东省','广州市',4),(74,74,'17-Aug-2019 20:58:59','17-Aug-2019 21:05:07',368,'',1,5000,2,2,1,3,4,2,2,3,2,2,2000,4000,300,2000,2000,800,150,100,5000,200,200,6,'',2,2040,5,'广东省','韶关市',3),(75,75,'17-Aug-2019 21:01:54','17-Aug-2019 21:05:28',214,'',1,20000,1,1,2,2,1,1,1,1,1,2,50000,6000,3000,2000,3000,1200,700,4000,80000,1000,0,8,'',1,2042,3,'广东省','汕头市',4),(76,76,'17-Aug-2019 21:08:03','17-Aug-2019 21:11:36',213,'',1,5000,1,2,2,2,5,4,1,2,3,2,5000,2000,1000,2000,1000,2000,500,1000,5000,0,1000,2,'治病',2,2028,8,'广东省','佛山市',3),(77,77,'17-Aug-2019 21:08:48','17-Aug-2019 21:12:46',238,'',5,3000,1,1,1,2,5,2,4,1,1,1,30000,2000,300,500,3000,180,80,100,5000,300,300,6,'',2,2042,9,'广东省','广州市',2),(78,78,'17-Aug-2019 21:09:58','17-Aug-2019 21:19:34',576,'',1,8000,3,2,1,2,2,2,1,2,2,2,30000,80,400,5500,1000,1500,60,200,5000,100,200,10,'服饰',2,2041,2,'广东省','汕头市',4),(79,79,'17-Aug-2019 21:06:17','17-Aug-2019 21:23:32',1035,'',1,5000,3,2,1,3,1,1,4,2,1,1,7000,2000,800,500,500,500,100,200,10000,500,300,5,'购物',2,2037,5,'广东省','广州市',4),(80,80,'17-Aug-2019 21:20:32','17-Aug-2019 21:25:14',282,'',1,5000,2,1,1,3,4,4,2,3,1,1,10000,2000,500,300,800,100,200,100,10000,100,100,5,'餐饮',2,2038,3,'广东省','佛山市',3),(81,81,'17-Aug-2019 21:19:22','17-Aug-2019 21:26:32',430,'',5,0,1,1,1,1,1,3,2,2,1,1,0,3000,500,500,500,200,100,100,3000,0,0,10,'',2,2040,12,'广东省','江门市',2),(82,82,'17-Aug-2019 21:25:33','17-Aug-2019 21:31:06',333,'',1,20000,2,2,3,3,5,4,2,3,2,2,20000,1500,200,4000,2000,1000,150,200,5000,200,300,8,'',1,2042,3,'广东省','江门市',4),(83,83,'17-Aug-2019 21:30:12','17-Aug-2019 21:35:01',289,'',1,20000,2,2,1,3,4,2,2,2,2,3,0,5000,12000,5000,500,2000,200,1000,30000,1000,500,5,'',1,2038,5,'广东省','广州市',6),(84,84,'17-Aug-2019 21:27:35','17-Aug-2019 21:36:53',558,'',1,5000,2,2,2,1,1,2,4,2,1,2,0,500,500,2500,200,100,88,0,5000,0,0,8,'',2,2037,3,'广东省','广州市',4),(85,85,'17-Aug-2019 20:49:24','17-Aug-2019 21:37:42',2898,'',1,5000,1,2,1,1,1,1,4,1,1,1,50,50,80,500,500,1000,200200,200,5000,200,500,6,'',1,2033,4,'广东省','湛江市',3),(86,86,'17-Aug-2019 21:35:56','17-Aug-2019 21:41:30',334,'',1,5000,2,2,1,1,1,1,1,2,2,1,4000,1000,500,14000,200,500,150,50,5000,100,2000,6,'',1,2028,4,'广东省','广州市',5),(87,87,'17-Aug-2019 21:37:45','17-Aug-2019 21:43:44',359,'',1,10000,1,4,1,1,1,2,2,2,1,2,20000,3000,1000,2000,2000,1000,100,500,5000,500,500,8,'',1,2042,2,'广东省','广州市',6),(88,88,'17-Aug-2019 21:43:19','17-Aug-2019 21:48:53',334,'',1,20000,2,2,2,3,1,2,2,3,2,3,2000,2000,2000,1000,2000,1000,100,200,30000,500,500,6,'买衣服',2,2042,5,'广东省','广州市',5),(89,89,'17-Aug-2019 21:43:29','17-Aug-2019 21:49:48',379,'',1,4000,1,1,1,1,1,2,3,2,2,1,2000,2000,500,500,500,700,50,200,1000,100,0,1,'餐饮，日用',2,2031,4,'湖南省','长沙市',2),(90,90,'17-Aug-2019 21:45:22','17-Aug-2019 21:52:02',400,'',1,5000,2,1,2,3,5,2,2,4,1,1,3000,2500,300,1000,200,200,100,50,3000,100,100,8,'',2,2045,11,'广东省','广州市',2),(91,91,'17-Aug-2019 21:41:47','17-Aug-2019 21:52:45',658,'',1,12000,3,1,2,3,3,1,2,2,2,1,5000,60,1000,900,200,400,100,800,6000,300,100,8,'无',2,2047,2,'广东省','中山市',5),(92,92,'17-Aug-2019 21:10:09','17-Aug-2019 21:56:50',2801,'',1,5000,3,1,2,2,4,1,1,1,1,1,300,600,500,200,1000,200,100,200,3000,100,200,6,'',2,2040,4,'广东省','惠州市',2),(93,93,'17-Aug-2019 21:57:16','17-Aug-2019 22:00:29',193,'',1,8000,1,1,2,3,1,2,2,1,2,2,500,6000,500,500,500,100,100,0,5000,500,1000,5,'100',2,2040,5,'广东省','广州市',6),(94,94,'17-Aug-2019 22:01:55','17-Aug-2019 22:10:30',515,'',1,20000,1,3,3,1,1,1,4,2,2,3,0,2000,1000,4000,1000,1000,1000,200,2000,200,50,7,'',1,2042,9,'广东省','广州市',4),(95,95,'17-Aug-2019 22:08:32','17-Aug-2019 22:11:55',203,'',1,10000,2,2,2,3,5,3,2,2,2,2,0,2000,500,700,5000,200,80,200,5000,100,100,6,'无',1,2030,5,'广东省','广州市',5),(96,96,'17-Aug-2019 22:13:46','17-Aug-2019 22:18:54',308,'',1,12000,3,2,3,3,5,3,1,3,2,2,1000,1000,1000,2000,1000,1000,1000,200,10000,100,100,6,'无',1,2040,5,'广东省','广州市',6),(97,97,'17-Aug-2019 22:19:21','17-Aug-2019 22:22:21',180,'',1,15000,2,3,1,1,1,1,4,1,1,1,11000,5000,300,300,500,500,150,200,10000,200,300,6,'',1,2034,5,'广东省','广州市',6),(98,98,'17-Aug-2019 22:24:50','17-Aug-2019 22:29:34',284,'',1,8000,2,2,2,3,5,2,2,2,2,1,1000,2000,500,1000,500,100,100,100,20000,100,100,8,'',1,2043,5,'广东省','广州市',6),(99,99,'17-Aug-2019 22:28:06','17-Aug-2019 22:36:04',478,'',1,10000,1,2,2,3,5,4,2,3,2,2,7000,3000,500,30000,1500,200,100,500,10000,500,500,7,'',2,2042,5,'广东省','深圳市',4),(100,100,'17-Aug-2019 22:47:39','17-Aug-2019 22:50:10',151,'',1,10000,2,2,1,1,1,2,2,2,2,1,3000,2000,800,2000,2000,2000,300,1000,5000,800,0,5,'无',1,2031,3,'广东省','深圳市',4),(101,101,'17-Aug-2019 22:47:19','17-Aug-2019 22:52:18',299,'',1,3000,2,2,2,3,4,2,2,1,1,2,10000,3000,1000,40001000,1000,1500,200,200,5000,100,100,4,'',2,2041,5,'广东省','江门市',4),(102,102,'17-Aug-2019 22:52:06','17-Aug-2019 22:55:09',183,'',1,5000,1,2,1,1,1,1,4,2,1,1,2000,500,200,300,600,900,200,300,500,100,100,5,'无',2,2027,2,'广东省','广州市',6),(103,103,'17-Aug-2019 22:54:35','17-Aug-2019 22:59:21',286,'',1,20000,1,2,1,1,2,2,2,3,2,3,4000,2000,500,4000,1000,500,200,2000,5000,1000,500,8,'',1,2041,5,'广东省','广州市',6),(104,104,'17-Aug-2019 22:58:07','17-Aug-2019 23:04:46',399,'',1,16000,1,2,2,3,4,3,2,2,2,1,20000,3000,800,3000,1000,600,100,500,10000,300,300,8,'有',2,2040,5,'广东省','梅州市',4),(105,105,'17-Aug-2019 23:05:11','17-Aug-2019 23:08:48',217,'',1,5000,3,2,1,2,3,2,1,2,2,1,30000,800,1500,1000,500,200,200,500,10000,200,500,7,'有',2,2032,5,'广东省','广州市',6),(106,106,'17-Aug-2019 23:06:41','17-Aug-2019 23:14:03',442,'',1,6000,2,2,1,3,4,4,1,2,2,1,10000,5000,2000,5000,500,2000,200,300,6000,600,500,6,'无',2,2040,5,'广东省','广州市',4),(107,107,'17-Aug-2019 23:09:30','17-Aug-2019 23:20:01',631,'',1,15000,2,2,2,2,5,3,1,2,1,2,10000,4000,200,4000,3000,1000,60,100,10000,1000,500,7,'',1,2040,5,'广东省','广州市',6),(108,108,'17-Aug-2019 23:11:21','17-Aug-2019 23:20:28',547,'',1,15000,2,1,2,3,5,4,2,3,2,2,20000,4000,500,0,300,1000,200,300,30000,2000,800,6,'购物',2,2040,3,'广东省','汕头市',4),(109,109,'17-Aug-2019 23:15:22','17-Aug-2019 23:22:21',419,'',1,7000,1,1,2,3,3,4,2,2,1,3,2000,1000,200,500,800,800,200,300,5000,200,100,7,'',1,2044,5,'广东省','广州市',6),(110,110,'17-Aug-2019 23:16:57','17-Aug-2019 23:22:40',343,'',1,10000,1,1,1,1,1,2,4,2,1,1,5000,200,300,800,5000,1000,200,5000,20000,2000,500,6,'',2,2032,5,'广东省','广州市',5),(111,111,'17-Aug-2019 23:21:29','17-Aug-2019 23:30:01',512,'',5,20000,3,2,2,2,1,1,4,2,1,2,150000,5000,3000,1500,2000,1000,300,300,20000,200,500,10,'养生美容',2,2041,13,'广东省','佛山市',3),(112,112,'17-Aug-2019 23:25:10','17-Aug-2019 23:30:10',300,'',1,8000,1,3,2,3,2,1,2,2,2,1,100,3000,1000,2200,300,1000,100,100,10000,200,50,5,'',2,2029,5,'广东省','广州市',5),(113,113,'17-Aug-2019 23:22:51','17-Aug-2019 23:33:52',661,'',1,5000,1,2,1,2,1,2,1,3,3,2,3000,2000,800,4000,800,800,80,50,5000,50,100,5,'护肤品，生活用品',2,2043,4,'广东省','广州市',4),(114,114,'17-Aug-2019 23:48:52','17-Aug-2019 23:51:48',176,'',1,7000,3,1,1,1,1,2,2,2,1,1,1000,2000,300,400,500,300,300,500,10000,100,100,6,'无',1,2035,3,'广东省','广州市',5),(115,115,'17-Aug-2019 22:55:08','17-Aug-2019 23:55:12',3604,'',1,180000,1,1,2,2,4,4,1,1,2,1,4000,3000,1000,7000,1000,300,100,100,10000,500,400,8,'无',2,2044,5,'广东省','广州市',4),(116,116,'17-Aug-2019 23:42:37','17-Aug-2019 23:58:26',949,'',1,7000,1,3,2,1,1,1,4,2,2,1,0,2200,500,1800,600,1500,100,500,1200,300,900,3,'网购',1,2051,3,'广东省','广州市',3),(117,117,'18-Aug-2019 00:43:16','18-Aug-2019 00:49:12',356,'',1,15000,1,1,2,3,5,3,2,2,2,2,0,2000,200,1200,500,300,100,50,0,0,100,5,'',1,2042,3,'广东省','深圳市',3),(118,118,'18-Aug-2019 00:53:29','18-Aug-2019 01:00:12',403,'',1,15000,1,1,1,1,1,2,1,1,1,1,10000,2000,800,500,500,800,200,300,5000,300,300,6,'',2,2046,5,'广东省','广州市',4),(119,119,'18-Aug-2019 00:02:03','18-Aug-2019 01:12:45',4242,'',1,3000,1,1,1,1,5,1,4,2,1,1,0,1000,100,500,1500,200,100,100,3000,500,100,5,'',2,2024,4,'广东省','广州市',2),(120,120,'18-Aug-2019 01:25:47','18-Aug-2019 01:28:44',177,'',1,5000,3,1,2,3,3,4,2,4,2,3,0,1500,500,150,200,100,100,100,10000,500,300,7,'',1,2023,5,'广东省','广州市',5),(121,121,'18-Aug-2019 02:05:48','18-Aug-2019 02:11:46',358,'',1,15000,3,2,2,3,1,3,2,2,1,1,1000,3000,1000,7000,1000,500,200,0,10000,0,0,5,'',1,2043,5,'广东省','广州市',6),(122,122,'18-Aug-2019 05:08:31','18-Aug-2019 05:15:06',395,'',1,5000,1,2,1,1,1,2,4,2,1,1,5000,1500,200,3000,200,100,100,300,0,50,0,2,'',1,2040,6,'湖南省','株洲市',2),(123,123,'18-Aug-2019 05:28:34','18-Aug-2019 05:44:07',933,'',1,2000,1,1,1,3,5,1,4,1,1,1,5000,3000,500,10000,2000,800,500,300,6000,500,200,3,'买衣服',2,2052,6,'广东省','汕头市',2),(124,124,'18-Aug-2019 06:21:37','18-Aug-2019 06:25:48',251,'',1,10000,3,1,1,3,1,1,2,2,1,1,0,2000,500,300,3000,1000,300,300,10000,500,0,7,'',1,2044,5,'广东省','广州市',6),(125,125,'18-Aug-2019 07:57:07','18-Aug-2019 08:09:56',769,'',1,20000,2,1,1,3,5,1,1,1,1,1,3000,5000,1000,1000,5000,800,200,2000,10000,200,500,3,'无',2,2043,5,'广东省','东莞市',4),(126,126,'18-Aug-2019 08:07:10','18-Aug-2019 08:11:23',253,'',1,20000,3,2,1,2,2,2,1,2,2,2,0,2000,1000,3000,2000,1000,200,500,3000,500,100,7,'',1,2036,5,'广东省','广州市',6),(127,127,'18-Aug-2019 08:13:58','18-Aug-2019 08:19:28',330,'',1,5000,1,3,1,2,3,3,1,2,1,2,20000,2000,1000,500,2000,500,200,200,10000,500,300,1,'人情方面',2,2024,4,'广东省','广州市',5),(128,128,'18-Aug-2019 08:24:12','18-Aug-2019 08:28:58',286,'',1,10000,4,2,3,3,5,4,2,3,3,3,20000,4000,1000,1000,200,500,100,0,5000,0,0,8,'',1,2031,2,'广东省','广州市',6),(129,129,'18-Aug-2019 09:21:45','18-Aug-2019 09:26:27',282,'',1,10000,1,1,2,3,3,2,2,1,1,1,5000,5000,1000,1000,1000,500,500,500,10000,500,200,10,'',2,2037,2,'广东省','广州市',4),(130,130,'18-Aug-2019 09:23:24','18-Aug-2019 09:30:18',414,'',1,10000,1,2,2,3,3,3,2,2,1,1,5000,2000,500,5000,500,2000,50,500,20000,500,500,10,'无',2,2031,5,'广东省','广州市',4),(131,131,'18-Aug-2019 09:30:30','18-Aug-2019 09:35:23',293,'',1,6000,1,2,2,2,2,2,1,1,2,2,2000,2000,200,400,100,10080,80,100,1000,300,100,5,'',1,2040,2,'江苏省','南京市',5),(132,132,'18-Aug-2019 09:30:10','18-Aug-2019 09:37:22',432,'',1,9000,2,2,2,3,5,1,2,3,1,2,0,1000,300,500,800,1200,500,200,200,100,200,5,'餐饮购物',1,2042,3,'广东省','江门市',4),(133,133,'18-Aug-2019 10:10:49','18-Aug-2019 10:15:20',271,'',5,3000,1,1,2,1,2,1,4,2,1,1,800,1000,300,200,500,100,50,100,0,50,100,5,'',2,2042,12,'广东省','广州市',2),(134,134,'18-Aug-2019 09:59:51','18-Aug-2019 10:24:43',1492,'',5,2000,3,3,2,3,5,3,2,3,2,2,3000,2000,500,1800,1500,500,150,1000,5000,100,1000,5,'',2,2039,12,'广东省','中山市',3),(135,135,'18-Aug-2019 10:55:25','18-Aug-2019 10:59:31',246,'',1,7000,1,2,1,3,2,4,2,2,3,2,1000,1500,3000,7000,1000,200,150,100,5000,100,100,7,'衣服',2,2037,4,'广东省','深圳市',3),(136,136,'18-Aug-2019 11:06:18','18-Aug-2019 11:08:35',137,'',1,1500,1,1,2,1,1,2,1,2,2,1,0,600,500,200,200,100,100,300,5000,200,50,6,'餐饮、购物',2,2013,1,'江苏省','南京市',4),(137,137,'18-Aug-2019 11:04:19','18-Aug-2019 11:09:35',316,'',1,2000,2,1,2,1,1,2,1,2,2,1,0,1500,200,250,50,50,20,110,0,20,0,8,'',1,2013,1,'江苏省','南京市',4),(138,138,'18-Aug-2019 11:25:26','18-Aug-2019 11:28:50',204,'',1,10000,1,2,2,1,1,2,4,2,1,1,500,300,200,1000,500,100,100,2000,100,0,100,8,'',1,2031,5,'广东省','广州市',5),(139,139,'18-Aug-2019 11:26:53','18-Aug-2019 11:30:00',187,'',1,3000,1,2,2,1,1,1,4,1,1,1,0,1000,50,1500,500,50,28,0,0,30,300,5,'',1,2023,4,'广东省','广州市',2),(140,140,'18-Aug-2019 12:47:08','18-Aug-2019 12:51:21',253,'',1,7000,3,2,2,3,4,2,2,2,2,1,0,2000,1000,500,500,200,200,1000,5000,100,200,5,'',2,2042,5,'广东省','梅州市',4),(141,141,'18-Aug-2019 15:25:25','18-Aug-2019 15:32:15',410,'',1,5000,3,3,2,3,5,4,2,3,2,3,5000,3000,1009,1000,1000,1000,150,200,15000,500,200,8,'几类，自己以外冲动的',2,2041,7,'广东省','广州市',3),(142,142,'18-Aug-2019 22:24:15','18-Aug-2019 22:29:05',290,'',1,12000,2,2,2,2,3,2,2,2,2,2,10000,100,300,1500,600,150,250,300,1500,200,300,6,'',1,2042,5,'广东省','广州市',5);
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `principal` double NOT NULL,
  `number` float NOT NULL,
  `type` int(11) NOT NULL,
  `startTime` timestamp NOT NULL,
  `history` text NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userId` (`userId`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `e_mail` varchar(50) NOT NULL,
  `tag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verf_code`
--

DROP TABLE IF EXISTS `verf_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verf_code` (
  `email` varchar(50) DEFAULT NULL,
  `verf_code` varchar(50) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verf_code`
--

LOCK TABLES `verf_code` WRITE;
/*!40000 ALTER TABLE `verf_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `verf_code` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-08 21:48:36