package controlleur;

public class Salles {
    private int id;
    private String nom;
    private String adresse;
    private String ville;
    private String chaine;
    private String horaire_debut;
    private String horaire_fin;

    // Constructeur complet avec id
    public Salles(int id, String nom, String adresse, String ville, String chaine, String horaire_debut, String horaire_fin) {
        super();
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.chaine = chaine;
        this.horaire_debut = horaire_debut;
        this.horaire_fin = horaire_fin;

    }

    // Constructeur sans id
    public Salles(String nom, String adresse, String ville, String chaine, String horaire_debut, String horaire_fin) {
        super();
        this.id = 0; // L'id sera généré automatiquement en base de données
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.chaine = chaine;
        this.horaire_debut = horaire_debut;
        this.horaire_fin = horaire_fin;
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

    public String getHoraire_debut() {
        return horaire_debut;
    }

    public void setHoraire_debut(String horaire_debut) {
        this.horaire_debut = horaire_debut;
    }
    
    public String getHoraire_fin() {
        return horaire_fin;
    }

    public void setHoraire_fin(String horaire_fin) {
        this.horaire_fin = horaire_fin;
    }
}
