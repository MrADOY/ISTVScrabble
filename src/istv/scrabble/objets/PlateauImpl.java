package istv.scrabble.objets;

import istv.scrabble.interfaces.Plateau;

/**
 * 
 *
 * @author Aurelien PIETRZAK
 *
 */

public class PlateauImpl implements Plateau {

	/* Attributs */

	static CelluleImpl[][] plateauJeu;

	/* Constructeurs */

	public PlateauImpl() {
		plateauJeu = new CelluleImpl[Plateau.LONGUEUR_PLATEAU][Plateau.LARGEUR_PLATEAU];
	}

	/* Methodes */

	@Override
	public void poserCellule(int i, int j, CelluleImpl cellule) {
		PlateauImpl.plateauJeu[i][j].setLettre(cellule.getLettre());
		PlateauImpl.plateauJeu[i][j].setScoreLettre(cellule.getScoreLettre());
		PlateauImpl.plateauJeu[i][j].setEstVide();

	}

	/**
	 * Cette methode est utilisée pour instancier un plateau contenant des cellules vides
	 */
	
	@Override
	public void creationPlateau() {

		if (PlateauImpl.plateauJeu == null) {
			PlateauImpl.plateauJeu = new CelluleImpl[Plateau.LARGEUR_PLATEAU][Plateau.LONGUEUR_PLATEAU];
		}

		for (int i = 0; i < Plateau.LONGUEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LARGEUR_PLATEAU; j++) {
				System.out.println(i + " ," + j);
				PlateauImpl.plateauJeu[i][j] = new CelluleImpl(i, j);
				PlateauImpl.plateauJeu[i][j].genererCelluleVide();
			}
		}
	}

	/**
	 * Methode qui determine les cases jouables d'un plateau , une case est jouable
	 * lorsqu'une l'une de ses voisines est non vide
	 */
	
	public void setCaseJouable() {
		for (int i = 0; i < Plateau.LONGUEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LARGEUR_PLATEAU; j++) {
				if (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
					if (j - 1 >= 0) {
						if (PlateauImpl.plateauJeu[i][j - 1].getEstVide()) {
							PlateauImpl.plateauJeu[i][j - 1].setEstJouable(true);
						}
					}
					if (j + 1 < Plateau.LARGEUR_PLATEAU) {
						if (PlateauImpl.plateauJeu[i][j + 1].getEstVide()) {
							PlateauImpl.plateauJeu[i][j + 1].setEstJouable(true);
						}
					}
					if (i - 1 >= 0) {
						if (PlateauImpl.plateauJeu[i - 1][j].getEstVide()) {
							PlateauImpl.plateauJeu[i - 1][j].setEstJouable(true);
						}
					}
					if (i + 1 < Plateau.LONGUEUR_PLATEAU) {
						if (PlateauImpl.plateauJeu[i + 1][j].getEstVide()) {
							PlateauImpl.plateauJeu[i + 1][j].setEstJouable(true);
						}
					}
				}
			}
		}
	}

	
	/**
	 * methode a utiliser pour les tests uniquement 
	 */

	@Deprecated
	public void dessinerPlateau() {
		for (int i = 0; i < Plateau.LONGUEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LARGEUR_PLATEAU; j++) {
				System.out.print(PlateauImpl.plateauJeu[i][j].getEstJouable() + " ");

			}
			System.out.println();
		}
	}
	
	@Override
	public CelluleImpl getCellule(int i, int j) {
		return PlateauImpl.plateauJeu[i][j];
	}

	@Override
	public CelluleImpl[][] getPlateau() {
		return PlateauImpl.plateauJeu;
	}

}
