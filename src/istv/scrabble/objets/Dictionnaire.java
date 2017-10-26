/**
 * 26-10-2017
 * @author Lefevre Romain
 * Licence 3 FA - ISTV
 * 
 */

package istv.scrabble.objets;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Dictionnaire {

	protected static TreeSet<String> set;
	protected String monFichier = "dico.txt";

	public Dictionnaire() {
		set = new TreeSet<String>();
		ajoutMotsTree();
	}
	
	//Ajouter au Treeset les mots du fichier dico.txt
	public void ajoutMotsTree(){
		try{
			InputStream ips = new FileInputStream(monFichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while((ligne=br.readLine()) != null){
				Dictionnaire.set.add(ligne);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
