package vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controlleur.Admin;
import controlleur.Controlleur;
import controlleur.FatFitnessAdmin;
import modele.Modele;

public class VueConnexion extends JFrame implements ActionListener, KeyListener {

    private JPanel panelCon = new JPanel();
    private JButton btSeConnecter = new JButton("Se connecter");
    private JButton btAnnuler = new JButton("Annuler");
    private JTextField txtEmail = new JTextField("admin@fatfitness.com");
    private JPasswordField txtMdp = new JPasswordField("000");

    public VueConnexion() {
        this.setTitle("FatFitness - Connexion Admin");
        this.setBounds(100, 100, 700, 350);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.darkGray);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon logoImage = new ImageIcon("src/images/Capture d'écran 2025-04-11 150006.png");
        JLabel logo = new JLabel(logoImage);
        logo.setBounds(20, 20, 300, 250);
        this.add(logo);

        this.panelCon.setBackground(Color.darkGray);
        this.panelCon.setBounds(350, 80, 280, 150);
        this.panelCon.setLayout(new GridLayout(3, 2));
        this.panelCon.add(new JLabel("Email :"));
        this.panelCon.add(this.txtEmail);
        this.panelCon.add(new JLabel("Mot de passe :"));
        this.panelCon.add(this.txtMdp);
        this.panelCon.add(this.btAnnuler);
        this.panelCon.add(this.btSeConnecter);
        this.add(this.panelCon);

        this.btAnnuler.addActionListener(this);
        this.btSeConnecter.addActionListener(this);

        this.btAnnuler.addKeyListener(this);
        this.btSeConnecter.addKeyListener(this);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btAnnuler) {
            this.txtEmail.setText("");
            this.txtMdp.setText("");
        } else if (e.getSource() == this.btSeConnecter) {
            this.traitement();
        }
    }

    private void traitement() {
        String email = this.txtEmail.getText();
        String mdp = new String(this.txtMdp.getPassword());

        // Vérification de l'admin via Controlleur
        Admin unAdmin = Controlleur.selectWhereAdmin(email, mdp);
        if (unAdmin == null) {
            JOptionPane.showMessageDialog(this, "Identifiants incorrects ou vous n'êtes pas un administrateur autorisé.",
                    "Erreur de Connexion", JOptionPane.ERROR_MESSAGE);
        } else {
        	JOptionPane.showMessageDialog(this, "Bienvenue à l'application FatFitness\n" + " Vous est : Nom "
					+ unAdmin.getNom() + "\n"+ " Vous est : Prenom "
					+ unAdmin.getPrenom() + "\n"+ " Vous est : Role "
					+ unAdmin.getRole() + "\n"+ " Vous est : Email "
					+ unAdmin.getEmail() + "\n"+ " Vous est : Mots de passe "
					+ unAdmin.getMdp() + "\n"+ " Vou est : Telephone "
					+ unAdmin.getTel() + "\n" , "Connexion à FatFitness", JOptionPane.INFORMATION_MESSAGE);

            // Sauvegarder l'admin connecté
            FatFitnessAdmin.setTechConnecte(unAdmin);

            // Lancer la vue générale
            FatFitnessAdmin.rendreVisibleVueConnexion(false);
            FatFitnessAdmin.creerVueGenerale(true);
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.traitement();
        }
    }

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
    	new VueConnexion();
    }
}

