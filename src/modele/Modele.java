package modele;
 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controlleur.Controlleur;
import controlleur.Coach;
import controlleur.Admin;
import controlleur.Sportif;
import controlleur.Boutique;
import controlleur.Salles;
import controlleur.Programme;


public class Modele {
	
	private static Connexion uneConnexion = new Connexion("localhost", "fatfitness_db", "root", "");
	
	/***************** Gestion de Sportif ***************************/
	public static void insertSportif(Sportif unSportif) {
		String requete ="insert into Sportif values (null, '"+unSportif.getNom()
		+"', '"+unSportif.getPrenom()+"', '"+unSportif.getEmail()
		+"' , '"+unSportif.getTelephone()+"' ,'"+unSportif.getMotDePasse()
		+"' ,'"+unSportif.getAge()+"' ,'"+unSportif.getSexe()
		+"' ,'"+unSportif.getTaille()+"' ,'"+unSportif.getPoids()
		+"' ,'"+unSportif.getObjectif()+"' );";
		executerRequete (requete);
	}

	public static ArrayList<Sportif> selectAllSportifs() {
		ArrayList<Sportif> lesSportifs = new ArrayList<>();
        String requete = "SELECT * FROM Sportif ;";
        try {
        	uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
            while (desResultats.next()) {
                Sportif unSportif = new Sportif(
                		desResultats.getInt("Id_Sportif"),
                		desResultats.getString("Nom"),
                		desResultats.getString("Prenom"),
                		desResultats.getString("Email"),
                		desResultats.getString("Telephone"),
                		desResultats.getString("MotDePasse"),
                		desResultats.getInt("Age"),
                		desResultats.getString("Sexe"),
                		desResultats.getFloat("Taille"),
                        desResultats.getFloat("Poids"),
                        desResultats.getString("Objectif"));
                lesSportifs.add(unSportif);
            }
            unStat.close();
			uneConnexion.seConnecter();
        } catch(SQLException exp){
			System.out.println("erreur:"+requete);
			System.out.println("erreur:"+exp);
        }
        return lesSportifs;
	}

