package istv.scrabble.tu;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import istv.scrabble.objets.Joueur;

public class JoueurTest extends ScrabbleUtilsTest {
	@Test
	public void testAfficheNomJoueur() {
		Joueur j = this.scrabble.getJoueurs()[0];
		
		System.out.println(j.getNom());
	}
	@Test
	public void testAfficheMainJoueur() {
		Joueur j1 = this.scrabble.getJoueurs()[0];
		
		assertNotNull(j1.getMain());
	}
}
