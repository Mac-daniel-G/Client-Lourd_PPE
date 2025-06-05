package controlleur;

public class Programme {
    private int id_programme;
    private String nom_programme;
    private String rythme;
    private String description;
    private String duree; // on utilise String pour représenter le TIME en Java
    private String categorie; // Enum pas possible : "lourd", "moyen", "simple"
    private int salle_id;
    private int coach_id;

    // Constructeur complet
    public Programme(int id_programme, String nom_programme, String rythme, String description, String duree, String categorie, int salle_id, int coach_id) {
        this.id_programme = id_programme;
        this.nom_programme = nom_programme;
        this.rythme = rythme;
        this.description = description;
        this.duree = duree;
        this.categorie = categorie;
        this.salle_id = salle_id;
        this.coach_id = coach_id;
    }

    // Constructeur sans id (insertion)
    public Programme(String nom_programme, String rythme, String description, String duree, String categorie, int salle_id, int coach_id) {
        this.id_programme = 0;
        this.nom_programme = nom_programme;
        this.rythme = rythme;
        this.description = description;
        this.duree = duree;
        this.categorie = categorie;
        this.salle_id = salle_id;
        this.coach_id = coach_id;
    }

    // Getters & Setters
    public int getIdProgramme() {
        return id_programme;
    }

    public void setIdProgramme(int idProgramme) {
        this.id_programme = idProgramme;
    }

    public String getNomProgramme() {
        return nom_programme;
    }

    public void setNomProgramme(String nom_programme) {
        this.nom_programme = nom_programme;
    }

    public String getRythme() {
        return rythme;
    }

    public void setRythme(String rythme) {
        this.rythme = rythme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    public int getSalleId() {
        return salle_id;
    }

    public void setSalleId(int salle_id) {
        this.salle_id = salle_id;
    }
    
    public int getCoachId() {
        return coach_id;
    }

    public void setCoachId(int coach_id) {
        this.coach_id = coach_id;
    }
}
