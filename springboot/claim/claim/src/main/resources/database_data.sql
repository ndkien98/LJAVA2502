CREATE DATABASE  IF NOT EXISTS `insurance_claim` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `insurance_claim`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: insurance_claim
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `claim`
--

DROP TABLE IF EXISTS `claim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `claim` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `claim_date` date DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfkypqix42u6j9uj5a1kq2428n` (`status_id`),
  KEY `FKlmon26is6b9p2wipdl88yn68y` (`customer_id`),
  KEY `FK6k25jaynajdvvcmst08cphrwl` (`product_id`),
  CONSTRAINT `FK6k25jaynajdvvcmst08cphrwl` FOREIGN KEY (`product_id`) REFERENCES `insurance_product` (`id`),
  CONSTRAINT `FKfkypqix42u6j9uj5a1kq2428n` FOREIGN KEY (`status_id`) REFERENCES `claim_status` (`id`),
  CONSTRAINT `FKlmon26is6b9p2wipdl88yn68y` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim`
--

LOCK TABLES `claim` WRITE;
/*!40000 ALTER TABLE `claim` DISABLE KEYS */;
INSERT INTO `claim` VALUES (1,NULL,NULL,NULL,NULL,NULL,600000,'2024-04-02','CLM0001','Mô tả yêu cầu 1',2,2,2),(2,NULL,NULL,NULL,NULL,NULL,700000,'2024-04-03','CLM0002','Mô tả yêu cầu 2',3,3,3),(3,NULL,NULL,NULL,NULL,NULL,800000,'2024-04-04','CLM0003','Mô tả yêu cầu 3',1,4,4),(4,NULL,NULL,NULL,NULL,NULL,900000,'2024-04-05','CLM0004','Mô tả yêu cầu 4',2,5,5),(5,NULL,NULL,NULL,NULL,NULL,1000000,'2024-04-06','CLM0005','Mô tả yêu cầu 5',3,6,1),(6,NULL,NULL,NULL,NULL,NULL,1100000,'2024-04-07','CLM0006','Mô tả yêu cầu 6',1,7,2),(7,NULL,NULL,NULL,NULL,NULL,1200000,'2024-04-08','CLM0007','Mô tả yêu cầu 7',2,8,3),(8,NULL,NULL,NULL,NULL,NULL,1300000,'2024-04-09','CLM0008','Mô tả yêu cầu 8',3,9,4),(9,NULL,NULL,NULL,NULL,NULL,1400000,'2024-04-10','CLM0009','Mô tả yêu cầu 9',1,10,5),(10,NULL,NULL,NULL,NULL,NULL,1500000,'2024-04-11','CLM0010','Mô tả yêu cầu 10',2,1,1),(11,NULL,NULL,NULL,NULL,NULL,1600000,'2024-04-12','CLM0011','Mô tả yêu cầu 11',3,2,2),(12,NULL,NULL,NULL,NULL,NULL,1700000,'2024-04-13','CLM0012','Mô tả yêu cầu 12',1,3,3),(13,NULL,NULL,NULL,NULL,NULL,1800000,'2024-04-14','CLM0013','Mô tả yêu cầu 13',2,4,4),(14,NULL,NULL,NULL,NULL,NULL,1900000,'2024-04-15','CLM0014','Mô tả yêu cầu 14',3,5,5),(15,NULL,NULL,NULL,NULL,NULL,2000000,'2024-04-16','CLM0015','Mô tả yêu cầu 15',1,6,1),(16,NULL,NULL,NULL,NULL,NULL,2100000,'2024-04-17','CLM0016','Mô tả yêu cầu 16',2,7,2),(17,NULL,NULL,NULL,NULL,NULL,2200000,'2024-04-18','CLM0017','Mô tả yêu cầu 17',3,8,3),(18,NULL,NULL,NULL,NULL,NULL,2300000,'2024-04-19','CLM0018','Mô tả yêu cầu 18',1,9,4),(19,NULL,NULL,NULL,NULL,NULL,2400000,'2024-04-20','CLM0019','Mô tả yêu cầu 19',2,10,5),(20,NULL,NULL,NULL,NULL,NULL,2500000,'2024-04-21','CLM0020','Mô tả yêu cầu 20',3,1,1),(21,NULL,NULL,NULL,NULL,NULL,2600000,'2024-04-22','CLM0021','Mô tả yêu cầu 21',1,2,2),(22,NULL,NULL,NULL,NULL,NULL,2700000,'2024-04-23','CLM0022','Mô tả yêu cầu 22',2,3,3),(23,NULL,NULL,NULL,NULL,NULL,2800000,'2024-04-24','CLM0023','Mô tả yêu cầu 23',3,4,4),(24,NULL,NULL,NULL,NULL,NULL,2900000,'2024-04-25','CLM0024','Mô tả yêu cầu 24',1,5,5),(25,NULL,NULL,NULL,NULL,NULL,3000000,'2024-04-26','CLM0025','Mô tả yêu cầu 25',2,6,1),(26,NULL,NULL,NULL,NULL,NULL,3100000,'2024-04-27','CLM0026','Mô tả yêu cầu 26',3,7,2),(27,NULL,NULL,NULL,NULL,NULL,3200000,'2024-04-28','CLM0027','Mô tả yêu cầu 27',1,8,3),(28,NULL,NULL,NULL,NULL,NULL,3300000,'2024-04-01','CLM0028','Mô tả yêu cầu 28',2,9,4),(29,NULL,NULL,NULL,NULL,NULL,3400000,'2024-04-02','CLM0029','Mô tả yêu cầu 29',3,10,5),(30,NULL,NULL,NULL,NULL,NULL,3500000,'2024-04-03','CLM0030','Mô tả yêu cầu 30',1,1,1);
/*!40000 ALTER TABLE `claim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim_document`
--

DROP TABLE IF EXISTS `claim_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `claim_document` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `document_name` varchar(255) DEFAULT NULL,
  `document_type` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `upload_date` date DEFAULT NULL,
  `claim_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK482n7wmh1ry39ewmqmailkpb8` (`claim_id`),
  CONSTRAINT `FK482n7wmh1ry39ewmqmailkpb8` FOREIGN KEY (`claim_id`) REFERENCES `claim` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_document`
--

LOCK TABLES `claim_document` WRITE;
/*!40000 ALTER TABLE `claim_document` DISABLE KEYS */;
INSERT INTO `claim_document` VALUES (1,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 1','PDF','/files/clm0001_doc.pdf','2024-04-03',1),(2,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 2','PDF','/files/clm0002_doc.pdf','2024-04-04',2),(3,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 3','PDF','/files/clm0003_doc.pdf','2024-04-05',3),(4,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 4','PDF','/files/clm0004_doc.pdf','2024-04-06',4),(5,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 5','PDF','/files/clm0005_doc.pdf','2024-04-07',5),(6,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 6','PDF','/files/clm0006_doc.pdf','2024-04-08',6),(7,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 7','PDF','/files/clm0007_doc.pdf','2024-04-09',7),(8,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 8','PDF','/files/clm0008_doc.pdf','2024-04-10',8),(9,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 9','PDF','/files/clm0009_doc.pdf','2024-04-11',9),(10,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 10','PDF','/files/clm0010_doc.pdf','2024-04-12',10),(11,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 11','PDF','/files/clm0011_doc.pdf','2024-04-13',11),(12,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 12','PDF','/files/clm0012_doc.pdf','2024-04-14',12),(13,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 13','PDF','/files/clm0013_doc.pdf','2024-04-15',13),(14,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 14','PDF','/files/clm0014_doc.pdf','2024-04-16',14),(15,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 15','PDF','/files/clm0015_doc.pdf','2024-04-17',15),(16,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 16','PDF','/files/clm0016_doc.pdf','2024-04-18',16),(17,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 17','PDF','/files/clm0017_doc.pdf','2024-04-19',17),(18,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 18','PDF','/files/clm0018_doc.pdf','2024-04-20',18),(19,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 19','PDF','/files/clm0019_doc.pdf','2024-04-21',19),(20,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 20','PDF','/files/clm0020_doc.pdf','2024-04-22',20),(21,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 21','PDF','/files/clm0021_doc.pdf','2024-04-23',21),(22,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 22','PDF','/files/clm0022_doc.pdf','2024-04-24',22),(23,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 23','PDF','/files/clm0023_doc.pdf','2024-04-25',23),(24,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 24','PDF','/files/clm0024_doc.pdf','2024-04-26',24),(25,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 25','PDF','/files/clm0025_doc.pdf','2024-04-27',25),(26,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 26','PDF','/files/clm0026_doc.pdf','2024-04-28',26),(27,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 27','PDF','/files/clm0027_doc.pdf','2024-04-29',27),(28,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 28','PDF','/files/clm0028_doc.pdf','2024-04-02',28),(29,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 29','PDF','/files/clm0029_doc.pdf','2024-04-03',29),(30,NULL,NULL,NULL,NULL,NULL,'Giấy tờ minh chứng 30','PDF','/files/clm0030_doc.pdf','2024-04-04',30);
/*!40000 ALTER TABLE `claim_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim_status`
--

DROP TABLE IF EXISTS `claim_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `claim_status` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_status`
--

LOCK TABLES `claim_status` WRITE;
/*!40000 ALTER TABLE `claim_status` DISABLE KEYS */;
INSERT INTO `claim_status` VALUES (1,NULL,NULL,NULL,NULL,NULL,'NEW','Yêu cầu mới'),(2,NULL,NULL,NULL,NULL,NULL,'APPROVED','Đã duyệt'),(3,NULL,NULL,NULL,NULL,NULL,'REJECTED','Bị từ chối');
/*!40000 ALTER TABLE `claim_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_number` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,NULL,NULL,NULL,NULL,NULL,'123 Le Loi, HCM','Vietcombank','001100001','a.nguyen@example.com','Nguyen Van A','0909123456'),(2,NULL,NULL,NULL,NULL,NULL,'45 Hai Ba Trung, HN','ACB','002200002','b.tran@example.com','Tran Thi B','0909988776'),(3,NULL,NULL,NULL,NULL,NULL,'12 Pham Van Dong, Da Nang','Techcombank','003300003','c.le@example.com','Le Van C','0911223344'),(4,NULL,NULL,NULL,NULL,NULL,'78 Tran Hung Dao, HCM','BIDV','004400004','d.pham@example.com','Pham Thi D','0933445566'),(5,NULL,NULL,NULL,NULL,NULL,'99 Nguyen Trai, HN','VIB','005500005','e.hoang@example.com','Hoang Van E','0944556677'),(6,NULL,NULL,NULL,NULL,NULL,'88 Dinh Tien Hoang, HCM','Sacombank','006600006','f.nguyen@example.com','Nguyen Thi F','0955667788'),(7,NULL,NULL,NULL,NULL,NULL,'56 Le Duan, Hue','MB Bank','007700007','g.do@example.com','Do Van G','0966778899'),(8,NULL,NULL,NULL,NULL,NULL,'30 Vo Van Tan, Can Tho','VPBank','008800008','h.dang@example.com','Dang Thi H','0977889900'),(9,NULL,NULL,NULL,NULL,NULL,'10 Tran Phu, Hai Phong','SHB','009900009','i.vu@example.com','Vu Van I','0988990011'),(10,NULL,NULL,NULL,NULL,NULL,'15 Cach Mang Thang 8, HCM','TPBank','010100010','j.ly@example.com','Ly Thi J','0999001122');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance_product`
--

