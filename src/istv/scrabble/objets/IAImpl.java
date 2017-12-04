package istv.scrabble.objets;

import java.util.ArrayList;
import java.util.List;

import istv.scrabble.exceptions.Logger;
import istv.scrabble.interfaces.IA;
import istv.scrabble.interfaces.Plateau;
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

	public IAImpl(String nom,Pioche pioche,PlateauImpl plateauJeu) {
		super(nom,pioche,plateauJeu);
	}

	public void getPositionJouer() {

	}

	public int getFirstCaseJouable() {

		for (int i = 0; i < PlateauImpl.LONGUEUR_PLATEAU; i++) {
			for (int j = 0; j < PlateauImpl.LARGEUR_PLATEAU; j++) {
				if (Scrabble.plateau.getPlateau()[i][j].getEstJouable()) {
					return Plateau.LARGEUR_PLATEAU * i + j;
				}
			}
		}
		return -1;
	}

	
	public void jouer() {
		
		/* Etape 1 Detecter où l'IA doit jouer */
		
		int indice = getFirstCaseJouable();
		
		int i = this.getI(indice);
		int j = this.getJ(indice);
		
		Logger.log("L'IA va jouer en [" + i + "," + j + "]");
		

		/* Etape 2 Detecter la direction du mot */
		
		Direction dir = this.getDirectionMot(i, j);
		
		if(null != dir) {			
		Logger.log("L'IA à detecter la direction du mot comme [" + dir + "]");
		}else {
			Logger.log("L'IA va poser son mot");
		}
		
		/* Etape 3 Detecter la longueur possible à etendre à droite et recuperer le mot à completer */
		
		
		if(null != dir) {

		String main = "";

		ArrayList<String> permutation = new ArrayList<String>();
		
		for(int k = 0 ; k < this.main.getCellulesJoueur().size() ; k++) {
			main += this.main.getCellulesJoueur().get(i).getLettre(); 
		}
		
		this.permutation("", main, 7 , permutation);
		
		permutation.stream().filter(s -> Scrabble.regle.isInDico(s));
		
		int max = 0;
		String best = "";
		for(String s : permutation) {
			
			if(s.length() > max) {
				best = s;
				max = best.length();
			}
		}
			
		Logger.log("L'IA va poser le mot [" + best + "]");
		
		}
		
		
	}
	
	@Override
	public List<String> etendreDroite(List<String> suffix, String Initiale) {
		MDAG m = new MDAG(suffix);

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

	private void permutation(String prefix, String str, int n, ArrayList<String> permutationSolution) {

		if (n == 0) {
			permutationSolution.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {

				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), n - 1,
						permutationSolution);
			}
		}
	}

	private int getI(int indice) {
		return indice / Plateau.LARGEUR_PLATEAU;
	}

	private int getJ(int indice) {
		return indice % Plateau.LONGUEUR_PLATEAU;
	}

	private Direction getDirectionMot(int i, int j) {

		if (!PlateauImpl.plateauJeu[i][j - 1].getEstVide())
			return Direction.HORIZONTALE;
		else if (!PlateauImpl.plateauJeu[i][j + 1].getEstVide())
			return Direction.HORIZONTALE;
		else if (!PlateauImpl.plateauJeu[i - 1][j].getEstVide())
			return Direction.VERTICALE;
		else if (!PlateauImpl.plateauJeu[i + 1][j].getEstVide())
			return Direction.VERTICALE;

		return null;

	}

	private int getMotPose(Direction direction, int i, int j, String mot) {


		switch (direction) {

		case VERTICALE:

			while (!PlateauImpl.plateauJeu[i - 1][j].getEstVide()) {
				i--;
			}

			while (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre();
				i++;
			}

			break;

		case HORIZONTALE:

			while (!PlateauImpl.plateauJeu[i][j - 1].getEstVide()) {
				j--;
			}

			while (!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre();
				j++;
			}

			break;

		}
		
		return Plateau.LARGEUR_PLATEAU * i + j;
	}
}
