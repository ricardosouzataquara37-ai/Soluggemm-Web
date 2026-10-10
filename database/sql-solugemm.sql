-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: solugemm
-- ------------------------------------------------------
-- Server version	8.0.39

CREATE DATABASE IF NOT EXISTS solugemm;
USE solugemm;



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
-- Table structure for table `acumulo_servicos`
--

DROP TABLE IF EXISTS `acumulo_servicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acumulo_servicos` (
  `idAcumuloServicos` int NOT NULL AUTO_INCREMENT,
  `valorAcumulado` decimal(6,2) DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  PRIMARY KEY (`idAcumuloServicos`),
  KEY `fk_idCliente_AC` (`idCliente`),
  CONSTRAINT `fk_idCliente_AC` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acumulo_servicos`
--

LOCK TABLES `acumulo_servicos` WRITE;
/*!40000 ALTER TABLE `acumulo_servicos` DISABLE KEYS */;
INSERT INTO `acumulo_servicos` VALUES (29,4667.00,35),(30,180.00,36),(31,240.00,37),(32,240.00,38),(35,0.00,41),(36,0.00,42);
/*!40000 ALTER TABLE `acumulo_servicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `idCargo` int NOT NULL AUTO_INCREMENT,
  `nomeCargo` varchar(45) NOT NULL,
  `salario` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (11,'Técino de Refrigeração Pleno',2980.00),(12,'Técino de Refrigeração Sênior',3850.00),(13,'Técnico Gasista Júnior',2280.00),(14,'Técnico Gasista Sênior',2490.00),(15,'Técnico Gasista Plêno',4380.00),(16,'Proprietário',NULL),(17,'Atendente2',2480.00),(18,'Atendent3',2680.00),(19,'atendente',2200.00),(20,'dono',0.00);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `identificacao` varchar(14) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `sexo` char(1) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (35,'joao ana','10340440444','92536454545','2000-02-20',0,'M','vfvvvvvvv'),(36,'Carlos da Silva','10227346555',NULL,'2000-02-10',25,'M',''),(37,'Julia Rodrigues da Costa','10239475655',NULL,'2003-04-11',22,'F',''),(38,'Mariana dos Santos','10235456555',NULL,'1999-01-10',26,'F',''),(41,'Marcos Lima','22340440444',NULL,'2000-02-10',25,'M',''),(42,'Patrique Silva','34340440444',NULL,'2000-03-20',25,'M','');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ACUMULO_SERVICO_INS` AFTER INSERT ON `cliente` FOR EACH ROW begin 
    insert into acumulo_servicos(valorAcumulado,idCliente) values
        (0.00,new.idCliente);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `idEmpresa` int NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(14) NOT NULL,
  `razaoSocial` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'53019145000109','solugemm Gardênia','solugemm@solugemm.com'),(4,'53019145000109','Solugemm Serviços técnicos(Pechincha)','contato@solugemm.com'),(5,'53019145000109','Solugemm Serviços técnicos(Piedade)','contato@solugemm.com'),(6,'53019145000109','Solugemm Serviços técnicos(Cachambi)','contato@solugemm.com'),(7,'53019145000109','Solugemm Serviços técnicos(Méier)','contato@solugemm.com'),(8,'53019145000109','Solugemm Serviços técnicos(Cascadura)','contato@solugemm.com'),(9,'53019145000109','Solugemm Serviços técnicos(Camorim)','contato@solugemm.com'),(10,'53019145000109','Solugemm Serviços técnicos(M Hermes)','contato@solugemm.com'),(11,'53019145000109','Solugemm Serviços técnicos(Campinho)','contato@solugemm.com');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `idEndereco` int NOT NULL AUTO_INCREMENT,
  `cep` varchar(10) DEFAULT NULL,
  `rua` varchar(50) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(45) NOT NULL DEFAULT 'Rio de janeiro',
  `Estado` varchar(2) NOT NULL DEFAULT 'RJ',
  `casa` varchar(4) DEFAULT NULL,
  `numeroApartamento` varchar(4) DEFAULT NULL,
  `bloco` varchar(4) DEFAULT NULL,
  `idEmpresa` int DEFAULT NULL,
  `idFuncionario` int DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  PRIMARY KEY (`idEndereco`),
  KEY `fk_Endereco_idEmpresa` (`idEmpresa`),
  KEY `fk_Endereco_idFuncionario` (`idFuncionario`),
  KEY `fk_Endereco_idCliente` (`idCliente`),
  CONSTRAINT `fk_Endereco_idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE,
  CONSTRAINT `fk_Endereco_idEmpresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE CASCADE,
  CONSTRAINT `fk_Endereco_idFuncionario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (57,'39465778','Firmino','50','Méier','Rio de janeiro','RJ','703','','',NULL,NULL,NULL),(58,'84657687','Dias da Cruz','5113','Méier','Rio de janeiro','RJ','25','','',NULL,NULL,NULL),(59,'30475867','Estrada Lucio Costa','4336','Barra da Tijuca','Rio de janeiro','RJ','','1003','2',NULL,NULL,NULL),(61,'83745342','Estrada dos Bandeirantes','2435','Camurim','Rio de janeiro','RJ','10','vv','vv',NULL,NULL,35),(62,'27364534','Rua Carlos Lacerda','24','Pechincha','Rio de janeiro','RJ','100','','',NULL,NULL,36),(63,'83546345','Rua Lasaro','30','Taquara','Rio de janeiro','RJ','40','','',NULL,NULL,37),(64,'28356465','Rua da Graça','100','Taquara','Rio de janeiro','RJ','20','','',NULL,NULL,38),(68,'29374859','Rua Parque dos Anjos','44','Taquara','Rio de janeiro','RJ','40','nn','40',NULL,19,NULL),(69,'29384668','Rua Vinicius silva','20','Taquara','Rio de janeiro','RJ','20','','',NULL,20,NULL),(73,'20384753','Rua Marques de Oliveira','20','Anil','Rio de janeiro','RJ','40','','',NULL,24,NULL),(74,'20384643','Estrada dos Tres Rios','2376','Taquara','Rio de janeiro','RJ','','','',1,NULL,NULL),(76,'22002-284','ttttt','44','tttt','ttt','tt','ttt','ttt','tt',NULL,35,NULL),(81,'83745342','Estrada dos Bandeirantes','2435','Camurim','Rio de janeiro','RJ','10','vv','vv',NULL,NULL,NULL),(82,'83745342','Estrada dos Bandeirantes','2435','Camurim','Rio de janeiro','RJ','10','vv','vv',NULL,NULL,NULL);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabricante`
--

DROP TABLE IF EXISTS `fabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fabricante` (
  `idFabricante` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  PRIMARY KEY (`idFabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricante`
--

LOCK TABLES `fabricante` WRITE;
/*!40000 ALTER TABLE `fabricante` DISABLE KEYS */;
INSERT INTO `fabricante` VALUES (9,' Fujitsu','26374657697867'),(10,' Suryha','47563547583925'),(11,' Comeco','35465768798065'),(12,' Hulter','39465534576879'),(13,'Sumih ','24349568705576'),(14,' Philco','13374659677889'),(15,'Canza ','40349568705576'),(16,'EOS','14243546574534'),(17,'aaaa','16243546576879');
/*!40000 ALTER TABLE `fabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `idFuncionario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `senha` varchar(30) DEFAULT NULL,
  `identificacao` varchar(14) NOT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `dataNascimento` date NOT NULL,
  `sexo` char(1) NOT NULL,
  `idade` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `idCargo` int NOT NULL,
  `idEmpresa` int NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  KEY `fk_idCargo` (`idCargo`),
  KEY `fk_idEmpresa` (`idEmpresa`),
  CONSTRAINT `fk_idCargo` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`) ON DELETE CASCADE,
  CONSTRAINT `fk_idEmpresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (19,'marcos silva','2221','','10449556711','21645576879','1980-01-20','M',0,'leohd@yahoo.com',11,1),(20,'Victor de Lima Andrade','1934659678','','12428345677',NULL,'1980-01-10','M',45,'brasilgama22@gmail.com',12,1),(24,' José Carlos de Brito Neto',' 992374658','carlos123',' 10237465773',NULL,'1965-03-10','M',60,'josecarlos@gmail.com',16,1),(27,'Luiz Carlos','3221622841','','20449556711',NULL,'1980-01-23','M',45,'luizd@yahoo.com',12,1),(28,'Rafael Cardoso','2234659678','','14428345677',NULL,'1980-01-11','M',45,'Rafa111@gmail.com',12,1),(35,'eeeee','4444',NULL,'28353546444','27454645353','2020-10-10','m',0,'frrfrfrrfrffr',11,1),(37,'Francisco da Silva','2004','user2004','263545565','21546576879','1960-03-20','m',66,'Francisco@hotmail.com',20,1),(38,'Joana da Silva','1003','user1003','364535454','21945566756','2000-01-20','f',26,'ana@hotmail.com',19,1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario_servico`
