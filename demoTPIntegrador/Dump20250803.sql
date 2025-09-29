-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: stock
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidad` (
  `id_especialidad` int(11) NOT NULL AUTO_INCREMENT,
  `detalle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidad`
--

LOCK TABLES `especialidad` WRITE;
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` VALUES (1,'Cardiología'),(2,'Traumatología'),(3,'Ginecología'),(4,'Hematología'),(5,'Kinesiología'),(6,'Cirugía'),(7,'Andrología'),(8,'Urología'),(9,'Nutrición'),(13,'Obstetricia');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidadespormedico`
--

DROP TABLE IF EXISTS `especialidadespormedico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidadespormedico` (
  `medico_id_medico` int(11) NOT NULL,
  `especialidad_id_especialidad` int(11) NOT NULL,
  PRIMARY KEY (`medico_id_medico`,`especialidad_id_especialidad`),
  KEY `fk_ProfesionalDeLaSalud_has_Especialidad_Especialidad1_idx` (`especialidad_id_especialidad`),
  KEY `fk_ProfesionalDeLaSalud_has_Especialidad_ProfesionalDeLaSal_idx` (`medico_id_medico`),
  CONSTRAINT `fk_ProfesionalDeLaSalud_has_Especialidad_Especialidad1` FOREIGN KEY (`especialidad_id_especialidad`) REFERENCES `especialidad` (`id_especialidad`),
  CONSTRAINT `fk_ProfesionalDeLaSalud_has_Especialidad_ProfesionalDeLaSalud1` FOREIGN KEY (`medico_id_medico`) REFERENCES `medico` (`id_medico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidadespormedico`
--

LOCK TABLES `especialidadespormedico` WRITE;
/*!40000 ALTER TABLE `especialidadespormedico` DISABLE KEYS */;
INSERT INTO `especialidadespormedico` VALUES (1,2),(1,4),(1,6),(3,1),(3,6),(4,3),(7,1),(7,6),(8,5),(9,1),(9,5),(9,6),(9,7),(9,8),(10,2),(10,3),(10,8),(10,13),(11,2),(12,7),(12,8),(13,1),(13,2),(13,3),(14,8),(15,1),(15,2),(15,6),(15,8);
/*!40000 ALTER TABLE `especialidadespormedico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `id_medico` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_medico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (1,'Gunther','Blankley'),(2,'Eric','Polkinghorne'),(3,'Elston','Kempton'),(4,'Edsel','Noakes'),(5,'Igor','Whawell'),(6,'Vina','Kemwall'),(7,'Gabriele','Carefull'),(8,'Alic','Phillippo'),(9,'Lauren','Stinton'),(10,'Candide','Halshaw'),(11,'Gaby','Edger'),(12,'Gloriana','Paur'),(13,'Ches','Searston'),(14,'Noland','Spellsworth'),(15,'Josee','Dorricott');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-03 11:37:57
