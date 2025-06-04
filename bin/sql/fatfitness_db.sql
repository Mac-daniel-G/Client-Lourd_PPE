-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 10 avr. 2025 à 11:31
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `fatfitness_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `tel` varchar(20) NOT NULL
);

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`idAdmin`, `nom`, `prenom`, `role`, `email`, `mdp`, `tel`) VALUES
(1, 'Ghotu', 'Mac Daniel', 'Super Admin', 'admin@fatfitness.com', '000', '0123456789'),
(2, 'Smith', 'John', 'Manager', 'john.smith@fatfitness.com', '1234', '0678945612');

-- --------------------------------------------------------

--
-- Structure de la table `boutique`
--

CREATE TABLE `boutique` (
  `id_article` int(11) NOT NULL,
  `nom_article` varchar(30) NOT NULL,
  `description_article` varchar(100) NOT NULL,
  `prix_article` decimal(10,2) NOT NULL,
  `image_article` varchar(200) NOT NULL
);

--
-- Déchargement des données de la table `boutique`
--

INSERT INTO `boutique` (`id_article`, `nom_article`, `description_article`, `prix_article`, `image_article`) VALUES
(1, 'T-shirt Sport', 'T-shirt de sport respirant', 25.99, 'uploads/tshirt.jpeg'),
(2, 'Gants Musculation', 'Gants pour haltérophilie', 19.99, 'uploads/gants.jpeg'),
(3, 'Bouteille Eau', 'Bouteille deau réutilisable', 12.50, 'uploads/bouteille.jpeg');

-- --------------------------------------------------------

--
-- Structure de la table `coach`
--

CREATE TABLE `coach` (
  `Id_Coach` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Specialite` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Telephone` varchar(15) NOT NULL,
  `MotDePasse` varchar(255) NOT NULL DEFAULT '1234'
);

--
-- Déchargement des données de la table `coach`
--

INSERT INTO `coach` (`Id_Coach`, `Nom`, `Prenom`, `Specialite`, `Email`, `Telephone`, `MotDePasse`) VALUES
(4, 'Dupont', 'Jean', 'Musculation', 'jean.dupont@example.com', '0600000000', 'mdp123'),
(5, 'Martin', 'Sophie', 'Yoga', 'sophie.martin@example.com', '0612345678', 'yoga456'),
(6, 'Lefevre', 'Paul', 'Cardio', 'paul.lefevre@example.com', '0623456789', 'cardio789');

-- --------------------------------------------------------

--
-- Structure de la table `coach_programme`
--

CREATE TABLE `coach_programme` (
  `Id_Coach` int(11) NOT NULL,
  `Id_Programme` int(11) NOT NULL
);

-- --------------------------------------------------------

--
-- Structure de la table `programme`
--

CREATE TABLE `programme` (
  `id_programme` int(11) NOT NULL,
  `nom_programme` varchar(50) NOT NULL,
  `rythme` varchar(50) NOT NULL,
  `description` text DEFAULT NULL,
  `duree` time DEFAULT NULL,
  `categorie` enum('lourd','moyen','simple') NOT NULL
);

--
-- Déchargement des données de la table `programme`
--

INSERT INTO `programme` (`id_programme`, `nom_programme`, `rythme`, `description`, `duree`, `categorie`) VALUES
(1, 'Full Body', 'Quotidien', 'Programme pour tout le corps', '01:00:00', 'moyen'),
(2, 'Yoga Débutant', 'Hebdomadaire', 'Initiation au yoga', '00:45:00', 'simple'),
(3, 'HIIT Intensif', 'Quotidien', 'Entraînement cardio intense', '00:30:00', 'lourd');

-- --------------------------------------------------------

--
-- Structure de la table `reservations`
--

CREATE TABLE `reservations` (
  `id` int(11) NOT NULL,
  `salle_id` int(11) NOT NULL,
  `client_nom` varchar(255) NOT NULL,
  `client_email` varchar(255) NOT NULL,
  `horaire` varchar(50) NOT NULL,
  `date_reservation` date NOT NULL
);

-- --------------------------------------------------------

--
-- Structure de la table `salles`
--

CREATE TABLE `salles` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `chaine` varchar(255) NOT NULL,
  `disponibilites` text NOT NULL
);

--
-- Déchargement des données de la table `salles`
--

INSERT INTO `salles` (`id`, `nom`, `adresse`, `ville`, `chaine`, `disponibilites`) VALUES
(1, 'Basic-Fit Centre', '10 Rue de la République', 'Paris', 'Basic-Fit', '{\"lundi\": [\"07:00\", \"22:00\"]}'),
(2, 'Fitness Park Montreuil', '5 Avenue du Général', 'Montreuil', 'Fitness Park', '{\"mardi\": [\"06:30\", \"21:30\"]}');

-- --------------------------------------------------------

--
-- Structure de la table `sportif`
--

CREATE TABLE `sportif` (
  `Id_Sportif` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Telephone` varchar(20) NOT NULL,
  `MotDePasse` varchar(255) NOT NULL,
  `Age` int(3) NOT NULL,
  `Sexe` enum('Homme','Femme') NOT NULL,
  `Taille` decimal(5,2) NOT NULL,
  `Poids` decimal(5,2) NOT NULL,
  `Objectif` text NOT NULL
);

