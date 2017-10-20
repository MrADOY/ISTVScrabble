/**
 * 22-09-2017
 * @author Lefevre Romain
 * Licence 3 FA - ISTV
 * 
 */

package istv.scrabble.objets;

import istv.scrabble.interfaces.Plateau;
import java.io.*;
import java.util.List;
import java.util.TreeSet;

public class Scrabble {
	Plateau plateau;
	List<Character> pioche;

	//DECLARATION DES VARIABLES / TREESET
	String monMot;
	String monFichier = "./src/dico.txt";
	TreeSet<String> set = new TreeSet<String>();
	
	public void piocheLettre(){
		
	}

	// NAVIGATION DANS MON FICHIER TXT ET AJOUT DES LIGNES DANS TREESET
	public void verifMotsTree(String monMot){
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
		this.monMot = monMot;
	}
	
	public void ajoutMotsTree(){
		
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

	// METHODE TOSTRING QUI RENVOIE SI OUI OU NON LA VALEUR EXISTE DANS LA LISTE TREESET
	public String toString() {
		if(set.contains(monMot.toUpperCase()) == true){
			return "Le mot " + monMot.toLowerCase() + " existe dans la liste !";
		}else{
			return "Le mot " + monMot.toLowerCase() + " n'existe pas dans la liste !";
		}
	}

}
