-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: gestion_michef
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL DEFAULT '""',
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Verduleria'),(2,'Carnes'),(3,'Fiambres'),(4,'Especias'),(5,'Pescaderia'),(6,'Panaderia'),(7,'Lacteos'),(8,'Aderezos');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conceptos`
--

DROP TABLE IF EXISTS `conceptos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conceptos` (
  `idconceptos` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) NOT NULL,
  PRIMARY KEY (`idconceptos`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conceptos`
--

LOCK TABLES `conceptos` WRITE;
/*!40000 ALTER TABLE `conceptos` DISABLE KEYS */;
INSERT INTO `conceptos` VALUES (1,'Infusiones'),(4,'Combis');
/*!40000 ALTER TABLE `conceptos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costoconcepto`
--

DROP TABLE IF EXISTS `costoconcepto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costoconcepto` (
  `conceptos_idconceptos` int(11) NOT NULL,
  `eventos_ideventos` int(11) NOT NULL,
  `costo` decimal(15,2) NOT NULL,
  PRIMARY KEY (`conceptos_idconceptos`,`eventos_ideventos`),
  KEY `fk_conceptos_has_eventos_eventos1_idx` (`eventos_ideventos`),
  KEY `fk_conceptos_has_eventos_conceptos1_idx` (`conceptos_idconceptos`),
  CONSTRAINT `fk_conceptos_has_eventos_conceptos1` FOREIGN KEY (`conceptos_idconceptos`) REFERENCES `conceptos` (`idconceptos`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_conceptos_has_eventos_eventos1` FOREIGN KEY (`eventos_ideventos`) REFERENCES `eventos` (`ideventos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costoconcepto`
--

LOCK TABLES `costoconcepto` WRITE;
/*!40000 ALTER TABLE `costoconcepto` DISABLE KEYS */;
INSERT INTO `costoconcepto` VALUES (1,4,421.00),(1,9,2121.00),(4,4,123.00);
/*!40000 ALTER TABLE `costoconcepto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos` (
  `ideventos` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) NOT NULL,
  `fecha` date NOT NULL,
  `precio` decimal(15,2) DEFAULT '0.00',
  `costo` decimal(15,2) DEFAULT '0.00',
  `cobro` decimal(15,2) DEFAULT '0.00',
  `saldo` decimal(15,2) DEFAULT '0.00',
  PRIMARY KEY (`ideventos`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (4,'FanaFalcon','2018-01-07',0.00,544.00,0.00,0.00),(9,'Casuarinas','2018-01-14',0.00,2121.00,0.00,55.00);
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientes`
--

DROP TABLE IF EXISTS `ingredientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredientes` (
  `idingredientes` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL DEFAULT '""',
  `idCategoria` int(11) NOT NULL,
  `cantidad` float NOT NULL DEFAULT '0',
  `medida` varchar(200) NOT NULL DEFAULT '""',
  `puntoReposicion` float NOT NULL,
  PRIMARY KEY (`idingredientes`,`idCategoria`),
  KEY `fk_ingredientes_categoria1_idx` (`idCategoria`),
  CONSTRAINT `fk_ingredientes_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientes`
--

LOCK TABLES `ingredientes` WRITE;
/*!40000 ALTER TABLE `ingredientes` DISABLE KEYS */;
INSERT INTO `ingredientes` VALUES (2,'Bananas',1,5,'Kilos',20),(6,'Queso',7,17.5,'Kilos',20),(7,'Jamon',3,20,'Kilos',5),(8,'Cebolla',1,20,'Kilos',25),(9,'Cebolla de verdeo',1,10,'Atado',15),(11,'Pan rallado',6,2.5,'Kilos',1),(13,'comino',1,3.44,'kilos',2),(14,'Manzana',1,15,'kilos',10),(18,'Chimichurri',8,2,'Latas',1);
/*!40000 ALTER TABLE `ingredientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientesderecetas`
--

DROP TABLE IF EXISTS `ingredientesderecetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredientesderecetas` (
  `idingredientesRecetas` int(11) NOT NULL,
  `recetas_idrecetas` int(11) NOT NULL,
  `cantidad` float DEFAULT NULL,
  PRIMARY KEY (`idingredientesRecetas`,`recetas_idrecetas`),
  KEY `fk_ingredientesRecetas_has_recetas_recetas1_idx` (`recetas_idrecetas`),
  KEY `fk_ingredientesRecetas_has_recetas_ingredientesRecetas1_idx` (`idingredientesRecetas`),
  CONSTRAINT `fk_ingredientesRecetas_has_recetas_ingredientesRecetas1` FOREIGN KEY (`idingredientesRecetas`) REFERENCES `ingredientesrecetas` (`idingredientesRecetas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingredientesRecetas_has_recetas_recetas1` FOREIGN KEY (`recetas_idrecetas`) REFERENCES `recetas` (`idrecetas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientesderecetas`
--

LOCK TABLES `ingredientesderecetas` WRITE;
/*!40000 ALTER TABLE `ingredientesderecetas` DISABLE KEYS */;
INSERT INTO `ingredientesderecetas` VALUES (3,2,2222),(4,2,221);
/*!40000 ALTER TABLE `ingredientesderecetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientesrecetas`
--

DROP TABLE IF EXISTS `ingredientesrecetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredientesrecetas` (
  `idingredientesRecetas` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) NOT NULL,
  `medida` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idingredientesRecetas`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientesrecetas`
--

LOCK TABLES `ingredientesrecetas` WRITE;
/*!40000 ALTER TABLE `ingredientesrecetas` DISABLE KEYS */;
INSERT INTO `ingredientesrecetas` VALUES (3,'Manzanas','Kilos'),(4,'Peras','Kilos');
/*!40000 ALTER TABLE `ingredientesrecetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precios`
--

DROP TABLE IF EXISTS `precios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `precios` (
  `precio` decimal(15,2) NOT NULL DEFAULT '0.00',
  `idProveedores` int(11) NOT NULL,
  `idIngredientes` int(11) NOT NULL,
  PRIMARY KEY (`idProveedores`,`idIngredientes`),
  KEY `fk_precios_ingredientes1_idx` (`idIngredientes`),
  CONSTRAINT `fk_precios_ingredientes1` FOREIGN KEY (`idIngredientes`) REFERENCES `ingredientes` (`idingredientes`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_precios_proveedores` FOREIGN KEY (`idProveedores`) REFERENCES `proveedores` (`idproveedores`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precios`
--

LOCK TABLES `precios` WRITE;
/*!40000 ALTER TABLE `precios` DISABLE KEYS */;
INSERT INTO `precios` VALUES (20.00,8,6),(14.99,18,2);
/*!40000 ALTER TABLE `precios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `idproveedores` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `numeroContacto` int(15) DEFAULT NULL,
  `cuit` int(30) DEFAULT '0',
  PRIMARY KEY (`idproveedores`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (8,'Cacho S.R.L',NULL,0),(14,'Tomy S.R.L',NULL,0),(18,'Fulano S.A',14125125,0),(19,'Mengano S.R.L',2222,0),(21,'EMAUS S.A',123124,123123);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recetas`
--

DROP TABLE IF EXISTS `recetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recetas` (
  `idrecetas` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  `precio` decimal(15,2) NOT NULL,
  `cantidadinicial` float NOT NULL,
  PRIMARY KEY (`idrecetas`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recetas`
--

LOCK TABLES `recetas` WRITE;
/*!40000 ALTER TABLE `recetas` DISABLE KEYS */;
INSERT INTO `recetas` VALUES (2,'Bagguetes',5.00,15),(3,'Sandwiches',10.00,5);
/*!40000 ALTER TABLE `recetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `contrasenia` varchar(100) NOT NULL,
  PRIMARY KEY (`idusuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'administracion','michefadmin01'),(2,'almacen','michefalm01');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gestion_michef'
--

--
-- Dumping routines for database 'gestion_michef'
--
/*!50003 DROP PROCEDURE IF EXISTS `buscarCodigoIngredienteRecetas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarCodigoIngredienteRecetas`(in nom varchar(150), out cod int)
BEGIN
if(exists(select * from ingredientesrecetas where descripcion = nom))
then
select idingredientesRecetas into cod from ingredientesrecetas where descripcion = nom;
else
set cod = -1;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarUsuario`(IN nom varchar(200) , IN cont varchar(200), OUT ver int)
BEGIN
declare n varchar(200);
declare c varchar(200);
select nombre, contrasenia into n, c from usuarios where usuarios.nombre = nom and usuarios.contrasenia = cont;
if(exists(select * from usuarios where usuarios.nombre = nom and usuarios.contrasenia = cont))
then
if (n = "administracion" and c = "michefadmin01")
then
set ver = 1;
else if(n = "almacen" and c = "michefalm01")
then
set ver = 2;
end if;
end if;
else
set ver = 0;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `traerCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `traerCategoria`(IN cat varchar(200), OUT cod int)
BEGIN
if(exists(select * from categoria where descripcion = cat))
then
select idCategoria into cod from categoria where categoria.descripcion = cat;
else
set cod = -1;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `traerNomCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `traerNomCategoria`(IN cat int, OUT cod varchar(200))
BEGIN
if(exists(select * from categoria where idCategoria = cat))
then
select descripcion into cod from categoria where categoria.idCategoria = cat;
else
set cod = "";
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verificarNombreProveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verificarNombreProveedor`(in NOM varchar(200), out b int)
BEGIN
if(exists(select * from proveedores where descripcion = NOM))
then
set b = 1;
else
set b = 0;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-11  2:52:41
