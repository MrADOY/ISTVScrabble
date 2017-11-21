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

public class Main {

	// ATTRIBUTS

	protected List<CelluleImpl> mainJoueur;
	protected Joueur joueur;

	/**
	 * Constructeur de MainJoueur
	 */

	public Main(Joueur joueur) {
		
		
		this.joueur = joueur;
		this.mainJoueur = new ArrayList<CelluleImpl>();
		this.joueur.setMain(this);
		
		List<Character> pioche = joueur.getPioche().piocheLettre(7);

		for (Character c : pioche) {
			mainJoueur.add(new CelluleImpl(c));
			System.out.println("Lettre " + c + " ajoutée au Joueur "+ joueur.getNom() );
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
