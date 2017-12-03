package istv.scrabble.tu;

import org.junit.Before;
import org.junit.Test;

import istv.scrabble.exceptions.GameException;
import istv.scrabble.interfaces.Cellule;
import istv.scrabble.objets.CelluleImpl;
import istv.scrabble.objets.Dictionnaire;
import istv.scrabble.objets.Joueur;
import istv.scrabble.objets.Pioche;
import istv.scrabble.objets.Placement;
import istv.scrabble.objets.PlateauImpl;
import istv.scrabble.objets.Regle;
import istv.scrabble.objets.Scrabble;

/**
 * 
 * @author Aurelien Pietrzak
 *
 */


public class RegleTest{

	private PlateauImpl plateau;
	private CelluleImpl celluleA;
	private CelluleImpl celluleB;
	private CelluleImpl celluleC;
	private CelluleImpl celluleD;
	private Regle regle;

	@Before
	public void setUp() {
		
		Scrabble s  = new Scrabble();
		
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
	public void testDirectionMot_HORI_SEUL_OK() throws GameException {

		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(7, 9, celluleC);

		plateau.getPlateau();
		regle.setChangement(7, 7);
		regle.setChangement(7, 8);
		regle.setChangement(7, 9);

		plateau.dessinerPlateau();

		
	
		
	}

	@Test
	public void testDirectionMot_HORI_UNE_LETTRE_OK() throws GameException {

		regle.initChangementGrille();

		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(7, 9, celluleC);
		plateau.poserCellule(7, 10, celluleD);
		regle.setChangement(7, 10);

		plateau.dessinerPlateau();

		regle.recuperationMotsPoses();


	}

	@Test
	public void testDirectionMot_HORI_CROISE_OK() throws GameException {

		regle.initChangementGrille();

		plateau.poserCellule(6, 8, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(8, 8, celluleC);

		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(7, 9, celluleC);

		regle.setChangement(7, 7);
		regle.setChangement(7, 9);

		plateau.dessinerPlateau();

		regle.recuperationMotsPoses();

	
	}

	@Test
	public void testDirectionMot_CROISE_OK() throws GameException {

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

		regle.recuperationMotsPoses();

	}

	@Test
	public void testDirectionMot_CROISE_FIN_MOT_OK() throws GameException {

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

		regle.recuperationMotsPoses();

	}
	
	@Test
	public void testDirectionMot_HORI_UNE_LETTRE_OK_SCORE() throws GameException {

		regle.initChangementGrille();

		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(7, 9, celluleC);
		plateau.poserCellule(7, 10, celluleD);
		regle.setChangement(7, 10);

		plateau.dessinerPlateau();

		regle.recuperationMotsPoses();


		
	}
}
