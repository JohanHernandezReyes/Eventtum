-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eventtum
-- ------------------------------------------------------
-- Server version	5.5.62-log

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (8);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcalificaciones`
--

DROP TABLE IF EXISTS `tblcalificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcalificaciones` (
  `idcalificaciones` int(4) NOT NULL AUTO_INCREMENT,
  `calpuntuacion` int(2) NOT NULL,
  `calcomentarios` text NOT NULL,
  `tblcliente_idcliente` int(10) NOT NULL,
  `tblpedidos_idpedido` int(4) NOT NULL,
  PRIMARY KEY (`idcalificaciones`),
  UNIQUE KEY `idcalificaciones_UNIQUE` (`idcalificaciones`),
  KEY `tblcalificaciones_ibfk_1` (`tblcliente_idcliente`),
  KEY `tblcalificaciones_ibfk_2` (`tblpedidos_idpedido`),
  CONSTRAINT `tblcalificaciones_ibfk_1` FOREIGN KEY (`tblcliente_idcliente`) REFERENCES `tblclientes` (`idcliente`),
  CONSTRAINT `tblcalificaciones_ibfk_2` FOREIGN KEY (`tblpedidos_idpedido`) REFERENCES `tblpedidos` (`idpedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcalificaciones`
--

LOCK TABLES `tblcalificaciones` WRITE;
/*!40000 ALTER TABLE `tblcalificaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblcalificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcategorias`
--

DROP TABLE IF EXISTS `tblcategorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcategorias` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `catnombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcategorias`
--

LOCK TABLES `tblcategorias` WRITE;
/*!40000 ALTER TABLE `tblcategorias` DISABLE KEYS */;
INSERT INTO `tblcategorias` VALUES (1,'Celebraciones');
/*!40000 ALTER TABLE `tblcategorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblciudad`
--

DROP TABLE IF EXISTS `tblciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblciudad` (
  `idciudad` int(4) NOT NULL AUTO_INCREMENT,
  `ciunombre` varchar(50) NOT NULL,
  `ciupais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idciudad`),
  UNIQUE KEY `idciudad_UNIQUE` (`idciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblciudad`
--

LOCK TABLES `tblciudad` WRITE;
/*!40000 ALTER TABLE `tblciudad` DISABLE KEYS */;
INSERT INTO `tblciudad` VALUES (1,'Bogotá D.C.','Colombia'),(2,'Medellin','Colombia'),(3,'Cali','Colombia'),(4,'Barranquilla','Colombia');
/*!40000 ALTER TABLE `tblciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblclientes`
--

DROP TABLE IF EXISTS `tblclientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblclientes` (
  `idcliente` int(10) NOT NULL AUTO_INCREMENT,
  `cli_identificacion` varchar(45) NOT NULL,
  `clinombre_razonsocial` varchar(50) NOT NULL,
  `clitelefono` varchar(10) NOT NULL,
  `clidireccion` varchar(50) NOT NULL,
  `clifecharegistro` date NOT NULL,
  `tblciudad_idciudad` int(4) NOT NULL,
  `tblusuarios_idusuario` int(10) NOT NULL,
  `tbltipoid_idtipoid` int(4) NOT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE KEY `idcliente_UNIQUE` (`idcliente`),
  KEY `FKbr9k3v9y8qtrf910ejxbmkbn2` (`tblciudad_idciudad`),
  KEY `FKlerloinisuttcgc9854sqcwro` (`tbltipoid_idtipoid`),
  KEY `FKabykwdn7y7cyarnfq1pxke2bu` (`tblusuarios_idusuario`),
  CONSTRAINT `tblclientes_ibfk_1` FOREIGN KEY (`tblciudad_idciudad`) REFERENCES `tblciudad` (`idCiudad`),
  CONSTRAINT `tblclientes_ibfk_2` FOREIGN KEY (`tblusuarios_idusuario`) REFERENCES `tblusuarios` (`idusuario`),
  CONSTRAINT `tblclientes_ibfk_3` FOREIGN KEY (`tbltipoid_idtipoid`) REFERENCES `tbltipoid` (`idtipoid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblclientes`
--

LOCK TABLES `tblclientes` WRITE;
/*!40000 ALTER TABLE `tblclientes` DISABLE KEYS */;
INSERT INTO `tblclientes` VALUES (1,'901234557','Eventtum SAS','3012345678','Cl Falsa 123','2022-11-18',1,1,1),(2,'901223534','Juan Rojas','3012345678','Cl Falsa 123','2022-11-18',2,2,1);
/*!40000 ALTER TABLE `tblclientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbllocaciones`
--

DROP TABLE IF EXISTS `tbllocaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbllocaciones` (
  `idlocacion` int(11) NOT NULL AUTO_INCREMENT,
  `locdescripcion` varchar(255) DEFAULT NULL,
  `locnombre` varchar(255) DEFAULT NULL,
  `tblcategorias_idcategoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`idlocacion`),
  KEY `fk1` (`tblcategorias_idcategoria`),
  CONSTRAINT `fk1` FOREIGN KEY (`tblcategorias_idcategoria`) REFERENCES `tblcategorias` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllocaciones`
--

LOCK TABLES `tbllocaciones` WRITE;
/*!40000 ALTER TABLE `tbllocaciones` DISABLE KEYS */;
INSERT INTO `tbllocaciones` VALUES (1,'Casa campestre con piscina en Villa Encanto','piscina',1),(2,'Ideal para recepciones familiares','salon azul',1),(3,'Salon amplio en hotel del norte de la ciduad','salon amarillo',1);
/*!40000 ALTER TABLE `tbllocaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblmercadopago`
--

DROP TABLE IF EXISTS `tblmercadopago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblmercadopago` (
  `idpago` int(10) NOT NULL AUTO_INCREMENT,
  `mermediopago` varchar(50) NOT NULL,
  `merfechapago` date NOT NULL,
  `mervalorpago` float DEFAULT NULL,
  `tblcliente_idcliente` int(10) NOT NULL,
  `tblpedidos_idpedido` int(4) NOT NULL,
  PRIMARY KEY (`idpago`),
  UNIQUE KEY `idpago_UNIQUE` (`idpago`),
  KEY `tblmercadopago_ibfk_1` (`tblcliente_idcliente`),
  KEY `tblmercadopago_ibfk_2` (`tblpedidos_idpedido`),
  CONSTRAINT `tblmercadopago_ibfk_1` FOREIGN KEY (`tblcliente_idcliente`) REFERENCES `tblclientes` (`idCliente`),
  CONSTRAINT `tblmercadopago_ibfk_2` FOREIGN KEY (`tblpedidos_idpedido`) REFERENCES `tblpedidos` (`idpedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblmercadopago`
--

LOCK TABLES `tblmercadopago` WRITE;
/*!40000 ALTER TABLE `tblmercadopago` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblmercadopago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblpedidos`
--

