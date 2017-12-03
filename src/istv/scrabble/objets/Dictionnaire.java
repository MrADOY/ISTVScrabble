/**
 * 26-10-2017
 * @author Lefevre Romain
 * Licence 3 FA - ISTV
 * 
 */

package istv.scrabble.objets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import istv.scrabble.exceptions.GameException;
import istv.scrabble.exceptions.Logger;
import istv.scrabble.mdag.MDAG;

public class Dictionnaire {

	protected String fichier = "dico.txt";
	protected MDAG dictionnaire;

	public Dictionnaire(String path) throws GameException {

		File fichier = new File(path);
		
		try {
			this.dictionnaire = new MDAG(fichier);
			Logger.log("Initialisation du dictionnaire , OK");
		} catch (IOException e) {
			throw new GameException(GameException.ERREUR_TECHNIQUE,"Initialisation du dictionnaire impossible");
		}

		
	}

	public MDAG getDictionnaire() {
		return this.dictionnaire;
	}

}
