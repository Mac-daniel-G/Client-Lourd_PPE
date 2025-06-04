package controlleur;

public class Boutique {
	private int id_article;
    private String nom_article;
    private String description_article;
    private float prix_article;
    private String image_article;

    public Boutique(int id_article, String nom_article, String description_article, float prix_article, String image_article) {
        this.id_article = id_article;
        this.nom_article = nom_article;
        this.description_article = description_article;
        this.prix_article = prix_article;
        this.image_article = image_article;
    }
    
    public Boutique( String nom_article, String description_article, float prix_article, String image_article) {
    	this.id_article = 0;
        this.nom_article = nom_article;
        this.description_article = description_article;
        this.prix_article = prix_article;
        this.image_article = image_article;
    }
	
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public String getDescription_article() {
		return description_article;
	}
	public void setDescription_article(String description_article) {
		this.description_article = description_article;
	}
	public float getPrix_article() {
		return prix_article;
	}
	public void setPrix_article(float prix_article) {
		this.prix_article = prix_article;
	}
	public String getImage_article() {
		return image_article;
	}
	public void setImage_article(String image_article) {
		this.image_article = image_article;
	}
	

}
