package istv.scrabble.tu;

import org.junit.Before;
import org.junit.Test;

import istv.scrabble.enumerations.CelluleBonus;
import istv.scrabble.exceptions.GameException;
import istv.scrabble.objets.CelluleImpl;
import istv.scrabble.objets.Joueur;
import istv.scrabble.objets.Pioche;
import istv.scrabble.objets.PlateauImpl;
import istv.scrabble.objets.Scrabble;

public class PlateauImplTest {

	private PlateauImpl plateau;
	private CelluleImpl celluleA;
	private CelluleImpl celluleB;
	private CelluleImpl celluleC;

	@Before
	public void setUp() {
		plateau = new PlateauImpl();

		celluleA = new CelluleImpl('A', CelluleBonus.NORMAL);
		celluleB = new CelluleImpl('B');
		celluleC = new CelluleImpl('C');

		plateau.creationPlateau();

	}

	@Test
	public void testMethodeSetCaseJouable() {

		plateau.dessinerPlateau();
		System.out.println("===================================");
		try {
			plateau.poserCellule(7, 7, celluleA);
		} catch (GameException e) {
				//
		}
		try {
			plateau.poserCellule(2, 3, celluleA);
		} catch (GameException e) {
				//
		}
		
		System.out.println("===================================");
		plateau.dessinerPlateau();

	}

	@Test
	public void testCaseBonus() {
		System.out.println(plateau.getPlateau()[7][7].getCelluleBonus());
		try {
			plateau.poserCellule(7, 7, celluleA);
		} catch (GameException e) {
			//
		}
		plateau.dessinerPlateau();
	}

	@Test
	public void testLienMainJoueur() {

		Scrabble s = new Scrabble();

		s.plateau.creationPlateau();
		Pioche p = new Pioche();
		Joueur j = new Joueur("test", p,s.plateau);

		Scrabble.setJoueurActuel(j);

		System.out.println("Etat initiale");
		System.out.println(j.getMain());

		plateau.dessinerPlateau();

		try {
			plateau.poserCellule(7, 7, j.getMain().getCellulesJoueur().get(3));
		} catch (GameException e) {
			//
		}

		System.out.println("Etat de la main après avoir posé");
		System.out.println(j.getMain());
		plateau.dessinerPlateau();

		plateau.enleverCellule(7, 7);

		System.out.println("Etat après avoir enlevé");
		System.out.println(j.getMain());
		plateau.dessinerPlateau();

	}

	@Test

	public void testPileCoupJoue() {

		Scrabble s = new Scrabble();
		s.plateau.creationPlateau();
		Pioche p = new Pioche();
		Joueur j = new Joueur("test", p,s.plateau);

		Scrabble.setJoueurActuel(j);

		System.out.println("Etat initial");
		System.out.println(j.getMain());
		plateau.dessinerPlateau();
		try {
			plateau.poserCellule(7, 7, j.getMain().getCellulesJoueur().get(0));
		} catch (GameException e) {
			//
		}
		try {
			plateau.poserCellule(7, 8, j.getMain().getCellulesJoueur().get(1));
		} catch (GameException e) {
			//
		}
		try {
			plateau.poserCellule(7, 9, j.getMain().getCellulesJoueur().get(2));
		} catch (GameException e) {
			//
		}

		plateau.dessinerPlateau();

		plateau.supprimerPileCaseJouee();

		System.out.println(j.getMain());
		plateau.dessinerPlateau();
	}

}
