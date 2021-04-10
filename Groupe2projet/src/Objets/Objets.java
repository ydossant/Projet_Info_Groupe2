package Objets;

import Outils.*;

public class Objets extends Potion
{
	
	public Objets()
	{
        super(Initialisation.get_nomObjets(Alea.EntierEntre(0, Initialisation.get_NBnomObjets()+1)));
	} 
	
	
	public String toString()
	{
	    StringBuffer Objets = new StringBuffer();
	    Objets.append(super.toString())
	    .append( "+ "+super.get_Soin()+ " vie grâce à cette potion !!" );
	    
	    return Objets.toString();
	    
	}
	
}