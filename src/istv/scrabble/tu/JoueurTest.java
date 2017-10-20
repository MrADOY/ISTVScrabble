package istv.scrabble.tu;


import org.junit.Test;

import istv.scrabble.objets.Joueur;

public class JoueurTest {
	@Test
	public void testJoueur() {
		Joueur joueur = new Joueur();
		System.out.println(joueur.getNom());
	}
}
