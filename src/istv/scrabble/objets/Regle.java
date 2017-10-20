package istv.scrabble.objets;

import istv.scrabble.interfaces.Plateau;


/**
 * 
 * @author Aurelien Pietrzak 
 *
 */

/*Attention les règles ne sont pas encore au point */


public class Regle {

	static boolean[][] changement = new boolean[15][15];

	public void initChangement() {
		for (int i = 0; i < Plateau.LARGEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LONGUEUR_PLATEAU; j++) {
				changement[i][j] = false;
			}
		}
	}

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

	public Direction getDirMot() {

		Direction dir = null;

		int indiceFirstCellule = this.getFirstChangement();
		int i = getI(indiceFirstCellule);
		int j = getJ(indiceFirstCellule);
		int nbChangement = this.getNbChangement(); // Cas differents suivant nb changements
		int nbVoisin = this.getNbVoisin(i, j);

		if (nbChangement == 1) {
			// Une seule lettre a été posée le joueur complete un mot

			if (nbVoisin == 1) // On cherche le sens du mot
			{
				if (!PlateauImpl.plateauJeu[i][j - 1].getEstVide())
					dir = Direction.HORIZONTALE;
				else if (!PlateauImpl.plateauJeu[i][j + 1].getEstVide())
					dir = Direction.HORIZONTALE;
				else if (!PlateauImpl.plateauJeu[i - 1][j].getEstVide())
					dir = Direction.VERTICALE;
				else if (!PlateauImpl.plateauJeu[i + 1][j].getEstVide())
					dir = Direction.VERTICALE;
			}

		}
			else if (nbChangement > 1) // Le joueur pose un mot complet ou complete 1 mot et rempli {
			{

				if (nbVoisin == 1) // Le joueur pose uniquement un seul mot
				{
					if (!PlateauImpl.plateauJeu[i][j - 1].getEstVide())
						dir = Direction.HORIZONTALE;
					else if (!PlateauImpl.plateauJeu[i][j + 1].getEstVide())
						dir = Direction.HORIZONTALE;
					else if (!PlateauImpl.plateauJeu[i - 1][j].getEstVide())
						dir = Direction.VERTICALE;
					else if (!PlateauImpl.plateauJeu[i + 1][j].getEstVide())
						dir = Direction.VERTICALE;
				}
				
				if(nbVoisin >= 2) { //LES MOTS SERONT FORCEMENT DANS LES DEUX DIRECTIONS{
					
					System.out.println(getMotPose(Direction.HORIZONTALE, i, j));
					System.out.println(getMotPose(Direction.VERTICALE, i, j));
					
				}

			}

		//System.out.println(dir);
		//System.out.println(getMotPose(dir, i, j));

		return null;

	}

	private String getMotPose(Direction direction, int i, int j) {

		String mot = "";

		switch (direction) {

		case VERTICALE:

			while (!PlateauImpl.plateauJeu[i - 1][j].getEstVide()) {
				i--;
			}

			while (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre();
				i++;
			}

			break;

		case HORIZONTALE:

			while (!PlateauImpl.plateauJeu[i][j - 1].getEstVide()) {
				j--;
			}

			while (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre();
				j++;
			}

			break;

		}

		return mot;
	}

	public void setChangement(int i, int j) {
		changement[i][j] = true;
	}

	private int getI(int indice) {
		return indice / Plateau.LARGEUR_PLATEAU;
	}

	private int getJ(int indice) {
		return indice % Plateau.LARGEUR_PLATEAU;
	}

	/*
	 * ATTENTION à appliquer lorsque les cases jouées ont bien été validées par les
	 * règles
	 */

	private int getFirstChangement() {
		for (int i = 0; i < Plateau.LARGEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LONGUEUR_PLATEAU; j++) {
				if (changement[i][j]) {
					return Plateau.LARGEUR_PLATEAU * i + j;
				}
			}
		}
		return -1;
	}

	private int getNbChangement() {

		int nb = 0;

		for (int i = 0; i < Plateau.LARGEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LONGUEUR_PLATEAU; j++) {
				if (changement[i][j]) {
					nb++;
				}
			}
		}

		return nb;
	}

}
