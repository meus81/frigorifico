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
  PRIMARY KEY (`id_animal`),
  KEY `fk_animal_tropa1_idx` (`tropa_id_tropa`),
  KEY `fk_animal_categoria1_idx` (`categoria_id_categoria`),
  CONSTRAINT `fk_animal_categoria1` FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_tropa1` FOREIGN KEY (`tropa_id_tropa`) REFERENCES `tropa` (`id_tropa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,14,200,7,1),(2,15,150,7,2),(3,16,125,8,1),(4,17,138,8,1),(5,18,120,8,2),(6,1,215.2,10,1),(7,1,215.2,35,1),(8,1,215.2,36,1),(9,1,215.2,37,1);
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
  PRIMARY KEY (`id_tropa`),
  KEY `fk_tropa_establecimiento_idx` (`establecimiento_id_establecimiento`),
  KEY `fk_tropa_especie_idx` (`especie_id_especie`),
  CONSTRAINT `fk_tropa_especie` FOREIGN KEY (`especie_id_especie`) REFERENCES `especie` (`id_especie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tropa_establecimiento` FOREIGN KEY (`establecimiento_id_establecimiento`) REFERENCES `establecimiento` (`id_establecimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tropa`
--

LOCK TABLES `tropa` WRITE;
/*!40000 ALTER TABLE `tropa` DISABLE KEYS */;
INSERT INTO `tropa` VALUES (7,'2014-11-30 00:00:00','2014-12-01 00:00:00',20,1,34,1),(8,'2015-11-30 00:00:00','2015-12-01 00:00:00',20,1,35,1),(10,'2010-11-30 08:30:00','2010-12-01 15:20:10',100,1,30,1),(11,'2010-11-30 08:30:00','2010-12-01 15:20:10',100,1,30,1),(19,NULL,'2016-01-05 09:03:56',0,1,1,1),(20,NULL,'2016-01-05 09:15:23',0,1,2,1),(21,NULL,'2016-01-05 09:19:26',0,1,3,1),(22,NULL,'2016-01-05 09:21:35',0,1,4,1),(23,NULL,'2016-01-05 09:25:43',0,1,5,1),(24,NULL,'2016-01-06 14:50:01',0,1,6,1),(25,NULL,'2016-01-06 15:16:57',0,1,7,1),(26,NULL,'2016-01-06 15:21:42',0,1,8,1),(27,NULL,'2016-01-06 15:40:14',0,1,9,1),(28,NULL,'2016-01-06 15:41:16',0,1,10,1),(29,NULL,'2016-01-06 16:52:27',0,1,11,1),(30,NULL,'2016-01-06 16:54:24',0,1,12,1),(31,NULL,'2016-01-07 16:27:37',0,1,13,1),(32,NULL,'2016-01-07 16:32:03',0,1,14,1),(33,NULL,'2016-01-07 16:40:52',0,1,15,2),(34,NULL,'2016-01-07 16:44:56',0,1,16,2),(35,NULL,'2016-01-07 16:47:20',0,1,17,2),(36,NULL,'2016-01-11 11:48:45',0,1,18,2),(37,NULL,'2016-01-22 15:45:55',0,1,21,1),(38,NULL,'2016-01-22 15:46:06',0,1,22,1);
/*!40000 ALTER TABLE `tropa` ENABLE KEYS */;
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
INSERT INTO `tropa_reservada` VALUES (1,1,1000,2015,1,35),(2,1,1000,2016,1,22),(3,1001,2000,2015,2,0),(4,1001,2000,2016,2,0),(5,2001,5000,2015,3,0),(6,2001,5000,2016,3,0);
/*!40000 ALTER TABLE `tropa_reservada` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `establecimiento`
--

LOCK TABLES `establecimiento` WRITE;
/*!40000 ALTER TABLE `establecimiento` DISABLE KEYS */;
INSERT INTO `establecimiento` VALUES (1,'01.029.0.21924/00','El Cora','Capiangos S.R.L.',30714579785,4833,'(0221) 15-5574055','Calle Chascomús','Chascomús','Buenos Aires');
/*!40000 ALTER TABLE `establecimiento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-22 15:54:28
