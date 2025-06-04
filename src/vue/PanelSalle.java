package vue;

import controlleur.Salles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelSalle extends JPanel implements ActionListener {

    private JTable tableSalles;
    private DefaultTableModel model;
    private JTextField txtNom, txtAdresse, txtVille, txtChaine, txtDisponibilites;
    private JButton btValider, btSupprimer, btAnnuler;

    private ArrayList<Salles> salles;
    private int selectedIndex = -1;

    public PanelSalle() {
        setLayout(new BorderLayout());

        // --- TABLE ---
        model = new DefaultTableModel(new String[]{"Nom", "Adresse", "Ville", "Chaîne", "Disponibilités"}, 0);
        tableSalles = new JTable(model);
        tableSalles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableSalles.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedIndex = tableSalles.getSelectedRow();
                if (selectedIndex != -1) {
                    Salles s = salles.get(selectedIndex);
                    txtNom.setText(s.getNom());
                    txtAdresse.setText(s.getAdresse());
                    txtVille.setText(s.getVille());
                    txtChaine.setText(s.getChaine());
                    txtDisponibilites.setText(s.getDisponibilites());
                    btValider.setText("Modifier");
                }
            }
        });

        add(new JScrollPane(tableSalles), BorderLayout.CENTER);

        // --- FORMULAIRE ---
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        txtNom = new JTextField();
        txtAdresse = new JTextField();
        txtVille = new JTextField();
        txtChaine = new JTextField();
        txtDisponibilites = new JTextField();

        formPanel.add(new JLabel("Nom de la salle :"));
        formPanel.add(txtNom);
        formPanel.add(new JLabel("Adresse :"));
        formPanel.add(txtAdresse);
        formPanel.add(new JLabel("Ville :"));
        formPanel.add(txtVille);
        formPanel.add(new JLabel("Chaîne :"));
        formPanel.add(txtChaine);
        formPanel.add(new JLabel("Disponibilités :"));
        formPanel.add(txtDisponibilites);

        add(formPanel, BorderLayout.NORTH);

        // --- BOUTONS ---
        JPanel btnPanel = new JPanel();
        btValider = new JButton("Valider");
        btSupprimer = new JButton("Supprimer");
        btAnnuler = new JButton("Annuler");

        btValider.addActionListener(this);
        btSupprimer.addActionListener(this);
        btAnnuler.addActionListener(this);

        btnPanel.add(btValider);
        btnPanel.add(btSupprimer);
        btnPanel.add(btAnnuler);

        add(btnPanel, BorderLayout.SOUTH);

        salles = new ArrayList<>();
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btValider) {
            String nom = txtNom.getText().trim();
            String adresse = txtAdresse.getText().trim();
            String ville = txtVille.getText().trim();
            String chaine = txtChaine.getText().trim();
            String disponibilites = txtDisponibilites.getText().trim();

            if (nom.isEmpty() || adresse.isEmpty() || ville.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir les champs obligatoires (nom, adresse, ville).");
                return;
            }

            if (btValider.getText().equals("Valider")) {
                Salles s = new Salles(nom, adresse, ville, chaine, disponibilites);
                salles.add(s);
                model.addRow(new Object[]{nom, adresse, ville, chaine, disponibilites});
            } else {
                Salles s = salles.get(selectedIndex);
                s.setNom(nom);
                s.setAdresse(adresse);
                s.setVille(ville);
                s.setChaine(chaine);
                s.setDisponibilites(disponibilites);

                model.setValueAt(nom, selectedIndex, 0);
                model.setValueAt(adresse, selectedIndex, 1);
                model.setValueAt(ville, selectedIndex, 2);
                model.setValueAt(chaine, selectedIndex, 3);
                model.setValueAt(disponibilites, selectedIndex, 4);

                btValider.setText("Valider");
            }

            resetForm();

        } else if (source == btSupprimer) {
            if (selectedIndex != -1) {
                salles.remove(selectedIndex);
                model.removeRow(selectedIndex);
                selectedIndex = -1;
                resetForm();
                btValider.setText("Valider");
            }
        } else if (source == btAnnuler) {
            resetForm();
            btValider.setText("Valider");
            tableSalles.clearSelection();
            selectedIndex = -1;
        }
    }

    private void resetForm() {
        txtNom.setText("");
        txtAdresse.setText("");
        txtVille.setText("");
        txtChaine.setText("");
        txtDisponibilites.setText("");
    }
}
