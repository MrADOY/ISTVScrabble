package istv.scrabble.enumerations;

/**
 * 
 *
 * @author Aurelien PIETRZAK
 *
 */

public enum CelluleBonus {
	
	NORMAL(0),
	MOT_COMPTE_DOUBLE(2),
	MOT_COMPTE_TRIPLE(3),
	LETTRE_COMPTE_DOUBLE(2),
	LETTRE_COMPTE_TRIPLE(3);
	
	final private int bonus;
	
	CelluleBonus(final int bonus) {
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return bonus;
	}
}
