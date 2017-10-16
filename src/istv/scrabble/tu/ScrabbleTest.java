package istv.scrabble.tu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import istv.scrabble.objets.Scrabble;

public class ScrabbleTest {
	
	@Test
	public void isInDicoTest() {
		Scrabble scr1 = new Scrabble();
		scr1.ajoutMotsTree();
		boolean actuel = scr1.isInDico("AA");
		boolean attendu = true;
		assertEquals(actuel, attendu);
	}
}
