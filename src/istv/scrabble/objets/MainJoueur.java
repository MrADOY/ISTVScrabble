package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import istv.scrabble.interfaces.PiocheInt;

/**
 * 
 * @author Nicolas JOURDAIN
 * 
 */
public class MainJoueur {

	// ATTRIBUTS
	
	protected static List<Character> mainJoueur;
	
	
	/**
	 * Constructeur de MainJoueur
	 */
	public MainJoueur() {
		mainJoueur = new ArrayList<Character>();
//		PiocheInt p = new Pioche();
//		List<Character> l = new ArrayList<Character>();
//		l = Pioche.piocheLettre(7);
//		((MainJoueur) mainJoueur).ajoutLettreMain(l);

	}
	
	
    public List<Character> ajoutLettreMain(List<Character> rack) {
        mainJoueur.addAll(rack);
        return mainJoueur;
    }
    
	public static List<Character> getMainJoueur() {
		return mainJoueur;
	}
	
	public void afficherMainJoueur() {
		System.out.println("Votre main est : ");
		for(Character l : mainJoueur)
		System.out.print(l + " ");
		System.out.print("\n");
	}


	public static void setMainJoueur(List<Character> mainJoueur) {
		MainJoueur.mainJoueur = mainJoueur;
	}
	
	public List<Character> melangerMain(List<Character> mainJoueur) {
		Collections.shuffle(mainJoueur);
		return mainJoueur;
	}

	
	
}
