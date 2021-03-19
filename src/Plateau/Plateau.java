package Plateau;

public class Plateau {

	private int nbrelign ;
    private int nbrecol;
    private char [][] grille;
 
    public Plateau(int n,int p ){
         nbrelign = n;
         nbrecol = p;
         grille = new char[nbrelign][nbrecol];
 
         for(int i=0; i< nbrelign; i++){
            for(int j =0; j< nbrecol; j++){
             grille[i][j] = '*';
           }
        }
    }
 
    public void afficher(){
       System.out.println();
       for(int i=0; i< nbrelign; i++){
            for(int j  =0; j< nbrecol; j++){
 
             System.out.print(" | " + grille[i][j]);
           }
            System.out.println(" | " );
       }
       System.out.println();
   }
 
}
