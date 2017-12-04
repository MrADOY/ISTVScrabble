/**
 * 22-09-2017
 * @author Lefevre Romain
 * Licence 3 FA - ISTV
 * 
 */

package istv.scrabble.objets;

import java.util.Scanner;

import istv.scrabble.exceptions.GameException;
import istv.scrabble.exceptions.Logger;
import istv.scrabble.mdag.MDAG;

public class Scrabble {

	public static PlateauImpl plateau;
	public static Pioche pioche;
	public static Joueur[] joueurs;
	public static Joueur joueurActuel;
	public static Dictionnaire dico;
	public static Regle regle;
	public static int nbTour;

	public Scrabble() {

		
		Scrabble.plateau = new PlateauImpl();
		Scrabble.pioche = new Pioche();
		Scrabble.joueurs = new Joueur[2];
		Scrabble.joueurs[0] = new Joueur("Joueur 1", pioche, plateau);
		Scrabble.joueurs[1] = new Joueur("Joueur 2", pioche, plateau);
		Scrabble.setJoueurActuel(Scrabble.joueurs[0]);
		
		Scrabble.regle = new Regle();
		Scrabble.nbTour = 1;
		try {
			Scrabble.dico = new Dictionnaire("dico.txt");
		} catch (GameException e) {

		}
		Logger.log("Initialisation du Scrabble , OK !");
	}

	public Scrabble(String j1, String j2) {

	
		Scrabble.plateau = new PlateauImpl();
		Scrabble.pioche = new Pioche();
		Scrabble.joueurs = new Joueur[2];
		Scrabble.joueurs[0] = new Joueur(j1, pioche, plateau);
		Scrabble.joueurs[1] = new Joueur(j2, pioche, plateau);
		Scrabble.regle = new Regle();
		Scrabble.nbTour = 1;

		Scrabble.setJoueurActuel(Scrabble.joueurs[0]);
		try {
			Scrabble.dico = new Dictionnaire("dico.txt");
		} catch (GameException e) {
			//
		}
		Logger.log("Initialisation du Scrabble , OK !");

	}
	
	public Scrabble(String j1) {

		
		Scrabble.plateau = new PlateauImpl();
		Scrabble.pioche = new Pioche();
		Scrabble.joueurs = new Joueur[2];
		Scrabble.joueurs[0] = new Joueur(j1, pioche, plateau);
		Scrabble.joueurs[1] = new IAImpl("IA", pioche, plateau);
		Scrabble.regle = new Regle();
		Scrabble.nbTour = 1;

		Scrabble.setJoueurActuel(Scrabble.joueurs[0]);
		try {
			Scrabble.dico = new Dictionnaire("dico.txt");
		} catch (GameException e) {
			//
		}
		Logger.log("Initialisation du Scrabble , OK !");

	}

	public static void jouerTour() {

		Scanner sc = new Scanner(System.in);

		boolean choixFinTour = false;

		int choixCellule = 0;
		int i = 0;
		int j = 0;

		Logger.log("Tour actuel : " + Scrabble.nbTour);
		Logger.log("C'est au tour de : " + Scrabble.getJoueurActuel());

		do {

			Scrabble.plateau.dessinerPlateau();
			
			System.out.println(Scrabble.getJoueurActuel().getMain().toString());
			System.out.println("Entrez le numéro de la cellule choisie");
			choixCellule = sc.nextInt();
			System.out.println("Entrez la ligne choisie");
			i = sc.nextInt();
			System.out.println("Entrez la colonne choisie");
			j = sc.nextInt();

			Scrabble.getJoueurActuel().poserCellule(choixCellule, i, j);

			System.out.println("Fin du tour 1/0 ? ");
			choixFinTour = (sc.nextInt() == 1) ? true : false;

		}

		while (!choixFinTour);	
		
		Scrabble.verificationFinTour();
		
	}

	public static void verificationFinTour() {

		try {
			Scrabble.regle.recuperationMotsPoses();
			Logger.log("Fin du tour de : " + Scrabble.getJoueurActuel());
			Scrabble.changementJoueur();
		} catch (GameException e) {
			Scrabble.jouerTour();
			Scrabble.changementJoueur();
		}
	}

	public static void changementJoueur() {

		if (Scrabble.joueurActuel.equals(Scrabble.getJoueur1())) {
			Scrabble.setJoueurActuel(Scrabble.getJoueur2());
			Scrabble.getJoueurActuel().piocheLettre();
			Scrabble.nbTour++;
		} else {
			Scrabble.setJoueurActuel(Scrabble.getJoueur1());
			Scrabble.getJoueurActuel().piocheLettre();
			Scrabble.nbTour++;
		}
	}
	
	public static PlateauImpl getPlateau() {
		return plateau;
	}

	public static void setPlateau(PlateauImpl plateau) {
		Scrabble.plateau = plateau;
	}

	public static Pioche getPioche() {
		return pioche;
	}

	public static void setPioche(Pioche pioche) {
		Scrabble.pioche = pioche;
	}

	public static Joueur[] getJoueurs() {
		return joueurs;
	}

	public static void setJoueurs(Joueur[] joueurs) {
		Scrabble.joueurs = joueurs;
	}

	public static MDAG getDictionnaire() {

		return dico.getDictionnaire();

	}
	
	public static Joueur getJoueurActuel() {
		return joueurActuel;
	}

	public static void setJoueurActuel(Joueur j) {
		Scrabble.joueurActuel = j;
	}

	public static Joueur getJoueur1() {
		return Scrabble.joueurs[0];
	}

	public static Joueur getJoueur2() {
		return Scrabble.joueurs[1];
	}

}
