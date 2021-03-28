package Plateau;


public class Plateau {
	private static Plateau plat;
    private int nbrelign ;
    private int nbrecol;
    private Piece [][] grille;
    private Piece pie;
    Orientation coordHeros = null;
 
    public Plateau(int n,int p ){
         nbrelign = this.getNbrelign();
         nbrecol = this.getNbrecol();
 
         for(int i=0; i< nbrelign; i++){
            for(int j =0; j< nbrecol; j++){
            	Piece pie = new Piece( new Orientation(i, j) );
				this.set_UneCase(i, j, pie);
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

	public Piece[][] getGrille() {
		return grille;
	}

	public void setGrille(Piece[][] grille) {
		this.grille = grille;
	}
	
	protected Piece get_UneCase(int i, int j)
	{
		return this.grille[i][j];
	}
	
	protected final void set_UneCase(int i, int j, Piece pie)
	{
		this.grille[i][j] = pie;
	}
	
	protected Orientation get_CoordHeros()
	{
		return this.coordHeros;
	}
	
	public String toString()
	{
		StringBuffer bf = new StringBuffer("\n");
		
		for(int i = 0; i < this.nbrelign; i ++)
		{
			bf.append( this.afficheUneLigne(i) );
		}
		
		bf.append("\n");
		
		return bf.toString();
	}
	
	protected String afficheUneLigne(int lig)
	{
		StringBuffer bf = new StringBuffer("");
		int nbL = this.getNbrelign();
		int nbC = this.getNbrecol();
		
		bf.append( TravailleChaine.avant_ElementPiece(nbC, 5) );
		
		/* 2) On affiche le contenu de chaque pièce pour une ligne */
		for(int j = 0; j < nbC; j ++)
		{
			Piece pi = this.get_UneCase(lig, j);

			String heros = new String();

			Orientation or = pi.getCoord();
			/* Si le héros se trouve dans la pièce on l'affiche aussi */
			if( or.equals(this.get_CoordHeros()) )
			{
				heros = new String("H");
			}		
			StringBuffer ssSB = new StringBuffer(heros);
			/* On rajoute l'élément qu'il y a dans la pièce */
			ssSB.append( pi.attribuer_Lettre() );
			
			bf.append( TravailleChaine.rajouter_Blanc(5, ssSB.toString(), " ") );	
		}
		bf.append("|\n");
		
		bf.append( TravailleChaine.apres_ElementPiece(nbC, 5) );
		
		return bf.toString();
	}

	public void afficher(){
       System.out.println();
       for(int i=0; i< nbrelign; i++){
            for(int j  =0; j< nbrecol; j++){
 
             System.out.print(" " + pie.attribuer_Lettre());
           }
            System.out.println(" " );
       }
       System.out.println();
	}
	
	public static void detruire_Plateau()
	{
		Plateau.plat = null;
		Orientation.raz_ValsMaxs();
	}
	

 
}
	