package istv.scrabble.tu;

import org.junit.Before;
import org.junit.Test;

import istv.scrabble.enumerations.CelluleBonus;
import istv.scrabble.objets.CelluleImpl;
import istv.scrabble.objets.Joueur;
import istv.scrabble.objets.PlateauImpl;
import istv.scrabble.objets.Scrabble;

public class PlateauImplTest {

	private PlateauImpl plateau;
	private CelluleImpl celluleA;
	private CelluleImpl celluleB;
	private CelluleImpl celluleC;
	
	
	@Before
	public void setUp() {
	plateau =  new PlateauImpl();
	
	celluleA  = new CelluleImpl('A',CelluleBonus.NORMAL);
	celluleB  = new CelluleImpl('B');
	celluleC  = new CelluleImpl('C');
	
	plateau.creationPlateau();
	
	}
	
	@Test
	public void testMethodeSetCaseJouable() {
		
		
		plateau.dessinerPlateau();
		System.out.println("===================================");
		plateau.poserCellule(7, 7, celluleA);
		plateau.poserCellule(2, 3, celluleA);
		System.out.println("===================================");
		plateau.dessinerPlateau();
		
	}
	
	@Test
	public void testCaseBonus() {
		System.out.println(plateau.getPlateau()[7][7].getCelluleBonus());
		plateau.poserCellule(7, 7, celluleA);
		plateau.dessinerPlateau();
	}
	
	@Test
	public void testLienMainJoueur() {

		Scrabble s = new Scrabble();
	
		Joueur j = new Joueur("test");
	
		Scrabble.setJoueurActuel(j);

		System.out.println("Etat initiale");
		System.out.println(j.getMain());
		
		plateau.dessinerPlateau();
		
		plateau.poserCellule(7, 7, j.getMain().getMainJoueur().get(3));
		
		
		System.out.println("Etat de la main après avoir posé");
		System.out.println(j.getMain());
		plateau.dessinerPlateau();
		
		
		plateau.enleverCellule(7, 7 , plateau.getCellule(7, 7));
		
		System.out.println("Etat après enlevage");
		System.out.println(j.getMain());
		plateau.dessinerPlateau();
		
		
	}
}
