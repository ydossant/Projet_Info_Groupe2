package Objets;

import Outils.Alea;

public class Potion
{
	private String Nom;
	private int soin;
	private Object nomObjets;
	
	public Potion(String get_nomObjets) {
		this.soin = Alea.EntierEntre(3, 5);
	}
	
	public int get_Soin() {
		return this.soin;
	}
	public String get_Nom()
	{
		return this.Nom;
	}
	public Object getNomObjects(){
		return this.nomObjets;
	}
	public String toString ()
	{
	    StringBuffer Potion = new StringBuffer(this.get_Soin());
		
		return Potion.toString();
	}
}
