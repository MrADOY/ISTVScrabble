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
		
		CelluleImpl cellule = new CelluleImpl(0,0,CelluleBonus.NORMAL);
		
		System.out.println(cellule.getBonus().equals(CelluleBonus.NORMAL));
	}

}
