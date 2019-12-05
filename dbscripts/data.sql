-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: smartshop
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Dumping data for table `bill_history`
--

LOCK TABLES `bill_history` WRITE;
/*!40000 ALTER TABLE `bill_history` DISABLE KEYS */;
INSERT INTO `bill_history` VALUES (6,'2019-12-01',5,'A1','user'),(3,'2019-12-01',2,'A2','user'),(8,'2019-12-01',1,'A15','user'),(7,'2019-12-01',1,'A2','user'),(1,'2019-12-02',1,'A2','user'),(2,'2019-12-02',1,'A13','user'),(4,'2019-12-03',5,'A10','user'),(5,'2019-12-03',5,'A10','user');
/*!40000 ALTER TABLE `bill_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (6);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('A1','Laptop','Dell',45000,25,'2019-11-20','two','third','2019-08-01','2019-11-22','https://images.unsplash.com/photo-1565375706404-082d37dd1f5d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Electronics',NULL),('A10','Milk','Heritage',24,10,'2019-11-20','two','first','2019-07-14','2019-11-22','https://images.unsplash.com/photo-1563636619-e9143da7973b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Grocery',NULL),('A11','Bread','britania',45,30,'2019-11-20','three','fourth','2019-09-13','2019-11-22','https://images.unsplash.com/photo-1547033965-5dd4885e88ae?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Grocery',NULL),('A12','Cereal','complan',120,22,'2019-11-20','four','fifth','2019-11-14','2019-11-22','https://cdn.britannica.com/90/94190-050-C0BA6A58/Cereal-crops-wheat-reproduction.jpg','Grocery',NULL),('A13','coke','cocola',25,30,'2019-11-20','five','third','2019-11-12','2019-11-22','https://images.unsplash.com/photo-1554866585-cd94860890b7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Grocery',NULL),('A14','Refrigerator','samsung',25000,5,'2019-11-20','two','second','2019-11-14','2019-11-22','https://images.unsplash.com/photo-1542331325-bebfc9b990d7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Appliances',NULL),('A15','Microwave','samsung',10000,4,'2019-11-20','four','sixth','2019-10-29','2019-11-22','https://images.unsplash.com/photo-1574269909862-7e1d70bb8078?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Appliances',NULL),('A16','waterheater','aquaguard',4000,18,'2019-11-20','seven','eight','2019-11-16','2019-11-22','https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQhFPW1DyWreY-p-ZOFoV1hluGceQo1iT5XfbrKkIIGHy_W_Hndk5easCLVeJPiTz-Rm34gHrtD4UmX4fo2H11PGtLFe114Q_OBK-21in6_ro5Nngie60_q&usqp=CAc','Appliances',NULL),('A17','kettle','aquaguard',1000,12,'2019-11-20','four','second','2019-11-10','2019-11-22','https://images.unsplash.com/photo-1565006886707-b7834d18525e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Appliances',NULL),('A2','MobilePhone','One plus',38000,12,'2019-11-20','four','second','2019-11-14','2019-11-21','https://images.unsplash.com/photo-1533160772606-ba8c6a74d336?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Electronics',NULL),('A3','Ipod','apple',15000,19,'2019-11-22','five','third','2019-11-21','2019-11-21','https://images.unsplash.com/photo-1560994470-52f147e76d1c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Electronics',NULL),('A4','Camera','sony',6000,5,'2019-11-20','one','fifth','2019-10-14','2019-11-22','https://images.unsplash.com/photo-1519638831568-d9897f54ed69?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Electronics',NULL),('A5','Fan','usha',2800,10,'2019-11-20','two','four','2019-09-14','2019-11-22','https://images.unsplash.com/photo-1559536207-e64933d5798b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Electronics',NULL),('A6','slippers','crocs',1500,5,'2019-11-20','one','second','2019-07-14','2019-11-22','https://images.unsplash.com/photo-1456163195787-d80d558a2786?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Fashion',NULL),('A7','shirt','levis',800,6,'2019-11-20','four','fifth','2019-11-14','2019-11-22','https://images.unsplash.com/flagged/photo-1564468781192-f023d514222d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Fashion',NULL),('A8','jeans','lee cooper',1200,8,'2019-11-20','six','third','2019-11-23','2019-11-22','https://images.unsplash.com/photo-1565084888279-aca607ecce0c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Fashion',NULL),('A9','watch','titan',2500,10,'2019-11-20','seven','second','2019-08-15','2019-11-22','https://images.unsplash.com/photo-1451290337906-ac938fc89bce?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60','Fashion',NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'user'),(2,'superuser'),(3,'admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('admin','admin','admin',23,'male','4444444444','$2a$10$.S5.ltkrkde9P0NWUnNjmefxUYGH2Aj0E1Gl4t3eBC8rGUFXH5EOa','A','D'),('admin2','ravi','teja',22,'Male','984028','$2a$10$EECLqPTbIV3s.gHfs5XHCuy3vqoZUEmLLPiB28XHIVgVKYgv.VF6e','A','P'),('checker',NULL,NULL,25,NULL,'0','$2a$10$TR9nglAZpkWJZz.aKPen5e1gwIFY1t4Qi/b8z7wgozey3S.vCJYl.','U','A'),('king',NULL,NULL,0,NULL,'0','$2a$10$y7g6qXC3T7BMKQnY8uX25OZO76O5NZkpOLPr/CRWvHaNTcDv/EyXy','U','A'),('lionsraviteja',NULL,NULL,0,NULL,'0','$2a$10$2jl6K6SQaRcGJ1ThgyFWme.NLlbBAHcodALcos90ZnIcF3gD1t2.W','U','A'),('new',NULL,NULL,0,NULL,'0','$2a$10$8dXni09HPXPJBl9nLfkMVuGaVU0nrS6nAiWq9oRplfz07v.KcVjOi','U','A'),('now','now','now',22,'Male','9840282567','$2a$10$2umgcK/xAttGmfESmS8eb.cXnHCHDVHaLqoZUWGBzUAxOuQa7lUXq','U','A'),('one',NULL,NULL,0,NULL,'0','$2a$10$ak.7oDVaeeMbnrkS9bGDOec2jTgdUxxq6FjlH0a3AnJeJaZZvJaZ.','A','P'),('onemore',NULL,NULL,22,'Male','0','$2a$10$5ozXFAfZP8giteXgSsNjP.fEQC5qYUaImubdXcdq.PgCkWGeroh3S','U','A'),('ravi','ravi','ravi',22,'Male','7673927057','$2a$10$4qWdVqY9TSOqRoEbck.toOY9xRik7GnqC8U5FAqmnlXH2hxuWNpVK','A','P'),('raviteja',NULL,NULL,0,NULL,'0','$2a$10$fhPZlws53uoPnwADcg6W9O.PWqBMfG0q2i87h8r0VFoGrBCDFpluS','U','A'),('superuser','abd','abd',34,'male','55555555555','$2a$10$.S5.ltkrkde9P0NWUnNjmefxUYGH2Aj0E1Gl4t3eBC8rGUFXH5EOa','A','A'),('user','ravi','teja',21,'male','9840282403','$2a$10$.S5.ltkrkde9P0NWUnNjmefxUYGH2Aj0E1Gl4t3eBC8rGUFXH5EOa','A','U');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'user',1),(2,'lionsraviteja',1),(3,'raviteja',1),(4,'new',1),(5,'king',1),(6,'checker',1),(7,'onemore',1),(8,'now',1),(9,'superuser',2),(10,'admin',3),(11,'admin2',2),(12,'ravi',3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-03 15:12:09
