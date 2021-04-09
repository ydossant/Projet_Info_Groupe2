package Objets;

import Outils.Alea;

public abstract class Potion
{
	private String Nom;
	private int soin;
	private Object nomObjets;

	
	{
	 this.soin=Alea.EntierEntre(3,5);
	}
	
	public Potion(String get_nomObjets) {
		return;
	}
	
	public int get_Soin() {
		return this.soin;
	}
	public String get_Nom()
	{
		return this.Nom;
	}
	
	public String toString ()
	{
	    StringBuffer Potion = new StringBuffer(this.get_Nom());
		
		return Potion.toString();
	}
}
