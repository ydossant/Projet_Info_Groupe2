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
		
		/* On affiche d'abord les coordonnées */
		sb.append(this.getCoord());
		
		sb.append("\nPrésence d'un monstre : ");
		sb.append("\n").append( this.A_Potions() );
		
		sb.append("\nPrésence d'un piège : ");
		sb.append("\n").append( this.A_Pieges() );
		
		sb.append("\nPrésence d'un trésor : ");
		sb.append("\n").append( this.A_Murs() ).append(" ");

		return sb.toString();		
	}
	
	public String attribuer_Lettre()
	{
		StringBuffer bf = new StringBuffer("");
		
		/* On va afficher soit un M pour monstre
		 *                soit un T pour tresor
		 *                soit un P pour piege
		 *                soit un R pour une pièce vide
		 */
		
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
	
	


}
