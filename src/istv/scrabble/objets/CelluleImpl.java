package istv.scrabble.objets;

import istv.scrabble.enumerations.CelluleBonus;
import istv.scrabble.interfaces.Cellule;

/**
 * 
 * 
 * @author Amine BOUMOUSSOU
 * @contributors Aurelien PIETRZAK
 */

public class CelluleImpl implements Cellule {

	/* Attributs */

	private int i, j, scoreLettre;
	private Character lettre;
	private Boolean estVide;
	private Boolean estJouable;
	private CelluleBonus bonus;
	
	/* Constructeurs */


	public CelluleImpl() {

	}

	public CelluleImpl(final int i, final int j) {
		this.i = i;
		this.j = j;
	}
	
	public CelluleImpl(final int i, final int j,final CelluleBonus bonus) {
		this.i = i;
		this.j = j;
		this.bonus = bonus;
		
	}

	public CelluleImpl(final Character lettre) {
		this.lettre = lettre;
		this.char2score();
		this.estVide = false;
		this.estJouable = false;
	}
	
	public CelluleImpl(final Character lettre,CelluleBonus bonus) {
		this.lettre = lettre;
		this.char2score();
		this.estVide = false;
		this.estJouable = false;
		this.bonus = bonus;
	}

	/* Methodes */

	@Override
	public String toString() {
		
		if(!this.estVide)
		return " [" + this.getLettre() + "," + this.getI() + "," + this.getJ() + "] ";
		return " [VIDE] ";	
	
	}
		
	@Override
	public CelluleImpl genererCelluleVide() {

		this.lettre = ' ';
		this.scoreLettre = 0;
		this.setEstVide();
		this.estJouable = false;
		return this;
	
	}

	
	@Override
	public int getI() {
		return i;
	}

	@Override
	public void setI(int i) {
		this.i = i;
	}

	@Override
	public int getJ() {
		return j;
	}

	@Override
	public void setJ(int j) {
		this.j = j;
	}

	@Override
	public int getScoreLettre() {
		return scoreLettre;
	}

	@Override
	public void setScoreLettre(int scoreLettre) {
		this.scoreLettre = scoreLettre;
	}

	@Override
	public Character getLettre() {
		return lettre;
	}

	@Override
	public void setLettre(Character lettre) {
		this.lettre = lettre;
	}
	
	public CelluleBonus getBonus() {
		return bonus;
	}
	
	public void setBonus(CelluleBonus bonus) {
		this.bonus = bonus;
	}

	@Override
	public Boolean getEstVide() {
		return estVide;
	}

	@Override
	public void setEstVide(Boolean estVide) {
		this.estVide = estVide;
	}

	@Override
	public void setEstVide() {
		if (this.lettre.equals(' ')) {
			this.estVide = true;
		} else
			this.estVide = false;
	}

	@Override
	public Boolean getEstJouable() {
		return estJouable;
	}

	@Override
	public void setEstJouable(Boolean estJouable) {
		this.estJouable = estJouable;
	}
	
	@Override
	public void setEstJouable() {
		if(this.estVide) {
			this.estJouable = true;
		}
		else this.estJouable = false;
	}
	
	public void char2score() {
		
		Lettre l = new Lettre();
		
		this.scoreLettre = l.getScore(this.getLettre());
	}


	
}
