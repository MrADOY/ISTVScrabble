package istv.scrabble.tu;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import istv.scrabble.interfaces.PiocheInt;
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
		PiocheInt p = new Pioche();
		List<Character> l = new ArrayList<Character>();
		p.piocheRestant();
		p.piocheRestantLettres();
		l = Pioche.piocheLettre(45);
		p.piocheRestant();
		p.piocheRestantLettres();
	}
}
