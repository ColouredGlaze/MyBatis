CREATE DATABASE  IF NOT EXISTS `mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mybatis`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mybatis
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` varchar(32) NOT NULL,
  `account_email` varchar(30) NOT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('fbed4cfa52c211e8a8f754e1ad6e4031','ming******@outlook.com','2018-05-08 21:23:18','2018-05-08 22:06:48');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` varchar(32) NOT NULL,
  `full_name` varchar(30) NOT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES ('327e64eb540211e88b7854e1ad6e4031','路遥','2018-05-10 11:28:24',NULL),('7b9ff9a9540011e88b7854e1ad6e4031','卡勒德·胡赛尼','2018-05-10 11:16:08',NULL);
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` varchar(32) NOT NULL,
  `title` varchar(20) NOT NULL,
  `author_id` varchar(32) NOT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_author_id` (`author_id`),
  CONSTRAINT `fk_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('1de75d20540111e88b7854e1ad6e4031','追风筝的人','7b9ff9a9540011e88b7854e1ad6e4031','2018-05-10 11:20:40',NULL),('1deb7cfe540111e88b7854e1ad6e4031','灿烂千阳','7b9ff9a9540011e88b7854e1ad6e4031','2018-05-10 11:20:40',NULL),('1debc6c8540111e88b7854e1ad6e4031','群山回唱','7b9ff9a9540011e88b7854e1ad6e4031','2018-05-10 11:20:40',NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computer`
--

DROP TABLE IF EXISTS `computer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computer` (
  `id` varchar(32) NOT NULL,
  `trademark` varchar(60) DEFAULT NULL,
  `owner` varchar(60) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computer`
--

LOCK TABLES `computer` WRITE;
/*!40000 ALTER TABLE `computer` DISABLE KEYS */;
/*!40000 ALTER TABLE `computer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturer` (
  `id` varchar(32) NOT NULL,
  `name_of_manufacturer` varchar(30) NOT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES ('050d31ac54ba11e8b2e954e1ad6e4031','高月制造商','2018-05-11 09:24:16',NULL),('0f77dbc054ba11e8b2e954e1ad6e4031','少司命制造商','2018-05-11 09:24:33',NULL),('fb8333a954b911e8b2e954e1ad6e4031','荆天明制造商','2018-05-11 09:24:00',NULL);
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer_product`
--

DROP TABLE IF EXISTS `manufacturer_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturer_product` (
  `id` varchar(32) NOT NULL,
  `manufacturer_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `manufacturer_id` (`manufacturer_id`,`product_id`),
  KEY `fk_product_id` (`product_id`),
  KEY `fk_manufacturer_id` (`manufacturer_id`),
  CONSTRAINT `fk_manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer_product`
--

LOCK TABLES `manufacturer_product` WRITE;
/*!40000 ALTER TABLE `manufacturer_product` DISABLE KEYS */;
INSERT INTO `manufacturer_product` VALUES ('8536551854c711e8b2e954e1ad6e4031','050d31ac54ba11e8b2e954e1ad6e4031','9eb4fea754bc11e8b2e954e1ad6e4031','2018-05-11 11:00:57',NULL),('8b2c0baf54c711e8b2e954e1ad6e4031','050d31ac54ba11e8b2e954e1ad6e4031','a9aed6da54bc11e8b2e954e1ad6e4031','2018-05-11 11:01:07',NULL),('8fd0b9e754c711e8b2e954e1ad6e4031','050d31ac54ba11e8b2e954e1ad6e4031','c0c39b3354bc11e8b2e954e1ad6e4031','2018-05-11 11:01:15',NULL),('94c5281a54c711e8b2e954e1ad6e4031','0f77dbc054ba11e8b2e954e1ad6e4031','c0c39b3354bc11e8b2e954e1ad6e4031','2018-05-11 11:01:23',NULL),('991d9dc354c711e8b2e954e1ad6e4031','0f77dbc054ba11e8b2e954e1ad6e4031','a9aed6da54bc11e8b2e954e1ad6e4031','2018-05-11 11:01:31',NULL),('9d391ff054c711e8b2e954e1ad6e4031','0f77dbc054ba11e8b2e954e1ad6e4031','9eb4fea754bc11e8b2e954e1ad6e4031','2018-05-11 11:01:38',NULL),('a0e7df0154c711e8b2e954e1ad6e4031','fb8333a954b911e8b2e954e1ad6e4031','9eb4fea754bc11e8b2e954e1ad6e4031','2018-05-11 11:01:44',NULL),('a55d5f7f54c711e8b2e954e1ad6e4031','fb8333a954b911e8b2e954e1ad6e4031','a9aed6da54bc11e8b2e954e1ad6e4031','2018-05-11 11:01:51',NULL),('ac1071dc54c711e8b2e954e1ad6e4031','fb8333a954b911e8b2e954e1ad6e4031','c0c39b3354bc11e8b2e954e1ad6e4031','2018-05-11 11:02:03',NULL);
/*!40000 ALTER TABLE `manufacturer_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `id` varchar(32) NOT NULL,
  `phone_number` varchar(11) NOT NULL,
  `account_id` varchar(32) NOT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  KEY `fk_account_id` (`account_id`),
  CONSTRAINT `fk_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` varchar(32) NOT NULL,
  `brand_name` varchar(30) NOT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('9eb4fea754bc11e8b2e954e1ad6e4031','女子香','2018-05-11 09:42:52',NULL),('a9aed6da54bc11e8b2e954e1ad6e4031','月光色','2018-05-11 09:43:11',NULL),('c0c39b3354bc11e8b2e954e1ad6e4031','痴情郎','2018-05-11 09:43:49',NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` varchar(32) NOT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `stu_age` tinyint(4) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mybatis'
--

--
-- Dumping routines for database 'mybatis'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-12 23:27:23
