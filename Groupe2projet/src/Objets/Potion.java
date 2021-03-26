package Groupe2projet.src.Objets;

import java.io.Serializable;

public abstract class Potion implements Serializable
{

	private String Nom;

	
	public Potion (String Potion)
	{
	 this.Nom=Potion;   
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
