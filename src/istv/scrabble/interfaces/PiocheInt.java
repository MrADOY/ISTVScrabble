package istv.scrabble.interfaces;

import java.util.List;

/**
 * 
 *
 * @author Nicolas JOURDAIN
 *
 */
public interface PiocheInt {

	/**
	 * Indique le nombre de pièces restantes dans la pioche
	 * @return le nombre de pièces restantes
	 */
	int piocheRestant();

	/**
	 * Indique le nombre de pièces restantes par lettres dans la pioche
	 */
	void piocheRestantLettres();

	/**
	 * Indique le nombre de pièces restantes par lettres dans la pioche
	 */
	void piocheContenu();

}