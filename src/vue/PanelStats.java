package vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controlleur.Controlleur;

public class PanelStats extends PanelPrincipal
{	
	private JPanel panelCount = new JPanel();
	private JLabel lbAdmin = new JLabel();
	private JLabel lbSportif = new JLabel();
	private JLabel ldCoach = new JLabel();
	private JLabel lbSalle = new JLabel();
	private JLabel IbProgramme = new JLabel();
	private JLabel IbBoutique = new JLabel();
	
	public PanelStats() {
		super ("Gestion des Stats");
		
		panelCount.setBackground(Color.blue);
		panelCount.setBounds(50, 100, 380, 250);
		panelCount.setLayout(new GridLayout(3,3));
		panelCount.add(lbAdmin);
		panelCount.add(lbSportif);
		panelCount.add(ldCoach);
		panelCount.add(lbSalle);
		panelCount.add(IbProgramme);
		panelCount.add(IbBoutique);
		this.add(panelCount);
		remplirLB();
	}
	
	public void remplirLB() {
		lbAdmin.setText("Nombre de admins : "+Controlleur.count("Admin"));
		lbSportif.setText("Nombre de sportifs : "+Controlleur.count("Sportif"));
		ldCoach.setText("Nombre de Coachs : "+Controlleur.count("Coach"));
		lbSalle.setText("Nombre de Salles : "+Controlleur.count("Salles"));
		IbProgramme.setText("Nombre de Programmes : "+Controlleur.count("Programme"));
		IbBoutique.setText("Nombre de Boutiques : "+Controlleur.count("Boutique"));
    }
}


