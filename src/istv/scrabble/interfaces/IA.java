package istv.scrabble.interfaces;

import java.util.List;

public interface IA {

	public List<String> etendreGauche(String suffix, String Initiale);

	public List<String> chosirMeilleurMot(List<String> mots);

	List<String> etendreDroite(List<String> suffix, String Initiale);
}
