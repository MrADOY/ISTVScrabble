/**
 * 22-09-2017
 * @author Lefevre Romain
 * Licence 3 FA - ISTV
 * 
 */

package istv.scrabble.objets;

import istv.scrabble.interfaces.Plateau;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Scrabble {
	Plateau plateau;
	List<Character> pioche;

	//DECLARATION DES VARIABLES / TREESET
	String monFichier = "dico.txt";
	int score = 0;
	Lettre lettre = new Lettre();
	TreeSet<String> set = new TreeSet<String>();
	
	public void piocheLettre(){
		
	}

	// NAVIGATION DANS MON FICHIER TXT ET AJOUT DES LIGNES DANS TREESET
	public void ajoutMotsTree(){
		try{
			InputStream ips = new FileInputStream(monFichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while((ligne=br.readLine()) != null){
				set.add(ligne);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Decoupe le mot en character 
	public ArrayList<Character> decoupMot(String motADecoupe) {
		String str1 = motADecoupe;
		ArrayList<Character> maListe = new ArrayList<Character>();
		for(int i = 0; i < str1.length(); i++) {
			char val = str1.charAt(i);
			maListe.add(val);
		}
		return maListe;
	}
	
	// Calcul le score des mots posés 
	public int valeurScore(ArrayList<Character> tab) {
		//CelluleImpl tab[] = {new CelluleImpl('Z'),  new CelluleImpl('Z')};
		Lettre valeurScore = new Lettre();
		for(Character c : tab) {
			score = score + valeurScore.getScore(c);
		}
		
		/*
		for(int i = 0; i < tab.length; i++) {
			score = score + tab[i].getScoreLettre();
		}
		*/
		return score;
	}
	
	public boolean isInDico(String monMot) {
		return set.contains(monMot.toUpperCase());
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public List<Character> getPioche() {
		return pioche;
	}

	public void setPioche(List<Character> pioche) {
		this.pioche = pioche;
	}

	public TreeSet<String> getDico() {
		return set;
	}

	public void setDico(TreeSet<String> dico) {
		this.set = dico;
	}
}