--
-- Déchargement des données de la table `sportif`
--

INSERT INTO `sportif` (`Id_Sportif`, `Nom`, `Prenom`, `Email`, `Telephone`, `MotDePasse`, `Age`, `Sexe`, `Taille`, `Poids`, `Objectif`) VALUES
(1, 'Ghotu', 'Daniel', 'daniel.ghotu@fatfitness.com', '0600000001', 'pass1234', 25, 'Homme', 180.00, 75.00, 'Prise de masse'),
(2, 'Durand', 'Claire', 'claire.durand@fatfitness.com', '0600000002', 'motdepasse', 30, 'Femme', 165.50, 60.00, 'Perte de poids'),
(3, 'Nguyen', 'Thierry', 'thierry.nguyen@fatfitness.com', '0600000003', 'fit2024', 28, 'Homme', 172.00, 68.00, 'Améliorer l’endurance'),
(4, 'Moreau', 'Lucie', 'lucie.moreau@fatfitness.com', '0600000004', 'luciepass', 22, 'Femme', 158.00, 55.00, 'Tonification musculaire');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `boutique`
--
ALTER TABLE `boutique`
  ADD PRIMARY KEY (`id_article`);

--
-- Index pour la table `coach`
--
ALTER TABLE `coach`
  ADD PRIMARY KEY (`Id_Coach`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Index pour la table `coach_programme`
--
ALTER TABLE `coach_programme`
  ADD PRIMARY KEY (`Id_Coach`,`Id_Programme`),
  ADD KEY `Id_Programme` (`Id_Programme`);

--
-- Index pour la table `programme`
--
ALTER TABLE `programme`
  ADD PRIMARY KEY (`id_programme`);

--
-- Index pour la table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `salle_id` (`salle_id`);

--
-- Index pour la table `salles`
--
ALTER TABLE `salles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `sportif`
--
ALTER TABLE `sportif`
  ADD PRIMARY KEY (`Id_Sportif`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `boutique`
--
ALTER TABLE `boutique`
  MODIFY `id_article` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `coach`
--
ALTER TABLE `coach`
  MODIFY `Id_Coach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `programme`
--
ALTER TABLE `programme`
  MODIFY `id_programme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `salles`
--
ALTER TABLE `salles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `sportif`
--
ALTER TABLE `sportif`
  MODIFY `Id_Sportif` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `coach_programme`
--
ALTER TABLE `coach_programme`
  ADD CONSTRAINT `coach_programme_ibfk_1` FOREIGN KEY (`Id_Coach`) REFERENCES `coach` (`Id_Coach`) ON DELETE CASCADE,
  ADD CONSTRAINT `coach_programme_ibfk_2` FOREIGN KEY (`Id_Programme`) REFERENCES `programme` (`id_programme`) ON DELETE CASCADE;

--
-- Contraintes pour la table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`salle_id`) REFERENCES `salles` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
