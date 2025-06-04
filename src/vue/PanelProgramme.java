package vue;

import controlleur.Programme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PanelProgramme extends JPanel implements ActionListener {

    private JTable tableProgramme;
    private DefaultTableModel model;
    private JTextField txtNom, txtRythme, txtDuree;
    private JTextArea txtDescription;
    private JComboBox<String> cbCategorie;
    private JButton btValider, btSupprimer, btAnnuler;

    private ArrayList<Programme> programmes;
    private int selectedIndex = -1;

    public PanelProgramme() {
        setLayout(new BorderLayout());

        // --- TABLE ---
        model = new DefaultTableModel(new String[]{"Nom", "Rythme", "Durée", "Catégorie"}, 0);
        tableProgramme = new JTable(model);
        tableProgramme.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableProgramme.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedIndex = tableProgramme.getSelectedRow();
                if (selectedIndex != -1) {
                    Programme p = programmes.get(selectedIndex);
                    txtNom.setText(p.getNomProgramme());
                    txtRythme.setText(p.getRythme());
                    txtDescription.setText(p.getDescription());
                    txtDuree.setText(p.getDuree());
                    cbCategorie.setSelectedItem(p.getCategorie());
                    btValider.setText("Modifier");
                }
            }
        });

        add(new JScrollPane(tableProgramme), BorderLayout.CENTER);

        // --- FORMULAIRE ---
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        txtNom = new JTextField();
        txtRythme = new JTextField();
        txtDescription = new JTextArea(3, 20);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDuree = new JTextField();

        cbCategorie = new JComboBox<>(new String[]{"simple", "moyen", "lourd"});

        formPanel.add(new JLabel("Nom du programme :"));
        formPanel.add(txtNom);
        formPanel.add(new JLabel("Rythme :"));
        formPanel.add(txtRythme);
        formPanel.add(new JLabel("Description :"));
        formPanel.add(new JScrollPane(txtDescription));
        formPanel.add(new JLabel("Durée :"));
        formPanel.add(txtDuree);
        formPanel.add(new JLabel("Catégorie :"));
        formPanel.add(cbCategorie);

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

        programmes = new ArrayList<>();
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btValider) {
            String nom = txtNom.getText().trim();
            String rythme = txtRythme.getText().trim();
            String description = txtDescription.getText().trim();
            String duree = txtDuree.getText().trim();
            String categorie = cbCategorie.getSelectedItem().toString();

            if (nom.isEmpty() || rythme.isEmpty() || duree.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs obligatoires.");
                return;
            }

            if (btValider.getText().equals("Valider")) {
                Programme p = new Programme(nom, rythme, description, duree, categorie);
                programmes.add(p);
                model.addRow(new Object[]{nom, rythme, duree, categorie});
            } else {
                Programme p = programmes.get(selectedIndex);
                p.setNomProgramme(nom);
                p.setRythme(rythme);
                p.setDescription(description);
                p.setDuree(duree);
                p.setCategorie(categorie);

                model.setValueAt(nom, selectedIndex, 0);
                model.setValueAt(rythme, selectedIndex, 1);
                model.setValueAt(duree, selectedIndex, 2);
                model.setValueAt(categorie, selectedIndex, 3);

                btValider.setText("Valider");
            }

            resetForm();

        } else if (source == btSupprimer) {
            if (selectedIndex != -1) {
                programmes.remove(selectedIndex);
                model.removeRow(selectedIndex);
                selectedIndex = -1;
                resetForm();
                btValider.setText("Valider");
            }
        } else if (source == btAnnuler) {
            resetForm();
            btValider.setText("Valider");
            tableProgramme.clearSelection();
            selectedIndex = -1;
        }
    }

    private void resetForm() {
        txtNom.setText("");
        txtRythme.setText("");
        txtDescription.setText("");
        txtDuree.setText("");
        cbCategorie.setSelectedIndex(0);
    }
}

