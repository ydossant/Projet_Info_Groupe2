package Plateau;

public class Plateau2 {
 
    private int nbrelign ;
    private int nbrecol;
    private char [][] grille;
 
    public Plateau2(int n,int p ){
         nbrelign = n;
         nbrecol = p;
         grille = new char[nbrelign][nbrecol];
 
         for(int i=0; i< nbrelign; i++){
            for(int j =0; j< nbrecol; j++){
             grille[i][j] = '*';
           }
        }
    }
 
    public int getNbrelign() {
		return nbrelign;
	}

	public void setNbrelign(int nbrelign) {
		this.nbrelign = nbrelign;
	}

	public int getNbrecol() {
		return nbrecol;
	}

	public void setNbrecol(int nbrecol) {
		this.nbrecol = nbrecol;
	}

	public char[][] getGrille() {
		return grille;
	}

	public void setGrille(char[][] grille) {
		this.grille = grille;
	}

	public void afficher(){
       System.out.println();
       for(int i=0; i< nbrelign; i++){
            for(int j  =0; j< nbrecol; j++){
 
             System.out.print(" " + grille[i][j]);
           }
            System.out.println(" " );
       }
       System.out.println();
   }
 
}
