package istv.scrabble.tu;

import org.junit.Before;
import org.junit.Test;

import istv.scrabble.objets.CelluleImpl;
import istv.scrabble.objets.PlateauImpl;

public class PlateauImplTest {

	private PlateauImpl plateau;
	private CelluleImpl celluleA;
	private CelluleImpl celluleB;
	private CelluleImpl celluleC;
	
	
	@Before
	public void setUp() {
	plateau =  new PlateauImpl();
	
	celluleA  = new CelluleImpl('A');
	celluleB  = new CelluleImpl('B');
	celluleC  = new CelluleImpl('C');
	
	plateau.creationPlateau();
	
	}
	
	@Test
	public void testMethodeSetCaseJouable() {
		
		
		plateau.dessinerPlateau();
		System.out.println("===================================");
		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(2, 3, celluleA);
		System.out.println("===================================");
		plateau.dessinerPlateau();
		
	}
	
}
