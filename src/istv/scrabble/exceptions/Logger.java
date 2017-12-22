package istv.scrabble.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Aurelien Pietrzak
 *
 * Etudiant Licence 3 Informatique ISTV
 */
public class Logger {

	public static String log (String message) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		System.err.println("[" + sdf.format(new Date()) + "] " + "Message : " + message);
		return "[" + new Date() + "]" + "Message :" + message;
	}
}
