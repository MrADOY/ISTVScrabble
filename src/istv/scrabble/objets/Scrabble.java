/**
 * 22-09-2017
 * @author Lefevre Romain
 * Licence 3 FA - ISTV
 * 
 */

package istv.scrabble.objets;


public class Scrabble {

	protected PlateauImpl plateau;
	protected Pioche pioche;
	protected Joueur[] joueurs;
	
	public Scrabble() {
		plateau = new PlateauImpl();
		pioche = new Pioche();
		joueurs = new Joueur[2];
		
	}
	
}
