package istv.scrabble.tu;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import istv.scrabble.mdag.MDAG;
import istv.scrabble.objets.Dictionnaire;

public class MDAGTest {

	@Test
	
	public void test() {
		
		Dictionnaire d = new Dictionnaire();
		d.ajoutMotsTree();
		
		MDAG myMDAG = new MDAG(d.getSet()); //Overriden constructor also accepts a file
		
		assertTrue(myMDAG.contains("VOITURE"));
		
		//Get all Strings starting with "str1" (O(n) based on input)
//		HashSet<String> startingWithSet = myMDAG.getStringsStartingWith("DE"); //{"str1"}
//
//		startingWithSet.forEach(System.out::println);
//		
		//Get all String containing "r3" (O(n) based on dictionary)
		//HashSet<String> containingSet = myMDAG.getStringsWithSubstring("ENT"); //{"str3"}
		//containingSet.forEach(System.out::println);

		
	}
	
	
}
	

