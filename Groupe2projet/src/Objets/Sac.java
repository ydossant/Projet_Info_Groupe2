package Objets;

import java.util.Iterator;
import java.util.LinkedList;
import Outils.*;


public class Sac {
	private LinkedList potions;
	private int max = 0;
	
	public Sac() {
		this.max = Alea.EntierEntre(3,6);
		this.potions = new LinkedList();
	}
	
	public final void ajouter_Element(Potion po)
	{
		int nbElts = this.potions.size();
		if( nbElts + 1 <= this.get_Capacite() )
		{
			this.potions.add(po);
		}
		else
		{
			System.out.println("Capacité du sac à  dos dépassé !\n");
		}
	}
	
	public final boolean supprimer_Element(Potion po)
	{
		boolean bon = false;
		if( this.potions.contains(po) )
		{
			bon = true;
			this.potions.remove(po);
		}
		
		return bon;
	}
	
	public final Object[] toArray()
	{
		return this.potions.toArray();
	}
	
	public final int get_Capacite()
	{
		return this.max;
	}
	
	public final int get_NBelements()
	{
		return this.potions.size();
	}
	
	public String toString()
	{
		StringBuffer bf = new StringBuffer("\n");
		
		Iterator i = this.potions.iterator();
		while( i.hasNext() )
		{
			Potion p = (Potion)i.next();
			bf.append(p);
		}
		
		return bf.toString();
	}
}
