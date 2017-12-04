

package istv.scrabble.objets;
import java.util.*;


public class AnagrammeAlgo {

	
	
	public static List<String> Anagramme(String  pmot)
	{
		 	char [] word; 
		    char [] solution; 
		    char [] TEMP=pmot.toCharArray();
		    int max_taille_solution = 3;
		  
		    int n_arbre=1; 
		    int taille_solution=0; 
		    int long_anagram = TEMP.length; 
		  
		    List<String> result = new ArrayList<String>();
		    
		    word = new char[long_anagram];
		    solution = new char[long_anagram];        // Là ou seront stockées les différentes solutions 
		    for (int m=0;m<long_anagram;m++) 
		    {
		    	word[m]=TEMP[m]; 
		    }
		  
		    result = Arbre(word,0,long_anagram,solution,taille_solution, max_taille_solution);            // On rentre dans le premier étage de l'arbre 
		  
		    if (word !=null)
		    {
		    	word = null;
		    }
		    if (solution != null) 
		    {
		    	solution = null;
		    }
		    System.gc();
		    return  result;
	}
	
	 static List<String> Arbre(char [] word, int n, int lg, char [] solution, int taille_solution, int max_taille_solution)    // Fonction recursive 
	{ 
	    char [] comb; 
	    int i,j,k,m; 
	    String tmp ;
	    List<String> result = new ArrayList<String>();
	    if (lg!=0) 
	    {  
	        comb = new char[lg];
	  
	        taille_solution++;        // On est descendu d'un étage dans l'arbre => taille de la solution +1 
	        if(taille_solution <= max_taille_solution) {
		        for (i=0;i<lg;i++)        // Pour chaque lettre du nouveau mot on réalise autant d'arbre pour l'étage suivant 
		        { 
		            solution[n]=word[i];    // On ajoute la nouvelle lettre à la fin de la solution (n = étage) 
		            
		            tmp = new String();
		            //System.out.println("--------------");
		            //System.out.println("Nbr de carac :"+taille_solution);
		            for (m=0;m<taille_solution;m++) 
		            {
		            		tmp.append(solution[m]);
		            }
		            
		            System.out.println(tmp);   ///########## Les différentes combinaisons sortent ici !! BINGO ###########//
		            result.add(tmp);
		            k=0;                // ICI on définit la nouvelle combinaison COMB avec les lettres restantes 
		            for (j=0;j<lg;j++) 
		            { 
		                if (j!=i) 
		                { 
		                    comb[k] = word[j];    // Donc comb prend toutes les lettres restantes 
		                    k++; 
		                } 
		            } 
		  
		            Arbre(comb, n+1, lg-1, solution, taille_solution, max_taille_solution);    // Puis on descend d'un étage dans l'arbre en reinjectant le nouveau comb 
		        } 
	        }
	    } 
	    else taille_solution--;    // On remonte d'un étage dans l'arbre 
	    return result;
	} 
	
	public static void main(String[] args) {
		Dictionnaire Dico = new Dictionnaire();
		AnagrammeAlgo ana = new AnagrammeAlgo();
		//Arbre liste = new Arbre;
		//System.out.println(Dico.set);
		System.out.println(AnagrammeAlgo.Anagramme("valenciennes"));
		/*for (String mot : AnagrammeAlgo.Anagramme("paris")) {
			System.out.println(mot);
		}
		System.exit(0);*/
		//System.out.println(Dicos.set);
		//AnagrammeAlgo ana = new AnagrammeAlgo("paris");
		
	}

}