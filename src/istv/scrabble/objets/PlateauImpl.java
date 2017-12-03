package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.List;

import istv.scrabble.enumerations.CelluleBonus;
import istv.scrabble.exceptions.GameException;
import istv.scrabble.exceptions.Logger;
import istv.scrabble.interfaces.Plateau;

/**
 * 
 *
 * @author Aurelien PIETRZAK
 */

public class PlateauImpl implements Plateau {

	/* Attributs */

	protected static CelluleImpl[][] plateauJeu;
	protected static List<CelluleImpl> caseJouee;

	/* Constructeurs */

	public PlateauImpl() {
		plateauJeu = new CelluleImpl[Plateau.LONGUEUR_PLATEAU][Plateau.LARGEUR_PLATEAU];
		this.creationPlateau();
		caseJouee = new ArrayList<CelluleImpl>();
		Logger.log("Initialisation du plateau , OK !");
	}

	/* Methodes */

	public void poserCellule(int i, int j, CelluleImpl cellule) throws GameException {

		if (PlateauImpl.plateauJeu[i][j].getEstJouable()) {

			PlateauImpl.plateauJeu[i][j].setLettre(cellule.getLettre());
			PlateauImpl.plateauJeu[i][j].setScoreLettre(cellule.getScoreLettre());
			PlateauImpl.plateauJeu[i][j].setEstVide();
			PlateauImpl.plateauJeu[i][j].setI(i);
			PlateauImpl.plateauJeu[i][j].setJ(j);

			Scrabble.getJoueurActuel().getMain().retirerCelluleMain(cellule);

			PlateauImpl.caseJouee.add(PlateauImpl.plateauJeu[i][j]);
			PlateauImpl.plateauJeu[i][j].setEstJouable(false);
			Regle.changementGrille[i][j] = true;
			
			this.setJouableCellulesVoisines(i, j, true);
			
			Logger.log("Le joueur " + Scrabble.getJoueurActuel() + " pose " + cellule  + " en " + "[" + i + "," + j + "]");

		}

		else {
			throw new GameException(GameException.CODE_ERREUR_REGLE, "La case posée n'est pas une case jouable veuillez rejouer");
		}
	}

	/**
	 * Enlève une cellule qui est mal placée , elle effectue les tests pour remettre
	 * à jour les cellules voisines jouables
	 * 
	 */

	public void enleverCellule(int i, int j) {

		Logger.log("Le joueur " + Scrabble.getJoueurActuel() + " ajoute une cellule de la case " + "[" + i + "," + j + "]" +"a sa main");
		
		CelluleImpl celluleAjoutMain = new CelluleImpl(this.getCellule(i, j).getLettre());
		
		Scrabble.getJoueurActuel().getMain().ajouteCelluleMain(celluleAjoutMain);
		
		PlateauImpl.plateauJeu[i][j].genererCelluleVide();
		
		this.setJouableCellulesVoisines(i, j, false);

	}

	
	/**
	 * Enleve toutes les cases jouées de la pile si mauvais Placement
	 */
	
	public void supprimerPileCaseJouee() {
		for(CelluleImpl c : PlateauImpl.caseJouee) {			
			this.enleverCellule(c.getI(), c.getJ());
		}
	}
	
	
	/**
	 * Mettre � jour les cellules voisines jouables
	 */

	public void setJouableCellulesVoisines(int i, int j, boolean jouable) {

		//PlateauImpl.plateauJeu[i][j].genererCelluleVide();

		if (j - 1 >= 0) { // Gauche
			if (PlateauImpl.plateauJeu[i][j - 1].getEstVide()) {
				PlateauImpl.plateauJeu[i][j - 1].setEstJouable(jouable);
			}
		}
		if (j + 1 < Plateau.LARGEUR_PLATEAU) { // Droite
			if (PlateauImpl.plateauJeu[i][j + 1].getEstVide()) {
				PlateauImpl.plateauJeu[i][j + 1].setEstJouable(jouable);
			}
		}
		if (i - 1 >= 0) { // Haut
			if (PlateauImpl.plateauJeu[i - 1][j].getEstVide()) {
				PlateauImpl.plateauJeu[i - 1][j].setEstJouable(jouable);
			}
		}
		if (i + 1 < Plateau.LONGUEUR_PLATEAU) { // Bas
			if (PlateauImpl.plateauJeu[i + 1][j].getEstVide()) {
				PlateauImpl.plateauJeu[i + 1][j].setEstJouable(jouable);
			}
		}
	}

