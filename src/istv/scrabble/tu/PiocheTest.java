package istv.scrabble.tu;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import istv.scrabble.objets.Pioche;

/**
 * 
 *
 * @author Nicolas JOURDAIN
 *
 */

public class PiocheTest {

	@Test
	public void testPiocheGetLettre() {
		
		Pioche p = new Pioche();
		List<Character> l = new ArrayList<Character>();
		l = p.piocheLettre(105);
		for (Character a : l)
		{
			System.out.println(a + " ");
		}
	}

}
