package Plateau;


public class Piece{
	private Orientation coord;
	private boolean estDejaVenu = false;
	private boolean aTresor     = false;
	private boolean estSortie   = false;
	private boolean estArrive   = false;	
	private int nbPotions  = -1;
	private int nbPieges  = -1;
	private int nbMurs = -1;
	
	public Piece(Orientation coord)
	{
		this.setCoord(coord);
	}
	
	public Piece(Orientation coord, int nbPotions, int nbPieges, int nbMurs)
	{
		this.setCoord(coord);
		
		this.nbPotions  = nbPotions;
		this.nbPieges  = nbPieges;
		this.nbMurs = nbMurs;
	}
	
	public boolean est_Vide()
	{
		boolean bon = true; 		
		bon =  (! this.A_Potions() );
		bon &= (! this.A_Pieges() );
		bon &= (! this.A_Murs() );
		bon &= (!this.est_LaPieceSortie() );
		
		return bon;
	}
	
	public String toString ()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.getCoord());
		
		sb.append("\nPr�sence d'une potion : ");
		sb.append("\n").append( this.A_Potions() );
		
		sb.append("\nPr�sence d'un pi�ge : ");
		sb.append("\n").append( this.A_Pieges() );
		
		sb.append("\nPr�sence d'un mur : ");
		sb.append("\n").append( this.A_Murs() ).append(" ");

		return sb.toString();		
	}
	
	public String representation_Texte(int lg, int larg)
	{
		
		StringBuffer bf = new StringBuffer("o");
		
		bf.append( this.attribuer_Lettre() );
				
		return bf.toString();
	}
	
	public String attribuer_Lettre()
	{
		StringBuffer bf = new StringBuffer("");
		
		if( this.nbPotions > 0 )
		{
			bf.append("M");
		}
		if( this.nbPieges > 0 )
		{
			bf.append("P");
		}
		if( this.nbMurs > 0 )
		{
			bf.append("T");
		}
		if( this.est_Vide() )
		{
			bf.append("?");
		}
		
		return bf.toString();
	}
	
	public final boolean est_DejaPasseIci()
	{
		return this.estDejaVenu;
	}
	
	public final boolean est_LaPieceSortie()
	{
		return this.estSortie;
	}
	
	public final boolean A_Murs()
	{
		return (this.nbMurs > 0);
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
				(this.nbPieges   == -1) &&
				(this.nbMurs  == -1) );
		
		return bon;
	}
	//GETS AND SETS

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

	public boolean isaTresor() {
		return aTresor;
	}

	public void setaTresor(boolean aTresor) {
		this.aTresor = aTresor;
	}

	public boolean isEstSortie() {
		return estSortie;
	}

	public void setEstSortie(boolean estSortie) {
		this.estSortie = estSortie;
	}

	public boolean isEstArrive() {
		return estArrive;
	}

	public void setEstArrive(boolean estArrive) {
		this.estArrive = estArrive;
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

	public int getNbMurs() {
		return nbMurs;
	}

	public void setNbMurs(int nbMurs) {
		this.nbMurs = nbMurs;
	}
	
	public final void set_Tous(int nbM, int nbPo, int nbPi)
	{
		this.setNbPieges(nbPi);
		this.setNbPotions(nbPo);
		this.setNbMurs(nbM);
	}
	


}
