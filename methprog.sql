-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for methprog
CREATE DATABASE IF NOT EXISTS `methprog` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `methprog`;


-- Dumping structure for table methprog.entries
CREATE TABLE IF NOT EXISTS `entries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `address` text COLLATE utf8_unicode_ci NOT NULL,
  `city` text COLLATE utf8_unicode_ci NOT NULL,
  `country` text COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) DEFAULT NULL,
  `title` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`),
  KEY `FK__users` (`user`),
  CONSTRAINT `FK__users` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table methprog.entries: ~7 rows (approximately)
/*!40000 ALTER TABLE `entries` DISABLE KEYS */;
INSERT INTO `entries` (`id`, `user`, `address`, `city`, `country`, `price`, `title`) VALUES
	(1, 1, 'Miaouli', 'Serres', 'Greece', 20000, 'Pwleitai Neoktisto sto Kentro'),
	(2, 2, 'Kountouriotou', 'Thessaloniki', 'Greece', 220, 'Enoikiazetai Studio idaniko gia foitites'),
	(3, 3, 'Thessalonikis', 'Serres', 'Greece', 15000, 'Pwleitai Epiplomeno Triari'),
	(4, 1, 'Agiou Dimitriou', 'Thessaloniki', 'Greece', 36000, 'A title'),
	(5, 2, 'Kostopoulou', 'Serres', 'Greece', 160, 'Some Title'),
	(6, 1, 'Merarxias', 'Serres', 'Greece', 200, 'Τίτλος'),
	(7, 12, 'Aristotelous 14', 'Athens', 'Greece', 8124, 'Test Title 1');
/*!40000 ALTER TABLE `entries` ENABLE KEYS */;


-- Dumping structure for table methprog.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` text COLLATE utf8_unicode_ci NOT NULL,
  `password` text COLLATE utf8_unicode_ci NOT NULL,
  `first_name` text COLLATE utf8_unicode_ci NOT NULL,
  `last_name` text COLLATE utf8_unicode_ci NOT NULL,
  `birth_date` text COLLATE utf8_unicode_ci,
  `profile_pic` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table methprog.users: ~7 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `password`, `first_name`, `last_name`, `birth_date`, `profile_pic`) VALUES
	(1, 'user1@methprog.com', 'user1', 'Maria', 'Maraki', NULL, NULL),
	(2, 'user1@methprog.com', '1234', 'Pakis', 'Papadopoulos', NULL, NULL),
	(3, 'user2@methprog.com', 'user2', 'Kiki', 'Xatzi', NULL, NULL),
	(7, 'user4@methprog.com', 'user4@methprog.com', 'Xaralampos', 'Xaralampous', NULL, NULL),
	(8, 'user5@methprog.com', 'user5', 'Mixalis', 'Mixalios', NULL, NULL),
	(11, 'user6@methprog.com', 'user6', 'Afroditi', 'Milioti', NULL, NULL),
	(12, 'user7@methprog.com', 'user7', 'Aris', 'Pylidis', NULL, NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
