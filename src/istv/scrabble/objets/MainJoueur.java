package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
	}
	
	
    public List<Character> ajoutLettreMain(List<Character> rack) {
        mainJoueur.addAll(rack);
        return mainJoueur;
    }
    
	public List<Character> getMainJoueur() {
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
