package istv.scrabble.interfaces;

import istv.scrabble.objets.CelluleImpl;

/**
 * 
 * 
 * @author Amine BOUMOUSSOU
 * @contributors Aurelien PIETRZAK
 */

public interface Cellule {
	
	/* Methodes */
	
	public CelluleImpl genererCelluleVide();
	public int getI();
	public void setI(int i);
	public int getJ();
	public void setJ(int j);
	public int getScoreLettre();
	public void setScoreLettre(int scoreLettre);
	public void setLettre(Character lettre);
	public Character getLettre();
	public Boolean getEstVide();
	public void setEstVide(Boolean estVide);
	public void setEstVide();
	public Boolean getEstJouable();
	public void setEstJouable(Boolean estJouable);
	public void setEstJouable();
	
}
