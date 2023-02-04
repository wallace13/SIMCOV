-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: simcov
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `idFuncionario` int NOT NULL AUTO_INCREMENT,
  `nomeCompleto` varchar(128) NOT NULL,
  `nomeUsuario` varchar(32) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `nivelPermissao` int NOT NULL,
  PRIMARY KEY (`idFuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Wallace Sales','sales','123',0);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leito`
--

DROP TABLE IF EXISTS `leito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leito` (
  `idLeito` int NOT NULL AUTO_INCREMENT,
  `disponibilidade` tinyint(1) NOT NULL,
  `tipoDeCovid` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`idLeito`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leito`
--

LOCK TABLES `leito` WRITE;
/*!40000 ALTER TABLE `leito` DISABLE KEYS */;
INSERT INTO `leito` VALUES (1,1,NULL),(2,1,NULL),(3,1,NULL),(4,1,NULL),(5,1,NULL),(6,1,NULL),(7,1,NULL),(8,1,NULL),(9,1,NULL),(10,1,NULL);
/*!40000 ALTER TABLE `leito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `cpf` char(14) NOT NULL,
  `nomeCompleto` varchar(128) NOT NULL,
  `sexo` char(9) NOT NULL,
  `idade` int DEFAULT NULL,
  `dataNascimento` char(10) NOT NULL,
  `logradouro` varchar(64) NOT NULL,
  `numero` int NOT NULL,
  `complemento` varchar(64) DEFAULT NULL,
  `bairro` varchar(64) NOT NULL,
  `cidade` varchar(64) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `cep` char(9) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `telefoneParente` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro` (
  `idRegistro` int NOT NULL AUTO_INCREMENT,
  `dataEntrada` date NOT NULL,
  `horaEntrada` time NOT NULL,
  `dataSaida` date DEFAULT NULL,
  `horaSaida` time DEFAULT NULL,
  `cpf` char(14) NOT NULL,
  `idFuncionario` int NOT NULL,
  `idLeito` int NOT NULL,
  PRIMARY KEY (`idRegistro`),
  KEY `fkCpf2` (`cpf`),
  KEY `fkLeito` (`idLeito`),
  KEY `fkFuncionario` (`idFuncionario`),
  CONSTRAINT `fkCpf2` FOREIGN KEY (`cpf`) REFERENCES `paciente` (`cpf`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fkFuncionario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fkLeito` FOREIGN KEY (`idLeito`) REFERENCES `leito` (`idLeito`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registromorto`
--

DROP TABLE IF EXISTS `registromorto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registromorto` (
  `idRegistro` int NOT NULL,
  `dataEntrada` date DEFAULT NULL,
  `horaEntrada` time DEFAULT NULL,
  `dataSaida` date DEFAULT NULL,
  `horaSaida` time DEFAULT NULL,
  `cpf` char(14) DEFAULT NULL,
  `idFuncionario` int DEFAULT NULL,
  `idLeito` int DEFAULT NULL,
  PRIMARY KEY (`idRegistro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registromorto`
--

LOCK TABLES `registromorto` WRITE;
/*!40000 ALTER TABLE `registromorto` DISABLE KEYS */;
/*!40000 ALTER TABLE `registromorto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sintoma`
--

DROP TABLE IF EXISTS `sintoma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sintoma` (
  `idSintoma` int NOT NULL AUTO_INCREMENT,
  `dataDeInicio` char(10) NOT NULL,
  `tipoDeSintoma` varchar(128) NOT NULL,
  `cpf` char(14) NOT NULL,
  PRIMARY KEY (`idSintoma`),
  KEY `fkCpf` (`cpf`),
  CONSTRAINT `fkCpf` FOREIGN KEY (`cpf`) REFERENCES `paciente` (`cpf`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sintoma`
--

LOCK TABLES `sintoma` WRITE;
/*!40000 ALTER TABLE `sintoma` DISABLE KEYS */;
/*!40000 ALTER TABLE `sintoma` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-04 13:35:13
