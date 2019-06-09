-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  Dim 09 juin 2019 à 18:29
-- Version du serveur :  10.1.38-MariaDB
-- Version de PHP :  7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `school`
--

-- --------------------------------------------------------

--
-- Structure de la table `class`
--

CREATE TABLE `class` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `level_id` int(11) NOT NULL,
  `school_id` int(11) NOT NULL,
  `school_year_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `class`
--

INSERT INTO `class` (`id`, `name`, `level_id`, `school_id`, `school_year_id`) VALUES
(68, 'CPA', 18, 58, 2019),
(69, 'CPB', 18, 58, 2019),
(70, 'CE1A', 19, 58, 2019),
(71, 'CE1B', 19, 58, 2019),
(72, 'Terminale L', 30, 66, 2018),
(89, 'Terminale S', 30, 66, 2018),
(94, '6èmeA', 23, 61, 2017),
(95, '6èmeB', 23, 61, 2017),
(148, '5èmeA', 24, 66, 2016),
(149, 'Terminale ES', 30, 64, 2020);

-- --------------------------------------------------------

--
-- Structure de la table `grade`
--

CREATE TABLE `grade` (
  `id` int(11) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  `value` double NOT NULL,
  `report_card_detail_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `grade`
--

INSERT INTO `grade` (`id`, `appreciation`, `value`, `report_card_detail_id`) VALUES
(154, 'Très bien', 18, 153),
(155, 'Bien', 15, 153),
(161, 'Bien', 15, 160),
(162, 'OK', 14, 160),
(164, 'OK', 12.5, 163),
(165, 'Peut faire mieux', 11.5, 163),
(167, 'Court très vite', 20, 166);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(168),
(168),
(168),
(168),
(168),
(168),
(168),
(168),
(168),
(168),
(168),
(168),
(100),
(100),
(100),
(100),
(100),
(100),
(100),
(100),
(100),
(100),
(100),
(100);

-- --------------------------------------------------------

--
-- Structure de la table `level`
--

CREATE TABLE `level` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `level`
--

INSERT INTO `level` (`id`, `name`) VALUES
(18, 'CP'),
(19, 'CE1'),
(20, 'CE2'),
(21, 'CM1'),
(22, 'CM2'),
(23, '6ème'),
(24, '5ème'),
(25, '4ème'),
(27, '3ème'),
(28, '2nde'),
(29, '1ère'),
(30, 'Terminale');

-- --------------------------------------------------------

--
-- Structure de la table `quarter`
--

