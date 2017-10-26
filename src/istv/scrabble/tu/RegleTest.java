package istv.scrabble.tu;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import istv.scrabble.interfaces.Cellule;
import istv.scrabble.objets.CelluleImpl;
import istv.scrabble.objets.Placement;
import istv.scrabble.objets.PlateauImpl;
import istv.scrabble.objets.Regle;

/**
 * 
 * @author Aurelien Pietrzak
 *
 */


public class RegleTest {

	private PlateauImpl plateau;
	private CelluleImpl celluleA;
	private CelluleImpl celluleB;
	private CelluleImpl celluleC;
	private CelluleImpl celluleD;
	private Regle regle;

	@Before
	public void setUp() {
		plateau = new PlateauImpl();

		celluleA = new CelluleImpl('M');
		celluleB = new CelluleImpl('O');
		celluleC = new CelluleImpl('T');
		celluleD = new CelluleImpl('S');
		plateau.creationPlateau();

		regle = new Regle();

		regle.initChangementGrille();

	}

	@Test
	public void testDirectionMot_HORI_SEUL_OK() {

		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(7, 9, celluleC);

		regle.setChangement(7, 7);
		regle.setChangement(7, 8);
		regle.setChangement(7, 9);

		plateau.dessinerPlateau();

		Placement actual = regle.recuperationMotsPoses();

		for (String s : actual.getMot()) {
			System.out.println(s);
		}
		
		for (Cellule c : actual.getCellules()) {
			System.out.println(c);
		}

		
	}

	@Test
	public void testDirectionMot_HORI_UNE_LETTRE_OK() {

		regle.initChangementGrille();

		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(7, 9, celluleC);
		plateau.poserCellule(7, 10, celluleD);
		regle.setChangement(7, 10);

		plateau.dessinerPlateau();

		Placement actual = regle.recuperationMotsPoses();

		for (String s : actual.getMot()) {
			System.out.println(s);
		}
		
		for (Cellule c : actual.getCellules()) {
			System.out.println(c);
		}
	}

	@Test
	public void testDirectionMot_HORI_CROISE_OK() {

		regle.initChangementGrille();

		plateau.poserCellule(6, 8, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(8, 8, celluleC);

		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(7, 9, celluleC);

		regle.setChangement(7, 7);
		regle.setChangement(7, 9);

		plateau.dessinerPlateau();

		Placement actual = regle.recuperationMotsPoses();

		for (String s : actual.getMot()) {
			System.out.println(s);
		}
		
		for (Cellule c : actual.getCellules()) {
			System.out.println(c);
		}
	}

	@Test
	public void testDirectionMot_CROISE_OK() {

		regle.initChangementGrille();

		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(8, 8, celluleC);

		plateau.poserCellule(6, 8, celluleA);
		plateau.poserCellule(6, 9, celluleB);
		plateau.poserCellule(6, 10, celluleC);

		regle.setChangement(6, 8);
		regle.setChangement(6, 9);
		regle.setChangement(6, 10);

		plateau.dessinerPlateau();

		Placement actual = regle.recuperationMotsPoses();

		for (String s : actual.getMot()) {
			System.out.println(s);
		}
		
		for (Cellule c : actual.getCellules()) {
			System.out.println(c);
		}
	}

	@Test
	public void testDirectionMot_CROISE_FIN_MOT_OK() {

		regle.initChangementGrille();

		plateau.poserCellule(6, 8, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(8, 8, celluleC);

		plateau.poserCellule(6, 5, celluleA);
		plateau.poserCellule(6, 6, celluleB);
		plateau.poserCellule(6, 7, celluleC);

		regle.setChangement(6, 5);
		regle.setChangement(6, 6);
		regle.setChangement(6, 7);

		plateau.dessinerPlateau();

		Placement actual = regle.recuperationMotsPoses();

		for (String s : actual.getMot()) {
			System.out.println(s);
		}
		
		for (Cellule c : actual.getCellules()) {
			System.out.println(c);
		}
	}
	
	@Test
	public void testDirectionMot_HORI_UNE_LETTRE_OK_SCORE() {

		regle.initChangementGrille();

		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(7, 9, celluleC);
		plateau.poserCellule(7, 10, celluleD);
		regle.setChangement(7, 10);

		plateau.dessinerPlateau();

		Placement actual = regle.recuperationMotsPoses();

		for (String s : actual.getMot()) {
			System.out.println(s);
		}
		
		for (Cellule c : actual.getCellules()) {
			System.out.println(c);
		}
		
		System.out.println(Regle.valeurScore(actual.getCellules()));
		
	}

	
	
	
	
	
}
