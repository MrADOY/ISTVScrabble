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
	protected static Joueur[] joueurs;
	protected static Joueur joueurActuel;
	
	
	
	public Scrabble() {
//		plateau = new PlateauImpl();
		pioche = new Pioche();
//		joueurs = new Joueur[2];
//		
	}
	
 
	public static Joueur getJoueurActuel() {
		return joueurActuel;
	}
	
	public static void setJoueurActuel(Joueur j) {
		Scrabble.joueurActuel = j;
	}
	
	public static void switchJoueur() {
		if (Scrabble.joueurActuel.equals(joueurs[0])) {
			Scrabble.setJoueurActuel(joueurs[1]);
		}
		else {
			Scrabble.setJoueurActuel(joueurs[0]);
		}
	}
	
}
