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
	
	protected List<Character> mainJoueur;
	
	
	/**
	 * Constructeur de MainJoueur
	 */
	public MainJoueur() {
		mainJoueur = new ArrayList<Character>();
		mainJoueur.addAll(Pioche.piocheLettre(7));
	}
	
	
    public List<Character> ajoutLettreMain(List<Character> rack) {
        mainJoueur.addAll(rack);
        return mainJoueur;
    }
    
    public List<Character> retirerLettreMain(List<Character> rack) {
        mainJoueur.removeAll(rack);
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


	public void setMainJoueur(List<Character> mainJoueur, MainJoueur main) {
		main = (MainJoueur) mainJoueur;
	}
	
	public List<Character> melangerMain(List<Character> mainJoueur) {
		Collections.shuffle(mainJoueur);
		return mainJoueur;
	}
}
