package istv.scrabble.tu;

import org.junit.Test;

import istv.scrabble.enumerations.CelluleBonus;
import istv.scrabble.objets.CelluleImpl;

/**
 * 
 *
 * @author Aurelien PIETRZAK
 *
 */

public class CelluleImplTest {

	@Test
	public void testCelluleImplBonus() {
		
		CelluleImpl cellule = new CelluleImpl();

		cellule.genererCelluleVide();
		
		cellule.setBonus(CelluleBonus.LETTRE_COMPTE_DOUBLE);
		System.out.println(cellule.getCelluleBonus());
	}

}
