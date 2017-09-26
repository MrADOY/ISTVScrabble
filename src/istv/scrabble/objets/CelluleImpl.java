package istv.scrabble.objets;

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
	private String lettre;
	private Boolean estVide;

	/* Constructeurs */

	public CelluleImpl() {

	}

	public CelluleImpl(final int i, final int j) {
		this.i = i;
		this.j = j;
	}

	public CelluleImpl(final String lettre, final int scoreLettre) {
		this.lettre = lettre;
		this.scoreLettre = scoreLettre;
		this.estVide = false;
	}

	/* Methodes */

	@Override
	public void genererCelluleVide() {

		this.lettre = "";
		this.estVide = true;
		this.scoreLettre = 0;

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
	public String getLettre() {
		return lettre;
	}

	@Override
	public void setLettre(String lettre) {
		this.lettre = lettre;
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
		if (this.lettre.equals("")) {
			this.estVide = true;
		} else
			this.estVide = false;
	}
}
