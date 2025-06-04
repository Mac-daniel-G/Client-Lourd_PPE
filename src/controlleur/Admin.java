package controlleur;

public class Admin {
	private int idAdmin ; 
	private String nom, prenom, role, email, mdp,tel;
	public Admin(int idAdmin, String nom, String prenom, String role, String email, String mdp,
			String tel) {
		super();
		this.idAdmin = idAdmin;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.email = email;
		this.mdp = mdp;
		this.tel = tel;
	}
	
	public Admin(String nom, String prenom, String role, String email, String mdp,
			String tel) {
		super();
		this.idAdmin = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.email = email;
		this.mdp = mdp;
		this.tel = tel;
	}
	
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	} 

}
