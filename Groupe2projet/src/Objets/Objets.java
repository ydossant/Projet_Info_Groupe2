package Groupe2projet.src.Objets;


public class Objets extends Potion
{
	
	public Objets()
	{
        super(Initialisation.get_nomObjetF(Alea.EntierEntre(0, Initialisation.get_NBnomObjetF()+1)));
	}
	
	
	public String toString()
	{
	    StringBuffer Objets = new StringBuffer("POTION !");
	    Objets.append(super.toString())
	    .append( "+ 1 vie grâce à cette potion !!" );
	    
	    return Objets.toString();
	    
	}
	
}