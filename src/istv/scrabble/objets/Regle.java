package istv.scrabble.objets;

import istv.scrabble.interfaces.Plateau;

public class Regle {

	static boolean[][] changement = new boolean[15][15];

	public void initChangement() {
		for (int i = 0; i < Plateau.LARGEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LONGUEUR_PLATEAU; j++) {
				changement[i][j] = false;
			}
		}
	}

	/*
	 * ATTENTION à appliquer lorsque les cases jouées ont bien été validées par les
	 * règles
	 */

	private int getFirstChangement() {
		for (int i = 0; i < Plateau.LARGEUR_PLATEAU; i++) {
			for (int j = 0; j < Plateau.LONGUEUR_PLATEAU; j++) {
				if (changement[i][j]) {
					return Plateau.LARGEUR_PLATEAU * i + j;
				}
			}
		}
		return -1;
	}

	public Direction getDirMot() {

		Direction dir = null;
		
		int indiceFirstCellule = this.getFirstChangement();
		
		int i = getI(indiceFirstCellule);
		int j = getJ(indiceFirstCellule);

		if (!PlateauImpl.plateauJeu[i][j - 1].getEstVide())
			dir = Direction.HORIZONTALE;
		else if (!PlateauImpl.plateauJeu[i][j + 1].getEstVide())
			dir = Direction.HORIZONTALE;
		else if (!PlateauImpl.plateauJeu[i - 1][j].getEstVide()) 
			dir =  Direction.VERTICALE;
		else if(!PlateauImpl.plateauJeu[i + 1][j].getEstVide())
			dir =  Direction.VERTICALE;
		
		
		System.out.println(dir);
		System.out.println(getMotPose(dir , i , j));

		
		return null;
	}
	
	private String getMotPose(Direction direction , int i , int j) {
		
		String mot = "";
		
		
		switch(direction) {
		
		case VERTICALE:
			
			while(!PlateauImpl.plateauJeu[i -1 ][j].getEstVide()) {
				i--;
			}
			
			while(!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre(); 
				i++;
			}
			
			break;
		case HORIZONTALE:
		
			while(!PlateauImpl.plateauJeu[i][j - 1].getEstVide()) {
				j--;
			}
			
			while(!PlateauImpl.plateauJeu[i][j].getEstVide()) {
				mot = mot + PlateauImpl.plateauJeu[i][j].getLettre(); 
				j++;
			}
			
			
			break;
			
		}
		
		return mot;
	}

	public void setChangement(int i , int j) {
		changement[i][j] = true;
	}
	private int getI(int indice) {
		return indice / Plateau.LARGEUR_PLATEAU;
	}

	private int getJ(int indice) {
		return indice % Plateau.LARGEUR_PLATEAU;
	}

}
