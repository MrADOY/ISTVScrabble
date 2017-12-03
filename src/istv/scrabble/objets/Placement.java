package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.List;

import istv.scrabble.interfaces.Cellule;

/**
 * 
 * @author Aurelien Pietrzak
 *
 */


public class Placement {

	/* Attributs */

	List<String> mots;
	List<Cellule> cellules;

	/* Constructeurs */

	/* Methodes */

	public List<String> getMot() {
		return mots;
	}

	public List<Cellule> getCellules() {
		return cellules;
	}

	public void setCellules(List<Cellule> cellules) {
		this.cellules = cellules;
	}

	public void setMot(List<String> mots) {
		this.mots = mots;
	}

	public Placement addCellules(List<Cellule> cellules) {
		
		if (this.cellules == null) {
			this.cellules = new ArrayList<Cellule>();
			this.cellules = cellules;
		} else {
			this.cellules.addAll(cellules);
		}

		return this;
	}
	
	public Placement addMot(String mot) {
		if (this.mots == null)
			this.mots = new ArrayList<String>();

		mots.add(mot);

		return this;
	}
	
	public String toString() {
		
		String placement =  "Placement ";
		
		placement += "Cellule actuelles  : " ;
				
		for(Cellule c : this.getCellules()) {
			placement += "[" + c.getLettre() + "]";
		}
		
		placement += "Mots actuels  : " ;
		
		for(String mot : this.getMot()) {
			placement += "[" + mot + "]";
		}
		
		return placement;
		
	}
}
