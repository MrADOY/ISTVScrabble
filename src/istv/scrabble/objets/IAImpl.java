package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.List;

import istv.scrabble.interfaces.IA;
import istv.scrabble.mdag.MDAG;

/**
 * 
 * @author Aurelien Pietrzak
 *
 */

public class IAImpl extends Joueur implements IA {

	/* Attributs */

	/* Constructeurs */

	public IAImpl() {
		super();
	}

	public IAImpl(String nom) {
		//super(nom);
	}

	@Override
	public List<String> etendreDroite(List<String> suffix, String Initiale) {
		MDAG m = new MDAG(suffix);

		String meilleurMot  = null;
		String chaineTemporaire = null;
		List<String> motEtendu = new ArrayList<String>();

		for (String s : suffix) {
			
			chaineTemporaire = Initiale.concat(s);
			m.contains(chaineTemporaire);
			motEtendu.add(chaineTemporaire);
		
		}

		if (!motEtendu.isEmpty()) {
		
		}
		return null;
	}

	@Override
	public List<String> etendreGauche(String suffix, String Initiale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> chosirMeilleurMot(List<String> mots) {
		// TODO Auto-generated method stub
		return null;
	}

	/* Méthodes */

}
