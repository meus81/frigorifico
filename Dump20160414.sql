CREATE DATABASE  IF NOT EXISTS `frigorifico` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `frigorifico`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: frigorifico
-- ------------------------------------------------------
-- Server version	5.5.36

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT COMMENT '		',
  `descripcion` varchar(45) DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `abreviatura` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Chancha','03.01','CHA'),(2,'Capon','03.02','CAP');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especie`
--

DROP TABLE IF EXISTS `especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especie` (
  `id_especie` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_especie` varchar(45) DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `tipo_especie` int(11) NOT NULL,
  PRIMARY KEY (`id_especie`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especie`
--

LOCK TABLES `especie` WRITE;
/*!40000 ALTER TABLE `especie` DISABLE KEYS */;
INSERT INTO `especie` VALUES (1,'Ovino',NULL,1),(2,'Porcinos',NULL,2),(3,'Vacuno',NULL,3);
/*!40000 ALTER TABLE `especie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tropa_reservada`
--

DROP TABLE IF EXISTS `tropa_reservada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tropa_reservada` (
  `id_tropa_reservada` int(11) NOT NULL AUTO_INCREMENT,
  `desde` int(11) NOT NULL,
  `hasta` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  `procedencia_id_procedencia` int(11) NOT NULL,
  `ultima_tropa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_tropa_reservada`),
  KEY `fk_tropa_reservada_procedencia_idx` (`procedencia_id_procedencia`),
  CONSTRAINT `fk_tropa_reservada_procedencia` FOREIGN KEY (`procedencia_id_procedencia`) REFERENCES `procedencia` (`id_procedencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tropa_reservada`
--

LOCK TABLES `tropa_reservada` WRITE;
/*!40000 ALTER TABLE `tropa_reservada` DISABLE KEYS */;
INSERT INTO `tropa_reservada` VALUES (1,1,1000,2015,1,35),(2,1,1000,2016,1,44),(3,1001,2000,2015,2,0),(4,1001,2000,2016,2,0),(5,2001,5000,2015,3,0),(6,2001,5000,2016,3,0);
/*!40000 ALTER TABLE `tropa_reservada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corral`
--

DROP TABLE IF EXISTS `corral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corral` (
  `id_corral` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `ocupacion` int(11) DEFAULT NULL,
  `fecha_egreso` datetime DEFAULT NULL,
  PRIMARY KEY (`id_corral`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corral`
--

LOCK TABLES `corral` WRITE;
/*!40000 ALTER TABLE `corral` DISABLE KEYS */;
INSERT INTO `corral` VALUES (1,1,30,NULL,NULL),(2,2,40,NULL,NULL),(3,3,35,NULL,NULL),(4,4,45,NULL,NULL);
/*!40000 ALTER TABLE `corral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procedencia`
--

DROP TABLE IF EXISTS `procedencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procedencia` (
  `id_procedencia` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_procedencia`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedencia`
--

LOCK TABLES `procedencia` WRITE;
/*!40000 ALTER TABLE `procedencia` DISABLE KEYS */;
INSERT INTO `procedencia` VALUES (1,'Estancias'),(2,'Remate'),(3,'Productores');
/*!40000 ALTER TABLE `procedencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animal` (
  `id_animal` int(11) NOT NULL AUTO_INCREMENT,
  `garron` int(11) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `tropa_id_tropa` int(11) NOT NULL,
  `categoria_id_categoria` int(11) NOT NULL,
  `cabeza_faenada_entera` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `fk_animal_tropa1_idx` (`tropa_id_tropa`),
  KEY `fk_animal_categoria1_idx` (`categoria_id_categoria`),
  CONSTRAINT `fk_animal_categoria1` FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_tropa1` FOREIGN KEY (`tropa_id_tropa`) REFERENCES `tropa` (`id_tropa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,14,200,7,1,NULL),(2,15,150,7,2,NULL),(3,16,125,8,1,NULL),(4,17,138,8,1,NULL),(5,18,120,8,2,NULL),(6,19,215.2,10,1,NULL),(7,1,215.2,35,1,NULL),(8,1,215.2,36,1,NULL),(9,1,215.2,37,1,NULL),(10,2,150,38,2,NULL),(11,1,250,39,1,NULL),(12,2,250,40,1,NULL),(13,3,250,41,1,NULL),(14,4,250,42,1,NULL),(15,5,250,7,1,NULL),(16,5,250,8,1,NULL),(17,5,250,52,1,NULL),(18,6,250,53,1,NULL),(19,7,250,54,1,NULL),(20,8,215.2,56,1,NULL),(21,1,215.2,59,1,NULL),(22,2,250,60,1,NULL);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tropa`
--

DROP TABLE IF EXISTS `tropa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tropa` (
  `id_tropa` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `fecha_ingreso` datetime DEFAULT NULL,
  `fecha_faena` datetime DEFAULT NULL,
  `animales_recibidos` int(11) DEFAULT NULL,
  `establecimiento_id_establecimiento` int(11) NOT NULL,
  `numero_tropa` int(11) NOT NULL,
  `especie_id_especie` int(11) NOT NULL,
  `corral_id_corral` int(11) NOT NULL,
  PRIMARY KEY (`id_tropa`),
  KEY `fk_tropa_establecimiento_idx` (`establecimiento_id_establecimiento`),
  KEY `fk_tropa_especie_idx` (`especie_id_especie`),
  KEY `fk_tropa_corral` (`corral_id_corral`),
  CONSTRAINT `fk_tropa_corral` FOREIGN KEY (`corral_id_corral`) REFERENCES `corral` (`id_corral`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tropa_especie` FOREIGN KEY (`especie_id_especie`) REFERENCES `especie` (`id_especie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tropa_establecimiento` FOREIGN KEY (`establecimiento_id_establecimiento`) REFERENCES `establecimiento` (`id_establecimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tropa`
--

LOCK TABLES `tropa` WRITE;
/*!40000 ALTER TABLE `tropa` DISABLE KEYS */;
INSERT INTO `tropa` VALUES (7,'2014-11-30 00:00:00','2014-12-01 00:00:00',20,1,34,1,1),(8,'2015-11-30 00:00:00','2015-12-01 00:00:00',20,1,35,1,1),(10,'2010-11-30 08:30:00','2010-12-01 15:20:10',100,1,30,1,1),(11,'2010-11-30 08:30:00','2010-12-01 15:20:10',100,1,30,1,1),(19,NULL,'2016-01-05 09:03:56',0,1,1,1,1),(20,NULL,'2016-01-05 09:15:23',0,1,2,1,1),(21,NULL,'2016-01-05 09:19:26',0,1,3,1,1),(22,NULL,'2016-01-05 09:21:35',0,1,4,1,1),(23,NULL,'2016-01-05 09:25:43',0,1,5,1,1),(24,NULL,'2016-01-06 14:50:01',0,1,6,1,1),(25,NULL,'2016-01-06 15:16:57',0,1,7,1,1),(26,NULL,'2016-01-06 15:21:42',0,1,8,1,1),(27,NULL,'2016-01-06 15:40:14',0,1,9,1,1),(28,NULL,'2016-01-06 15:41:16',0,1,10,1,1),(29,NULL,'2016-01-06 16:52:27',0,1,11,1,1),(30,NULL,'2016-01-06 16:54:24',0,1,12,1,1),(31,NULL,'2016-01-07 16:27:37',0,1,13,1,1),(32,NULL,'2016-01-07 16:32:03',0,1,14,1,1),(33,NULL,'2016-01-07 16:40:52',0,1,15,2,1),(34,NULL,'2016-01-07 16:44:56',0,1,16,2,1),(35,NULL,'2016-01-07 16:47:20',0,1,17,2,1),(36,NULL,'2016-01-11 11:48:45',0,1,18,2,1),(37,NULL,'2016-01-22 15:45:55',0,1,21,1,1),(38,NULL,'2016-01-22 15:46:06',0,1,22,1,1),(39,'2016-01-28 09:54:46','2016-01-28 09:54:46',75,1,23,1,1),(40,'2016-01-28 10:20:27','2016-01-28 10:20:27',75,1,24,1,1),(41,'2016-01-28 10:21:27','2016-01-28 10:21:27',75,1,25,1,1),(42,'2016-01-28 10:36:29','2016-01-28 10:36:29',75,1,26,1,1),(43,'2016-02-24 08:30:00','2016-02-25 15:20:10',100,1,27,1,1),(44,'2016-02-24 08:30:00','2016-02-25 15:20:10',100,1,28,1,1),(45,'2016-02-24 08:30:00','2016-02-25 15:20:10',100,1,29,1,1),(46,'2016-02-24 08:30:00','2016-02-25 15:20:10',100,1,30,1,1),(47,'2016-02-24 08:30:00','2016-02-25 15:20:10',100,1,31,1,1),(48,'2016-02-24 08:30:00','2016-02-25 15:20:10',100,1,32,1,1),(49,'2016-02-24 08:30:00','2016-02-25 15:20:10',100,1,33,1,1),(50,'2016-01-28 16:52:29','2016-01-28 16:52:29',75,1,34,1,1),(51,'2016-01-28 16:55:49','2016-01-28 16:55:49',75,1,35,1,1),(52,'2016-01-28 16:58:46','2016-01-28 16:58:46',75,1,36,1,1),(53,'2016-01-28 17:01:45','2016-01-28 17:01:45',75,1,37,1,1),(54,'2016-01-28 17:02:32','2016-01-28 17:02:32',75,1,38,1,1),(55,NULL,'2016-01-28 17:35:46',0,1,39,1,1),(56,NULL,'2016-01-28 17:35:46',0,1,40,1,1),(57,'2016-02-24 08:30:00','2016-02-25 15:20:10',100,1,41,1,1),(58,NULL,'2016-01-29 15:23:49',0,1,42,1,1),(59,NULL,'2016-01-29 15:23:49',0,1,43,1,1),(60,'2016-01-29 15:23:57','2016-01-29 15:23:57',75,1,44,1,1);
/*!40000 ALTER TABLE `tropa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `establecimiento`
--

DROP TABLE IF EXISTS `establecimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `establecimiento` (
  `id_establecimiento` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_establecimiento` varchar(45) DEFAULT NULL,
  `titular` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `cuit` bigint(12) DEFAULT NULL,
  `numero_habilitacion` int(11) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_establecimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `establecimiento`
--

LOCK TABLES `establecimiento` WRITE;
/*!40000 ALTER TABLE `establecimiento` DISABLE KEYS */;
INSERT INTO `establecimiento` VALUES (1,'01.029.0.21924/00','El Cora','Capiangos S.R.L.',30714579785,4833,'(0221) 15-5574055','Calle Chascomús','Chascomús','Buenos Aires'),(2,'01.029.0.21924/00','El Cora','Capiangos S.R.L.',30714579785,4833,'(0221) 15-5574055','Calle ChascomÃºs','ChascomÃºs','Buenos Aires');
/*!40000 ALTER TABLE `establecimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'frigorifico'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-14 14:45:06
