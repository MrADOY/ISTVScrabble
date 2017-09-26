package istv.scrabble.interfaces;
import istv.scrabble.objets.CelluleImpl;

/**
 * 
 *
 * @author Aurelien PIETRZAK
 *
 */

public interface Plateau {

	/*Constantes*/
	
	final int LARGEUR_PLATEAU = 15;
	final int LONGUEUR_PLATEAU = 15;
	
	/*Methodes*/
	
	public CelluleImpl[][] getPlateau();
	public void poserCellule(final int i , final int j,final CelluleImpl cellule);
	public void creationPlateau();
	public CelluleImpl getCellule(final int i,final int j);
}
