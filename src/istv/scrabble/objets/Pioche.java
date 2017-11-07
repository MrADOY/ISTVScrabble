package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import istv.scrabble.interfaces.PiocheInt;

/**
 * 
 * @author Nicolas JOURDAIN
 * 
 */
public class Pioche implements PiocheInt {

	    static List<Character> lettresPioche = new ArrayList<Character>();
	    
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
				'Z',
				'*','*'
				);
	    	    }

	    /**
	     * Le joueur pioche un nombre j de lettres 
	     * @param le nombre de lettres à piocher
	     * @return List<Character> contenant les lettres piochées
	     */
	public static List<Character> piocheLettre(int j) {
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
	    
	    public int piocheRestant() {
	        System.out.println("Il reste " + lettresPioche.size() + " lettres dans la pioche");
	       	return lettresPioche.size();
	    }
	    
	    public void piocheRestantLettres() {
	        Set<Character> lettres = new TreeSet<Character>();
	        int i = 0;
	    		for(Character l : lettresPioche) {
	    			lettres.add(l);
	    		}
	    		
	    		for(Character m : lettres) {
	    			i=lettresPioche.lastIndexOf(m)-lettresPioche.indexOf(m)+1;
	    			System.out.println(m + " x " + i);
	    		}
	    		
	    }
	    
	    
	    public void piocheContenu() {
	        Set<Character> lettres = new TreeSet<Character>();
	    		for(Character l : lettresPioche) {
	    			lettres.add(l);
	    		}
	    		
	    		for(Character m : lettres) {
	    			System.out.println(m);
	    		}
	    		
	    }

}
