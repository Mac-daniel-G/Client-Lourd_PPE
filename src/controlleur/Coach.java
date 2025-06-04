package controlleur;

public class Coach {
	private int idCoach ; 
	private String Nom, Prenom, Specialite, Email, Telephone, MotDePasse;
	public Coach(int idCoach, String Nom, String Prenom, String Specialite, String Email, String Telephone,
			String MotDePasse) {
		super();
		this.idCoach = idCoach;
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.Specialite = Specialite;
		this.Email = Email;
		this.Telephone = Telephone;
		this.MotDePasse = MotDePasse;
	}
	public Coach(String Nom, String Prenom, String Specialite, String Email, String Telephone,
			String MotDePasse) {
		super();
		this.idCoach = 0;
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.Specialite = Specialite;
		this.Email = Email;
		this.Telephone = Telephone;
		this.MotDePasse = MotDePasse;
	}
	public int getIdCoach() {
		return idCoach;
	}
	public void setIdCoach(int idCoach) {
		this.idCoach = idCoach;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String Nom) {
		this.Nom = Nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String Prenom) {
		this.Prenom = Prenom;
	}
	public String getSpecialite() {
		return Specialite;
	}
	public void setSpecialite(String Specialite) {
		this.Specialite = Specialite;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String Telephone) {
		this.Telephone = Telephone;
	}
	public String getMotDePasse() {
		return MotDePasse;
	}
	public void setMotDePasse(String MotDePasse) {
		this.MotDePasse = MotDePasse;
	}
}
