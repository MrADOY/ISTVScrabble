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

	//DECLARATION DES VARIABLES / TREESET
	Plateau plateau;
	List<Character> pioche;
	String monFichier = "dico.txt";
	int score = 0;
	Lettre lettre = new Lettre();
	TreeSet<String> set = new TreeSet<String>();

	// NAVIGATION DANS FICHIER TXT ET AJOUT DES LIGNES DANS TREESET
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
	
	/*
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
		Lettre valeurScore = new Lettre();
		for(Character c : tab) {
			score = score + valeurScore.getScore(c);
		}
		return score;
	}
	*/
	
	//Decoupe le mot en character & calcul le score des mots posés 
	public int valeurScore(String motADecoupe) {
		String str1 = motADecoupe;
		ArrayList<Character> maListe = new ArrayList<Character>();
		for(int i = 0; i < str1.length(); i++) {
			char val = str1.charAt(i);
			maListe.add(val);
		}
		
		Lettre valeurScore = new Lettre();
		for(Character c : maListe) {
			score = score + valeurScore.getScore(c);
		}
		return score;
	}
	
	public boolean isInDico(String monMot) {
		return set.contains(monMot.toUpperCase());
	}
}
