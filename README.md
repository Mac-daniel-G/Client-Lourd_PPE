# FatFitnessAdmin

## 1. Présentation du projet

**FatFitnessAdmin** est une application client lourd (bureau) développée en Java avec Swing, destinée à la gestion interne d'une plateforme spécialisée dans la mise en relation de coachs sportifs et de clients.

Cette application permet aux administrateurs de gérer efficacement les utilisateurs (sportifs), les coachs, les programmes sportifs, les réservations, les vidéos de fitness, ainsi que les salles. Elle utilise une base de données MySQL et suit une architecture MVC (Modèle-Vue-Contrôleur).

---

## 2. Fonctionnalités principales

### Gestion des utilisateurs (sportifs)
- Ajouter, modifier, supprimer, consulter un sportif
- Rechercher un utilisateur par nom ou email
- Visualiser l’évolution des données (objectifs, poids, etc.)

### Gestion des coachs
- Ajouter, modifier, supprimer, consulter un coach
- Gérer les spécialisations et les disponibilités
- Affecter des programmes aux coachs

### Gestion des programmes sportifs
- Créer et modifier un programme
- Définir rythme, durée, description
- Associer un coach à un programme

### Gestion des réservations
- Suivre les réservations de séances
- Modifier ou annuler une réservation
- Voir l’historique par utilisateur ou coach

### Gestion des vidéos de fitness
- Ajouter, modifier, supprimer des vidéos
- Lier les vidéos à des programmes ou types d’exercices

### Gestion des salles
- Enregistrer une salle (nom, capacité)
- Gérer les disponibilités pour les séances

### Tableau de bord d’administration
- Visualisation rapide : nombre d’utilisateurs actifs, coachs, réservations
- Statistiques de fréquentation et d’activité (à venir)

### Sécurité et accès
- Connexion sécurisée avec mot de passe
- Interface réservée aux administrateurs
- Gestion des rôles prévue pour les futures versions

---

## 3. Contraintes techniques

- **Langage** : Java
- **Interface graphique** : Swing
- **Connexion à la base de données** : JDBC
- **Base de données** : MySQL
- **Architecture** : MVC (Modèle / Vue / Contrôleur)
- **IDE recommandé** : Eclipse

---

## 4. Installation et utilisation

1. Cloner ce dépôt :  
   ```bash
   git clone https://github.com/Mac-daniel-G/Client-Lourd_PPE.git
