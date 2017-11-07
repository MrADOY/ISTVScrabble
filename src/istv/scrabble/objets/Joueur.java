package istv.scrabble.objets;

/**
 * @author Amine BOUMOUSSOU
 * Licence 3 FA - ISTV
 * 
 */


public class Joueur {
	
	/* Attributs */
	
	protected String nom;
	protected int score;
	protected MainJoueur main;

	/* Constructeurs */
	
	public Joueur() {

	}

	public Joueur(String nom) {
		this.nom = nom;
		this.main = new MainJoueur();
	}

	/* Methodes */
	


	public void calculScore(int score) {
		this.score += score;
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
