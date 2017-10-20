package istv.scrabble.tu;

import org.junit.Before;
import org.junit.Test;

import istv.scrabble.objets.CelluleImpl;
import istv.scrabble.objets.PlateauImpl;
import istv.scrabble.objets.Regle;

public class RegleTest {

	private PlateauImpl plateau;
	private CelluleImpl celluleA;
	private CelluleImpl celluleB;
	private CelluleImpl celluleC;
	private CelluleImpl celluleD;
	private Regle regle;
	
	@Before
	public void setUp() {
	plateau =  new PlateauImpl();
	
	celluleA  = new CelluleImpl('M');
	celluleB  = new CelluleImpl('O');
	celluleC  = new CelluleImpl('T');
	celluleD  = new CelluleImpl('S');
	plateau.creationPlateau();
	
	regle = new Regle();
	
	regle.initChangement();
	
	
	}
	
	@Test
	public void testDirectionMot() {
		
		
		
		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(7, 8, celluleB);
		plateau.poserCellule(7, 9, celluleC);
		
		regle.setChangement(7,7);
		regle.setChangement(7,8);
		regle.setChangement(7,9);
		
		plateau.dessinerPlateau();
		
		regle.getDirMot();
		
	}
}