	public Boolean isCelluleJouable(CelluleImpl cellule) {
		return cellule.getEstJouable();
	}

	/**
	 * Cette methode est utilisée pour instancier un plateau contenant des cellules
	 * vides
	 */

	@Override
	public void creationPlateau() {

		if (PlateauImpl.plateauJeu == null) {
			PlateauImpl.plateauJeu = new CelluleImpl[Plateau.LARGEUR_PLATEAU][Plateau.LONGUEUR_PLATEAU];
		}

		for (int i = 0; i < Plateau.LONGUEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LARGEUR_PLATEAU; j++) {
				PlateauImpl.plateauJeu[i][j] = new CelluleImpl(i, j).genererCelluleVide();
				PlateauImpl.plateauJeu[i][j].setBonus(CelluleBonus.NORMAL);
			}
		}

		/* Bonus mot triple */

		int[] ligne = { 0, 0, 0, 7, 7, 14, 14, 14 };
		int[] colone = { 0, 7, 14, 0, 14, 0, 7, 14 };
		for (int i = 0; i < ligne.length; i++) {
			PlateauImpl.plateauJeu[ligne[i]][colone[i]].setBonus(CelluleBonus.MOT_COMPTE_TRIPLE);
		}

		/* Bonus mot double */

		int[] ligne1 = { 1, 1, 2, 2, 3, 3, 4, 4, 7, 10, 10, 11, 11, 12, 12, 13, 13 };
		int[] colone1 = { 1, 13, 2, 12, 3, 11, 4, 10, 7, 4, 10, 3, 11, 2, 12, 1, 13 };

		for (int i = 0; i < ligne1.length; i++) {
			PlateauImpl.plateauJeu[ligne1[i]][colone1[i]].setBonus(CelluleBonus.MOT_COMPTE_DOUBLE);
		}

		/* Bonus lettre compte triple */

		int[] ligne2 = { 1, 1, 5, 5, 5, 5, 9, 9, 9, 9, 13, 13 };
		int[] colone2 = { 5, 9, 1, 5, 9, 13, 1, 5, 9, 13, 5, 9 };
		for (int i = 0; i < ligne2.length; i++) {
			PlateauImpl.plateauJeu[ligne2[i]][colone2[i]].setBonus(CelluleBonus.LETTRE_COMPTE_TRIPLE);
		}

		/* Bonus lettre compte double */

		int[] ligne3 = { 0, 0, 2, 2, 3, 3, 3, 6, 6, 6, 6, 7, 7, 8, 8, 8, 8, 11, 11, 11, 12, 12, 14, 14 };
		int[] colone3 = { 3, 11, 6, 8, 0, 7, 14, 2, 6, 8, 12, 3, 11, 2, 6, 8, 12, 0, 7, 14, 6, 8, 3, 11 };
		for (int i = 0; i < ligne3.length; i++) {
			PlateauImpl.plateauJeu[ligne3[i]][colone3[i]].setBonus(CelluleBonus.LETTRE_COMPTE_DOUBLE);
		}

		PlateauImpl.plateauJeu[7][7].setEstJouable(true);
	}

	/**
	 * Methode qui determine les cases jouables d'un plateau , une case est jouable
	 * lorsqu'une l'une de ses voisines est non vide
	 */

	public void setCaseJouable() {
		for (int i = 0; i < Plateau.LONGUEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LARGEUR_PLATEAU; j++) {
				if (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
					checkVoisin(i, j);
				}
			}
		}
	}

	private void checkVoisin(int i, int j) {
		if (j - 1 >= 0) { // Gauche
			if (PlateauImpl.plateauJeu[i][j - 1].getEstVide()) {
				PlateauImpl.plateauJeu[i][j - 1].setEstJouable(true);
			}
		}
		if (j + 1 < Plateau.LARGEUR_PLATEAU) { // Droite
			if (PlateauImpl.plateauJeu[i][j + 1].getEstVide()) {
				PlateauImpl.plateauJeu[i][j + 1].setEstJouable(true);
			}
		}
		if (i - 1 >= 0) { // Haut
			if (PlateauImpl.plateauJeu[i - 1][j].getEstVide()) {
				PlateauImpl.plateauJeu[i - 1][j].setEstJouable(true);
			}
		}
		if (i + 1 < Plateau.LONGUEUR_PLATEAU) { // Bas
			if (PlateauImpl.plateauJeu[i + 1][j].getEstVide()) {
				PlateauImpl.plateauJeu[i + 1][j].setEstJouable(true);
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
				System.out.print(PlateauImpl.plateauJeu[i][j]);

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
