package istv.scrabble.objets;

import istv.scrabble.exceptions.GameException;
import istv.scrabble.exceptions.Logger;
import istv.scrabble.interfaces.Plateau;

/**
 * @author Amine BOUMOUSSOU
 * Licence 3 FA - ISTV
 * 
 */


public class Joueur {
	
	/* Attributs */
	
	protected String nom;
	protected int score;
	protected Main main;
	protected Pioche pioche;
	protected PlateauImpl plateauJeu;
	
	/* Constructeurs */
	
	public Joueur() {

	}

	public Joueur(String nom,Pioche pioche,PlateauImpl plateauJeu) {
	
		this.nom = nom;
		this.pioche = pioche;
		this.main = new Main(this);
		this.plateauJeu = plateauJeu;
		Logger.log("Initialisation du joueur " + nom + " , OK! ");
	
	}

	/* Methodes */
	


	public void calculScore(int score) {
		this.score += score;
		Logger.log("Le joueur " + this.nom + " possède un score de " + this.score);
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

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	public Pioche getPioche() {
		return pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}
	
	public String toString() {
		return  nom + " score : " + score + " main : " + main;
		
	}
	
	public CelluleImpl choisirCelluleMain(int nb) {
		return this.getMain().getCellulesJoueur().get(nb);
	}
	
	public void poserCellule(int nb , int i , int j) {
		
		try {
			this.plateauJeu.poserCellule(i, j, choisirCelluleMain(nb));
		} catch (GameException e) {
			//
		}
	}
	
	public boolean poserCellule2(int nb , int i , int j) {
		try {
			this.plateauJeu.poserCellule(i, j, choisirCelluleMain(nb));
			return true;
		} catch (GameException e) {
			return false;
		}
	}
	public void piocheLettre() {
		this.main.piocherLettreManquante();
	}

}
