package istv.scrabble.objets;

/**
 * 
 * @author Nicolas JOURDAIN
 * 
 */
public class MainJoueur {

	// ATTRIBUTS
	static CelluleImpl[][] mainJoueur;
	
	
	/**
	 * Constructeur de MainJoueur
	 */
	public MainJoueur() {
		mainJoueur = new CelluleImpl[1][7];
	}


	public static CelluleImpl[][] getMainJoueur() {
		return mainJoueur;
	}


	public static void setMainJoueur(CelluleImpl[][] mainJoueur) {
		MainJoueur.mainJoueur = mainJoueur;
	}
	
	public MainJoueur melangerMain(MainJoueur mainJoueur) {
		
		return mainJoueur;
	}
	
	public MainJoueur piocherLettre(MainJoueur main, Pioche pioche) {
		
		return main;
		
	}

}
