package controlleur;

public class Sportif {
    private int idSportif;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String motDePasse;
    private int age;
    private String sexe;
    private double taille;
    private double poids;
    private String objectif;

    // Constructeur complet avec id
    public Sportif(int idSportif, String nom, String prenom, String email, String telephone, String motDePasse,
                   int age, String sexe, double taille, double poids, String objectif) {
        super();
        this.idSportif = idSportif;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.age = age;
        this.sexe = sexe;
        this.taille = taille;
        this.poids = poids;
        this.objectif = objectif;
    }

    // Constructeur sans id
    public Sportif(String nom, String prenom, String email, String telephone, String motDePasse,
                   int age, String sexe, double taille, double poids, String objectif) {
        super();
        this.idSportif = 0; // L'id sera généré automatiquement en base de données
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.age = age;
        this.sexe = sexe;
        this.taille = taille;
        this.poids = poids;
        this.objectif = objectif;
    }
    
    

    // Getters et Setters
    public int getIdSportif() {
        return idSportif;
    }

    public void setIdSportif(int idSportif) {
        this.idSportif = idSportif;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

	public String getSpecialite() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIdCoach() {
		// TODO Auto-generated method stub
		return null;
	}
}
