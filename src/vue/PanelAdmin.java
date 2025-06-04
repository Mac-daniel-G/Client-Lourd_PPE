package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlleur.Admin;
import controlleur.Controlleur;

public class PanelAdmin extends PanelPrincipal implements ActionListener {
    
    private JPanel panelForm = new JPanel();
    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtRole = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JPasswordField txtMdp = new JPasswordField();
    private JTextField txtTel = new JTextField();
    
    private JButton btAnnuler = new JButton("Annuler");
    private JButton btValider = new JButton("Valider");
    
    public PanelAdmin() {
        super("Gestion des administrateurs");
        
        // Construction du panelForm
        this.panelForm.setBackground(Color.cyan);
        this.panelForm.setBounds(60, 50, 250, 300);
        this.panelForm.setLayout(new GridLayout(7, 2));
        
        this.panelForm.add(new JLabel("Nom :"));
        this.panelForm.add(this.txtNom);
        this.panelForm.add(new JLabel("Prénom :"));
        this.panelForm.add(this.txtPrenom);
        this.panelForm.add(new JLabel("Rôle :"));
        this.panelForm.add(this.txtRole);
        this.panelForm.add(new JLabel("Email :"));
        this.panelForm.add(this.txtEmail);
        this.panelForm.add(new JLabel("Mot de passe :"));
        this.panelForm.add(this.txtMdp);
        this.panelForm.add(new JLabel("Téléphone :"));
        this.panelForm.add(this.txtTel);
        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btValider);
        
        this.add(this.panelForm);
        
        // Rendre les boutons écoutables
        this.btAnnuler.addActionListener(this);
        this.btValider.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btAnnuler) {
            this.txtNom.setText("");
            this.txtPrenom.setText("");
            this.txtRole.setText("");
            this.txtEmail.setText("");
            this.txtTel.setText("");
            this.txtMdp.setText("");
        } 
        else if (e.getSource() == this.btValider) {
            String nom = this.txtNom.getText();
            String prenom = this.txtPrenom.getText();
            String role = this.txtRole.getText();
            String email = this.txtEmail.getText();
            String tel = this.txtTel.getText();
            String mdp = new String(this.txtMdp.getPassword());

            Admin unAdmin = new Admin(nom, prenom, role, email, mdp, tel);
            Controlleur.insertAdmin(unAdmin);

            JOptionPane.showMessageDialog(this, "Insertion réussie de l'administrateur.");
            this.txtNom.setText("");
            this.txtPrenom.setText("");
            this.txtRole.setText("");
            this.txtEmail.setText("");
            this.txtTel.setText("");
            this.txtMdp.setText("");
        }
    }
}

