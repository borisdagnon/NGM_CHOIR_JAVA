-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 24 fév. 2018 à 11:17
-- Version du serveur :  5.7.21-log
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `graceetfoi`
--

-- --------------------------------------------------------

--
-- Structure de la table `video`
--

DROP TABLE IF EXISTS `video`;
CREATE TABLE IF NOT EXISTS `video` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `lien` varchar(40) DEFAULT NULL,
  `annee` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `video_lien_uindex` (`lien`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `video`
--

INSERT INTO `video` (`id`, `lien`, `annee`) VALUES
(1, 'Gpyg8opOWpw', '2018'),
(2, 'ftXiMuS8Cvs', '2018'),
(3, '1XGeI8v0mQM', '2017'),
(4, 'XKJ5fAU8Wz4', '2017'),
(5, 'ip3MH9oLkpo', '2017'),
(6, 'fUjHNzXaum4', '2017'),
(7, 'Vvm8snBfaqU', '2017'),
(8, 'JBH5EPgywcQ', '2017'),
(9, 'X4CJ_T_DTfU', '2017'),
(10, '7N2PacVYOfA', '2017'),
(11, 'XNLA8fjdS_A', '2017'),
(12, 'eNMZT5V3Ucs', '2017'),
(13, 'oVfB0gAL2Tk', '2017'),
(14, '9Scfv7t2ans', '2017'),
(15, 'Nwz5sVkawXk', '2017'),
(16, 'HkmvRP0AHKM', '2017'),
(17, 'rLAXDtMcy48', '2017'),
(18, '3Klm9e_u3bk', '2017'),
(19, 'reo8Hb0SCXM', '2017'),
(20, 'jd_oM4suS1g', '2017'),
(21, 'oBis90Td4gA', '2017'),
(22, 'nk7tvrdegdM', '2017'),
(23, 'cus2vpZLddE', '2017'),
(24, 'BqCMcyci3PY', '2017'),
(25, 'Ka7ImCyNSnM', '2017'),
(26, '9CVVgdWTTXs', '2017');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
