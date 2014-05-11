CREATE DATABASE  IF NOT EXISTS `qlhs` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `qlhs`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: qlhs
-- ------------------------------------------------------
-- Server version	5.6.12-log

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
-- Table structure for table `bangdiem`
--

DROP TABLE IF EXISTS `bangdiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bangdiem` (
  `mabangdiem` int(11) NOT NULL AUTO_INCREMENT,
  `malop` int(11) NOT NULL,
  `mahs` int(11) NOT NULL,
  `mamonhoc` int(11) NOT NULL,
  `mahocky` int(11) NOT NULL,
  `diem15phut` float DEFAULT NULL,
  `diem1tiet` float DEFAULT NULL,
  `diemthi` float DEFAULT NULL,
  `diemtb` float DEFAULT NULL,
  PRIMARY KEY (`mabangdiem`),
  KEY `fk_bangdiem_hocky_idx` (`mahocky`),
  KEY `fk_bangdiem_hocsinh_idx` (`mahs`),
  KEY `fk_bangdiem_lop_idx` (`malop`),
  KEY `fk_bangdiem_monhoc_idx` (`mamonhoc`),
  CONSTRAINT `fk_bangdiem_hocky` FOREIGN KEY (`mahocky`) REFERENCES `hocky` (`mahocky`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bangdiem_hocsinh` FOREIGN KEY (`mahs`) REFERENCES `hocsinh` (`mahs`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bangdiem_lop` FOREIGN KEY (`malop`) REFERENCES `lop` (`malop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bangdiem_monhoc` FOREIGN KEY (`mamonhoc`) REFERENCES `monhoc` (`mamonhoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bangdiem`
--

LOCK TABLES `bangdiem` WRITE;
/*!40000 ALTER TABLE `bangdiem` DISABLE KEYS */;
/*!40000 ALTER TABLE `bangdiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bctongkethk`
--

DROP TABLE IF EXISTS `bctongkethk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bctongkethk` (
  `mabctongkethk` int(11) NOT NULL AUTO_INCREMENT,
  `mahocky` int(11) NOT NULL,
  `malop` int(11) NOT NULL,
  `soluongdat` int(11) NOT NULL,
  `tiledat` float NOT NULL,
  PRIMARY KEY (`mabctongkethk`),
  KEY `fk_bctongkethk_hocky_idx` (`mahocky`),
  KEY `fk_bctongkethk_lop_idx` (`malop`),
  CONSTRAINT `fk_bctongkethk_hocky` FOREIGN KEY (`mahocky`) REFERENCES `hocky` (`mahocky`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bctongkethk_lop` FOREIGN KEY (`malop`) REFERENCES `lop` (`malop`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bctongkethk`
--

LOCK TABLES `bctongkethk` WRITE;
/*!40000 ALTER TABLE `bctongkethk` DISABLE KEYS */;
/*!40000 ALTER TABLE `bctongkethk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bctongketmon`
--

DROP TABLE IF EXISTS `bctongketmon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bctongketmon` (
  `mabctongketmon` int(11) NOT NULL AUTO_INCREMENT,
  `mamonhoc` int(11) NOT NULL,
  `mahocky` int(11) NOT NULL,
  `malop` int(11) NOT NULL,
  `soluongdat` int(11) NOT NULL,
  `tile` float NOT NULL,
  PRIMARY KEY (`mabctongketmon`),
  KEY `fk_bctongketmon_hocky_idx` (`mahocky`),
  KEY `fk_bctongketmon_lop_idx` (`malop`),
  KEY `fk_bctongketmon_monhoc_idx` (`mamonhoc`),
  CONSTRAINT `fk_bctongketmon_hocky` FOREIGN KEY (`mahocky`) REFERENCES `hocky` (`mahocky`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bctongketmon_lop` FOREIGN KEY (`malop`) REFERENCES `lop` (`malop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bctongketmon_monhoc` FOREIGN KEY (`mamonhoc`) REFERENCES `monhoc` (`mamonhoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bctongketmon`
--

LOCK TABLES `bctongketmon` WRITE;
/*!40000 ALTER TABLE `bctongketmon` DISABLE KEYS */;
/*!40000 ALTER TABLE `bctongketmon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctxeplop`
--

DROP TABLE IF EXISTS `ctxeplop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctxeplop` (
  `mactxeplop` int(11) NOT NULL AUTO_INCREMENT,
  `mahs` int(11) NOT NULL,
  `malop` int(11) NOT NULL,
  PRIMARY KEY (`mactxeplop`),
  KEY `fk_ctxeplop_lop_idx` (`malop`),
  KEY `fk_ctxeplop_hocsinh_idx` (`mahs`),
  CONSTRAINT `fk_ctxeplop_lop` FOREIGN KEY (`malop`) REFERENCES `lop` (`malop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ctxeplop_hocsinh` FOREIGN KEY (`mahs`) REFERENCES `hocsinh` (`mahs`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctxeplop`
--

LOCK TABLES `ctxeplop` WRITE;
/*!40000 ALTER TABLE `ctxeplop` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctxeplop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diemtb`
--

DROP TABLE IF EXISTS `diemtb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diemtb` (
  `madiemtb` int(11) NOT NULL AUTO_INCREMENT,
  `manamhoc` int(11) NOT NULL,
  `malop` int(11) NOT NULL,
  `mahs` int(11) NOT NULL,
  `tbhocky1` float NOT NULL,
  `tbhocky2` float NOT NULL,
  PRIMARY KEY (`madiemtb`),
  KEY `fk_diemtb_hocsinh_idx` (`mahs`),
  KEY `fk_diemtb_namhoc_idx` (`manamhoc`),
  KEY `fk_diemtb_lop_idx` (`malop`),
  CONSTRAINT `fk_diemtb_lop` FOREIGN KEY (`malop`) REFERENCES `lop` (`malop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_diemtb_hocsinh` FOREIGN KEY (`mahs`) REFERENCES `hocsinh` (`mahs`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_diemtb_namhoc` FOREIGN KEY (`manamhoc`) REFERENCES `namhoc` (`manamhoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diemtb`
--

LOCK TABLES `diemtb` WRITE;
/*!40000 ALTER TABLE `diemtb` DISABLE KEYS */;
/*!40000 ALTER TABLE `diemtb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocky`
--

DROP TABLE IF EXISTS `hocky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hocky` (
  `mahocky` int(11) NOT NULL AUTO_INCREMENT,
  `tenhocky` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `manamhoc` int(11) NOT NULL,
  PRIMARY KEY (`mahocky`),
  KEY `fk_hocky_namhoc_idx` (`manamhoc`),
  CONSTRAINT `fk_hocky_namhoc` FOREIGN KEY (`manamhoc`) REFERENCES `namhoc` (`manamhoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocky`
--

LOCK TABLES `hocky` WRITE;
/*!40000 ALTER TABLE `hocky` DISABLE KEYS */;
/*!40000 ALTER TABLE `hocky` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocsinh`
--

DROP TABLE IF EXISTS `hocsinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hocsinh` (
  `mahs` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ngaysinh` date DEFAULT NULL,
  `diachi` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`mahs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocsinh`
--

LOCK TABLES `hocsinh` WRITE;
/*!40000 ALTER TABLE `hocsinh` DISABLE KEYS */;
/*!40000 ALTER TABLE `hocsinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lop` (
  `malop` int(11) NOT NULL AUTO_INCREMENT,
  `tenlop` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `siso` int(11) NOT NULL,
  `mahocky` int(11) NOT NULL,
  PRIMARY KEY (`malop`),
  KEY `fk_lop_hocky_idx` (`mahocky`),
  CONSTRAINT `fk_lop_hocky` FOREIGN KEY (`mahocky`) REFERENCES `hocky` (`mahocky`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monhoc` (
  `mamonhoc` int(11) NOT NULL AUTO_INCREMENT,
  `tenmonhoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`mamonhoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `namhoc`
--

DROP TABLE IF EXISTS `namhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `namhoc` (
  `manamhoc` int(11) NOT NULL AUTO_INCREMENT,
  `tennamhoc` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`manamhoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `namhoc`
--

LOCK TABLES `namhoc` WRITE;
/*!40000 ALTER TABLE `namhoc` DISABLE KEYS */;
/*!40000 ALTER TABLE `namhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thamso`
--

DROP TABLE IF EXISTS `thamso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thamso` (
  `tenthamso` varchar(30) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `giatri` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`tenthamso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thamso`
--

LOCK TABLES `thamso` WRITE;
/*!40000 ALTER TABLE `thamso` DISABLE KEYS */;
/*!40000 ALTER TABLE `thamso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-11  8:31:00

