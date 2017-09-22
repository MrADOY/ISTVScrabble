package istv.scrabble.objets;

public class Cellule {
    int i;
    int j;
    Boolean estVide;
    
    //Constructeur
    public Cellule(){
        i= 100;
        j= 200;
        estVide= true;
    }
    public void genererCelluleVide(){
        Cellule cellule = new Cellule();
    }
}
