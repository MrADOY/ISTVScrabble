package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Nicolas JOURDAIN
 * 
 */
public class Pioche {

	    List<Character> lettresPioche = new ArrayList<Character>();
	    
	    /**
	     * Constructeur de Pioche
	     */
	    public Pioche() {

	        Collections.addAll(lettresPioche, 
				'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 
				'B', 'B', 
				'C', 'C', 
				'D', 'D', 'D', 
				'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
				'E', 'E', 'E', 'E', 'E',
				'F', 'F', 
				'G', 'G', 
				'H', 'H', 
				'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 
				'J',
				'K', 
				'L', 'L', 'L', 'L', 'L', 
				'M', 'M', 'M', 
				'N', 'N', 'N', 'N', 'N', 'N',
				'O', 'O', 'O', 'O', 'O', 'O',
				'P', 'P', 
				'Q', 
				'R', 'R', 'R', 'R', 'R', 'R',
				'S', 'S', 'S', 'S', 'S', 'S',
				'T', 'T', 'T', 'T', 'T', 'T',
				'U', 'U', 'U', 'U', 'U', 'U',
				'V', 'V', 
				'W', 
				'X', 
				'Y', 
				'Z'
				);


	    	    }

	    //Le joueur pioche j lettre
	    public List<Character> piocheLettre(int j) {
	        List<Character> tabLettre = new ArrayList<Character>();
	        
	        for (int i = 0; i < j; i++) {
	        		if(lettresPioche.size() != 0) {
	            int randomId = (int)(Math.random() * lettresPioche.size());
	            char randomLettre = lettresPioche.get(randomId);
	            tabLettre.add(i, randomLettre);
	            lettresPioche.remove(randomId);
	        		}
	        		else
	        		{
	        			System.out.println("La pioche est vide");
	        			break;
	        		}
	        }
	        return tabLettre;

	    }
}
