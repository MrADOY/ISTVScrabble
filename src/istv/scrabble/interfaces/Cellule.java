package istv.scrabble.interfaces;

/**
 * 
 * 
 * @author Amine BOUMOUSSOU
 * @contributors Aurelien PIETRZAK
 */

public interface Cellule {
	
	/* Methodes */
	
	public void genererCelluleVide();
	public int getI();
	public void setI(int i);
	public int getJ();
	public void setJ(int j);
	public int getScoreLettre();
	public void setScoreLettre(int scoreLettre);
	public String getLettre();
	public void setLettre(String lettre);
	public Boolean getEstVide();
	public void setEstVide(Boolean estVide);
	public void setEstVide();
	
}
