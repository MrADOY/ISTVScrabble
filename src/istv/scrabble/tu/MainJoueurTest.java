package istv.scrabble.tu;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import istv.scrabble.interfaces.PiocheInt;
import istv.scrabble.objets.MainJoueur;
import istv.scrabble.objets.Pioche;

/**
 * 
 *
 * @author Nicolas JOURDAIN
 *
 */

public class MainJoueurTest {

	@Test
	public void testMainJoueurImpl() {
		MainJoueur m = new MainJoueur();
		PiocheInt p = new Pioche();
		List<Character> l = new ArrayList<Character>();
		m.ajoutLettreMain(Pioche.piocheLettre(7));
		m.afficherMainJoueur();
		m.melangerMain(m.getMainJoueur());
		m.afficherMainJoueur();
		}

}
