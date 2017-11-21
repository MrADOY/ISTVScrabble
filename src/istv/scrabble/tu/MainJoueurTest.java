package istv.scrabble.tu;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import istv.scrabble.interfaces.PiocheInt;
import istv.scrabble.objets.Main;
import istv.scrabble.objets.Pioche;

/**
 * 
 *
 * @author Nicolas JOURDAIN
 *
 */

public class MainJoueurTest extends ScrabbleUtilsTest {

	@Test
	public void testMainJoueurImpl() {
		this.scrabble.getJoueurs()[0].getMain().afficherMainJoueur();
	}
}