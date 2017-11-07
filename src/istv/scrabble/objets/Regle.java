package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.List;

import istv.scrabble.enumerations.CelluleBonus;
import istv.scrabble.exceptions.GameException;
import istv.scrabble.interfaces.Cellule;
import istv.scrabble.interfaces.Plateau;

/**
 * 
 * @author Aurelien Pietrzak
 * @contributors Romain Lefevre 
 */


/*
 * Classe qui permet d'appliquer toutes les regles du jeu Scrabble. 
 */

public class Regle {

	/* Attributs */

	static boolean[][] changementGrille = new boolean[15][15];

	/**
	 * 
	 * Methode principale qui récupère les mots posés sur la grille au tour t
	 */

	public Placement recuperationMotsPoses() throws GameException{

		/* Initialise les variables pour connaître le cas dans lequel on se trouve */

		Direction direction = null;
		int indicePremierChangement = this.getPremierChangement();
		int i = getI(indicePremierChangement);
		int j = getJ(indicePremierChangement);
		int nombreChangement = this.getNombreChangement();
		int nombreVoisin = this.getNbVoisin(i, j);
		Placement p = new Placement();

		/* Le joueur complete un mot */

		if (nombreChangement == 1) {

			/* Le joueur complète un SEUL ET UNIQUE mot */
			
			if (nombreVoisin <= 1) {
				
				direction = this.getDirectionMot(i, j);
				this.getMotPose(p,direction, i, j);
			}

			/* Cas très rare le joueur complète DEUX MOTS avec SEULE lettre */

			else {	
				this.getMotPose(p,Direction.HORIZONTALE, i, j); 
				this.getMotPose(p,Direction.VERTICALE, i, j);
			}
		}

		/*
		 * Le joueur pose plusieurs pièces plusieurs cas s'offrent à nous -> Le joueur
		 * pose un mot sans lien direct avec d'autre mot -> Le joueur pose un mot qui
		 * complète la fin d'un autre mot
		 */

		else if (nombreChangement > 1)

		{
			if (nombreVoisin == 1) {

				{
	
					direction = this.getDirectionMot(i, j);
					this.getMotPose(p ,direction, i, j);

					int IndiceDerniereCase = this.getIndiceDernierCase(direction, i, j);
					int IderniereCase = this.getI(IndiceDerniereCase);
					int JderniereCase = this.getJ(IndiceDerniereCase);

					if (this.getNbVoisin(IderniereCase, JderniereCase) > 1) {

						direction = (direction.equals(Direction.VERTICALE)) ? Direction.HORIZONTALE : Direction.VERTICALE;					
							this.getMotPoseIndice(p , direction, IderniereCase, JderniereCase);

					}
				}
			}

			if (nombreVoisin >= 2) { // LES MOTS SERONT FORCEMENT DANS LES DEUX DIRECTIONS
				
				this.getMotPose(p , Direction.HORIZONTALE, i, j);
				this.getMotPose(p , Direction.VERTICALE, i, j);

			}

		}

		// Verifie si les mots posés sont dans le dico
		
		boolean isInDico = true;
		for(String pla : p.getMot()) {
			isInDico = this.isInDico(pla);
			if(!isInDico) {
				//TODO ENLEVER LES CELLULES
				new GameException("Mot : " + pla + " n'est pas un mot valide");
			}
		}
		
		// Calcul le score des mots posés 
		
		Scrabble.getJoueurActuel().calculScore(valeurScore(p.getCellules()));
		
		return p;
	}
	
	/**
	 * Verifie que le mot est présent dans le dico
	 */
	public boolean isInDico(String monMot) {
		return Dictionnaire.set.contains(monMot.toUpperCase());
	}
	
	/**
	 * Découpe le mot en character & calcul le score des mots posés 
	 */
	
	public static int valeurScore(List<Cellule> cellules) {
		int score = 0;
		for (Cellule c : cellules) {
			if (c.getCelluleBonus().equals(CelluleBonus.MOT_COMPTE_DOUBLE)
					|| (c.getCelluleBonus().equals(CelluleBonus.MOT_COMPTE_TRIPLE))) {
				// TODO
				score = score + c.getScoreLettre();
			} else {
				score = score + (c.getScoreLettre() * c.getCelluleBonus().getBonus());
			}
		}
		return score;
	}

	
	/**
	 * Recupere la direction d'un mot à partir des indices fournis en entrée
	 */

