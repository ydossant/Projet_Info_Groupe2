package Groupe2projet.src.Objets;


import java.io.Serializable;


public class Piege implements Serializable
{
	private int Niveau_Difficulte;
	private boolean Actif;
	
	
	public Piege()
	{
		this.Niveau_Difficulte = Alea.EntierEntre(2, 5);
		this.Actif = true;
	}
	
	
	public int get_Niveau()
	{
		return this.Niveau_Difficulte;
	}
	

	public boolean get_Actif()
	{
		return this.Actif;
	}
	
	
	public void set_Inactif()
	{
		this.Actif = false;
	}
}
