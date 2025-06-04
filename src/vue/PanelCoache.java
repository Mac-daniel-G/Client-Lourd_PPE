package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlleur.Coach;
import controlleur.Controlleur;
import controlleur.Tableau;

public class PanelCoache extends PanelPrincipal implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panelForm = new JPanel();
    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtSpecialite = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JTextField txtTelephone = new JTextField();
    private JTextField txtMotDePasse = new JTextField();

    private JButton btAnnuler = new JButton("Annuler");
    private JButton btValider = new JButton("Valider");
    private JButton btSupprimer = new JButton("Supprimer");

    private JTable tableCoach;
    private Tableau tableauCoach;

    private JPanel panelFiltre = new JPanel();
    private JTextField txtFiltre = new JTextField();
    private JButton btFiltrer = new JButton("Filtrer");

    public PanelCoache() {
        super("Gestion des Coachs");

        this.panelForm.setBackground(Color.blue);
        this.panelForm.setBounds(60, 50, 300, 300);
        this.panelForm.setLayout(new GridLayout(7, 2));

        this.panelForm.add(new JLabel("Nom :"));
        this.panelForm.add(this.txtNom);
        this.panelForm.add(new JLabel("Prénom :"));
        this.panelForm.add(this.txtPrenom);
        this.panelForm.add(new JLabel("Spécialité :"));
        this.panelForm.add(this.txtSpecialite);
        this.panelForm.add(new JLabel("Email :"));
        this.panelForm.add(this.txtEmail);
        this.panelForm.add(new JLabel("Téléphone :"));
        this.panelForm.add(this.txtTelephone);
        this.panelForm.add(new JLabel("Mot de Passe :"));
        this.panelForm.add(this.txtMotDePasse);
        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btValider);
        this.add(this.panelForm);

        this.btAnnuler.addActionListener(this);
        this.btValider.addActionListener(this);

        String entetes[] = {"Id Coach", "Nom", "Prénom", "Spécialité", "Email", "Téléphone", "Mot de Passe"};
        this.tableauCoach = new Tableau(this.obtenirDonnees(""), entetes);
        this.tableCoach = new JTable(tableauCoach);
        JScrollPane uneScroll = new JScrollPane(this.tableCoach);
        uneScroll.setBounds(400, 80, 600, 340);
        this.add(uneScroll);

        this.btSupprimer.setBounds(50, 420, 200, 40);
        this.add(this.btSupprimer);
        this.btSupprimer.setBackground(Color.red);
        this.btSupprimer.setVisible(false);
        this.btSupprimer.addActionListener(this);

        this.tableCoach.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 1) {
                    int numLigne = tableCoach.getSelectedRow();
                    txtNom.setText(tableauCoach.getValueAt(numLigne, 1).toString());
                    txtPrenom.setText(tableauCoach.getValueAt(numLigne, 2).toString());
                    txtSpecialite.setText(tableauCoach.getValueAt(numLigne, 3).toString());
                    txtEmail.setText(tableauCoach.getValueAt(numLigne, 4).toString());
                    txtTelephone.setText(tableauCoach.getValueAt(numLigne, 5).toString());
                    txtMotDePasse.setText(tableauCoach.getValueAt(numLigne, 6).toString());
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
        ArrayList<Coach> lesCoachs;
        if (filtre.equals("")) {
            lesCoachs = Controlleur.selectAllCoachs();
        } else {
            lesCoachs = Controlleur.selectLikeCoachs(filtre);
        }

        Object[][] matrice = new Object[lesCoachs.size()][7];
        int i = 0;
        for (Coach unCoach : lesCoachs) {
        	matrice[i][0] = unCoach.getIdCoach();
            matrice[i][1] = unCoach.getNom();
            matrice[i][2] = unCoach.getPrenom();
            matrice[i][3] = unCoach.getSpecialite();
            matrice[i][4] = unCoach.getEmail();
            matrice[i][5] = unCoach.getTelephone();
            matrice[i][6] = unCoach.getMotDePasse();
            i++;
        }
        return matrice;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btAnnuler) {
            txtNom.setText("");
            txtPrenom.setText("");
            txtSpecialite.setText("");
            txtEmail.setText("");
            txtTelephone.setText("");
            txtMotDePasse.setText("");
            btValider.setText("Valider");
            btSupprimer.setVisible(false);
        }
        else if (e.getSource() == btValider && btValider.getText().equals("Modifier")) {
            int id_coach = Integer.parseInt(tableauCoach.getValueAt(tableCoach.getSelectedRow(), 0).toString());
            Coach unCoach = new Coach(id_coach, txtNom.getText(), txtPrenom.getText(), txtSpecialite.getText(), txtEmail.getText(), txtTelephone.getText(), txtMotDePasse.getText());
            Controlleur.updateCoach(unCoach);
            tableauCoach.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Modification réussie du Coach.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btValider) {
            Coach unCoach = new Coach(txtNom.getText(), txtPrenom.getText(), txtSpecialite.getText(), txtEmail.getText(), txtTelephone.getText(), txtMotDePasse.getText());
            Controlleur.insertCoach(unCoach);
            tableauCoach.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Insertion réussie du Coach.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btSupprimer) {
        	System.out.println(tableauCoach.getValueAt(tableCoach.getSelectedRow(), 0));
            int id_coach = Integer.parseInt(tableauCoach.getValueAt(tableCoach.getSelectedRow(), 0)+"");
            System.out.println(id_coach);
            Controlleur.deleteCoach(id_coach);
            tableauCoach.setDonnees(this.obtenirDonnees(""));
            JOptionPane.showMessageDialog(this, "Suppression réussie du Coach.");
            btAnnuler.doClick();
        }
        else if (e.getSource() == btFiltrer) {
            tableauCoach.setDonnees(this.obtenirDonnees(txtFiltre.getText()));
        }
    }
}

