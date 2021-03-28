package Objets;

import Outils.*;

public class Objets extends Potion
{
	
	public Objets()
	{
        super(Initialisation.get_nomObjets(Alea.EntierEntre(0, Initialisation.get_NBnomObjets()-1)));
	}
	
	
	public String toString()
	{
	    StringBuffer Objets = new StringBuffer("POTION !");
	    Objets.append(super.toString())
	    .append( "+ 1 vie gr�ce � cette potion !!" );
	    
	    return Objets.toString();
	    
	}
	
}