CREATE TABLE `quarter` (
  `id` int(11) NOT NULL,
  `end_date` date NOT NULL,
  `number` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `school_year_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `quarter`
--

INSERT INTO `quarter` (`id`, `end_date`, `number`, `start_date`, `school_year_id`) VALUES
(33, '2018-12-18', 1, '2018-08-29', 2019),
(34, '2019-03-28', 2, '2018-12-31', 2019),
(35, '2019-06-27', 3, '2019-03-31', 2019),
(36, '2019-12-26', 1, '2019-09-01', 2020),
(37, '2020-04-02', 2, '2020-01-05', 2020),
(38, '2020-07-01', 3, '2020-04-05', 2020);

-- --------------------------------------------------------

--
-- Structure de la table `registration`
--

CREATE TABLE `registration` (
  `id` int(11) NOT NULL,
  `timestamp` datetime NOT NULL,
  `c_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `registration`
--

INSERT INTO `registration` (`id`, `timestamp`, `c_id`, `student_id`) VALUES
(139, '2019-06-09 16:21:36', 68, 32),
(140, '2019-06-09 16:21:39', 68, 31),
(141, '2019-06-09 16:21:42', 68, 33),
(142, '2019-06-09 16:21:44', 68, 34),
(143, '2019-06-09 16:21:48', 68, 35),
(144, '2019-06-09 16:21:56', 69, 36),
(145, '2019-06-09 16:22:00', 69, 37),
(146, '2019-06-09 16:22:05', 69, 38),
(147, '2019-06-09 16:22:15', 69, 39);

-- --------------------------------------------------------

--
-- Structure de la table `report_card`
--

CREATE TABLE `report_card` (
  `id` int(11) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  `quarter_id` int(11) NOT NULL,
  `registration_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `report_card`
--

INSERT INTO `report_card` (`id`, `appreciation`, `quarter_id`, `registration_id`) VALUES
(150, 'Bien', 33, 147);

-- --------------------------------------------------------

--
-- Structure de la table `report_card_detail`
--

CREATE TABLE `report_card_detail` (
  `id` int(11) NOT NULL,
  `appreciation` varchar(255) DEFAULT NULL,
  `report_card_id` int(11) NOT NULL,
  `teaching_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `report_card_detail`
--

INSERT INTO `report_card_detail` (`id`, `appreciation`, `report_card_id`, `teaching_id`) VALUES
(153, 'Très bien', 150, 151),
(160, 'Travaille bien', 150, 156),
(163, 'Passable', 150, 157),
(166, 'Court vite', 150, 159);

-- --------------------------------------------------------

--
-- Structure de la table `school`
--

CREATE TABLE `school` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `school`
--

INSERT INTO `school` (`id`, `name`) VALUES
(58, 'Archbishop Carroll High School'),
(59, 'Anacostia High School'),
(60, 'Ballou High School'),
(61, 'BASIS Washington DC'),
(62, 'Bell High School'),
(63, 'Benjamin Banneker Academic High School'),
(64, 'Booker T. Washington Public Charter School'),
(65, 'British International School of Washington'),
(66, 'Capital City Public Charter School'),
(67, 'Columbia Heights Education Campus');

-- --------------------------------------------------------

--
-- Structure de la table `school_year`
--

CREATE TABLE `school_year` (
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `school_year`
--

INSERT INTO `school_year` (`id`) VALUES
(2010),
(2011),
(2012),
(2013),
(2014),
(2015),
(2016),
(2017),
(2018),
(2019),
(2020);

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `forename` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `student`
--

INSERT INTO `student` (`id`, `forename`, `name`) VALUES
(32, 'Anderson', 'Doris'),
(31, 'Tammy', 'Hall'),
(33, 'Peter', 'Miller'),
(34, 'Robert', 'Parker'),
(35, 'Jack', 'Ward'),
(36, 'Cynthia', 'Evans'),
(37, 'Raymond', 'Thomas'),
(38, 'Matthew', 'Ramirez'),
(39, 'Roy', 'Wood'),
(40, 'Anthony', 'Sanders'),
(41, 'Marilyn', 'Walker'),
(42, 'Helen', 'White'),
(43, 'Timothy', 'Carter'),
(44, 'Victor', 'Russell'),
(45, 'Albert', 'Davis'),
(46, 'Rebecca', 'Smith'),
(47, 'Nicole', 'Cook'),
(48, 'Patrick', 'Edwards'),
(49, 'Cheryl', 'Turner'),
(50, 'Teresa', 'Barnes'),
(51, 'Raheem', 'Emmerich'),
(52, 'Jessie', 'Tillman'),
(53, 'Madisen', 'Lakin'),
(68, 'Alma', 'Wong'),
(69, 'Lexi', 'Cohen'),
(70, 'Rory', 'Woodard'),
(71, 'Makena', 'Holmes'),
(72, 'Aryana', 'Sosa'),
(73, 'Kian', 'Foley');

-- --------------------------------------------------------

--
-- Structure de la table `subject`
--

CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `subject`
--

INSERT INTO `subject` (`id`, `name`) VALUES
(1, 'Mathématiques'),
(2, 'Physique'),
(3, 'Histoire'),
(6, 'Latin'),
(5, 'Espagnol'),
(7, 'Allemand'),
(8, 'Français'),
(9, 'Géographie'),
(10, 'SVT'),
(11, 'Economie'),
(12, 'EPS');

-- --------------------------------------------------------

--
-- Structure de la table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `forename` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `teacher`
--

INSERT INTO `teacher` (`id`, `forename`, `name`) VALUES
(52, 'Philip', 'Price'),
(53, 'Richard', 'Perry'),
(54, 'Edward', 'Jackson'),
(55, 'Samuel', 'Long'),
(56, 'Linda', 'Coleman'),
(57, 'Bonnie', 'Bailey');

-- --------------------------------------------------------

--
-- Structure de la table `teaching`
--

CREATE TABLE `teaching` (
  `id` int(11) NOT NULL,
  `c_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `teaching`
--

INSERT INTO `teaching` (`id`, `c_id`, `subject_id`, `teacher_id`) VALUES
(151, 68, 1, 52),
(152, 69, 1, 52),
(156, 69, 2, 53),
(157, 69, 3, 52),
(158, 69, 6, 54),
(159, 69, 12, 55);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpfjncv5ln9j792r2v5mlgd0e9` (`level_id`),
  ADD KEY `FK96x0psi3ip7rge1n5ubwbhe3y` (`school_id`),
  ADD KEY `FKlxfrw17pvk7lsbucsjjyh3phq` (`school_year_id`);

--
-- Index pour la table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtk172kgfotk0cwe7e6slmxewr` (`report_card_detail_id`);

--
-- Index pour la table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `quarter`
--
ALTER TABLE `quarter`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2carfduvvqdjbi7qd77hg8a14` (`school_year_id`);

--
-- Index pour la table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9pm7rshqg231dxpnbyc1uab7y` (`c_id`),
  ADD KEY `FKcxvegulu1x4mjcvy3116tu5xu` (`student_id`);

--
-- Index pour la table `report_card`
--
ALTER TABLE `report_card`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKitf384a6c72t86orcwmqm79e5` (`quarter_id`),
  ADD KEY `FKjn8aj0j6b18va9gbbkbpobtxe` (`registration_id`);

--
-- Index pour la table `report_card_detail`
--
ALTER TABLE `report_card_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsh8g91rx5pigqkmryf1y9l626` (`report_card_id`),
  ADD KEY `FK21n6n6snwtom4gmfyh9uq5b4n` (`teaching_id`);

--
-- Index pour la table `school`
--
ALTER TABLE `school`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `school_year`
--
ALTER TABLE `school_year`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `teaching`
--
ALTER TABLE `teaching`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmihk58c0e1jtb10a00s5y57s8` (`c_id`),
  ADD KEY `FK6bvmkioymouqgr2pm18ur4nc8` (`subject_id`),
  ADD KEY `FKelw4652f7vqsosnnbs4vj7wmb` (`teacher_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
