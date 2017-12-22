package istv.scrabble.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GameException extends Exception {

	public static String CODE_ERREUR_REGLE = "1";
	public static String ERREUR_TECHNIQUE = "2";
	
	private static final long serialVersionUID = 1L;

	public GameException(String code, String message) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		System.err.println("[" + sdf.format(new Date()) + " ERROR " + "]" + "Erreur : " + message);
	
	}
}
