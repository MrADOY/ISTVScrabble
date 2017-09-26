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

	}

	/* Methodes */

	@Override
	public void poserCellule(int i, int j, CelluleImpl cellule) {
		PlateauImpl.plateauJeu[i][j].setLettre(cellule.getLettre());
		PlateauImpl.plateauJeu[i][j].setScoreLettre(cellule.getScoreLettre());
		PlateauImpl.plateauJeu[i][j].setEstVide();

	}

	@Override
	public void creationPlateau() {
		PlateauImpl.plateauJeu = new CelluleImpl[Plateau.LARGEUR_PLATEAU][Plateau.LONGUEUR_PLATEAU];
		for (int i = 0; i < Plateau.LARGEUR_PLATEAU; i++) {
			for (int j = 0; i < Plateau.LONGUEUR_PLATEAU; j++) {
				PlateauImpl.plateauJeu[i][j] = new CelluleImpl(i, j);
				PlateauImpl.plateauJeu[i][j].genererCelluleVide();
			}
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
