package istv.scrabble.objets;

public enum Direction {

	VERTICALE(1), HORIZONTALE(0);

	private int dir;

	Direction(int dir) {
		this.dir = dir;
	}

	public int getDir() {
		return this.dir;
	}

}
