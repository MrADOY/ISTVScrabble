package istv.scrabble.tu;

import org.junit.Test;

import istv.scrabble.objets.CelluleImpl;
import istv.scrabble.objets.PlateauImpl;

public class PlateauImplTest {

	
	@Test
	public void testMethodeSetCaseJouable() {
		PlateauImpl plateau =  new PlateauImpl();
		
		plateau.creationPlateau();
		CelluleImpl cellule = new CelluleImpl("TEST",0);
		plateau.poserCellule(0, 0, cellule);
		plateau.poserCellule(7, 7, cellule);
		plateau.poserCellule(5, 0, cellule);
		plateau.poserCellule(5, 14, cellule);
		plateau.setCaseJouable();
		plateau.dessinerPlateau();
		
	}

}
