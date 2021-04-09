package Objets;

import java.io.Serializable;

import Outils.Alea;

public abstract class Potion implements Serializable
{
	private String Nom;
	private int soin;

	
	public Potion ()
	{
	 this.soin=Alea.EntierEntre(3,5);
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
