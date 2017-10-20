/**
 * 16-10-2017
 * @author Lefevre Romain
 * Licence 3 FA - ISTV
 * 
 */
package istv.scrabble.tu;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import istv.scrabble.objets.Scrabble;

public class ScrabbleTest {

	@Test 
	// Test si la méthode dico renvoie true si le mot existe
	public void isInDicoTest() {
		Scrabble scr1 = new Scrabble();
		scr1.ajoutMotsTree();
		boolean actuel = scr1.isInDico("AA");
		boolean attendu = true;
		assertEquals(actuel, attendu);
	}
	
	/*
	@Test 
	// Test si le score de mon mot 'ZZ' renvoie le score '20'
	public void getScore() {
		Scrabble scr2 = new Scrabble();
		int actu = scr2.valeurScore();
		int atten = 20;
		assertEquals(actu, atten);
	}
	*/
	
	/*
	@Test 
	// Test si le mot est découpé et test le score renvoyé
	public void getTabChar() {
		Scrabble scr3 = new Scrabble();
		ArrayList<Character> actuel = scr3.decoupMot("ROMAIN");
		for(Character c : actuel) {
			System.out.print(c);
		}
		System.out.print("\n" + scr3.valeurScore(actuel));
	}
	*/
	
	@Test
	public void getScore() {
		Scrabble scr3 = new Scrabble();
		System.out.println(scr3.valeurScore("ZZ"));	
	}
}
