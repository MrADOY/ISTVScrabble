package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Nicolas JOURDAIN
 * 
 */

public class MainJoueur {

	// ATTRIBUTS

	protected List<CelluleImpl> mainJoueur;


	/**
	 * Constructeur de MainJoueur
	 */

	public MainJoueur() {
		mainJoueur = new ArrayList<CelluleImpl>();

		List<Character> pioche = Pioche.piocheLettre(7);

		for (Character c : pioche) {
			mainJoueur.add(new CelluleImpl(c));
		}

	}

	public void piocherLettreManquante() {

		int nombreLettresManquantes = 7 - this.mainJoueur.size();
		List<Character> lettresManquantes = Pioche.piocheLettre(nombreLettresManquantes);
		for (Character c : lettresManquantes) {
			this.ajoutCelluleMain(new CelluleImpl(c));
		}
	}

	public void ajoutCelluleMain(CelluleImpl cellule) {
		this.mainJoueur.add(cellule);
	}

	public void retirerCelluleMain(CelluleImpl cellule) {
		this.mainJoueur.remove(cellule);
	}

	public List<CelluleImpl> getMainJoueur() {
		return this.mainJoueur;
	}

	public void afficherMainJoueur() {
		System.out.println("Votre main est : ");
		for (CelluleImpl c : mainJoueur)
			System.out.print(c + " ");
		System.out.print("\n");
	}


	public void setMainJoueur(List<CelluleImpl> cellules) {
		this.mainJoueur = cellules;
	}

	public void melangerMain() {
		Collections.shuffle(mainJoueur);
	}
	
	public String toString() {
		
		String main = " [ ";
				
		for(CelluleImpl c : this.mainJoueur) {
			main += c.getLettre() + " ";
		}
		
		main += " ]";
		return main;
	}
	
}
