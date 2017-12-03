package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import istv.scrabble.exceptions.Logger;
import istv.scrabble.interfaces.PiocheInt;

/**
 * 
 * @author Nicolas JOURDAIN
 * 
 */
public class Pioche implements PiocheInt {

	static List<Character> pioche = new ArrayList<Character>();

	
	public Pioche() {		
		Collections.addAll(pioche, 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D',
				'D', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'F', 'F', 'G', 'G', 'H',
				'H', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'J', 'K', 'L', 'L', 'L', 'L', 'L', 'M', 'M', 'M', 'N', 'N',
				'N', 'N', 'N', 'N', 'O', 'O', 'O', 'O', 'O', 'O', 'P', 'P', 'Q', 'R', 'R', 'R', 'R', 'R', 'R', 'S', 'S',
				'S', 'S', 'S', 'S', 'T', 'T', 'T', 'T', 'T', 'T', 'U', 'U', 'U', 'U', 'U', 'U', 'V', 'V', 'W', 'X', 'Y',
				'Z', '*', '*');
		Logger.log("Initialisation de la pioche , OK !");
	}

	public List<Character> piocheLettre(int j) {
		List<Character> tabLettre = new ArrayList<Character>();

		for (int i = 0; i < j; i++) {
			if (pioche.size() != 0) {
				int randomId = (int) (Math.random() * pioche.size());
				char randomLettre = pioche.get(randomId);
				tabLettre.add(i, randomLettre);
				pioche.remove(randomId);
			} else {
				System.out.println("La pioche est vide");
				break;
			}
		}
		return tabLettre;
	}

	public int piocheRestant() {
		System.out.println("Il reste " + pioche.size() + " lettres dans la pioche");
		return pioche.size();
	}



}
