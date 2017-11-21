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
	protected Main main;
	protected Pioche pioche;
	
	/* Constructeurs */
	
	public Joueur() {

	}

	public Joueur(String nom,Pioche pioche) {
		this.nom = nom;
		this.pioche = pioche;
		this.main = new Main(this);
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

}