DROP TABLE IF EXISTS `tblpedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpedidos` (
  `idpedido` int(4) NOT NULL AUTO_INCREMENT,
  `pedfechapedido` date NOT NULL,
  `pedfechaservicio` date NOT NULL,
  `pedestadopedido` enum('Reservado','Cancelado','Pagado','Servicio Prestado') NOT NULL,
  `tblcliente_idcliente` int(10) NOT NULL,
  `pedcomentarios` text,
  PRIMARY KEY (`idpedido`),
  UNIQUE KEY `idpedido_UNIQUE` (`idpedido`),
  KEY `FKj9df27wbtq1mvtooi7pmwt8jp` (`tblcliente_idcliente`),
  CONSTRAINT `tblpedidos_ibfk_1` FOREIGN KEY (`tblcliente_idcliente`) REFERENCES `tblclientes` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblpedidos`
--

LOCK TABLES `tblpedidos` WRITE;
/*!40000 ALTER TABLE `tblpedidos` DISABLE KEYS */;
INSERT INTO `tblpedidos` VALUES (1,'2023-03-25','2023-04-08','Reservado',2,'efasfsaf'),(2,'2023-03-25','2023-04-05','Reservado',2,'mdg,mt'),(3,'2023-03-25','2023-04-05','Reservado',1,'requiero xyz'),(4,'2023-05-12','2023-05-13','Reservado',1,'hshs'),(5,'2023-05-12','2023-05-13','Reservado',1,'reserva xxx'),(6,'2023-05-12','2023-05-13','Reservado',1,'reserva xxx');
/*!40000 ALTER TABLE `tblpedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblpedidos_has_tbllocaciones`
--

DROP TABLE IF EXISTS `tblpedidos_has_tbllocaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpedidos_has_tbllocaciones` (
  `iddetallepedido` int(11) NOT NULL AUTO_INCREMENT,
  `hora_reserva` varchar(45) NOT NULL,
  `cantidad_personas` int(11) NOT NULL,
  `valor_pedido` double NOT NULL,
  `valor_pagado` double NOT NULL,
  `idtbllocaciones` int(11) NOT NULL,
  `idtblpedidos` int(11) NOT NULL,
  PRIMARY KEY (`iddetallepedido`),
  UNIQUE KEY `iddetallepedido_UNIQUE` (`iddetallepedido`),
  KEY `fk1_idx` (`idtblpedidos`),
  KEY `fk_detalleloc_idx` (`idtbllocaciones`),
  CONSTRAINT `fk_detalleloc` FOREIGN KEY (`idtbllocaciones`) REFERENCES `tbllocaciones` (`idlocacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detpedidos` FOREIGN KEY (`idtblpedidos`) REFERENCES `tblpedidos` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblpedidos_has_tbllocaciones`
--

LOCK TABLES `tblpedidos_has_tbllocaciones` WRITE;
/*!40000 ALTER TABLE `tblpedidos_has_tbllocaciones` DISABLE KEYS */;
INSERT INTO `tblpedidos_has_tbllocaciones` VALUES (1,'19:25:00',12,1000000,0,2,1),(2,'8:26:00',15,1000000,0,1,1),(3,'17:30:00',35,1000000,0,3,3),(4,'17:30:00',45,1000000,0,1,5);
/*!40000 ALTER TABLE `tblpedidos_has_tbllocaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblpqrs`
--

DROP TABLE IF EXISTS `tblpqrs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpqrs` (
  `idpqrs` int(11) NOT NULL AUTO_INCREMENT,
  `pqrfecha` datetime NOT NULL,
  `pqrdetalle` varchar(255) NOT NULL,
  `pqrs_email` varchar(255) NOT NULL,
  `pqrs_nombre` varchar(255) NOT NULL,
  `pqrtipo` varchar(255) NOT NULL,
  `tblcliente_idcliente` int(11) DEFAULT NULL,
  `tbllocaciones_idlocacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpqrs`),
  KEY `fkpqrscli` (`tblcliente_idcliente`),
  KEY `fkpqrsloc_idx` (`tbllocaciones_idlocacion`),
  CONSTRAINT `fkpqrscli` FOREIGN KEY (`tblcliente_idcliente`) REFERENCES `tblclientes` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkpqrsloc` FOREIGN KEY (`tbllocaciones_idlocacion`) REFERENCES `tbllocaciones` (`idlocacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblpqrs`
--

LOCK TABLES `tblpqrs` WRITE;
/*!40000 ALTER TABLE `tblpqrs` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblpqrs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblroles`
--

DROP TABLE IF EXISTS `tblroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblroles` (
  `idrol` int(4) NOT NULL AUTO_INCREMENT,
  `roltipo` varchar(50) NOT NULL,
  `roldescripcion` text NOT NULL,
  `rolestado` enum('Activo','Inactivo') DEFAULT NULL,
  PRIMARY KEY (`idrol`),
  UNIQUE KEY `idrol_UNIQUE` (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblroles`
--

LOCK TABLES `tblroles` WRITE;
/*!40000 ALTER TABLE `tblroles` DISABLE KEYS */;
INSERT INTO `tblroles` VALUES (1,'Admin','Adminsitrador del Sistema','Activo'),(2,'Empleado','Empleado de la compañia','Activo'),(3,'Cliente','Clientes usuarios de los servicios','Activo');
/*!40000 ALTER TABLE `tblroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltipoid`
--

DROP TABLE IF EXISTS `tbltipoid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltipoid` (
  `idtipoid` int(4) NOT NULL AUTO_INCREMENT,
  `tipdescripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`idtipoid`),
  UNIQUE KEY `idtipoid_UNIQUE` (`idtipoid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltipoid`
--

LOCK TABLES `tbltipoid` WRITE;
/*!40000 ALTER TABLE `tbltipoid` DISABLE KEYS */;
INSERT INTO `tbltipoid` VALUES (1,'NIT'),(2,'CC'),(3,'CE');
/*!40000 ALTER TABLE `tbltipoid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblusuarios`
--

DROP TABLE IF EXISTS `tblusuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblusuarios` (
  `idusuario` int(10) NOT NULL AUTO_INCREMENT,
  `usunombre` varchar(50) NOT NULL,
  `usucontrasena` varchar(50) NOT NULL,
  `usuemail` varchar(50) NOT NULL,
  `tblroles_idrol` int(4) NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `idusuario_UNIQUE` (`idusuario`),
  KEY `FKf2flf1q0vn3j7m45u9r37qwpr` (`tblroles_idrol`),
  CONSTRAINT `FKf2flf1q0vn3j7m45u9r37qwpr` FOREIGN KEY (`tblroles_idrol`) REFERENCES `tblroles` (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblusuarios`
--

LOCK TABLES `tblusuarios` WRITE;
/*!40000 ALTER TABLE `tblusuarios` DISABLE KEYS */;
INSERT INTO `tblusuarios` VALUES (1,'EventtumAdmin','8bad02869e1baa0db29af28a347245be','jehernandez1@misena.edu.co',1),(2,'Juan Rojas','827ccb0eea8a706c4c34a16891f84e7b','j.h25@hotmail.com',3),(3,'Juan Rojas','25d55ad283aa400af464c76d713c07ad','calozano882@misena.edu.co',3);
/*!40000 ALTER TABLE `tblusuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-16  8:50:50