--

DROP TABLE IF EXISTS `funcionario_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario_servico` (
  `idFuncionarioServico` int NOT NULL AUTO_INCREMENT,
  `horaInicioServico` time DEFAULT NULL,
  `horaFimServico` time DEFAULT NULL,
  `observacaoDoFuncionario` varchar(450) DEFAULT NULL,
  `idOS` int NOT NULL,
  `idFuncionario` int NOT NULL,
  PRIMARY KEY (`idFuncionarioServico`),
  KEY `fk_Funcionario_Servico_idOS` (`idOS`),
  KEY `fk_Funcionario_Servico_idFuncionario` (`idFuncionario`),
  CONSTRAINT `fk_Funcionario_Servico_idFuncionario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE CASCADE,
  CONSTRAINT `fk_Funcionario_Servico_idOS` FOREIGN KEY (`idOS`) REFERENCES `ordem_servicos_agendado` (`idOS`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario_servico`
--

LOCK TABLES `funcionario_servico` WRITE;
/*!40000 ALTER TABLE `funcionario_servico` DISABLE KEYS */;
INSERT INTO `funcionario_servico` VALUES (3,'07:20:00','18:30:00','Concluido com sucesso',27,19),(4,'12:00:00','17:00:00','Concluido com sucesso',28,20),(14,'10:10:00','10:10:00','3eddddd',39,19),(15,'10:10:00','10:10:00','ddddd',39,19),(16,'10:10:00','10:10:00','ddddd',40,19),(17,'10:10:00','10:10:00','wwww',40,19);
/*!40000 ALTER TABLE `funcionario_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `idMaterial` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `preco` decimal(6,2) NOT NULL,
  `codigo` varchar(4) NOT NULL,
  `idFabricante` int NOT NULL,
  PRIMARY KEY (`idMaterial`),
  KEY `fk_Material_idFabricante` (`idFabricante`),
  CONSTRAINT `fk_Material_idFabricante` FOREIGN KEY (`idFabricante`) REFERENCES `fabricante` (`idFabricante`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (3,'Capacitor duplo',30.00,'1125',9),(4,'Diafragma 16mm',80.00,'2000',11),(6,'Diafragma 12mm',57.00,'2055',11),(7,'Valvola Solenóide',135.00,'5599',11),(8,'Interroptor R-544',24.00,'6343',11),(10,'Capacitor simples EOS',20.00,'1111',16);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_utilizado`
--

DROP TABLE IF EXISTS `material_utilizado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material_utilizado` (
  `idMaterialUtilizado` int NOT NULL AUTO_INCREMENT,
  `precoMaterial` decimal(6,2) NOT NULL,
  `qtdMaterial` int NOT NULL,
  `totalMatUtilizado` decimal(10,2),
  `idOS` int NOT NULL,
  `idMaterial` int NOT NULL,
  PRIMARY KEY (`idMaterialUtilizado`),
  KEY `fk_Material_Utilizado_idOS` (`idOS`),
  KEY `fk_Material_Utilizado_idMaterial` (`idMaterial`),
  CONSTRAINT `fk_Material_Utilizado_idMaterial` FOREIGN KEY (`idMaterial`) REFERENCES `material` (`idMaterial`) ON DELETE CASCADE,
  CONSTRAINT `fk_Material_Utilizado_idOS` FOREIGN KEY (`idOS`) REFERENCES `ordem_servicos_agendado` (`idOS`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DELIMITER //

CREATE TRIGGER `trg_calc_total_insert` BEFORE INSERT ON `material_utilizado`
FOR EACH ROW
BEGIN
    SET NEW.totalMatUtilizado = (NEW.qtdMaterial * NEW.precoMaterial);
END //


CREATE TRIGGER `trg_calc_total_update` BEFORE UPDATE ON `material_utilizado`
FOR EACH ROW
BEGIN
    SET NEW.totalMatUtilizado = (NEW.qtdMaterial * NEW.precoMaterial);
END //

DELIMITER ;

--
-- Dumping data for table `material_utilizado`
--

LOCK TABLES `material_utilizado` WRITE;
/*!40000 ALTER TABLE `material_utilizado` DISABLE KEYS */;
INSERT INTO `material_utilizado` (`idMaterialUtilizado`, `precoMaterial`, `qtdMaterial`, `idOS`, `idMaterial`) VALUES (113,30.00,10,39,3),(114,80.00,2,39,4),(115,30.00,20,40,3);
/*!40000 ALTER TABLE `material_utilizado` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_Desconto_MU_INS` AFTER INSERT ON `material_utilizado` FOR EACH ROW begin 
    update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_MaoObra_Material_Desconto01_Vacumulado_Desconto02_INS` AFTER INSERT ON `material_utilizado` FOR EACH ROW begin 
	-- Lógica para subtrair o valor_acumulado do total da mão de obra com desconto para uma mesma OS já calculado.  1111111111111
      update acumulo_servicos set valorAcumulado =  SUBTRAIR_VALOR_ACUMULADO_CALCULADO(new.idOS)
        where idCliente = Retornar_Id_Cliente(new.idOS);
        
    -- lógica para recalcular o total da mão de obra com material da ordem de serviço 
    update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(new.idOS)
        where idOS = new.idOS;
    
    -- lógica para recalcular o desconto 01 da ordem de serviço 
     update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
        
   -- logica para calcular o valor da mão de obra com material e com desconto    
    call Valor_Total_OS(new.idOS);
   
   
   /*     
    -- lógica para calcular o valor acumulado da ordem de serviço
    update acumulo_servicos set valorAcumulado =  CALCULAR_VALOR_ACUMULADO_SERVICOS(new.idOS)
        where idCliente = Retornar_Id_Cliente(new.idOS);
    */
     call CALCULAR_VALOR_ACUMULADO_SERVICOS(new.idOS);  
        
     -- lógica para calcular o desconto  por acumulo de gastos em serviços das ordens de serviços;  
     call DESCONTO_ELEGIVEL_VAL_ACUM(new.idOS); 
   /*  
     update ordem_servicos_agendado set totalComDescFidelidad = DESCONTO_ELEGIVEL_VAL_ACUM(new.idOS)
        where idOS = new.idOS;
    */    
     /* lógica para calcular acúmulo de serviços pagos */
    -- call atualizar_valor_acumulado(new.idOS);
     
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_Desconto_MU_UPD` AFTER UPDATE ON `material_utilizado` FOR EACH ROW begin 
    if old.idOS <> new.idOS then
    update ordem_servicos_agendado set Desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS;
        
    update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
    else
	update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
   end if;      
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_MaoObra_Material_UPD` AFTER UPDATE ON `material_utilizado` FOR EACH ROW begin 
    -- Lógica para subtrair o valor_acumulado do total da mão de obra com desconto para uma mesma OS já calculado.
      update acumulo_servicos set valorAcumulado =  SUBTRAIR_VALOR_ACUMULADO_CALCULADO(old.idOS)
        where idCliente = Retornar_Id_Cliente(old.idOS);
        
    -- lógica para recalcular o total da mão de obra com material da OS 
    if old.idOS <> new.idOS then
    update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(old.idOS)
        where idOS = old.idOS;
        
    update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(new.idOS)
        where idOS = new.idOS;
    else
	update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(new.idOS)
        where idOS = new.idOS;
   end if; 
   
   -- lógica para recalcular o desconto da OS 
   
   if old.idOS <> new.idOS then
    update ordem_servicos_agendado set Desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS;
        
    update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
    else
	update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
   end if;
   
  -- logica para calcular o valor da mão de obra com material e com desconto    
  if old.idOS <> new.idOS then
    call Valor_Total_OS(old.idOS);  
	call Valor_Total_OS(new.idOS);  
    else
	     call Valor_Total_OS(new.idOS);  
   end if; 
   
 
   -- lógica para calcular o valor acumulado da ordem de serviço
   if old.idOS <> new.idOS then
     call CALCULAR_VALOR_ACUMULADO_SERVICOS(old.idOS);   
	 call CALCULAR_VALOR_ACUMULADO_SERVICOS(new.idOS);  
	 else
	     call CALCULAR_VALOR_ACUMULADO_SERVICOS(new.idOS);   
   end if; 
 
   -- lógica para calcular o desconto  por acumulo de gastos em serviços das ordens de serviços;  
    if old.idOS <> new.idOS then
     call  DESCONTO_ELEGIVEL_VAL_ACUM(old.idOS);   
	 call  DESCONTO_ELEGIVEL_VAL_ACUM(new.idOS);  
	 else
	     call  DESCONTO_ELEGIVEL_VAL_ACUM(new.idOS);   
    end if; 
  
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_Desconto_MU_DEL` AFTER DELETE ON `material_utilizado` FOR EACH ROW begin 
    update ordem_servicos_agendado set  desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS; 
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_MaoObra_Material_DEL` AFTER DELETE ON `material_utilizado` FOR EACH ROW begin 
  
  -- Lógica para subtrair o valor_acumulado do total da mão de obra com desconto para uma mesma OS já calculado.
      update acumulo_servicos set valorAcumulado =  SUBTRAIR_VALOR_ACUMULADO_CALCULADO(old.idOS)
        where idCliente = Retornar_Id_Cliente(old.idOS);  
        
    -- lógica para recalcular o total da mão de obra com material da OS 
    update ordem_servicos_agendado set  totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(old.idOS)
        where idOS = old.idOS; 
        
    -- lógica para recalcular o desconto da OS 
    update ordem_servicos_agendado set  desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS; 
    
    -- logica para calcular o valor da mão de obra com material e com desconto    
    call Valor_Total_OS(old.idOS);
 
    -- lógica para calcular o valor acumulado da ordem de serviço
    call CALCULAR_VALOR_ACUMULADO_SERVICOS(old.idOS);  
     
     -- lógica para calcular o desconto  por acumulo de gastos em serviços das ordens de serviços;  
     call DESCONTO_ELEGIVEL_VAL_ACUM(old.idOS); 
    
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ordem_servicos_agendado`
--

DROP TABLE IF EXISTS `ordem_servicos_agendado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordem_servicos_agendado` (
  `idOS` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `totalMaoDeObraMaterial` decimal(6,2) DEFAULT NULL,
  `desconto` decimal(6,2) DEFAULT '0.00',
  `totalMaodeObraComDesc` decimal(6,2) DEFAULT NULL,
  `idEmpresa` int NOT NULL,
  `idEndereco` int NOT NULL,
  `idCliente` int NOT NULL,
  `totalComDescFidelidad` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`idOS`),
  KEY `fk_OS_idEmpresa` (`idEmpresa`),
  KEY `fk_OS_idEndereco` (`idEndereco`),
  KEY `fk_OS_idCliente` (`idCliente`),
  CONSTRAINT `fk_OS_idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE,
  CONSTRAINT `fk_OS_idEmpresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE CASCADE,
  CONSTRAINT `fk_OS_idEndereco` FOREIGN KEY (`idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordem_servicos_agendado`
--

LOCK TABLES `ordem_servicos_agendado` WRITE;
/*!40000 ALTER TABLE `ordem_servicos_agendado` DISABLE KEYS */;
INSERT INTO `ordem_servicos_agendado` VALUES (26,'2025-02-14',240.00,0.00,240.00,1,61,35,240.00),(27,'2025-06-12',180.00,0.00,180.00,1,62,36,180.00),(28,'2025-01-22',240.00,0.00,240.00,1,63,37,240.00),(29,'2025-02-14',240.00,0.00,240.00,1,64,38,240.00),(39,'2020-10-10',2860.00,143.00,2717.00,1,81,35,2717.00),(40,'2020-10-10',1800.00,90.00,1710.00,1,82,35,1710.00);
/*!40000 ALTER TABLE `ordem_servicos_agendado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico_concluido`
--

DROP TABLE IF EXISTS `servico_concluido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico_concluido` (
  `idServicoConcluido` int NOT NULL AUTO_INCREMENT,
  `qtdTipoServico` int NOT NULL,
  `preco` decimal(6,2) NOT NULL,
  `totalMaoDeObra` decimal(10,2),
  `idOS` int NOT NULL,
  `idTDS` int NOT NULL,
  PRIMARY KEY (`idServicoConcluido`),
  KEY `fk_Servico_Concluido_idOS` (`idOS`),
  KEY `fk_Servico_Concluido_idTDS` (`idTDS`),
  CONSTRAINT `fk_Servico_Concluido_idOS` FOREIGN KEY (`idOS`) REFERENCES `ordem_servicos_agendado` (`idOS`) ON DELETE CASCADE,
  CONSTRAINT `fk_Servico_Concluido_idTDS` FOREIGN KEY (`idTDS`) REFERENCES `tipo_de_servico` (`idTDS`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DELIMITER //

CREATE TRIGGER `trg_calc_servico_insert` BEFORE INSERT ON `servico_concluido`
FOR EACH ROW
BEGIN
    SET NEW.totalMaoDeObra = (NEW.qtdTipoServico * NEW.preco);
END //

CREATE TRIGGER `trg_calc_servico_update` BEFORE UPDATE ON `servico_concluido`
FOR EACH ROW
BEGIN
    SET NEW.totalMaoDeObra = (NEW.qtdTipoServico * NEW.preco);
END //

DELIMITER ;

--
-- Dumping data for table `servico_concluido`
--

LOCK TABLES `servico_concluido` WRITE;
/*!40000 ALTER TABLE `servico_concluido` DISABLE KEYS */;
INSERT INTO `servico_concluido` (`idServicoConcluido`, `qtdTipoServico`, `preco`, `idOS`, `idTDS`) VALUES (69,2,90.00,27,7),(73,2,1200.00,39,2),(74,1,1200.00,40,2);
/*!40000 ALTER TABLE `servico_concluido` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_Desconto_SC_INS` AFTER INSERT ON `servico_concluido` FOR EACH ROW begin 
    update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_MaoObra_Material_SC_INS` AFTER INSERT ON `servico_concluido` FOR EACH ROW begin 

    -- Lógica para subtrair o valor_acumulado do total da mão de obra com desconto para uma mesma OS já calculado.  
      update acumulo_servicos set valorAcumulado =  SUBTRAIR_VALOR_ACUMULADO_CALCULADO(new.idOS)
        where idCliente = Retornar_Id_Cliente(new.idOS);
   
    -- lógica para recalcular o total da mão de obra com material da OS 
    update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(new.idOS)
        where idOS = new.idOS;
        
     -- lógica para recalcular o desconto da OS
     
      update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
        
      -- logica para calcular o valor da mão de obra com material e com desconto    
    call Valor_Total_OS(new.idOS);
    
     -- lógica para calcular o valor acumulado da ordem de serviço
    call CALCULAR_VALOR_ACUMULADO_SERVICOS(new.idOS);  
        
     -- lógica para calcular o desconto  por acumulo de gastos em serviços das ordens de serviços;  
     call DESCONTO_ELEGIVEL_VAL_ACUM(new.idOS); 
 
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_Desconto_SC_UPD` AFTER UPDATE ON `servico_concluido` FOR EACH ROW begin 
    if old.idOS <> new.idOS then
    update ordem_servicos_agendado set Desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS;
        
    update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
    else
	update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
   end if;      
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_MObra_Ma_DES_ValAcumuloServ_TotComDesc_SC_UPD` AFTER UPDATE ON `servico_concluido` FOR EACH ROW begin 
   /* 
    -- Lógica para subtrair o valor_acumulado do total da mão de obra com desconto para uma mesma OS já calculado.
      update acumulo_servicos set valorAcumulado =  SUBTRAIR_VALOR_ACUMULADO_CALCULADO(old.idOS)
        where idCliente = Retornar_Id_Cliente(old.idOS);

    -- lógica para recalcular o total da mão de obra com material da OS 
    if old.idOS <> new.idOS then
    update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(old.idOS)
        where idOS = old.idOS;
        
    update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(new.idOS)
        where idOS = new.idOS;
    else
	update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(new.idOS)
        where idOS = new.idOS;
   end if; 
   
    -- lógica para recalcular o desconto da OS
    
    if old.idOS <> new.idOS then
    update ordem_servicos_agendado set Desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS;
        
    update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
    else
	update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
   end if;
   
   -- lógica para recalcular o valor acumulado da OS
   
   if old.idOS <> new.idOS then
    update acumulo_servicos set valorAcumulado =  CALCULAR_VALOR_ACUMULADO_SERVICOS(old.idOS)
        where idCliente = Retornar_Id_Cliente(new.idOS);
        
    update acumulo_servicos set valorAcumulado =  CALCULAR_VALOR_ACUMULADO_SERVICOS(new.idOS)
        where idCliente = Retornar_Id_Cliente(new.idOS);
    else
	update acumulo_servicos set valorAcumulado =  CALCULAR_VALOR_ACUMULADO_SERVICOS(new.idOS)
        where idCliente = Retornar_Id_Cliente(new.idOS);
   end if;  
   
   -- lógica para calcular o desconto  por acumulo de gastos em serviços das ordens de serviços;  
     update ordem_servicos_agendado set totalComDescFidelidad = DESCONTO_ELEGIVEL_VAL_ACUM(new.idOS)
        where idOS = new.idOS;
   */     
-- refeito
   -- Lógica para subtrair o valor_acumulado do total da mão de obra com desconto para uma mesma OS já calculado.
      update acumulo_servicos set valorAcumulado =  SUBTRAIR_VALOR_ACUMULADO_CALCULADO(old.idOS)
        where idCliente = Retornar_Id_Cliente(old.idOS);
        
    -- lógica para recalcular o total da mão de obra com material da OS 
    if old.idOS <> new.idOS then
    update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(old.idOS)
        where idOS = old.idOS;
        
    update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(new.idOS)
        where idOS = new.idOS;
    else
	update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(new.idOS)
        where idOS = new.idOS;
   end if; 
   
   -- lógica para recalcular o desconto da OS 
   
   if old.idOS <> new.idOS then
    update ordem_servicos_agendado set Desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS;
        
    update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
    else
	update ordem_servicos_agendado set desconto = Valor_Desconto(new.idOS)
        where idOS = new.idOS;
   end if;
   
  -- logica para calcular o valor da mão de obra com material e com desconto    
  if old.idOS <> new.idOS then
    call Valor_Total_OS(old.idOS);  
	call Valor_Total_OS(new.idOS);  
    else
	     call Valor_Total_OS(new.idOS);  
   end if; 
   
 
   -- lógica para calcular o valor acumulado da ordem de serviço
   if old.idOS <> new.idOS then
     call CALCULAR_VALOR_ACUMULADO_SERVICOS(old.idOS);   
	 call CALCULAR_VALOR_ACUMULADO_SERVICOS(new.idOS);  
	 else
	     call CALCULAR_VALOR_ACUMULADO_SERVICOS(new.idOS);   
   end if; 
 
   -- lógica para calcular o desconto  por acumulo de gastos em serviços das ordens de serviços;  
    if old.idOS <> new.idOS then
     call  DESCONTO_ELEGIVEL_VAL_ACUM(old.idOS);   
	 call  DESCONTO_ELEGIVEL_VAL_ACUM(new.idOS);  
	 else
	     call  DESCONTO_ELEGIVEL_VAL_ACUM(new.idOS);   
    end if; 
    
-- fim refeito        
	
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_Desconto_SC_DEL` AFTER DELETE ON `servico_concluido` FOR EACH ROW begin 
    update ordem_servicos_agendado set  desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS; 
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `V_MaoObra_Material_SC_DEL` AFTER DELETE ON `servico_concluido` FOR EACH ROW begin 
    /*
    -- Lógica para subtrair o valor_acumulado do total da mão de obra com desconto para uma mesma OS já calculado.
      update acumulo_servicos set valorAcumulado =  SUBTRAIR_VALOR_ACUMULADO_CALCULADO(old.idOS)
        where idCliente = Retornar_Id_Cliente(old.idOS);

    -- lógica para recalcular o total da mão de obra com material da OS 
    update ordem_servicos_agendado set  totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(old.idOS)
        where idOS = old.idOS; 
        
    -- lógica para recalcular o desconto da OS
    update ordem_servicos_agendado set  desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS; 
        
	-- lógica para recalcular o valor acumulado da OS
    update acumulo_servicos set valorAcumulado =  CALCULAR_VALOR_ACUMULADO_SERVICOS(old.idOS)
        where idCliente = Retornar_Id_Cliente(old.idOS);    
        
    -- lógica para calcular o desconto  por acumulo de gastos em serviços das ordens de serviços;  
     update ordem_servicos_agendado set totalComDescFidelidad = DESCONTO_ELEGIVEL_VAL_ACUM(old.idOS)
        where idOS = old.idOS;    
    */
    
     -- Lógica para subtrair o valor_acumulado do total da mão de obra com desconto para uma mesma OS já calculado.  
      update acumulo_servicos set valorAcumulado =  SUBTRAIR_VALOR_ACUMULADO_CALCULADO(old.idOS)
        where idCliente = Retornar_Id_Cliente(old.idOS);
   
    -- lógica para recalcular o total da mão de obra com material da OS 
    update ordem_servicos_agendado set totalMaoDeObraMaterial = Valor_MaoObra_Material_OS(old.idOS)
        where idOS = old.idOS;
        
     -- lógica para recalcular o desconto da OS
     
      update ordem_servicos_agendado set desconto = Valor_Desconto(old.idOS)
        where idOS = old.idOS;
        
      -- logica para calcular o valor da mão de obra com material e com desconto    
    call Valor_Total_OS(old.idOS);
    
     -- lógica para calcular o valor acumulado da ordem de serviço
    call CALCULAR_VALOR_ACUMULADO_SERVICOS(old.idOS);  
        
     -- lógica para calcular o desconto  por acumulo de gastos em serviços das ordens de serviços;  
     call DESCONTO_ELEGIVEL_VAL_ACUM(old.idOS); 
 
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefone` (
  `idTelefone` int NOT NULL AUTO_INCREMENT,
  `numero` varchar(15) NOT NULL,
  `idEmpresa` int DEFAULT NULL,
  `idFuncionario` int DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  PRIMARY KEY (`idTelefone`),
  KEY `fk_Telefone_idEmpresa` (`idEmpresa`),
  KEY `fk_Telefone_idFuncionario` (`idFuncionario`),
  KEY `fk_Telefone_idCliente` (`idCliente`),
  CONSTRAINT `fk_Telefone_idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE,
  CONSTRAINT `fk_Telefone_idEmpresa` FOREIGN KEY (`idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE CASCADE,
  CONSTRAINT `fk_Telefone_idFuncionario` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefone`
--

LOCK TABLES `telefone` WRITE;
/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
INSERT INTO `telefone` VALUES (18,'21984756453',NULL,19,NULL),(19,'21984756342',NULL,20,NULL),(23,'21984657453',NULL,24,NULL),(25,'21984657452',NULL,NULL,35),(26,'21965746354',NULL,NULL,36),(27,'21968564534',NULL,NULL,37),(28,'21965746350',NULL,NULL,38);
/*!40000 ALTER TABLE `telefone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_de_servico`
--

DROP TABLE IF EXISTS `tipo_de_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_de_servico` (
  `idTDS` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `codigo` varchar(4) NOT NULL,
  `precoServico` decimal(6,2) NOT NULL,
  PRIMARY KEY (`idTDS`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_de_servico`
--

LOCK TABLES `tipo_de_servico` WRITE;
/*!40000 ALTER TABLE `tipo_de_servico` DISABLE KEYS */;
INSERT INTO `tipo_de_servico` VALUES (2,'Instalacão de Split 9000 a 18000 com material','2545',1200.00),(3,'Limpeza de ar piso teto completa','3424',700.00),(4,'Carga de fluido refrigerante R22 ACJ ou Split 7 a 18000','4352',240.00),(5,'Limpeza geral Splt 9000 a 18000','3867',280.00),(6,'troca de Diafragma Aquecedor 7L a 15L','1510',180.00),(7,'troca de Válvula Solenoide','1220',90.00);
/*!40000 ALTER TABLE `tipo_de_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'solugemm'
--

--
-- Dumping routines for database 'solugemm'
--
/*!50003 DROP FUNCTION IF EXISTS `DESCONTO_ELEGIVEL_VAL_ACUM` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `DESCONTO_ELEGIVEL_VAL_ACUM`(ID_OS INT) RETURNS decimal(6,2)
    DETERMINISTIC
begin
        declare id_cliente  int;
        declare v_Total_com_desc decimal(6,2);
        declare valor_elegivel decimal(6,2);
        declare valor_acumulado decimal(6,2);
        declare desconto decimal(6,2);
        declare novo_valor_acumulado decimal(6,2);
        declare gasto_min_para_desc decimal(6,2);
        select valorAcumulado into valor_acumulado from acumulo_servicos
          where idCliente = Retornar_Id_Cliente(ID_OS);
        select totalMaodeObraComDesc into v_total_com_desc from ordem_servicos_agendado
          where idOS = ID_OS;
        set valor_elegivel = 5000.00;  
        set desconto := 200.00;
        set gasto_min_para_desc := 199.99;
        if valor_acumulado > valor_elegivel and v_total_com_desc > gasto_min_para_desc then
          set v_total_com_desc := v_total_com_desc -  desconto;
          set novo_valor_acumulado := valor_acumulado - valor_elegivel;
          update acumulo_servicos set valorAcumulado = novo_valor_acumulado
            where idCliente = id_cliente;
         end if;   
        return  v_total_com_desc;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `Retornar_Id_Cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `Retornar_Id_Cliente`(id_OS int) RETURNS int
    DETERMINISTIC
begin 
        declare id_Cliente_OS int;
        select idCliente into id_Cliente_OS from  ordem_servicos_agendado     
        where idOS = id_OS;
        return id_Cliente_OS;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `SUBTRAIR_VALOR_ACUMULADO_CALCULADO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `SUBTRAIR_VALOR_ACUMULADO_CALCULADO`(id_OS int) RETURNS decimal(6,2)
    DETERMINISTIC
begin
    declare V_Total_Mao_Obra_Desconto decimal(6,2);
    declare V_Valor_Acumulado decimal(6,2);
    declare id_Cliente_OS int;
    declare V_Novo_Valor_Acumulado decimal(6,2);
    select totalMaodeObraComDesc into V_Total_Mao_Obra_Desconto
        from ordem_servicos_agendado
        where idOS = id_OS;
    select idCliente into id_Cliente_OS
        from ordem_servicos_agendado
        where idOS = id_OS;
    select valorAcumulado into V_Valor_Acumulado
        from acumulo_servicos
        where idCliente =id_Cliente_OS;
    if  V_Total_Mao_Obra_Desconto > 0.00 then   
        set V_Novo_Valor_Acumulado := V_Valor_Acumulado - V_Total_Mao_Obra_Desconto; 
        else set V_Novo_Valor_Acumulado := V_Valor_Acumulado;
    end if;    
    return V_Novo_Valor_Acumulado;
	end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `Valor_Desconto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `Valor_Desconto`(V_idOS int) RETURNS decimal(6,2)
    DETERMINISTIC
begin
  --      declare V_TotalMaterial decimal(6,2);
  --      declare V_TotalMaoObra decimal(6,2);
        declare V_MaoObra_Material decimal(6,2);
        declare V_Desconto decimal(6,2);
  --      declare V_Total_Com_Desconto decimal(6,2);
 /*       
        select coalesce(sum(totalMatUtilizado),0.00) into V_TotalMaterial
            from Material_Utilizado
            where idOS = V_idOS;
        select coalesce(sum(totalMaoDeObra),0.00) into V_TotalMaoObra
            from servico_concluido 
            where idOs = V_idOS;
        set V_MaoObra_Material := V_TotalMaterial + V_TotalMaoObra;
 */
 /*
        if V_maoObra_Material > 1000.00 then
           set V_desconto := V_MaoObra_Material * 0.05;
           else 
           set V_desconto := 0.00;
        end if;
*/        
     --   set V_Total_Com_Desconto :=  V_MaoObra_Material - V_desconto; 
     select totalMaoDeObraMaterial into V_MaoObra_Material 
         from ordem_servicos_agendado 
         where idOS = V_idOS;
     if V_MaoObra_Material > 1000.00 then
           set V_desconto := V_MaoObra_Material * 0.05;
           else 
           set V_desconto := 0.00;
        end if;
        return V_Desconto;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `Valor_MaoObra_Material_OS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `Valor_MaoObra_Material_OS`(V_idOS int) RETURNS decimal(6,2)
    DETERMINISTIC
begin
        declare V_TotalMaterial decimal(6,2);
        declare V_TotalMaoObra decimal(6,2);
        declare V_MaoObra_Material decimal(6,2);
   
        select coalesce(sum(totalMatUtilizado),0.00) into V_TotalMaterial
            from Material_Utilizado
            where idOS = V_idOS;
        select coalesce(sum(totalMaoDeObra),0.00) into V_TotalMaoObra
            from servico_concluido 
            where idOs = V_idOS;
        set V_MaoObra_Material := V_TotalMaterial + V_TotalMaoObra;
        
        return V_MaoObra_Material;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `Valor_Total_OS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `Valor_Total_OS`(V_idOS int) RETURNS decimal(6,2)
    DETERMINISTIC
begin
        declare V_TotalMaterial decimal(6,2);
        declare V_TotalMaoObra decimal(6,2);
        declare V_MaoObra_Material decimal(6,2);
        declare V_Desconto decimal(6,2);
        declare V_Total_Com_Desconto decimal(6,2);
        set V_Total_Com_Desconto :=  V_MaoObra_Material - V_desconto; 
        return V_Total_Com_Desconto;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `atualizar_valor_acumulado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `atualizar_valor_acumulado`(id_OS int)
begin
    declare total_com_desc_fid decimal(6,2);
    declare V_Valor_Acumulado decimal(6,2);
 --   declare total_m_obra_mat_desconto decimal(6,2);
    declare id_Cliente_OS int;
    declare V_Novo_Valor_Acumulado decimal(6,2);
    select totalComDescFidelidad into total_com_desc_fid
        from ordem_servicos_agendado
        where idOS = id_OS;
    select idCliente into id_Cliente_OS
        from ordem_servicos_agendado
        where idOS = id_OS;
    select valorAcumulado into V_Valor_Acumulado
        from acumulo_servicos
        where idCliente =id_Cliente_OS;
--    select  totalMaodeObraComDesc into total_m_obra_mat_desconto 
 --    from ordem_servicos_agendado
 --       where idOS = id_OS;
    set V_Novo_Valor_Acumulado := V_Valor_Acumulado  +  total_com_desc_fid;   
    
     update acumulo_servicos set valorAcumulado = V_Novo_Valor_Acumulado 
        where idCliente = Retornar_Id_Cliente(id_OS);
 end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CALCULAR_VALOR_ACUMULADO_SERVICOS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CALCULAR_VALOR_ACUMULADO_SERVICOS`(in id_OS int)
begin
    declare v_Total_Mao_Obra_material_desc decimal(6,2);
    declare V_Valor_Acumulado decimal(6,2);
    declare id_Cliente_OS int;
    declare V_Novo_Valor_Acumulado decimal(6,2);
    select totalMaodeObraComDesc into v_total_mao_obra_material_desc
        from ordem_servicos_agendado
        where idOS = id_OS;
    select idCliente into id_Cliente_OS
        from ordem_servicos_agendado
        where idOS = id_OS;
    select valorAcumulado into V_Valor_Acumulado
        from acumulo_servicos
        where idCliente =id_Cliente_OS;
    set V_Novo_Valor_Acumulado := V_Valor_Acumulado + V_Total_Mao_Obra_material_desc;   
    
     update acumulo_servicos set valorAcumulado = V_Novo_Valor_Acumulado 
        where idCliente = Retornar_Id_Cliente(id_OS);
    
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `DESCONTO_ELEGIVEL_VAL_ACUM` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DESCONTO_ELEGIVEL_VAL_ACUM`(ID_OS INT)
begin
        declare id_cliente  int;
        declare v_Total_com_desc decimal(6,2);
        declare v_total_com_desc_fidelidad decimal(6,2);
        declare valor_elegivel decimal(6,2);
        declare valor_acumulado decimal(6,2);
        declare desconto decimal(6,2);
        declare novo_valor_acumulado decimal(6,2);
        
        declare gasto_min_para_desc decimal(6,2);
        select valorAcumulado into valor_acumulado from acumulo_servicos
          where idCliente = Retornar_Id_Cliente(ID_OS);
        select totalMaodeObraComDesc into v_total_com_desc from ordem_servicos_agendado
          where idOS = ID_OS;
        set valor_elegivel = 5000.00;  
        set desconto := 200.00;
        set gasto_min_para_desc := 199.99;
        if valor_acumulado > valor_elegivel and v_total_com_desc > gasto_min_para_desc then
          set v_total_com_desc_fidelidad := v_total_com_desc -  desconto;
          set novo_valor_acumulado := valor_acumulado - valor_elegivel;
          update acumulo_servicos set valorAcumulado = novo_valor_acumulado
             where idCliente = Retornar_Id_Cliente(ID_OS);
          else 
             set v_total_com_desc_fidelidad := v_total_com_desc;
         end if;   
         update ordem_servicos_agendado set totalComDescFidelidad = v_total_com_desc_fidelidad
              where idOS = ID_OS;
    end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Valor_Total_OS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Valor_Total_OS`(V_idOS int)
begin
        declare V_TotalMaterial decimal(6,2);
        declare V_TotalMaoObra decimal(6,2);
        declare V_MaoObra_Material decimal(6,2);
        declare V_Desconto decimal(6,2);
        declare V_Total_Com_Desconto decimal(6,2);
        select totalMaoDeObraMaterial into V_maoObra_Material 
            from ordem_servicos_agendado
            where idOS = V_idOS;
        select desconto into V_desconto 
            from ordem_servicos_agendado
            where idOS = V_idOS;
        set V_Total_Com_Desconto :=  V_MaoObra_Material - V_desconto; 
        update ordem_servicos_agendado set totalMaodeObraComDesc = V_Total_Com_Desconto
            where idOS = V_idOS;
    end ;;
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

-- Dump completed on 2026-07-14 22:59:41
