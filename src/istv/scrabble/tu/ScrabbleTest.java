/**
 * 16-10-2017
 * @author Lefevre Romain
 * Licence 3 FA - ISTV
 * 
 */
package istv.scrabble.tu;

import org.junit.Test;

import istv.scrabble.objets.Scrabble;

public class ScrabbleTest {

	@Test
	public void testInitScrabble() {
		
		new Scrabble();
	
	}
	
	@Test
	public void testInitScrabble2() {
		new Scrabble("BENARD" , "JEAN LOUIS");

	}
	
	@Test
	public void testDeroulementPartie() {
		
		new Scrabble("BENARD" , "JEAN LOUIS");
	
		Scrabble.getJoueurActuel().poserCellule(0, 7, 7);
	
		Scrabble.plateau.dessinerPlateau();
		
		Scrabble.verificationFinTour();
		
		Scrabble.getJoueurActuel().poserCellule(0, 7, 8);
		
		Scrabble.plateau.dessinerPlateau();
		
		Scrabble.verificationFinTour();

	}
	
	@Test
	
	public void testDeroulementPartie2() {
		
		new Scrabble("BENARD" , "JEAN LOUIS");
		
		Scrabble.jouerTour();
	}
}
