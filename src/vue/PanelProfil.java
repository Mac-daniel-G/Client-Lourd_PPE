package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlleur.Admin;
import controlleur.Controlleur;
import controlleur.FatFitnessAdmin;
import modele.Modele;

public class PanelProfil extends PanelPrincipal implements ActionListener {

    private Admin adminConnecte;
    private JTextArea txtInfos = new JTextArea();

    private JButton btModifier = new JButton("Modifier");
    private JPanel panelForm = new JPanel();

    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtRole = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JTextField txtTel = new JTextField();
    private JPasswordField txtMdp1 = new JPasswordField();
    private JPasswordField txtMdp2 = new JPasswordField();

    private JButton btAnnuler = new JButton("Annuler");
    private JButton btValider = new JButton("Valider");

    public PanelProfil() {
        super("Profil Administrateur");

        this.adminConnecte = FatFitnessAdmin.getAdminConnecte();

        this.txtInfos.setText(
                "\n_______________PROFIL ADMIN________________\n\n"
                + " Nom : " + adminConnecte.getNom() + "\n\n"
                + " Prénom : " + adminConnecte.getPrenom() + "\n\n"
                + " Role : " + adminConnecte.getRole() + "\n\n"
                + " Email : " + adminConnecte.getEmail() + "\n\n"
                + " Téléphone : " + adminConnecte.getTel() + "\n\n"
                + " ________________________________________________"
        );
        this.txtInfos.setBounds(50, 100, 400, 250);
        this.txtInfos.setBackground(Color.LIGHT_GRAY);
        this.txtInfos.setEditable(false);
        this.add(this.txtInfos);

        // Formulaire
        this.panelForm.setBackground(Color.LIGHT_GRAY);
        this.panelForm.setLayout(new GridLayout(8, 2));
        this.panelForm.setBounds(460, 100, 400, 280);

        this.panelForm.add(new JLabel("Nom : "));
        this.panelForm.add(this.txtNom);

        this.panelForm.add(new JLabel("Prénom : "));
        this.panelForm.add(this.txtPrenom);

        this.panelForm.add(new JLabel("Role : "));
        this.panelForm.add(this.txtRole);
        
        this.panelForm.add(new JLabel("Email : "));
        this.panelForm.add(this.txtEmail);

        this.panelForm.add(new JLabel("Téléphone : "));
        this.panelForm.add(this.txtTel);

        this.panelForm.add(new JLabel("Mot de passe : "));
        this.panelForm.add(this.txtMdp1);

        this.panelForm.add(new JLabel("Confirmation MDP : "));
        this.panelForm.add(this.txtMdp2);

        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btValider);

        this.panelForm.setVisible(false);
        this.add(this.panelForm);

        this.btModifier.setBounds(200, 370, 120, 40);
        this.add(this.btModifier);

        // Ajout listeners
        this.btModifier.addActionListener(this);
        this.btAnnuler.addActionListener(this);
        this.btValider.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btModifier) {
            this.panelForm.setVisible(true);
            this.txtNom.setText(adminConnecte.getNom());
            this.txtPrenom.setText(adminConnecte.getPrenom());
            this.txtRole.setText(adminConnecte.getRole());
            this.txtEmail.setText(adminConnecte.getEmail());
            this.txtTel.setText(adminConnecte.getTel());
        } else if (e.getSource() == this.btAnnuler) {
            this.panelForm.setVisible(false);
            this.txtNom.setText("");
            this.txtPrenom.setText("");
            this.txtRole.setText("");
            this.txtEmail.setText("");
            this.txtTel.setText("");
            this.txtMdp1.setText("");
            this.txtMdp2.setText("");
        } else if (e.getSource() == this.btValider) {
            String nom = txtNom.getText().trim();
            String prenom = txtPrenom.getText().trim();
            String role = txtRole.getText().trim();
            String email = txtEmail.getText().trim();
            String tel = txtTel.getText().trim();
            String mdp1 = new String(txtMdp1.getPassword());
            String mdp2 = new String(txtMdp2.getPassword());

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || tel.isEmpty() || mdp1.isEmpty() || mdp2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires.");
            } else if (!mdp1.equals(mdp2)) {
                JOptionPane.showMessageDialog(this, "Les mots de passe ne correspondent pas.");
            } else {
                adminConnecte.setNom(nom);
                adminConnecte.setPrenom(prenom);
                adminConnecte.setRole(role);
                adminConnecte.setEmail(email);
                adminConnecte.setTel(tel);
                adminConnecte.setMdp(mdp1);

                Controlleur.updateAdmin(adminConnecte);

                JOptionPane.showMessageDialog(this, "Profil mis à jour avec succès !");
                this.panelForm.setVisible(false);

                // Rafraîchir infos
                this.txtInfos.setText(
                        "\n_______________PROFIL ADMIN________________\n\n"
                        + " Nom : " + adminConnecte.getNom() + "\n\n"
                        + " Prénom : " + adminConnecte.getPrenom() + "\n\n"
                        + " Role : " + adminConnecte.getRole() + "\n\n"
                        + " Email : " + adminConnecte.getEmail() + "\n\n"
                        + " Téléphone : " + adminConnecte.getTel() + "\n\n"
                        + " ________________________________________________"
                );
            }
        }
    }
}
