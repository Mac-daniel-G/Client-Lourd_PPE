package controlleur;

import java.util.ArrayList;

import controlleur.Sportif;
import modele.Modele;

public class Controlleur {
	
	/***************** Gestion des sportifs ***************************/
	public static void insertSportif(Sportif unSportif) {
		//on controle les donner avant insertion
		Modele.insertSportif(unSportif);
	}
	
	public static ArrayList<Sportif> selectAllSportifs (){
		return Modele.selectAllSportifs(); 
	}
	
	public static ArrayList<Sportif> selectLikeSportifs (String filtre){
		return Modele.selectLikeSportifs(filtre); 
	}
	
	
	public static void deleteSportif(int idSportif) {
		Modele.deleteSportif(idSportif);
	}
	
	public static void updateSportif(Sportif unSportif) {
		Modele.updateSportif(unSportif);
	}
	
	public static Sportif selectWhereSportif(int idSportif) {
		return Modele.selectWhereSportif (idSportif); 
	}
	
	/***************** Gestion des Coachs ***************************/
	public static void insertCoach(Coach unCoach) {
		//on controle les donner avant insertion
		Modele.insertCoach(unCoach);
	}
	
	public static ArrayList<Coach> selectAllCoachs (){
		return Modele.selectAllCoachs(); 
	}
	
	public static ArrayList<Coach> selectLikeCoachs (String filtre){
		return Modele.selectLikeCoachs(filtre); 
	}
	
	
	public static void deleteCoach(int idCoach) {
		Modele.deleteCoach(idCoach);
	}
	
	public static void updateCoach(Coach unCoach) {
		Modele.updateCoach(unCoach);
	}
	
	public static Coach selectWhereCoach(int idCoach) {
		return Modele.selectWhereCoach (idCoach); 
	}
	
	/***************** Gestion des Boutique ***************************/
	public static void insertBoutique(Boutique unBoutique) {
		//on controle les donner avant insertion
		Modele.insertBoutique(unBoutique);
	}
	
	public static ArrayList<Boutique> selectAllBoutiques (){
		return Modele.selectAllBoutiques(); 
	}
	
	public static ArrayList<Boutique> selectLikeBoutiques (String filtre){
		return Modele.selectLikeBoutiques(filtre); 
	}
	
	
	public static void deleteBoutique(int id_article) {
		Modele.deleteBoutique(id_article);
	}
	
	public static void updateBoutique(Boutique unBoutique) {
		Modele.updateBoutique(unBoutique);
	}
	
	public static Boutique selectWhereBoutique(int id_article) {
		return Modele.selectWhereBoutique(id_article); 
	}
	
	/***************** Gestion des Admins ***************************/
	public static void insertAdmin(Admin unAdmin) {
		// TODO Auto-generated method stub
		Modele.insertAdmin(unAdmin);
		
	}
	
	public static ArrayList<Admin> selectAllAdmins (){
		return Modele.selectAllAdmins(); 
	}
	
	public static ArrayList<Admin> selectLikeAdmins (String filtre){
		return Modele.selectLikeAdmins(filtre); 
	}
	
	
	public static void deleteAdmin(int idAdmin) {
		Modele.deleteAdmin(idAdmin);
	}
	
	public static void updateAdmin(Admin unAdmin) {
		Modele.updateAdmin(unAdmin);
	}
	
	public static Admin selectWhereAdmin(String email, String mdp) {
		return Modele.selectWhereAdmin(email, mdp); 
	}
	
	/***************** Gestion des Programmes ***************************/
	public static void insertProgramme(Programme unProgramme) {
		//on controle les donner avant insertion
		Modele.insertProgramme(unProgramme);
	}
	
	public static ArrayList<Programme> selectAllProgrammes (){
		return Modele.selectAllProgrammes(); 
	}
	
	public static ArrayList<Programme> selectLikeProgrammes (String filtre){
		return Modele.selectLikeProgrammes(filtre); 
	}
	
	
	public static void deleteProgramme(int id_programme) {
		Modele.deleteProgramme(id_programme);
	}
	
	public static void updateProgramme(Programme unProgramme) {
		Modele.updateProgramme(unProgramme);
	}
	
	public static Programme selectWhereProgramme(String nom_programme, String categorie ) {
		return Modele.selectWhereProgramme(nom_programme, categorie ); 
	}
	
	/***************** Gestion des Salles ***************************/
	public static void insertSalle(Salles unSalle) {
		//on controle les donner avant insertion
		Modele.insertSalle(unSalle);
	}
	
	public static ArrayList<Salles> selectAllSalles (){
		return Modele.selectAllSalles(); 
	}
	
	public static ArrayList<Salles> selectLikeSalles (String filtre){
		return Modele.selectLikeSalles(filtre); 
	}
	
	
	public static void deleteSalle(int id) {
		Modele.deleteSalle(id);
	}
	
	public static void updateSalle(Salles uneSalle) {
		Modele.updateSalle(uneSalle);
	}
	
	public static Salles selectWhereSalle(int id) {
		return Modele.selectWhereSalle(id); 
	}
	
	public static int count(String table) {
		return Modele.count(table);
	}
	

}
