package vue;

import controlleur.Coach;
import controlleur.Controlleur;
import controlleur.Salles;
import controlleur.Tableau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelSalle extends PanelPrincipal implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panelForm = new JPanel();
    private JTextField txtNom = new JTextField();
    private JTextField txtAdresse = new JTextField();
    private JTextField txtVille = new JTextField();
    private JTextField txtChaine = new JTextField();
    private JTextField txtHoraire_debut = new JTextField();
    private JTextField txtHoraire_fin = new JTextField();

    private JButton btAnnuler = new JButton("Annuler");
    private JButton btValider = new JButton("Valider");
    private JButton btSupprimer = new JButton("Supprimer");

    private JTable tableSalle;
    private Tableau tableauSalle;

    private JPanel panelFiltre = new JPanel();
    private JTextField txtFiltre = new JTextField();
    private JButton btFiltrer = new JButton("Filtrer");

    public PanelSalle() {
    	super("Gestion des Coachs");

        this.panelForm.setBackground(Color.blue);
        this.panelForm.setBounds(60, 50, 300, 300);
        this.panelForm.setLayout(new GridLayout(7, 2));

        this.panelForm.add(new JLabel("Nom :"));
        this.panelForm.add(this.txtNom);
        this.panelForm.add(new JLabel("Adresse :"));
        this.panelForm.add(this.txtAdresse);
        this.panelForm.add(new JLabel("Ville :"));
        this.panelForm.add(this.txtVille);
        this.panelForm.add(new JLabel("Chaine :"));
        this.panelForm.add(this.txtChaine);
        this.panelForm.add(new JLabel("Horaire_debut :"));
        this.panelForm.add(this.txtHoraire_debut);
        this.panelForm.add(new JLabel("Horaire_fin :"));
        this.panelForm.add(this.txtHoraire_fin);
        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btValider);
        this.add(this.panelForm);

        this.btAnnuler.addActionListener(this);
        this.btValider.addActionListener(this);

        String entetes[] = { "ID Salle", "Nom", "Adresse", "Ville", "Chaine", "Horaire_debut", "Horaire_fin"};
        this.tableauSalle = new Tableau(this.obtenirDonnees(""), entetes);
        this.tableSalle = new JTable(tableauSalle);
        JScrollPane uneScroll = new JScrollPane(this.tableSalle);
        uneScroll.setBounds(400, 80, 600, 340);
        this.add(uneScroll);

        this.btSupprimer.setBounds(50, 420, 200, 40);
        this.add(this.btSupprimer);
        this.btSupprimer.setBackground(Color.red);
        this.btSupprimer.setVisible(false);
        this.btSupprimer.addActionListener(this);

        this.tableSalle.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 1) {
                    int numLigne = tableSalle.getSelectedRow();
                    txtNom.setText(tableauSalle.getValueAt(numLigne, 1).toString());
                    txtAdresse.setText(tableauSalle.getValueAt(numLigne, 2).toString());
                    txtVille.setText(tableauSalle.getValueAt(numLigne, 3).toString());
                    txtChaine.setText(tableauSalle.getValueAt(numLigne, 4).toString());
                    txtHoraire_debut.setText(tableauSalle.getValueAt(numLigne, 5).toString());
                    txtHoraire_fin.setText(tableauSalle.getValueAt(numLigne, 6).toString());
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
        ArrayList<Salles> lesSalles;
        if (filtre.equals("")) {
            lesSalles = Controlleur.selectAllSalles();
        } else {
            lesSalles = Controlleur.selectLikeSalles(filtre);
        }

        Object[][] matrice = new Object[lesSalles.size()][7];
        int i = 0;
        for (Salles unSalle : lesSalles) {
        	matrice[i][0] = unSalle.getId();
            matrice[i][1] = unSalle.getNom();
            matrice[i][2] = unSalle.getAdresse();
            matrice[i][3] = unSalle.getVille();
            matrice[i][4] = unSalle.getChaine();
            matrice[i][5] = unSalle.getHoraire_debut();
            matrice[i][6] = unSalle.getHoraire_fin();
            i++;
        }
        return matrice;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btAnnuler) {
            txtNom.setText("");
            txtAdresse.setText("");
            txtVille.setText("");
            txtChaine.setText("");
            txtHoraire_debut.setText("");
            txtHoraire_fin.setText("");
            btValider.setText("Valider");
            btSupprimer.setVisible(false);
        }
        else if (e.getSource() == btValider && btValider.getText().equals("Modifier")) {
            int id = Integer.parseInt(tableauSalle.getValueAt(tableSalle.getSelectedRow(), 0).toString());
            Coach unSalle = new Coach(id, txtNom.getText(), txtAdresse.getText(), txtVille.getText(), txtChaine.getText(), txtHoraire_debut.getText(), txtHoraire_fin.getText());
            Controlleur.updateCoach(unSalle);
            tableauSalle.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Modification réussie du Salle.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btValider) {
            Coach unSalle = new Coach(txtNom.getText(), txtAdresse.getText(), txtVille.getText(), txtChaine.getText(), txtHoraire_debut.getText(), txtHoraire_fin.getText());
            Controlleur.insertCoach(unSalle);
            tableauSalle.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Insertion réussie du Salle.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btSupprimer) {
        	System.out.println(tableauSalle.getValueAt(tableSalle.getSelectedRow(), 0));
            int id = Integer.parseInt(tableauSalle.getValueAt(tableSalle.getSelectedRow(), 0)+"");
            System.out.println(id);
            Controlleur.deleteCoach(id);
            tableauSalle.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Suppression réussie du Salle.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btFiltrer) {
            tableauSalle.setDonnees(this.obtenirDonnees(txtFiltre.getText()));
        }
    }
}

