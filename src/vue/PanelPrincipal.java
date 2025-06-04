package vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class PanelPrincipal extends JPanel
{
	public PanelPrincipal(String titre) {
		this.setBackground(Color.blue);
		this.setBounds(20, 80, 940, 480);
		this.setLayout(null);
		
		JLabel lbTitre = new JLabel(titre);
		lbTitre.setBounds(360, 10, 200, 20);
		this.add(lbTitre);
		
		this.setVisible(false);
	}
}
