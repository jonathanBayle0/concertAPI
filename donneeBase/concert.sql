-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 03 mars 2023 à 10:13
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `concert`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_concert_con`
--

DROP TABLE IF EXISTS `t_concert_con`;
CREATE TABLE IF NOT EXISTS `t_concert_con` (
  `con_id` bigint(20) NOT NULL,
  `con_date_debut` datetime(6) DEFAULT NULL,
  `con_date_fin` datetime(6) DEFAULT NULL,
  `gro_id` bigint(20) DEFAULT NULL,
  `soi_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `t_concert_con`
--

INSERT INTO `t_concert_con` (`con_id`, `con_date_debut`, `con_date_fin`, `gro_id`, `soi_id`) VALUES
(1, '2023-02-21 15:05:00.000000', '2023-02-21 17:05:00.000000', 1, 1),
(2, '2023-02-21 18:05:00.000000', '2023-02-21 19:05:00.000000', 1, 1),
(3, '2023-02-21 13:05:00.000000', '2023-02-21 14:05:00.000000', 3, 2),
(4, '2023-02-21 12:05:00.000000', '2023-02-21 13:35:00.000000', 5, 3),
(5, '2023-02-21 23:05:00.000000', '2023-02-22 00:35:00.000000', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `t_salle_sal`
--

DROP TABLE IF EXISTS `t_salle_sal`;
CREATE TABLE IF NOT EXISTS `t_salle_sal` (
  `sal_id` bigint(20) NOT NULL,
  `sal_adresse` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sal_association` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sal_capacite` int(11) DEFAULT NULL,
  `sal_nom` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sal_nom_gestionnaire` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sal_prenom_gestionnaire` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `t_salle_sal`
--

INSERT INTO `t_salle_sal` (`sal_id`, `sal_adresse`, `sal_association`, `sal_capacite`, `sal_nom`, `sal_nom_gestionnaire`, `sal_prenom_gestionnaire`) VALUES
(1, '15 rue Lanredec, 29200, Brest', 'Les Restos du Coeur', 7, 'RestoCoeur', 'Colucci', 'Michel'),
(2, '15 rue agora, 29150, Chateaulin', '', 50, 'Agora', 'LeTout', 'Claude'),
(8, '16, 29290, Briec', '', 15, 'RunArePuns', 'Murphy', 'Eddy');

-- --------------------------------------------------------

--
-- Structure de la table `t_soiree_soi`
--

DROP TABLE IF EXISTS `t_soiree_soi`;
CREATE TABLE IF NOT EXISTS `t_soiree_soi` (
  `soi_id` bigint(20) NOT NULL,
  `sal_id` bigint(20) DEFAULT NULL,
  `soi_date_debut` datetime(6) DEFAULT NULL,
  `soi_date_fin` datetime(6) DEFAULT NULL,
  `soi_nom` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `soi_prix` double DEFAULT NULL,
  PRIMARY KEY (`soi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `t_soiree_soi`
--

INSERT INTO `t_soiree_soi` (`soi_id`, `sal_id`, `soi_date_debut`, `soi_date_fin`, `soi_nom`, `soi_prix`) VALUES
(1, 1, '2023-02-22 12:32:37.000000', '2023-02-25 12:32:37.000000', 'TheSoiree', 40),
(2, 2, '2023-03-22 12:32:37.000000', '2023-03-25 12:32:37.000000', 'TheSoiree2', 30),
(3, 2, '2023-04-22 13:32:37.000000', '2023-04-25 13:32:37.000000', 'TheSoiree3', 35);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
