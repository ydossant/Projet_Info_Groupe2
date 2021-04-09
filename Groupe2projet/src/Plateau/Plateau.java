package Plateau;

import Outils.Alea;
import Outils.HorsPlateau;

public class Plateau {
	private static Plateau plat;
    private int nbrelign ;
    private int nbrecol;
    private Piece [][] grille;
    private Piece arrive; //new Piece(coordHeros);
    private Piece sortie; //new Piece(nbrelign, nbrecol);
    Orientation coordHeros;// = Orientation(0,0);
    private int  nbPotions = -1, nbPieges = -1;
    
    public Plateau(int nbrelign, int nbrecol) {
    	this.setNbrelign(nbrelign);
    	this.setNbrecol(nbrecol);
    	this.grille = new Piece[nbrelign][nbrecol];
    	int ttPieces = (nbrelign * nbrecol) - 1;    	
		this.nbPotions = (int)( 1/4 * ttPieces );
		this.nbPieges = (int)( 1/4 * ttPieces );
		this.setArrive(arrive);
		this.setSortie(sortie);
    	
    	this.generer_Plateau();
    	
    }
    
    public static Plateau Nouveau(int nbLignes, int nbColonnes){
    	if(Plateau.plat == null)		
    	{
    		Plateau.plat = new Plateau(nbLignes, nbColonnes);
    	}

    	return Plateau.plat;
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
	}
    
    protected void attribuer(int nbPotions, int nbPieges, int totalUnElt)
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
				pie.set_Tous(nbPotions, nbPieges);
				compte ++;
			}
		}
	}
    
    protected void creer_AttribuePotions()
	{
		this.attribuer( 0, this.nbPotions, this.get_NbPotionsTotal() );	
	}
    
    protected void creer_AttribuerPieges()
	{
		this.attribuer( this.nbPieges, 0, this.get_NbPiegesTotal() );
	}
    
    protected void attribution_PiecesSpeciales()
	{
		int coordI = 0, coordJ = 0;
		int depart = Alea.EntierEntre(0, 1);
		int lg = this.getNbrelign();
		int larg = this.getNbrecol();
		
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
 
    public Piece Avance_Gauche() throws HorsPlateau
	{
		Piece pie = null;
		
		this.coordHeros.a_Gauche();
		pie = this.get_UneCase(this.coordHeros.get_coordI(), this.coordHeros.get_coordJ());
		
		return pie;
	}	
	
	public Piece Avance_Droite() throws HorsPlateau
	{
		Piece pie = null;
		
		this.coordHeros.a_Droite();
		pie = this.get_UneCase(this.coordHeros.get_coordI(), this.coordHeros.get_coordJ());
		
		return pie;
	}
	
	public Piece Avance_Bas() throws HorsPlateau
	{
		Piece pie = null;
		
		this.coordHeros.en_Bas();
		pie = this.get_UneCase(this.coordHeros.get_coordI(), this.coordHeros.get_coordJ());
		
		return pie;
	}

	public Piece Avance_Haut() throws HorsPlateau
	{
		Piece pie = null;
		
		this.coordHeros.en_Haut();
		pie = this.get_UneCase(this.coordHeros.get_coordI(), this.coordHeros.get_coordJ());
		
		return pie;
	}
	
	public String TestPossibilite_deplacement()
	{
		StringBuffer bf = new StringBuffer();

		try
		{
			Orientation or = (Orientation)this.coordHeros.clone();
			or.en_Haut();
			bf.append("H : Pièce au-dessus possible \n");
		}
		catch(Exception e) 
		{
			bf.append("Mur au-dessus\n"); 
		}
		
		try
		{
			Orientation or = (Orientation)this.coordHeros.clone();
			or.en_Bas();
			bf.append("B : Pièce au-dessous possible \n");
		}
		catch(Exception e) 
		{
			bf.append("Mur au-dessous\n");
		}
		
		try
		{
			Orientation or = (Orientation)this.coordHeros.clone();
			or.a_Gauche();
			bf.append("G : Pièce à gauche possible\n");
		}
		catch(Exception e) 
		{
			bf.append("Mur à gauche\n");
		}
		
		try
		{
			Orientation or = (Orientation)this.coordHeros.clone();
			or.a_Droite();
			bf.append("D : Pièce à droite possible \n");
		}
		catch(Exception e) 
		{
			bf.append("Mur à droite\n");
		}
		
		return bf.toString();
	}
	
	public String toString(){	
		StringBuffer bf = new StringBuffer("\n");
		for(int i = 0; i < this.nbrelign; i ++){
			for(int j = 0; j< this.nbrecol; j ++){				 
				Piece pi = this.get_UneCase(i, j);
				Orientation or = pi.getCoord();
				bf.append("|");
				if( or.equals(this.get_CoordHeros()) ){
					bf.append("H");
				}
				else
					bf.append(pi.attribuer_Lettre());
				bf.append("|");
	        }
			bf.append("\n");
		}
		return bf.toString();
	}

	public static void detruire_Plateau()
	{
		Plateau.plat = null;
		Orientation.raz_ValsMaxs();
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

	
}
	