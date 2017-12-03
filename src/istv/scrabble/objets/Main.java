package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import istv.scrabble.exceptions.Logger;

/**
 * 
 * @author Nicolas JOURDAIN
 * 
 */

public class Main {

	/* Attributs */

	protected List<CelluleImpl> cellulesMain;
	protected Joueur joueur;

	
	/* Constructeurs */
	
	public Main(Joueur joueur) {

		this.joueur = joueur;
		this.cellulesMain = new ArrayList<CelluleImpl>();
		this.joueur.setMain(this);
		this.joueur.getPioche();

		List<Character> pioche = this.joueur.getPioche().piocheLettre(7);

		for (Character c : pioche) {
			cellulesMain.add(new CelluleImpl(c));
			Logger.log("Lettre " + c + " ajoutée au Joueur " + joueur.getNom());
		}
	}

	/* Méthodes */
	
	public void piocherLettreManquante() {

		int nombreLettresManquantes = 7 - this.cellulesMain.size();
		List<Character> lettresManquantes = this.joueur.getPioche().piocheLettre(nombreLettresManquantes);
		
		for (Character c : lettresManquantes) {
			this.ajouteCelluleMain(new CelluleImpl(c));
		}
		
		for (Character c : lettresManquantes) {
			Logger.log("Lettre " + c + " ajoutée au Joueur " + joueur.getNom());
		}
	}

	public void ajouteCelluleMain(CelluleImpl cellule) {
		this.cellulesMain.add(cellule);
	}

	public void retirerCelluleMain(CelluleImpl cellule) {
		this.cellulesMain.remove(cellule);
	}

	public List<CelluleImpl> getCellulesJoueur() {
		return this.cellulesMain;
	}

	public void setMainJoueur(List<CelluleImpl> cellules) {
		this.cellulesMain = cellules;
	}

	public void melangerMain() {
		Collections.shuffle(cellulesMain);
	}

	public String toString() {

		String main = " [ ";

		for (CelluleImpl c : this.cellulesMain) {
			main += c.getLettre() + " ";
		}

		main += "]";

		return main;
	}

}
