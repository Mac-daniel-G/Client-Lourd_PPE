package controlleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
	
	private Object donnees [][];
	private String entetes [];
	
	public Tableau(Object[][] donnees, String[] entetes) {
		super();
		this.donnees = donnees;
		this.entetes = entetes;
	}

	@Override
	public int getRowCount() {
		return this.donnees.length; //nombre de lignes
	}

	@Override
	public int getColumnCount() {
		return this.entetes.length;//nombre de column
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.donnees[rowIndex][columnIndex]; //retourne les valeur
	}

	@Override
	public String getColumnName(int column) {
		return this.entetes[column]; //retourne le nom des colonne
	}
	
	public void setDonnees (Object matrice [][]) {
		this.donnees = matrice ;
		this.fireTableDataChanged(); //actualiser les données
	}
	
	

}