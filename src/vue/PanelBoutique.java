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

import controlleur.Boutique;
import controlleur.Controlleur;
import controlleur.Tableau;

public class PanelBoutique extends PanelPrincipal implements ActionListener {
    private JPanel panelForm = new JPanel();
    private JTextField txtNomArticle = new JTextField();
    private JTextField txtDescriptionArticle = new JTextField();
    private JTextField txtPrixArticle = new JTextField();
    private JTextField txtImageArticle = new JTextField();
    private JTextField txtIdSportif = new JTextField();
    
    private JButton btAnnuler = new JButton("Annuler");
    private JButton btValider = new JButton("Valider");
    private JButton btSupprimer = new JButton("Supprimer");
    
    private JTable tableBoutique ;
    private Tableau tableauBoutique ;
    
    private JPanel panelFiltre = new JPanel();
    private JTextField txtFiltre = new JTextField();
    private JButton btFiltrer = new JButton("Filtrer");
    
    public PanelBoutique() {
        super("Gestion des Articles de la Boutique");
        
        // Construire le panelForm
        this.panelForm.setBackground(Color.pink);
        this.panelForm.setBounds(60, 50, 250, 300);
        this.panelForm.setLayout(new GridLayout(6,2));
        
        this.panelForm.add(new JLabel("Nom de l'Article :"));
        this.panelForm.add(this.txtNomArticle);
        this.panelForm.add(new JLabel("Description :"));
        this.panelForm.add(this.txtDescriptionArticle);
        this.panelForm.add(new JLabel("Prix :"));
        this.panelForm.add(this.txtPrixArticle);
        this.panelForm.add(new JLabel("Image :"));
        this.panelForm.add(this.txtImageArticle);
        this.panelForm.add(new JLabel("ID Sportif :"));
        this.panelForm.add(this.txtIdSportif);
        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btValider);
        this.add(this.panelForm);
        
        // Rendre les boutons écoutables
        this.btAnnuler.addActionListener(this);
        this.btValider.addActionListener(this);
        
        // Construction de la table des articles
        String entetes[] = {"ID Article", "Nom", "Description", "Prix", "Image"};
        
        this.tableauBoutique = new Tableau(this.obtenirDonnees(""), entetes);
        this.tableBoutique = new JTable(tableauBoutique);
        JScrollPane uneScroll = new JScrollPane(this.tableBoutique);
        uneScroll.setBounds(380, 80, 540, 340);
        this.add(uneScroll);
        
        // Installation du bouton supprimer
        this.btSupprimer.setBounds(50, 420, 200, 40);
        this.add(this.btSupprimer);
        this.btSupprimer.setBackground(Color.red);
        this.btSupprimer.setVisible(false);
        this.btSupprimer.addActionListener(this);
        
