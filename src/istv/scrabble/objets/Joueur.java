/**
 * @author Amine BOUMOUSSOU
 * Licence 3 FA - ISTV
 * 
 */
package istv.scrabble.objets;

/**
 * 
 * Joueur.java
 *
 */

public class Joueur {
	// ATTRIBUTS
	String nom;
	int score;
	MainJoueur main;

	// CONSTRUCTEURS
	public Joueur() {
		this.nom = "Undefined";
		this.score = 0;
		this.main = new MainJoueur();
	}

	public Joueur(String nom) {
		this.nom = nom;
		this.score = 0;
		this.main = new MainJoueur();
	}

	// METHODES
	public void jouerCellule(int i, int j, CelluleImpl cellule) {
		// PlateauImp.poserCellule(i, j, cellule);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public MainJoueur getMain() {
		return main;
	}

	public void setMain(MainJoueur main) {
		this.main = main;
	}
}