DROP TABLE IF EXISTS `insurance_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `coverage` varchar(255) DEFAULT NULL,
  `description` text,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance_product`
--

LOCK TABLES `insurance_product` WRITE;
/*!40000 ALTER TABLE `insurance_product` DISABLE KEYS */;
INSERT INTO `insurance_product` VALUES (1,NULL,NULL,NULL,NULL,NULL,'Tai nạn, cháy nổ','Bảo hiểm trách nhiệm dân sự cho xe máy','Bảo hiểm xe máy'),(2,NULL,NULL,NULL,NULL,NULL,'Tai nạn, mất cắp, thiên tai','Bảo hiểm toàn diện cho xe ô tô','Bảo hiểm ô tô'),(3,NULL,NULL,NULL,NULL,NULL,'Khám ngoại trú, nội trú','Bảo hiểm khám chữa bệnh','Bảo hiểm sức khỏe'),(4,NULL,NULL,NULL,NULL,NULL,'Tử vong, tai nạn','Chi trả khi tử vong hoặc thương tật','Bảo hiểm nhân thọ'),(5,NULL,NULL,NULL,NULL,NULL,'Mất hành lý, tai nạn, trễ chuyến','Hỗ trợ chi phí phát sinh khi đi du lịch','Bảo hiểm du lịch');
/*!40000 ALTER TABLE `insurance_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin','2025-04-14 18:56:00.000000',_binary '\0','admin','2025-04-14 18:56:12.000000','ADMIN','admin'),(2,'admin','2025-04-14 18:56:02.000000',_binary '\0','admin','2025-04-14 18:56:14.000000','USER','user');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(3,1),(2,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mime_type` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `path_avatar` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'Head Office','USR00123','admin@example.com','Admin','System',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0909111222','admin'),(2,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'HCM','USR00124','sales1@example.com','Nguyen','Sales',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0911001100','sales1'),(3,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'HN','USR00125','agent1@example.com','Tran','Agent',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0912002200','agent1'),(4,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'Da Nang','USR00126','support1@example.com','Le','Support',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0913003300','support1'),(5,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'HCM','USR00127','claims1@example.com','Pham','Claims',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0914004400','claims1'),(6,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'Hue','USR00128','user1@example.com','Do','Customer',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0915005500','user1'),(7,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'Can Tho','USR00129','user2@example.com','Dang','Customer',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0916006600','user2'),(8,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'Hai Phong','USR00130','user3@example.com','Vu','Customer',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0917007700','user3'),(9,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'Quang Ninh','USR00131','user4@example.com','Ly','Customer',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0918008800','user4'),(10,NULL,'2025-06-05 21:14:16.000000',NULL,NULL,NULL,'HCM','USR00132','user5@example.com','Ngo','Customer',NULL,'$2a$10$XaDucyGIeUNE3CXL1TmgE.dzIkaKN.G3K1Ak6sw193bl4qEngRHl6',NULL,'0919009900','user5');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-15 15:35:22
