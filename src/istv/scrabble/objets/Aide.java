package istv.scrabble.objets;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *  Aide.java
 */
public class Aide {

	/**
	 * Constructeur de Aide
	 */
	public Aide() {
		// TODO Auto-generated constructor stub
	}
	
	String monFichier = "dico.txt";
	TreeSet<String> set = new TreeSet<String>();
	
	public ArrayList<Character> decoupMot(String motADecoupe) {
		String str1 = motADecoupe;
		ArrayList<Character> maListe = new ArrayList<Character>();
		for(int i = 0; i < str1.length(); i++) {
			char val = str1.charAt(i);
			maListe.add(val);
		}
		return maListe;
	}
	
	public boolean isAnagram(List<Character> motA, List<Character> motB){
		List<Character> a=motA.stream()
                .sorted()
                .collect(Collectors.toList());
		List<Character> b=motB.stream()
                .sorted()
                .collect(Collectors.toList());
	    return motA.equals(motB);
	}

	public List<Character> rechercheAnagram(List<Character> recherche){
		TreeSet<String> set = new TreeSet<String>();
		List<Character> anagrammes = new ArrayList<Character>();
		try{
			InputStream ips = new FileInputStream("dico.txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while((ligne=br.readLine()) != null){
				set.add(ligne);
			}
			br.close();
			for(String mots : set){
		        if (isAnagram(recherche, decoupMot(mots))){
		        		System.out.println("True");
		            anagrammes.addAll(decoupMot(mots));
		            break;
		        }
		    }
			for(Character l : anagrammes)
			System.out.print(l);
		    return anagrammes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return anagrammes;
	}

}
