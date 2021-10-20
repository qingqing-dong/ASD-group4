-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: ofos
-- ------------------------------------------------------
-- Server version	5.6.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `unit` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `picture` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Tamal','dish','plate',16.5,'1.webp','Fry chicken in sweet sour flavour'),(2,'Chipá','dish','plate',15.9,'2.webp','A chipá is a small, baked cheese-flavored roll, which is a popular snack and breakfast food in Brazil '),(3,'Feijoada','dish','plate',26.9,'3.jpg','A stew of black beans cooked with meat and served with rice, vegetables, assorted sausages'),(4,'Asado','dish','plate',35.9,'4.jpg','Asado is a term used for particular barbecue techniques, and also for the social event surrounding the barbecue'),(5,'Ceviche','dish','plate',22.9,'5.webp','Ceviche, or cebiche, is a dish of fresh raw fish cured in citrus juices'),(6,'Pabellón criollo','dish','plate',18.9,'6.jpg','Consists of rice with stewed black beans and shredded beef'),(7,'Ropa vieja','dish','plate',17.9,'7.webp','Ropa vieja’s shredded beef is indeed reminiscent of shredded rags of clothing');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(200) NOT NULL,
  `LASTNAME` varchar(200) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `GENDER` varchar(1000) NOT NULL,
  `ADDRESS` varchar(1000) NOT NULL,
  `PHONENUMBER` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
)  AUTO_INCREMENT=100;

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `customer` VALUES (100,"Justin","Bhe", "sdf@dfs.cj","sdf2313","Male","sdfsdf", "123124");
UNLOCK TABLES;

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(200) NOT NULL,
  `LASTNAME` varchar(200) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PASSWORD` double NOT NULL,
  `GENDER` varchar(1000) DEFAULT NULL,
  `ADDRESS` varchar(1000) DEFAULT NULL,
  `PHONENUMBER` varchar(1000) DEFAULT NULL,
  `POSITION` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
)  AUTO_INCREMENT=1000;

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1000,"Justin","Bhe", "sdf@dfs.cj","sdf2313","Male","sdfsdf", "123124","Staff");
UNLOCK TABLES;