	private Direction getDirectionMot(int i, int j) {

		if (!PlateauImpl.plateauJeu[i][j - 1].getEstVide())
			return Direction.HORIZONTALE;
		else if (!PlateauImpl.plateauJeu[i][j + 1].getEstVide())
			return Direction.HORIZONTALE;
		else if (!PlateauImpl.plateauJeu[i - 1][j].getEstVide())
			return Direction.VERTICALE;
		else if (!PlateauImpl.plateauJeu[i + 1][j].getEstVide())
			return Direction.VERTICALE;

		return null;

	}

	/**
	 * Recupere un mot pose à partir dans la direction donnée La méthode permet de
	 * partir du mot plus en haut / du mot le plus à gauche
	 */

	private void getMotPose(Placement placement ,Direction direction, int i, int j) {

		String mot = "";
		List<Cellule> cellules = new ArrayList<Cellule>();
		
		switch (direction) {

		case VERTICALE:

			while (!PlateauImpl.plateauJeu[i - 1][j].getEstVide()) {
				i--;
			}

			while (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre();
				cellules.add(PlateauImpl.plateauJeu[i][j]);
				i++;
			}

			break;

		case HORIZONTALE:

			while (!PlateauImpl.plateauJeu[i][j - 1].getEstVide()) {
				j--;
			}

			while (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre();
				cellules.add(PlateauImpl.plateauJeu[i][j]);
				j++;
			}

			break;

		}

		placement.addCellules(cellules).addMot(mot);
	}

	/**
	 * Recupere le mot selon la direction et à partir dans indices fournis
	 */

	private void getMotPoseIndice(Placement placement, Direction direction, int i, int j) {

		String mot = "";
		List<Cellule> cellules = new ArrayList<Cellule>();

		switch (direction) {

		case VERTICALE:

			while (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre();
				i++;
			}

			break;

		case HORIZONTALE:

			while (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre();
				j++;
			}

			break;

		}

		placement.addCellules(cellules).addMot(mot);
	}

	/*
	 * Recupère le premier Changement dans la grille de changement d'etat
	 */

	private int getPremierChangement() {

		for (int i = 0; i < Plateau.LARGEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LONGUEUR_PLATEAU; j++) {
				if (changementGrille[i][j]) {
					return Plateau.LARGEUR_PLATEAU * i + j;
				}
			}
		}
		return -1;
	}

	/**
	 * Recupère l'indice de la dernière lettre d'un mot dans la grille
	 */

	private int getIndiceDernierCase(Direction direction, int i, int j) {

		switch (direction) {
		case VERTICALE:
			while (!PlateauImpl.plateauJeu[i + 1][j].getEstVide())
				i++;
			break;

		case HORIZONTALE:
			while (!PlateauImpl.plateauJeu[i][j + 1].getEstVide())
				j++;
			break;
		}

		return Plateau.LARGEUR_PLATEAU * i + j;
	}

	/**
	 * Recupère le nombre de changement d'état dans la grille de changement
	 */

	private int getNombreChangement() {

		int nb = 0;

		for (int i = 0; i < Plateau.LARGEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LONGUEUR_PLATEAU; j++) {
				if (changementGrille[i][j]) {
					nb++;
				}
			}
		}

		return nb;
	}

	/**
	 * Initialise la grille des changements d'etat à false
	 */

	public void initChangementGrille() {
		for (int i = 0; i < Plateau.LARGEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LONGUEUR_PLATEAU; j++) {
				changementGrille[i][j] = false;
			}
		}
	}

	/**
	 * Recupere le nombre de voisin d'une Cellule
	 */

	private int getNbVoisin(int i, int j) {

		int nbVoisin = 0;

		{
			if (!PlateauImpl.plateauJeu[i][j - 1].getEstVide())
				nbVoisin++;
			if (!PlateauImpl.plateauJeu[i][j + 1].getEstVide())
				nbVoisin++;
			if (!PlateauImpl.plateauJeu[i - 1][j].getEstVide())
				nbVoisin++;
			if (!PlateauImpl.plateauJeu[i + 1][j].getEstVide())
				nbVoisin++;
		}

		return nbVoisin;
	}

	public void setChangement(int i, int j) {
		changementGrille[i][j] = true;
	}

	private int getI(int indice) {
		return indice / Plateau.LARGEUR_PLATEAU;
	}

	private int getJ(int indice) {
		return indice % Plateau.LONGUEUR_PLATEAU;
	}
}
