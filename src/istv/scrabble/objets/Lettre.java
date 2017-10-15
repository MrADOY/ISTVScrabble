package istv.scrabble.objets;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Aurelien Pietrzak
 *
 */

public class Lettre {

	private static Map<Character,Integer> lettre;
	
	public Lettre() {
		
		lettre = new HashMap<Character,Integer>();
		
		lettre.put('E', 1);
		lettre.put('A', 1);
		lettre.put('I', 1);
		lettre.put('N', 1);
		lettre.put('O', 1);
		lettre.put('R', 1);
		lettre.put('S', 1);
		lettre.put('T', 1);
		lettre.put('U', 1);
		lettre.put('L', 1);
		lettre.put('D', 2);
		lettre.put('M', 2);
		lettre.put('G', 2);
		lettre.put('B', 3);
		lettre.put('C', 3);
		lettre.put('P', 3);
		lettre.put('F', 4);
		lettre.put('H', 4);
		lettre.put('V', 4);
		lettre.put('J', 8);
		lettre.put('Q', 8);
		lettre.put('K', 10);
		lettre.put('W', 10);
		lettre.put('X', 10);
		lettre.put('Y', 10);
		lettre.put('Z', 10);
	
	}
	
	public int getScore(Character c) {
		return lettre.get(c);
	}
	
	
}

