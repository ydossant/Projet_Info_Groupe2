package Plateau;

import java.util.LinkedList;

public class Piece{
	private Orientation coord;
	private boolean estDejaVenu ;
	private boolean estSortie ;
	private int nbPotions  = -1;
	private int nbPieges  = -1;
	
	public Piece(Orientation coord)
	{
		this.setCoord(coord);
		this.set_EstLaSortie();
		this.setEstDejaVenu(estDejaVenu);
	}
	
	public Piece(Orientation coord, int nbPotions, int nbPieges)
	{
		this.setCoord(coord);	
		this.nbPotions  = nbPotions;
		this.nbPieges  = nbPieges;
		this.setEstDejaVenu(estDejaVenu);
	}
	
	public Piece(Orientation coord, int nbPotions, int nbPieges, boolean estDejaVenu)
	{
		this.setCoord(coord);	
		this.nbPotions  = nbPotions;
		this.nbPieges  = nbPieges;
		this.setEstDejaVenu(estDejaVenu);
	}
	
	public boolean equals(Object o)
	{
		boolean bon = false;
		if( o instanceof Piece )
		{
			Piece pp = (Piece)o;
			
			bon = this.coord.equals( pp.coord );
			bon &= (this.nbPotions == pp.nbPotions);
			bon &= (this.nbPieges == pp.nbPieges);
			bon &= (this.estDejaVenu = pp.estDejaVenu);
		}
		
		return bon;
	}
	
	public boolean est_Vide()
	{
		boolean bon = true; 		
		bon =  (! this.A_Potions() );
		bon &= (! this.A_Pieges() );
		bon &= (!this.est_LaPieceSortie() );
		
		return bon;
	}
	
	public String toString ()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.getCoord());
		
		sb.append("\nPrésence d'une potion : ");
		sb.append("\n").append( this.A_Potions() );
		
		sb.append("\nPrésence d'un piège : ");
		sb.append("\n").append( this.A_Pieges() );

		return sb.toString();		
	}
	
	public String representation_Texte(int lg, int larg)
	{
		
		StringBuffer bf = new StringBuffer("o");
		
		bf.append( this.attribuer_Lettre() );
				
		return bf.toString();
	}
	
	public String attribuer_Lettre(){
		StringBuffer bf = new StringBuffer("");
		
		if(isEstDejaVenu()==true){
			bf.append("?");
		}
		else{
			if( this.nbPotions > 0 ){
				bf.append("S");
			}
			if( this.nbPieges > 0 ){
				bf.append("P");
			}
			if( this.est_Vide() ){
				bf.append(" ");
			}
			if(est_LaPieceSortie()==true) {
				bf.append("E");
			}
		}				
		return bf.toString();
	}
	
	public final boolean get_Pieges(){
		if( ! this.est_DejaPasseIci() )
		{
			this.estDejaVenu = true;
		}
		return this.estDejaVenu;
	}
	
	public final boolean devient_Inactif() {
		boolean a= false;
		if(this.A_Pieges()&&this.est_DejaPasseIci()) {
			a=true;
		}
		return a;
	}
	public final boolean est_DejaPasseIci()
	{
		return this.estDejaVenu;
	}
	
	public final boolean est_LaPieceSortie()
	{
		return this.estSortie;
	}
	
	public final boolean A_Pieges()
	{
		boolean bon = false;
		bon = ( this.nbPieges > 0 );	
		return bon;
	}
	
	public final boolean A_Potions()
	{
		boolean bon = false;
		bon = ( this.nbPotions > 0 );		
		return bon;
	}
	
	boolean get_PasInitialisee()
	{
		boolean bon;
		
		bon = ( (this.nbPotions   == -1) && 
				(this.nbPieges   == -1));
		return bon;
	}

	public Orientation getCoord() {
		return coord;
	}

	public void setCoord(Orientation coord) {
		this.coord = coord;
	}

	public boolean isEstDejaVenu() {
		return estDejaVenu;
	}

	public void setEstDejaVenu(boolean estDejaVenu) {
		this.estDejaVenu = estDejaVenu;
	}

	public boolean isEstSortie() {
		return estSortie;
	}

	public void setEstSortie(boolean estSortie) {
		this.estSortie = estSortie;
	}
	
	public final void set_EstLaSortie()
	{
		if(! this.estSortie )
		{
			this.estSortie = true;
		}
	}

	public int getNbPotions() {
		return nbPotions;
	}

	public void setNbPotions(int nbPotions) {
		this.nbPotions = nbPotions;
	}

	public int getNbPieges() {
		return nbPieges;
	}

	public void setNbPieges(int nbPieges) {
		this.nbPieges = nbPieges;
	}
	
	public final Orientation get_Coordonnees()
	{
		return this.coord;
	}
	
	public final void set_Coordonnees(Orientation or)
	{
		if(this.coord == null)
		{
			this.coord = (Orientation)or.clone();
		}
	}
}
