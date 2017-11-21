package istv.scrabble.objets;


public class Anagramme {
	public Anagramme(String pmot) {
		char[] word;
		char[] solution;
		char[] TEMP = pmot.toCharArray();
		
		int taille_solution = 0;
		int limiteSuffixe = 6;
		int long_anagram = TEMP.length;
		
		word = new char[long_anagram];
		solution = new char[long_anagram]; // Là ou seront stockées les différentes solutions

		for (int m = 0; m < long_anagram; m++) {
			word[m] = TEMP[m];
		}

		Arbre(word, 0, long_anagram, solution, taille_solution, limiteSuffixe); // On rentre dans le premier étage de l'arbre

		if (word != null) {
			word = null;
		}
		if (solution != null) {
			solution = null;
		}
		System.gc();
	}

	void Arbre(char[] word, int n, int lg, char[] solution, int taille_solution, int limiteSuffixe) // Fonction recursive
	{
		char[] comb;
		int i, j, k, m;
		StringBuffer tmp;

		if (lg != 0) {
			comb = new char[lg];

			taille_solution++; // On est descendu d'un étage dans l'arbre => taille de la solution +1
			
			for (i = 0; i < lg; i++){ // Pour chaque lettre du nouveau mot on réalise autant d'arbre pour l'étage
				solution[n] = word[i]; // On ajoute la nouvelle lettre à la fin de la solution (n = étage)
				tmp = new StringBuffer();
				
				for (m = 0; m < taille_solution; m++) {
					tmp.append(solution[m]);
				}
				
				if(tmp.length() <= limiteSuffixe) {
					System.out.println(tmp);
				}
			
				//System.out.println(tmp); /// ########## Les différentes combinaisons sortent ici !! BINGO ###########//
				k = 0; // ICI on définit la nouvelle combinaison COMB avec les lettres restantes
				for (j = 0; j < lg; j++) {
					if (j != i) {
						comb[k] = word[j]; // Donc comb prend toutes les lettres restantes
						k++;
					}
				}
				Arbre(comb, n + 1, lg - 1, solution, taille_solution, limiteSuffixe); // Puis on descend d'un étage dans l'arbre en reinjectant le nouveau comb
			}
		}
		else {
			taille_solution--; // On remonte d'un étage dans l'arbre
		}
	}

	public static void main(String[] args) {
		Anagramme ana = new Anagramme("rraiver");
	}
}
