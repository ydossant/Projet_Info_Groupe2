package Plateau;

import Outils.Alea;
import plateau.Piece;

public class Plateau {
	private static Plateau plat;
    private int nbrelign ;
    private int nbrecol;
    private Piece [][] grille;
    private Piece arrive, sortie;
    Orientation coordHeros = null;
    
    protected Plateau(int nbrelign, int nbrecol) {
    	this.setNbrelign(nbrelign);
    	this.setNbrecol(nbrecol);
    	this.grille = new Piece[nbrelign][nbrecol];
    	
    	this.generer_Plateau();
    	
    }
    
    protected void generer_Plateau()
	{
		int nbc, nbl;
		
		nbl = this.getNbrelign();
		nbc = this.getNbrecol();
		for( int i = 0; i < nbl; i ++ )
		{	
			for( int j = 0; j < nbc; j ++ )
			{
				Piece pie = new Piece( new Orientation(i, j) );
				this.set_UneCase(i, j, pie);
			}
		}
		this.attribution_PiecesSpeciales();
		this.attribuer_AutresPieces();
	}
    
    protected void attribution_PiecesSpeciales()
	{
		int coordI = 0, coordJ = 0;
		int depart = Alea.EntierEntre(0, 1);
		int lg = this.getNbrelign();
		int larg = this.getNbrecol();
		
		/* On tire un nombre au hasard entre 1 et 2 pour savoir 
		 * Sur quelle coordonnée de départ on se fixe 
		 * 0 => Ordonnée, 1 => Abscisse
		 */
		if(depart == 0)
		{	
			/* On cherche à avoir des coordonnées faisants le contour du donjon */
			coordI = Alea.EntierEntre(0, lg - 1);
			
			if( (coordI == 0) || (coordI == (lg - 1) ) )
			{
				coordJ = Alea.EntierEntre(0, larg - 1);
			}
			else
			{
				boolean bon = false;
				while(! bon)
				{
					coordJ = Alea.EntierEntre(0, larg - 1);
					bon = ( (coordJ == 0) | (coordJ == larg - 1) );
				}
			}
		}
		else
		{
			/* On cherche à avoir des coordonnées faisants le contour du donjon */
			coordJ = Alea.EntierEntre(0, larg - 1);
			
			if( (coordJ == 0) || (coordJ == (larg - 1) ) )
			{
				coordI = Alea.EntierEntre(0, lg - 1);
			}
			else
			{
				boolean bon = false;
				while(! bon)
				{
					coordI = Alea.EntierEntre(0, lg - 1);
					bon = ( (coordI == 0) | (coordI == lg - 1) );
				}
			}
		}
				
		/* On définit la pièce où le joueur devra sortir */
		Piece pce = this.get_UneCase(coordI, coordJ); 
		this.setSortie( pce );
		this.setArrive( pce );
				
	}
 
    /*public Plateau(int n,int p ){
         nbrelign = this.getNbrelign();
         nbrecol = this.getNbrecol();
 
         for(int i=0; i< nbrelign; i++){
            for(int j =0; j< nbrecol; j++){
            	Piece pie = new Piece( new Orientation(i, j) );
				this.set_UneCase(i, j, pie);
           }
        }
    }
    */
    
 
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
	
	
	public static Plateau getPlat() {
		return plat;
	}

	public static void setPlat(Plateau plat) {
		Plateau.plat = plat;
	}

	public Piece getArrive() {
		return arrive;
	}

	public void setArrive(Piece arrive) {
		this.arrive = arrive;
	}

	public Piece getSortie() {
		return sortie;
	}

	public void setSortie(Piece sortie) {
		this.sortie = sortie;
	}

	public Orientation getCoordHeros() {
		return coordHeros;
	}

	public void setCoordHeros(Orientation coordHeros) {
		this.coordHeros = coordHeros;
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
			for(int j  =0; j< this.nbrecol; j++){
				 
	             System.out.print(pie.representation_Texte(i, j));
	           }
		}
		
		bf.append("\n");
		
		return bf.toString();
	}

	public void afficher(){
       System.out.println();
       for(int i=0; i< nbrelign; i++){
            for(int j  =0; j< nbrecol; j++){
 
             System.out.print(" " + pie.representation_Texte(i, j));
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
	