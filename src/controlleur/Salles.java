package controlleur;

public class Salles {
    private int id;
    private String nom;
    private String adresse;
    private String ville;
    private String chaine;
    private String disponibilites;

    // Constructeur complet avec id
    public Salles(int id, String nom, String adresse, String ville, String chaine, String disponibilites) {
        super();
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.chaine = chaine;
        this.disponibilites = disponibilites;
    }

    // Constructeur sans id
    public Salles(String nom, String adresse, String ville, String chaine, String disponibilites) {
        super();
        this.id = 0; // L'id sera généré automatiquement en base de données
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.chaine = chaine;
        this.disponibilites = disponibilites;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getChaine() {
        return chaine;
    }

    public void setChaine(String chaine) {
        this.chaine = chaine;
    }

    public String getDisponibilites() {
        return disponibilites;
    }

    public void setDisponibilites(String disponibilites) {
        this.disponibilites = disponibilites;
    }
}
