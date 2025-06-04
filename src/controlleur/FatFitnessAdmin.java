
package controlleur;

import vue.VueConnexion;
import vue.VueGenerale;

public class FatFitnessAdmin {

	private static VueConnexion uneVueConnexion ;
	private static VueGenerale uneVueGenerale ;
	
	private static Admin adminConnecte;
	
	
	public static Admin getAdminConnecte() {
		return adminConnecte;
	}

	public static void setTechConnecte(Admin adminConnecte) {
		FatFitnessAdmin.adminConnecte = adminConnecte;
	}

	public static void main(String[] args) {
		
		uneVueConnexion = new VueConnexion();
		uneVueConnexion.setVisible(true);
		
	}
	
	public static void creerVueGenerale (boolean action) {
		if (action == true) {
			uneVueGenerale = new VueGenerale();
			uneVueGenerale.setVisible(true);
		}else {
			uneVueGenerale.dispose();
		}
	}
	
	public static void rendreVisibleVueConnexion (boolean action) {
		uneVueConnexion.setVisible(action);
	}
	
}

//public class

	//public static void 
		//Donner l'index de l'affichage
		/*Client unClient = Controller.selectWhereClient(1);
		//afficher un client
		/*System.out.println("Le nom : " +  unClient.getNom());
		
		//ajout client
		/*Client unClient = new Client("Kerry", "Anthony",
				"Rue de Paris", "a@gmail.com", "0612671230");
		Controller.insertClient(unClient);*/
		
		//get all client
		/*for(Client unClient : Controller.selectAllClients()) {
			System.out.println("nom: "+unClient.getNom()+" ,Prenom: "+unClient.getPrenom()
			+" ,Adresse: "+unClient.getAdresse());
		}*/
		
		//recherche client
		/*for(Client unClient : Controller.selectLikeClients("paris")) {
			System.out.println("nom: "+unClient.getNom()+" ,Prenom: "+unClient.getPrenom());
		}*/
		
		//update
		/*Client ancien = new Client(1, "Kerry", "Anthony",
				"Rue de Lyon", "b@gmail.com", "0555555555");
		Controller.updateClient(ancien);*/
		
		//delete 
		//Controller.deleteClient(1);
		
		
	 

