package Objets;


public class Objets extends Potion
{
	/*
	 * Je bosse pendant la semaine pour trouver qqc qui fonctionne pour la potion (pour l'instant j'ai surtout repris 
	 * les classes du dossier zip)
	 */
	public Objets()
	{
        super(Initialisation.get_nomObjetF(Alea.EntierEntre(0, Initialisation.get_NBnomObjetF()+1)));
	}
	
	
	public String toString()
	{
	    StringBuffer Objets = new StringBuffer("\nObjet de la quête : ");
	    Objets.append(super.toString())
	    .append( "\nIl ne vous manque plus qu'à trouver la sortie ;o) !!" );
	    
	    return Objets.toString();
	    
	}
	
}