	public static ArrayList<Sportif> selectLikeSportifs(String filtre) {
		String requete = "select * from sportif where nom like '%" + filtre + "%' or prenom like '%" + filtre
			    + "%' or email like '%" + filtre + "%' or telephone like '%" + filtre
			    + "%' or motDePasse like '%" + filtre + "%' or sexe like '%" + filtre
			    + "%' or objectif like '%" + filtre + "%' or CAST(age AS CHAR) like '%" + filtre
			    + "%' or CAST(taille AS CHAR) like '%" + filtre + "%' or CAST(poids AS CHAR) like '%" + filtre + "%';";

		ArrayList<Sportif> lesSportifs = new ArrayList<Sportif>();
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while(desResultats.next()) {
				Sportif unSportif = new Sportif (
						desResultats.getString("nom"),
                		desResultats.getString("prenom"),
                		desResultats.getString("email"),
                		desResultats.getString("telephone"),
                		desResultats.getString("mdp"),
                		desResultats.getInt("age"),
                		desResultats.getString("sexe"),
                		desResultats.getFloat("taille"),
                        desResultats.getFloat("poids"),
                        desResultats.getString("objectif"));
				lesSportifs.add(unSportif);		
			}
			unStat.close();
			uneConnexion.seConnecter();
		}
		catch(SQLException exp){
			System.out.println("erreur:"+requete);
		}
		return lesSportifs;  

	}

	public static void deleteSportif(int idSportif) {
		String requetePanier = "delete from panier where id_client ="+idSportif+";" ;
		String requeteReservation = "delete from reservations where sportif_id ="+idSportif+";" ;
		String requete = "delete from sportif where Id_Sportif ="+idSportif+";" ;
		executerRequete (requetePanier);
		executerRequete (requeteReservation);
		executerRequete (requete);
	}

	public static void updateSportif(Sportif unSportif) {
		String requete = "update sportif set nom='" + unSportif.getNom()
	    + "', prenom='" + unSportif.getPrenom()
	    + "', email='" + unSportif.getEmail()
	    + "', telephone='" + unSportif.getTelephone()
	    + "', motDePasse='" + unSportif.getMotDePasse()
	    + "', age=" + unSportif.getAge()
	    + ", sexe='" + unSportif.getSexe()
	    + "', taille=" + unSportif.getTaille()
	    + ", poids=" + unSportif.getPoids()
	    + ", objectif='" + unSportif.getObjectif()
	    + "' where Id_Sportif=" + unSportif.getIdSportif() + ";";

	executerRequete(requete);
		
	}

	public static Sportif selectWhereSportif(int idSportif) {
		String requete = "select * from sportif where idSportif = " + idSportif + ";";
		Sportif unSportif = null;
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if(unResultat.next()) {
				unSportif = new Sportif (
						unResultat.getString("nom"),
						unResultat.getString("prenom"),
						unResultat.getString("email"),
                		unResultat.getString("telephone"),
                		unResultat.getString("mdp"),
                		unResultat.getInt("age"),
                		unResultat.getString("sexe"),
                		unResultat.getFloat("taille"),
                		unResultat.getFloat("poids"),
                		unResultat.getString("objectif"));
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		}
		catch(SQLException exp){
			System.out.println("erreur:"+requete);
		}
		return unSportif;	}
	
	
	public static void executerRequete (String requete) {
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneConnexion.seDeConnecter();
		}
		catch(SQLException exp){
			System.out.println("erreur:"+requete);
			System.out.println("erreur:"+exp);
		}
	}
	
	public static int count(String table) {
		int nb = 0 ;
		String requet = "Select count(*) as nb from "+ table + ";";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement(); //prepare
			ResultSet unResultat = unStat.executeQuery(requet);
			if (unResultat.next()) {
					nb = unResultat.getInt("nb");
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		}
		catch(SQLException exp){
			System.out.println("erreur d'excution de la requete :"+requet);
		}
		return nb;
		
	}
	
	/***************** Gestion de Coach ***************************/
	public static void insertCoach(Coach unCoach) {
		String requete ="insert into client values (null, '"+unCoach.getNom()
		+"', '"+unCoach.getPrenom()+"', '"+unCoach.getEmail()
		+"' , '"+unCoach.getTelephone()+"' ,'"+unCoach.getMotDePasse()
		+"' ,'"+unCoach.getSpecialite()+"'  );";
		executerRequete (requete);
	}

	public static ArrayList<Coach> selectAllCoachs() {
		ArrayList<Coach> lesCoachs = new ArrayList<>();
		String requete = "SELECT * FROM Coach;";
		try {
		    uneConnexion.seConnecter();
		    Statement unStat = uneConnexion.getMaConnexion().createStatement();
		    ResultSet desResultats = unStat.executeQuery(requete);
		    while (desResultats.next()) {
		        Coach unCoach = new Coach(
		            desResultats.getInt("id_Coach"),
		            desResultats.getString("Nom"),
		            desResultats.getString("Prenom"),
		            desResultats.getString("Specialite"),
		            desResultats.getString("Email"),
		            desResultats.getString("Telephone"),
		            desResultats.getString("MotDePasse")
		        );
		        lesCoachs.add(unCoach);
		    }
		    unStat.close();
		    uneConnexion.seConnecter();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return lesCoachs;

	}

	public static ArrayList<Coach> selectLikeCoachs(String filtre) {
		String requete = "select * from coach where Nom like '%" + filtre + "%' or Prenom like '%" + filtre
			    + "%' or Specialite like '%" + filtre + "%' or Email like '%" + filtre
			    + "%' or Telephone like '%" + filtre + "%' or MotDePasse like '%" + filtre + "%';";

			ArrayList<Coach> lesCoachs = new ArrayList<Coach>();
			try {
			    uneConnexion.seConnecter();
			    Statement unStat = uneConnexion.getMaConnexion().createStatement();
			    ResultSet desResultats = unStat.executeQuery(requete);
			    while (desResultats.next()) {
			        Coach unCoach = new Coach(
			            desResultats.getInt("idCoach"),
			            desResultats.getString("Nom"),
			            desResultats.getString("Prenom"),
			            desResultats.getString("Specialite"),
			            desResultats.getString("Email"),
			            desResultats.getString("Telephone"),
			            desResultats.getString("MotDePasse")
			        );
			        lesCoachs.add(unCoach);
			    }
			    unStat.close();
			    uneConnexion.seConnecter();
			} catch (SQLException exp) {
			    System.out.println("erreur : " + requete);
			    exp.printStackTrace();
			}
			return lesCoachs;

	}

	public static void deleteCoach(int idCoach) {
		String requeteProgramme = "delete from coachprogramme where idCoach ="+idCoach+";" ;
		String requete = "delete from coach where Id_Coach ="+idCoach+";" ;
		
		try {
			uneConnexion.seConnecter();
            Statement unStat= uneConnexion.getMaConnexion().createStatement();
            unStat.execute(requeteProgramme);
            unStat.execute(requete);
            unStat.close();
            uneConnexion.seDeConnecter();
        }
        catch(SQLException exp) {
            System.out.println("Erreur d'execution de: "+requete);
            System.out.println("Erreur d'execution de: "+exp);
        }
		
	}

	public static void updateCoach(Coach unCoach) {
		String requete = "UPDATE coach SET Nom='" + unCoach.getNom()
	    + "', Prenom='" + unCoach.getPrenom()
	    + "', Specialite='" + unCoach.getSpecialite()
	    + "', Email='" + unCoach.getEmail()
	    + "', Telephone='" + unCoach.getTelephone()
	    + "', MotDePasse='" + unCoach.getMotDePasse()
	    + "' WHERE Id_Coach=" + unCoach.getIdCoach() + ";";

		executerRequete(requete);

	}

	public static Coach selectWhereCoach(int idCoach) {
		String requete = "SELECT * FROM coach WHERE idCoach = " + idCoach + ";";
		Coach unCoach = null;
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unCoach = new Coach(
					unResultat.getInt("idCoach"),
					unResultat.getString("Nom"),
					unResultat.getString("Prenom"),
					unResultat.getString("Specialite"),
					unResultat.getString("Email"),
					unResultat.getString("Telephone"),
					unResultat.getString("MotDePasse")
				);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("erreur: " + requete);
		}
		return unCoach;
	}

	
	/***************** Gestion de Boutique ***************************/
	public static void insertBoutique(Boutique unBoutique) {
		String requete ="insert into Boutiques values (null, '"+unBoutique.getNom_article()
		+"', '"+unBoutique.getDescription_article()+"', '"+unBoutique.getPrix_article()
		+"' , '"+unBoutique.getImage_article()+"' );";
		executerRequete (requete);
	}


	public static ArrayList<Boutique> selectAllBoutiques() {
		ArrayList<Boutique> lesBoutiques = new ArrayList<Boutique>();
		String requete = "SELECT * FROM boutique;";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Boutique uneBoutique = new Boutique(
					desResultats.getInt("id_article"),
					desResultats.getString("nom_article"),
					desResultats.getString("description_article"),
					desResultats.getFloat("prix_article"),
					desResultats.getString("image_article")
				);
				lesBoutiques.add(uneBoutique);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
			System.out.println("Erreur : " + exp);
		}
		return lesBoutiques;
	}

	public static ArrayList<Boutique> selectLikeBoutiques(String filtre) {
		ArrayList<Boutique> lesBoutiques = new ArrayList<Boutique>();
		String requete = "SELECT * FROM boutique WHERE nom_article LIKE '%" + filtre + 
		                 "%' OR description_article LIKE '%" + filtre + 
		                 "%' OR CAST(prix_article AS CHAR) LIKE '%" + filtre + "%';";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Boutique uneBoutique = new Boutique(
					desResultats.getInt("id_article"),
					desResultats.getString("nom_article"),
					desResultats.getString("description_article"),
					desResultats.getFloat("prix_article"),
					desResultats.getString("image_article")
				);
				lesBoutiques.add(uneBoutique);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
		}
		return lesBoutiques;
	}

	public static void deleteBoutique(int id_article) {
		String requete = "call deleteBoutique("+id_article+");";
		executerRequete (requete);
		
	}

	public static void updateBoutique(Boutique uneBoutique) {
		String requete = "UPDATE boutique SET nom_article = '" + uneBoutique.getNom_article() +
			"', description_article = '" + uneBoutique.getDescription_article() +
			"', prix_article = " + uneBoutique.getPrix_article() +
			", image_article = '" + uneBoutique.getImage_article() +
			" WHERE id_article = " + uneBoutique.getId_article() + ";";
		executerRequete(requete);
	}

	public static Boutique selectWhereBoutique(int id_article) {
		Boutique uneBoutique = null;
		String requete = "SELECT * FROM boutique WHERE id_article = " + id_article + ";";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				uneBoutique = new Boutique(
					unResultat.getInt("id_article"),
					unResultat.getString("nom_article"),
					unResultat.getString("description_article"),
					unResultat.getFloat("prix_article"),
					unResultat.getString("image_article")
				);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
		}
		return uneBoutique;
	}


	/***************** Gestion des Admins ***************************/
	public static void insertAdmin(Admin unAdmin) {
		String requete ="insert into Boutiques values (null, '"+unAdmin.getNom()
		+"', '"+unAdmin.getPrenom()+"', '"+unAdmin.getRole()
		+"' , '"+unAdmin.getEmail()+"' ,'"+unAdmin.getMdp()+"' ,'"+unAdmin.getTel()+"'  );";
		executerRequete (requete);
	}

	public static ArrayList<Admin> selectAllAdmins() {
		ArrayList<Admin> lesAdmins = new ArrayList<Admin>();
		String requete = "SELECT * FROM admin;";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Admin unAdmin = new Admin(
					desResultats.getInt("idAdmin"),
					desResultats.getString("nom"),
					desResultats.getString("prenom"),
					desResultats.getString("role"),
					desResultats.getString("email"),
					desResultats.getString("mdp"),
					desResultats.getString("tel")
				);
				lesAdmins.add(unAdmin);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
		}
		return lesAdmins;
	}

	public static ArrayList<Admin> selectLikeAdmins(String filtre) {
		ArrayList<Admin> lesAdmins = new ArrayList<Admin>();
		String requete = "SELECT * FROM admin WHERE nom LIKE '%" + filtre +
			"%' OR prenom LIKE '%" + filtre +
			"%' OR role LIKE '%" + filtre +
			"%' OR email LIKE '%" + filtre +
			"%' OR tel LIKE '%" + filtre + "%';";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Admin unAdmin = new Admin(
					desResultats.getInt("idAdmin"),
					desResultats.getString("nom"),
					desResultats.getString("prenom"),
					desResultats.getString("role"),
					desResultats.getString("email"),
					desResultats.getString("mdp"),
					desResultats.getString("tel")
				);
				lesAdmins.add(unAdmin);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
		}
		return lesAdmins;
	}

	public static void deleteAdmin(int idAdmin) {
		String requete = "call deleteAdmin("+idAdmin+");";
		executerRequete (requete);
		
	}

	public static void updateAdmin(Admin unAdmin) {
		String requete = "UPDATE admin SET nom='" + unAdmin.getNom() +
			"', prenom='" + unAdmin.getPrenom() +
			"', role='" + unAdmin.getRole() +
			"', email='" + unAdmin.getEmail() +
			"', mdp='" + unAdmin.getMdp() +
			"', tel='" + unAdmin.getTel() +
			"' WHERE idAdmin=" + unAdmin.getIdAdmin() + ";";
		executerRequete(requete);
	}

	public static Admin selectWhereAdmin(String email, String mdp) {
		String requete = "SELECT * FROM admin WHERE email='" + email + "' AND mdp='" + mdp + "';";
		Admin unAdmin = null;
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unAdmin = new Admin(
					unResultat.getInt("idAdmin"),
					unResultat.getString("nom"),
					unResultat.getString("prenom"),
					unResultat.getString("role"),
					unResultat.getString("email"),
					unResultat.getString("mdp"),
					unResultat.getString("tel")
				);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
		}
		return unAdmin;
	}


	/***************** Gestion des Salles ***************************/
	public static void insertSalle(Salles unSalle) {
		String requete ="insert into Boutiques values (null, '"+unSalle.getNom()
		+"', '"+unSalle.getAdresse()+"', '"+unSalle.getVille()
		+"' , '"+unSalle.getChaine()+"' ,'"+unSalle.getDisponibilites()+"' );";
		executerRequete (requete);
	}

	public static ArrayList<Salles> selectAllSalles() {
		ArrayList<Salles> lesSalles = new ArrayList<Salles>();
		String requete = "SELECT * FROM salles;";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Salles unSalle = new Salles(
					desResultats.getInt("id"),
					desResultats.getString("nom"),
					desResultats.getString("adresse"),
					desResultats.getString("ville"),
					desResultats.getString("chaine"),
					desResultats.getString("disponibilites")
				);
				lesSalles.add(unSalle);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
		}
		return lesSalles;
	}

	public static ArrayList<Salles> selectLikeSalles(String filtre) {
		ArrayList<Salles> lesSalles = new ArrayList<Salles>();
	    String requete = "SELECT * FROM salles WHERE " +
                "nom LIKE '%" + filtre + "%' OR " +
                "adresse LIKE '%" + filtre + "%' OR " +
                "ville LIKE '%" + filtre + "%' OR " +
                "chaine LIKE '%" + filtre + "%' OR " +
                "disponibilites LIKE '%" + filtre + "%';";
		try {
		   uneConnexion.seConnecter();
		   Statement unStat = uneConnexion.getMaConnexion().createStatement();
		   ResultSet desResultats = unStat.executeQuery(requete);
		   while (desResultats.next()) {
		       Salles uneSalle = new Salles(
		           desResultats.getInt("id"),
		           desResultats.getString("nom"),
		           desResultats.getString("adresse"),
		           desResultats.getString("ville"),
		           desResultats.getString("chaine"),
		           desResultats.getString("disponibilites")
		       );
		       lesSalles.add(uneSalle);
		   }
		   unStat.close();
		   uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
		   System.out.println("Erreur : " + requete);
		}
		return lesSalles;
	}

	public static void deleteSalle(int id) {
		String requete = "call deleteSalle("+id+");";
		executerRequete (requete);
		
	}

	public static void updateSalle(Salles uneSalle) {
		String requete = "UPDATE salles SET " +
                "nom='" + uneSalle.getNom() +
                "', adresse='" + uneSalle.getAdresse() +
                "', ville='" + uneSalle.getVille() +
                "', chaine='" + uneSalle.getChaine() +
                "', disponibilites='" + uneSalle.getDisponibilites() +
                "' WHERE id_salle=" + uneSalle.getId() + ";";
		executerRequete(requete);
		
	}

	public static Salles selectWhereSalle (int id) {
		String requete = "SELECT * FROM salle WHERE id_salle=" + id + ";";
	    Salles uneSalle = null;
	    
	    try {
	        uneConnexion.seConnecter();
	        Statement unStat = uneConnexion.getMaConnexion().createStatement();
	        ResultSet unResultat = unStat.executeQuery(requete);
	        
	        if (unResultat.next()) {
	            uneSalle = new Salles(
	                unResultat.getInt("id_salle"),
	                unResultat.getString("nom"),
	                unResultat.getString("adresse"),
	                unResultat.getString("ville"),
	                unResultat.getString("chaine"),
	                unResultat.getString("disponibilites")
	            );
	        }
	        
	        unStat.close();
	        uneConnexion.seDeConnecter();
	    } catch (SQLException exp) {
	        System.out.println("Erreur : " + requete);
	    }
	    
	    return uneSalle;
	}

	/***************** Gestion des Programmes ***************************/
	public static void insertProgramme(Programme unProgramme) {
		String requete ="insert into Boutiques values (null, '"+unProgramme.getNomProgramme()
		+"', '"+unProgramme.getRythme()+"', '"+unProgramme.getDescription()
		+"' , '"+unProgramme.getDuree()+"' ,'"+unProgramme.getCategorie()+"' );";
		executerRequete (requete);
	}

	public static ArrayList<Programme> selectAllProgrammes() {
		ArrayList<Programme> lesProgrammes = new ArrayList<Programme>();
		String requete = "SELECT * FROM programme;";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Programme unProgramme = new Programme(
					desResultats.getInt("id_programme"),
					desResultats.getString("nom_programme"),
					desResultats.getString("rythme"),
					desResultats.getString("description"),
					desResultats.getString("duree"),
					desResultats.getString("categorie")
				);
				lesProgrammes.add(unProgramme);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
		}
		return lesProgrammes;
	}

	public static ArrayList<Programme> selectLikeProgrammes(String filtre) {
		ArrayList<Programme> lesProgrammes = new ArrayList<Programme>();
		String requete = "SELECT * FROM programme WHERE " +
						 "nom_programme LIKE '%" + filtre + "%' OR " +
						 "rythme LIKE '%" + filtre + "%' OR " +
						 "description LIKE '%" + filtre + "%' OR " +
						 "duree LIKE '%" + filtre + "%' OR " +
						 "categorie LIKE '%" + filtre + "%';";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Programme unProgramme = new Programme(
					desResultats.getInt("id_programme"),
					desResultats.getString("nom_programme"),
					desResultats.getString("rythme"),
					desResultats.getString("description"),
					desResultats.getString("duree"),
					desResultats.getString("categorie")
				);
				lesProgrammes.add(unProgramme);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
		}
		return lesProgrammes;
	}

	public static void deleteProgramme(int idProgramme) {
		String requete = "call deleteProgramme("+idProgramme+");";
		executerRequete (requete);
		
	}

	public static void updateProgramme(Programme unProgramme) {
		String requete = "UPDATE programme SET nom_programme='" + unProgramme.getNomProgramme() +
				"', rythme='" + unProgramme.getRythme() +
				"', description='" + unProgramme.getDescription() +
				"', duree='" + unProgramme.getDuree() +
				"', categorie='" + unProgramme.getCategorie() +
				"' WHERE id_programme=" + unProgramme.getIdProgramme() + ";";
		executerRequete(requete);
		
	}

	public static Programme selectWhereProgramme (String nom_programme, String categorie ) {
		String requete = "SELECT * FROM programme WHERE nom_programme='" + nom_programme + "' AND categorie='" + categorie + "';";
		Programme unProgramme = null;
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unProgramme = new Programme(
					unResultat.getInt("id_programme"),
					unResultat.getString("nom_programme"),
					unResultat.getString("rythme"),
					unResultat.getString("description"),
					unResultat.getString("duree"),
					unResultat.getString("categorie")
				);
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur : " + requete);
		}
		return unProgramme;
	}

	
	
	/*public static void executerRequete (String requete) {
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneConnexion.seDeConnecter();
		}
		catch(SQLException exp){
			System.out.println("erreur:"+requete);
		}
	}
	public static int count(String table) {
		int nb = 0 ;
		String requet = "Select count(*) as nb from "+ table + ";";
		try {
			uneConnexion.seConnecter();
			Statement unStat = uneConnexion.getMaConnexion().createStatement(); //prepare
			ResultSet unResultat = unStat.executeQuery(requet);
			if (unResultat.next()) {
					nb = unResultat.getInt("nb");
			}
			unStat.close();
			uneConnexion.seDeConnecter();
		}
		catch(SQLException exp){
			System.out.println("erreur d'excution de la requete :"+requet);
		}
		return nb;*/
}