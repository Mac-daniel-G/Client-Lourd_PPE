package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private String serveur , bdd , user , mdp ;
	private Connection maConnexion;
	
	public Connexion(String serveur, String bdd, String user, String mdp) {
		super();
		this.serveur = serveur;
		this.bdd = bdd;
		this.user = user;
		this.mdp = mdp;
		this.maConnexion = null;
	}
	
	public void chargerPilote () {
		try {
			Class.forName("com.mysql.cj.jdbc");
		}
		catch(ClassNotFoundException exp) {
			System.out.println("Abscence du pilote JDBC");
			
		}
		
	}
	
	public void seConnecter () {
		String url = "jdbc:mysql://"+this.serveur+"/"+this.bdd ;
		try {
			this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
		}
		catch (SQLException exp) {
			System.out.println("Erreur de connexion a la bdd : " + url);
			exp.printStackTrace();
		}
		
	}
	
	public void seDeConnecter () {
		try {
			if (this.maConnexion != null) {
				this.maConnexion.close();
;			}
		}
		catch (SQLException exp) {
			System.out.println("Erreur lors de la fermeture de la connexion ");
		}
		
	}

	public Connection getMaConnexion() {
		return this.maConnexion;
	}
	
}

