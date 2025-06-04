package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlleur.FatFitnessAdmin;

public class VueGenerale extends JFrame implements ActionListener
{
	private JButton btProfil = new JButton("Profil Admin"); 
	private JButton btCoach = new JButton("Coachs"); 
	private JButton btSportif = new JButton("Sportifs"); 
	private JButton btSalles = new JButton("Salles"); 
	private JButton btProgramme = new JButton("Programmes");
	private JButton btBoutique = new JButton("Articles");
	private JButton btStats = new JButton("Statistiques"); 
	private JButton btQuitter = new JButton("Déconnexion"); 
	
	// Panels
	private JPanel panelMenu = new JPanel();
	private static PanelProfil unPanelProfil = new PanelProfil(); 
	private static PanelCoache unPanelCoache = new PanelCoache(); 
	private static PanelSportif unPanelSportif = new PanelSportif(); 
	private static PanelSalle unPanelSalle = new PanelSalle();
	private static PanelProgramme unPanelProgramme = new PanelProgramme();
	private static PanelBoutique unPanelBoutique = new PanelBoutique();
	private static PanelStats unPanelStats = new PanelStats();
	
	public VueGenerale() {
		this.setTitle("FatFitness - Espace Administrateur");
		this.setBounds(100, 100, 1000, 600);
		this.getContentPane().setBackground(Color.darkGray);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		
		// Menu haut
		this.panelMenu.setBackground(Color.darkGray);
		this.panelMenu.setBounds(50, 10, 900, 40);
		this.panelMenu.setLayout(new GridLayout(1,7));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btCoach); 
		this.panelMenu.add(this.btSportif); 
		this.panelMenu.add(this.btSalles); 
		this.panelMenu.add(this.btProgramme);
		this.panelMenu.add(this.btBoutique); 
		this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btQuitter);
		this.add(this.panelMenu); 
		
		// Actions des boutons
		this.btProfil.addActionListener(this);
		this.btCoach.addActionListener(this);
		this.btSportif.addActionListener(this);
		this.btSalles.addActionListener(this);
		this.btProgramme.addActionListener(this);
		this.btBoutique.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btQuitter.addActionListener(this);
		
		// Ajout des panels au JFrame
		this.add(unPanelProfil);
		this.add(unPanelCoache); 
		this.add(unPanelSportif);
		this.add(unPanelSalle);
		this.add(unPanelProgramme);
		this.add(unPanelBoutique);
		this.add(unPanelStats);

		this.setVisible(false); // On l'affichera après connexion
	}

	// Afficher uniquement le panel choisi
	public void rendreVisible(int choix) {
		unPanelProfil.setVisible(false);
		unPanelCoache.setVisible(false);
		unPanelSportif.setVisible(false);
		unPanelSalle.setVisible(false);
		unPanelProgramme.setVisible(false);
		unPanelBoutique.setVisible(false);
		unPanelStats.setVisible(false);
		
		switch(choix) {
			case 0: unPanelProfil.setVisible(true); break;
			case 1: unPanelCoache.setVisible(true); break;
			case 2: unPanelSportif.setVisible(true); break;
			case 3: unPanelSalle.setVisible(true); break;
			case 4: unPanelProgramme.setVisible(true); break;
			case 5: unPanelBoutique.setVisible(true); break;
			case 6: unPanelStats.setVisible(true); break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter) {
			int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment vous déconnecter ?", 
					"Déconnexion", JOptionPane.YES_NO_OPTION); 
			if (retour == 0) {
				FatFitnessAdmin.creerVueGenerale(false);
				FatFitnessAdmin.rendreVisibleVueConnexion(true);
			}
		}
		else if (e.getSource() == this.btCoach) {
			this.rendreVisible(1);
		}
		else if (e.getSource() == this.btSportif) {
			this.rendreVisible(2);
		}
		else if (e.getSource() == this.btSalles) {
			this.rendreVisible(3);
		}
		else if (e.getSource() == this.btProgramme) {
			this.rendreVisible(4);
		}
		else if (e.getSource() == this.btBoutique) {
			this.rendreVisible(5);
		}
		else if (e.getSource() == this.btStats) {
			this.rendreVisible(6);
		}
		else if (e.getSource() == this.btProfil) {
			this.rendreVisible(0);
		}
	}
}
