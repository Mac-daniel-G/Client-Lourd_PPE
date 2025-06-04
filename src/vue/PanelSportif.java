package vue;

import controlleur.Sportif;
import controlleur.Controlleur;
import controlleur.Sportif;
import controlleur.Tableau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelSportif extends PanelPrincipal implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panelForm = new JPanel();
    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtEmail = new JTextField(); 
    private JTextField txtTelephone = new JTextField();
    private JTextField txtAge = new JTextField();
    private JTextField txtSexe = new JTextField();
    private JTextField txtTaille = new JTextField();
    private JTextField txtPoids = new JTextField();
    private JTextField txtObjectif = new JTextField();
    private JPasswordField txtMotDePasse = new JPasswordField();
    
    private JButton btAnnuler = new JButton("Annuler");
    private JButton btValider = new JButton("Valider");
    private JButton btSupprimer = new JButton("Supprimer");

    private JTable tableSportif;
    private Tableau tableauSportif;

    private JPanel panelFiltre = new JPanel();
    private JTextField txtFiltre = new JTextField();
    private JButton btFiltrer = new JButton("Filtrer");

    public PanelSportif() {
        super("Gestion des Sportif");

        this.panelForm.setBackground(Color.blue);
        this.panelForm.setBounds(60, 50, 300, 300);
        this.panelForm.setLayout(new GridLayout(11, 2));
        
        this.panelForm.add(new JLabel("Nom :"));
        this.panelForm.add(this.txtNom);
        this.panelForm.add(new JLabel("Prénom :"));
        this.panelForm.add(this.txtPrenom);
        this.panelForm.add(new JLabel("Sexe :"));
        this.panelForm.add(this.txtSexe);
        this.panelForm.add(new JLabel("Email :"));
        this.panelForm.add(this.txtEmail);
        this.panelForm.add(new JLabel("Age :"));
        this.panelForm.add(this.txtAge);
        this.panelForm.add(new JLabel("Taille :"));
        this.panelForm.add(this.txtTaille);
        this.panelForm.add(new JLabel("Poids :"));
        this.panelForm.add(this.txtPoids);
        this.panelForm.add(new JLabel("Objectif :"));
        this.panelForm.add(this.txtObjectif);
        this.panelForm.add(new JLabel("Téléphone :"));
        this.panelForm.add(this.txtTelephone);
        this.panelForm.add(new JLabel("Mot de Passe :"));
        this.panelForm.add(this.txtMotDePasse);
        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btValider);
        this.add(this.panelForm);
        
        this.btAnnuler.addActionListener(this);
        this.btValider.addActionListener(this);
        
        String entetes[] = {"Id Sportif", "Nom", "Prénom", "Sexe", "Email", "Age", "Taille", "Poids", "Objectif", "Téléphone", "Mot de Passe"};
        this.tableauSportif = new Tableau(this.obtenirDonnees(""), entetes);
        this.tableSportif = new JTable(tableauSportif);
        JScrollPane uneScroll = new JScrollPane(this.tableSportif);
        uneScroll.setBounds(400, 80, 600, 340);
        this.add(uneScroll);
        
        this.btSupprimer.setBounds(50, 420, 200, 40);
        this.add(this.btSupprimer);
        this.btSupprimer.setBackground(Color.red);
        this.btSupprimer.setVisible(false);
        this.btSupprimer.addActionListener(this);
        
        this.tableSportif.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 1) {
                    int numLigne = tableSportif.getSelectedRow();
                    txtNom.setText(tableauSportif.getValueAt(numLigne, 1).toString());
                    txtPrenom.setText(tableauSportif.getValueAt(numLigne, 2).toString());
                    txtSexe.setText(tableauSportif.getValueAt(numLigne, 3).toString());
                    txtEmail.setText(tableauSportif.getValueAt(numLigne, 4).toString());
                    txtAge.setText(tableauSportif.getValueAt(numLigne, 5).toString());
                    txtTaille.setText(tableauSportif.getValueAt(numLigne, 6).toString());
                    txtPoids.setText(tableauSportif.getValueAt(numLigne, 7).toString());
                    txtObjectif.setText(tableauSportif.getValueAt(numLigne, 8).toString());
                    txtTelephone.setText(tableauSportif.getValueAt(numLigne, 9).toString());
                    txtMotDePasse.setText(tableauSportif.getValueAt(numLigne, 10).toString());
                    btValider.setText("Modifier");
                    btSupprimer.setVisible(true);
                }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        
        this.panelFiltre.setBackground(Color.orange);
        this.panelFiltre.setLayout(new GridLayout(1, 3));
        this.panelFiltre.setBounds(420, 50, 500, 20);
        this.panelFiltre.add(new JLabel("Filtrer par :"));
        this.panelFiltre.add(this.txtFiltre);
        this.panelFiltre.add(this.btFiltrer);
        this.add(this.panelFiltre);
        this.btFiltrer.addActionListener(this);
        
	}
	
	public Object[][] obtenirDonnees(String filtre) {
	    ArrayList<Sportif> lesSportifs;
	    if (filtre.equals("")) {
	        lesSportifs = Controlleur.selectAllSportifs();
	    } else {
	        lesSportifs = Controlleur.selectLikeSportifs(filtre);
	    }
	
	    Object[][] matrice = new Object[lesSportifs.size()][11];
	    int i = 0;
	    for (Sportif unSportif : lesSportifs) {
	    	matrice[i][0] = unSportif.getIdSportif();
	        matrice[i][1] = unSportif.getNom();
	        matrice[i][2] = unSportif.getPrenom();
	        matrice[i][3] = unSportif.getSexe();
	        matrice[i][4] = unSportif.getEmail();
	        matrice[i][5] = unSportif.getAge();
	        matrice[i][6] = unSportif.getTaille();
	        matrice[i][7] = unSportif.getPoids();
	        matrice[i][8] = unSportif.getObjectif();
	        matrice[i][9] = unSportif.getTelephone();
	        matrice[i][10] = unSportif.getMotDePasse();
	        i++;
	    }
	    return matrice;
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btAnnuler) {
        	txtNom.setText("");
            txtPrenom.setText("");
            txtEmail.setText("");
            txtTelephone.setText("");
            txtMotDePasse.setText("");
            txtAge.setText("");
            txtSexe.setText("");
            txtTaille.setText("");
            txtPoids.setText("");
            txtObjectif.setText("");
            btValider.setText("Valider");
            btSupprimer.setVisible(false);
        }
        else if (e.getSource() == btValider && btValider.getText().equals("Modifier")) {
            int idSportif = Integer.parseInt(tableauSportif.getValueAt(tableSportif.getSelectedRow(), 0).toString());
            Sportif unSportif = new Sportif(idSportif, txtNom.getText(), txtPrenom.getText(), txtEmail.getText(), txtTelephone.getText(), new String(txtMotDePasse.getPassword()), Integer.parseInt(txtAge.getText()), txtSexe.getText(), Float.parseFloat(txtTaille.getText()), Float.parseFloat(txtPoids.getText()), txtObjectif.getText());
            Controlleur.updateSportif(unSportif);
            tableauSportif.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Modification réussie du Sportif.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btValider) {
            Sportif unSportif = new Sportif( txtNom.getText(), txtPrenom.getText(), txtEmail.getText(), txtTelephone.getText(), new String(txtMotDePasse.getPassword()), Integer.parseInt(txtAge.getText()), txtSexe.getText(), Float.parseFloat(txtTaille.getText()), Float.parseFloat(txtPoids.getText()), txtObjectif.getText());
            Controlleur.insertSportif(unSportif);
            tableauSportif.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Insertion réussie du Sportif.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btSupprimer) {
            int idSportif = Integer.parseInt(tableauSportif.getValueAt(tableSportif.getSelectedRow(), 0).toString());
            System.out.println(idSportif);
            Controlleur.deleteSportif(idSportif);
            tableauSportif.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Suppression réussie du Sportif.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btFiltrer) {
            tableauSportif.setDonnees(this.obtenirDonnees(txtFiltre.getText()));
        }
    }
}

       

