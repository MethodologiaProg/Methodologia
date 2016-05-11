-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Dumping data for table methprog.comments: ~11 rows (approximately)
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` (`id`, `senter`, `entry`, `message`) VALUES
	(1, 1, 1, 'This is a test Comment 1'),
	(2, 3, 1, 'Test comment 2'),
	(3, 2, 2, 'This is another comment'),
	(4, 12, 1, 'One more comment'),
	(5, 1, 1, 'Test Comment 3'),
	(6, 1, 1, 'Test Comment 4'),
	(7, 1, 1, 'Test Comment 5'),
	(8, 1, 1, 'Test Comment 6'),
	(9, 1, 4, 'Hello there! Nice house!!!'),
	(10, 1, 5, 'test comment123 df a'),
	(11, 1, 2, 'Nice house you got there'),
	(12, 3, 4, 'Is this a quite neighborhood?'),
	(13, 8, 1, 'Hello world');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;

-- Dumping data for table methprog.entries: ~12 rows (approximately)
/*!40000 ALTER TABLE `entries` DISABLE KEYS */;
INSERT INTO `entries` (`id`, `user`, `address`, `city`, `country`, `price`, `title`, `description`, `photo`) VALUES
	(1, 1, 'Miaouli', 'Serres', 'Greece', 20000, 'Pwleitai Neoktisto sto Kentro', 'Νεόκτιστο στο κέντρο των Σερρών. 2 δωμάτια, σαλοκουζινα, wc, μεγάλο μπαλκόνι', 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\entries\\1.jpg'),
	(2, 2, 'Kountouriotou', 'Thessaloniki', 'Greece', 220, 'Enoikiazetai Studio idaniko gia foitites', 'Studio 50τμ, Επιπλωμένο με κρεβάτι, κουζινα, γραφειο, ντουλάπα και μπάνιιο με ντουζ. Χαμηλά κοινόχρηστα', 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\entries\\2.jpg'),
	(3, 3, 'Thessalonikis', 'Serres', 'Greece', 15000, 'Pwleitai Epiplomeno Triari', 'Τριάρι επιπλωμένο σε πολυ καλή κατάσταση. Ιδανικό για οικογένειες. Σε καλή περιοχή κοντά σε σχολείο', 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\entries\\3.jpg'),
	(4, 1, 'Agiou Dimitriou', 'Thessaloniki', 'Greece', 36000, 'A title', 'A description ', 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\entries\\4.jpg'),
	(5, 2, 'Kostopoulou', 'Serres', 'Greece', 160, 'Some Title', 'Some description', 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\entries\\5.jpg'),
	(6, 1, 'Merarxias', 'Serres', 'Greece', 200, 'Τίτλος', 'Περιγραφή', 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\entries\\6.jpg'),
	(7, 12, 'Aristotelous 14', 'Athens', 'Greece', 8124, 'Test Title 1', 'Test description 1', 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\entries\\7.jpg'),
	(8, 7, 'Korai', 'Thessaloniki', 'Greece', 7, 'Test entry', 'asdfaerg aerg swe sg wefg sfg werg sdfgea asdg dafg awer gscfgv eargsdg ergasdfg aer ', 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\entries\\8.jpg'),
	(9, 11, 'Plastira', 'Thessaloniki', 'Greece', 47512, 'Test Entry no 3', 'This is another one description', 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\entries\\no_photo.png'),
	(10, 8, 'Makedonomaxwn', 'Kavala', 'Greece', 12345, 'test', 'test', 'C:/Users/Hrystos/Documents/NetBeansProjects/Methodologia/photos/entries/no_photo.png'),
	(11, 7, 'sdf', 'asdfa', 'asdf', 32456, 'asdfer', 'asdfe', 'C:/Users/Hrystos/Documents/NetBeansProjects/Methodologia/photos/entries/no_photo.png'),
	(12, 11, 'asdfae', 'asdf', 'asdf', 65432, 'asdfasdf', 'efasefsda', 'C:/Users/Hrystos/Documents/NetBeansProjects/Methodologia/photos/entries/no_photo.png');
/*!40000 ALTER TABLE `entries` ENABLE KEYS */;

-- Dumping data for table methprog.intrest: ~8 rows (approximately)
/*!40000 ALTER TABLE `intrest` DISABLE KEYS */;
INSERT INTO `intrest` (`id`, `userId`, `entryId`) VALUES
	(1, 1, 1),
	(2, 1, 7),
	(3, 2, 5),
	(4, 2, 1),
	(5, 1, 2),
	(6, 1, 3),
	(7, 1, 4),
	(8, 1, 2),
	(9, 1, 3);
/*!40000 ALTER TABLE `intrest` ENABLE KEYS */;

-- Dumping data for table methprog.users: ~9 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `password`, `first_name`, `last_name`, `birth_date`, `profile_pic`) VALUES
	(1, 'user1@methprog.com', 'user1', 'Maria', 'Maraki', NULL, 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\users\\1.jpg'),
	(2, 'user3@methprog.com', '1234', 'Pakis', 'Papadopoulos', NULL, 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\users\\2.jpg'),
	(3, 'user2@methprog.com', 'user2', 'Kiki', 'Xatzi', NULL, 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\users\\3.jpg'),
	(7, 'user4@methprog.com', 'user4@methprog.com', 'Xaralampos', 'Xaralampous', NULL, 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\users\\no_photo.png'),
	(8, 'user5@methprog.com', 'user5', 'Mixalis', 'Mixalios', NULL, 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\users\\no_photo.png'),
	(11, 'user6@methprog.com', 'user6', 'Afroditi', 'Milioti', NULL, 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\users\\no_photo.png'),
	(12, 'user7@methprog.com', 'user7', 'Aris', 'Pylidis', NULL, 'C:\\Users\\Hrystos\\Documents\\NetBeansProjects\\Methodologia\\photos\\users\\7.jpg'),
	(13, 'user10@methprog.com', 'user10', 'Nick', 'Papadopoulos', NULL, 'C:/Users/Hrystos/Documents/NetBeansProjects/Methodologia/photos/users/no_photo.png');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
