package Plateau;

import Outils.Alea;

public class Plateau {
	private static Plateau plat;
    private int nbrelign ;
    private int nbrecol;
    private Piece [][] grille;
    private Piece arrive, sortie;
    Orientation coordHeros = null;
    private int nbMurs = -1, nbPotions = -1, nbPieges = -1;
    
    protected Plateau(int nbrelign, int nbrecol) {
    	this.setNbrelign(nbrelign);
    	this.setNbrecol(nbrecol);
    	this.grille = new Piece[nbrelign][nbrecol];
    	int ttPieces = (nbrelign * nbrecol) - 1;    	
		this.nbPotions = (int)( 1/6 * ttPieces );
		this.nbPieges = (int)( 1/6 * ttPieces );
		this.nbMurs = (int)( 1/6 * ttPieces );
    	
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
    
    protected void attribuer_AutresPieces()
	{
		this.creer_AttribuePotions();
		this.creer_AttribuerPieges();
		this.creer_AttribuerMurs();
	}
    
    protected void attribuer(int nbPotions, int nbPieges, int nbMurs, int totalUnElt)
	{
		int compte = 0;
		int i, j, nbC, nbL;
		
		nbL = this.getNbrelign();
		nbC = this.getNbrecol();
		Piece pArrive = this.getArrive();
		Piece pSortie = this.getSortie();
		
		while(compte < totalUnElt)
		{
			i = Alea.EntierEntre(0, nbL - 1);
			j = Alea.EntierEntre(0, nbC - 1);
			
			Piece pie = this.get_UneCase(i, j);
			if( pie.get_PasInitialisee() && (pie != pArrive) 
										 && (pie != pSortie) )
			{
				pie.set_Tous(nbPotions, nbMurs, nbPieges);
				compte ++;
			}
		}
	}
    
    protected void creer_AttribuePotions()
	{
		this.attribuer( this.nbPotions, 0, 0, this.get_NbPotionsTotal() );	
	}
    
    protected void creer_AttribuerMurs()
	{
		Piece pArrive = this.getArrive();
		Piece pSortie = this.getSortie();
		for(int i = 0; i < this.nbrelign; i ++)
		{
			for(int j = 0; j < this.nbrecol; j ++)
			{
				Piece pi = this.get_UneCase(i, j);
				if(pi.get_PasInitialisee() && (pi != pArrive)
										   && (pi != pSortie) )
				{
					pi.set_Tous(0, this.nbMurs, 0);
				}
			}
		}
	}
    
    protected void creer_AttribuerPieges()
	{
		this.attribuer( 0, this.nbPieges, 0, this.get_NbPiegesTotal() );
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
	
	protected final int get_NbPotionsTotal()
	{
		return this.nbPotions;
	}
	
	protected final int get_NbPiegesTotal()
	{
		return this.nbPieges;
	}

	protected final int get_NbMursTotal()
	{
		return this.nbMurs;
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
	