        // Activer le MouseListener : clic sur la table
        this.tableBoutique.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int numLigne ;
                if (e.getClickCount() >= 1) {
                    numLigne = tableBoutique.getSelectedRow();
                    txtNomArticle.setText(tableauBoutique.getValueAt(numLigne, 1).toString());
                    txtDescriptionArticle.setText(tableauBoutique.getValueAt(numLigne, 2).toString());
                    txtPrixArticle.setText(tableauBoutique.getValueAt(numLigne, 3).toString());
                    txtImageArticle.setText(tableauBoutique.getValueAt(numLigne, 4).toString());
                    txtIdSportif.setText(tableauBoutique.getValueAt(numLigne, 5).toString());
                    
                    btValider.setText("Modifier");
                    btSupprimer.setVisible(true);
                }
            }
        });
        
        // Installation du panel Filtre
        this.panelFiltre.setBackground(Color.pink);
        this.panelFiltre.setLayout(new GridLayout(1, 3));
        this.panelFiltre.setBounds(400, 50, 400, 20);
        this.panelFiltre.add(new JLabel("Filtrer par :"));
        this.panelFiltre.add(this.txtFiltre);
        this.panelFiltre.add(this.btFiltrer);
        this.add(this.panelFiltre);
        this.btFiltrer.addActionListener(this);
    }
    
    public Object [][] obtenirDonnees(String filtre){
        ArrayList<Boutique> lesBoutique;
        
        if (filtre.equals("")) {
        	lesBoutique = Controlleur.selectAllBoutiques();
        } else {
        	lesBoutique = Controlleur.selectLikeBoutiques(filtre);
        }
        
        Object [][] matrice = new Object[lesBoutique.size()][6];
        int i = 0;
        for (Boutique unBoutique : lesBoutique) {
            matrice[i][0] = unBoutique.getId_article();
            matrice[i][1] = unBoutique.getNom_article();
            matrice[i][2] = unBoutique.getDescription_article();
            matrice[i][3] = unBoutique.getPrix_article();
            matrice[i][4] = unBoutique.getImage_article();
            i++;
        }
        return matrice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btAnnuler) {
            this.txtNomArticle.setText("");
            this.txtDescriptionArticle.setText("");
            this.txtPrixArticle.setText("");
            this.txtImageArticle.setText("");
            this.txtIdSportif.setText("");
            btValider.setText("Valider");
            btSupprimer.setVisible(false);
        }
        
        else if (e.getSource() == this.btValider && this.btValider.getText().equals("Modifier")) {
            // On récupère ID
            int idArticle, numLigne;
            numLigne = this.tableBoutique.getSelectedRow();
            idArticle = Integer.parseInt(this.tableauBoutique.getValueAt(numLigne, 0).toString());
            
            // On récupère les données
            String nomArticle = this.txtNomArticle.getText();
            String descriptionArticle = this.txtDescriptionArticle.getText();
            float prixArticle = Float.parseFloat(this.txtPrixArticle.getText());
            String imageArticle = this.txtImageArticle.getText();
            int idSportif = Integer.parseInt(this.txtIdSportif.getText());
            
            // On instancie un article avec tous les données
            Boutique unBoutique = new Boutique(idArticle, nomArticle, descriptionArticle, prixArticle, imageArticle);
            
            // On appelle la méthode update via le contrôleur
            Controlleur.updateBoutique(unBoutique);
            
            // On actualise l'affichage du tableau
            this.tableauBoutique.setDonnees(this.obtenirDonnees(""));
            
            // Confirmation de modification
            JOptionPane.showMessageDialog(this, "Modification réussie de l'Article.");
            
            // On vide les champs
            this.txtNomArticle.setText("");
            this.txtDescriptionArticle.setText("");
            this.txtPrixArticle.setText("");
            this.txtImageArticle.setText("");
            this.txtIdSportif.setText("");
            
            btValider.setText("Valider");
            btSupprimer.setVisible(false);
        }
        
        else if (e.getSource() == this.btValider && this.btValider.getText().equals("Valider")) {
            String nomArticle = this.txtNomArticle.getText();
            String descriptionArticle = this.txtDescriptionArticle.getText();
            float prixArticle = Float.parseFloat(this.txtPrixArticle.getText());
            String imageArticle = this.txtImageArticle.getText();
            int idSportif = Integer.parseInt(this.txtIdSportif.getText());
            
            // Instancier la classe Boutique
            Boutique unBoutique = new Boutique(nomArticle, descriptionArticle, prixArticle, imageArticle);
            
            // Insérer dans la base de données
            Controlleur.insertBoutique(unBoutique);
            
            // Confirmation d'insertion
            JOptionPane.showMessageDialog(this, "Insertion réussie de l'Article.");
            
            // Actualiser l'affichage du tableau
            this.tableauBoutique.setDonnees(this.obtenirDonnees(""));
            
            // Vider les champs
            this.txtNomArticle.setText("");
            this.txtDescriptionArticle.setText("");
            this.txtPrixArticle.setText("");
            this.txtImageArticle.setText("");
            this.txtIdSportif.setText("");
            
            btValider.setText("Valider");
            btSupprimer.setVisible(false);
        }
        
        else if (e.getSource() == this.btSupprimer) {
            // Récupérer ID de l'article
            int idArticle, numLigne;
            numLigne = this.tableBoutique.getSelectedRow();
            idArticle = Integer.parseInt(this.tableauBoutique.getValueAt(numLigne, 0).toString());
            
            // Appeler le contrôleur pour supprimer l'article
            Controlleur.deleteBoutique(idArticle);
            
            // Actualiser l'affichage du tableau
            this.tableauBoutique.setDonnees(this.obtenirDonnees(""));
            
            // Confirmation de suppression
            JOptionPane.showMessageDialog(this, "Suppression réussie de l'Article.");
        }
        
        else if (e.getSource() == this.btFiltrer) {
            // Filtrer les articles
            this.tableauBoutique.setDonnees(this.obtenirDonnees(this.txtFiltre.getText()));
        }
    }
}

