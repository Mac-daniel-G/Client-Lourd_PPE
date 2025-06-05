package vue;

import controlleur.Programme;
import controlleur.Controlleur;
import controlleur.Tableau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelProgramme extends PanelPrincipal implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panelForm = new JPanel();
    private JTextField txtNomProgramme = new JTextField();
    private JTextField txtRythme = new JTextField();
    private JTextField txtDescription = new JTextField();
    private JTextField txtDuree = new JTextField();
    private JComboBox<String> cbCategorie = new JComboBox<>();
    private JTextField txtSalle_id = new JTextField();
    private JTextField txtCoach_id = new JTextField();


    private JButton btAnnuler = new JButton("Annuler");
    private JButton btValider = new JButton("Valider");
    private JButton btSupprimer = new JButton("Supprimer");

    private JTable tableProgramme;
    private Tableau tableauProgramme;

    private JPanel panelFiltre = new JPanel();
    private JTextField txtFiltre = new JTextField();
    private JButton btFiltrer = new JButton("Filtrer");
	
    

    public PanelProgramme() {
    	super("Gestion des Programmes");

        this.panelForm.setBackground(Color.blue);
        this.panelForm.setBounds(60, 50, 300, 300);
        this.panelForm.setLayout(new GridLayout(8, 2));

        this.panelForm.add(new JLabel("Nom Programme :"));
        this.panelForm.add(this.txtNomProgramme);
        this.panelForm.add(new JLabel("Rythme :"));
        this.panelForm.add(this.txtRythme);
        this.panelForm.add(new JLabel("Description :"));
        this.panelForm.add(this.txtDescription);
        this.panelForm.add(new JLabel("Duree :"));
        this.panelForm.add(this.txtDuree);
        this.panelForm.add(new JLabel("Categorie :"));
        this.panelForm.add(this.cbCategorie);
        this.panelForm.add(new JLabel("Id Salle :"));
        this.panelForm.add(this.txtSalle_id);
        this.panelForm.add(new JLabel("Id Coach :"));
        this.panelForm.add(this.txtCoach_id);
        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btValider);
        this.add(this.panelForm);

        this.btAnnuler.addActionListener(this);
        this.btValider.addActionListener(this);
        
        this.cbCategorie.addItem("simple");
        this.cbCategorie.addItem("moyen");
        this.cbCategorie.addItem("lourd");

        String entetes[] = {"Id Programme", "Nom", "Rythme", "Description", "Durée", "Catégorie", "Id Salle", "Id Coach"};
        this.tableauProgramme = new Tableau(this.obtenirDonnees(""), entetes);
        this.tableProgramme = new JTable(tableauProgramme);
        JScrollPane uneScroll = new JScrollPane(this.tableProgramme);
        uneScroll.setBounds(400, 80, 600, 340);
        this.add(uneScroll);

        this.btSupprimer.setBounds(50, 420, 200, 40);
        this.add(this.btSupprimer);
        this.btSupprimer.setBackground(Color.red);
        this.btSupprimer.setVisible(false);
        this.btSupprimer.addActionListener(this);

        this.tableProgramme.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 1) {
                    int numLigne = tableProgramme.getSelectedRow();
                    txtNomProgramme.setText(tableauProgramme.getValueAt(numLigne, 1).toString());
                    txtRythme.setText(tableauProgramme.getValueAt(numLigne, 2).toString());
                    txtDescription.setText(tableauProgramme.getValueAt(numLigne, 3).toString());
                    txtDuree.setText(tableauProgramme.getValueAt(numLigne, 4).toString());
                    cbCategorie.setSelectedItem(tableauProgramme.getValueAt(numLigne, 5).toString());
                    txtSalle_id.setText(tableauProgramme.getValueAt(numLigne, 6).toString());
                    txtCoach_id.setText(tableauProgramme.getValueAt(numLigne, 7).toString());
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
        ArrayList<Programme> lesProgrammes;
        if (filtre.equals("")) {
            lesProgrammes = Controlleur.selectAllProgrammes();
        } else {
            lesProgrammes = Controlleur.selectLikeProgrammes(filtre);
        }

        Object[][] matrice = new Object[lesProgrammes.size()][8];
        int i = 0;
        for (Programme unProgramme : lesProgrammes) {
        	matrice[i][0] = unProgramme.getIdProgramme();
            matrice[i][1] = unProgramme.getNomProgramme();
            matrice[i][2] = unProgramme.getRythme();
            matrice[i][3] = unProgramme.getDescription();
            matrice[i][4] = unProgramme.getDuree();
            matrice[i][5] = unProgramme.getCategorie();
            matrice[i][6] = unProgramme.getSalleId();
            matrice[i][7] = unProgramme.getCoachId();
            i++;
        }
        return matrice;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btAnnuler) {
            txtNomProgramme.setText("");
            txtRythme.setText("");
            txtDescription.setText("");
            txtDuree.setText("");
            cbCategorie.setToolTipText("");
            txtSalle_id.setText("");
            txtCoach_id.setText("");
            cbCategorie.setSelectedIndex(0);
            btValider.setText("Valider");
            btSupprimer.setVisible(false);
        }
        else if (e.getSource() == btValider && btValider.getText().equals("Modifier")) {
            int id_programme = Integer.parseInt(tableauProgramme.getValueAt(tableProgramme.getSelectedRow(), 0).toString());
            int salle_id = Integer.parseInt(txtSalle_id.getText());
            int coach_id = Integer.parseInt(txtCoach_id.getText());
            Programme unProgramme = new Programme(
            	id_programme,
                txtNomProgramme.getText(),
                txtRythme.getText(),
                txtDescription.getText(),
                txtDuree.getText(),
                cbCategorie.getSelectedItem().toString(),
                salle_id,
                coach_id
            );
            Controlleur.updateProgramme(unProgramme);
            tableauProgramme.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Modification réussie du Programme.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btValider) {
        	int salle_id = Integer.parseInt(txtSalle_id.getText());
        	int coach_id = Integer.parseInt(txtCoach_id.getText());
        	Programme unProgramme = new Programme(
        	    txtNomProgramme.getText(),
        	    txtRythme.getText(),
        	    txtDescription.getText(),
        	    txtDuree.getText(),
        	    cbCategorie.getSelectedItem().toString(),
        	    salle_id,
        	    coach_id
        	);

            Controlleur.insertProgramme(unProgramme);
            tableauProgramme.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Insertion réussie du Programme.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btSupprimer) {
        	System.out.println(tableauProgramme.getValueAt(tableProgramme.getSelectedRow(), 0));
            int id_programme = Integer.parseInt(tableauProgramme.getValueAt(tableProgramme.getSelectedRow(), 0)+"");
            System.out.println(id_programme);
            Controlleur.deleteProgramme(id_programme);
            tableauProgramme.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Suppression réussie du Programme.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btFiltrer) {
            tableauProgramme.setDonnees(this.obtenirDonnees(txtFiltre.getText()));
        }
    }
}

