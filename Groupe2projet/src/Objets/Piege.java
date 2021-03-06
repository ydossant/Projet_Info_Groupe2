package Objets;

import Outils.*;

public class Piege
{
	private int Niveau_Difficulte;
	private boolean Actif;
	
	
	public Piege()
	{
		this.Niveau_Difficulte = Alea.EntierEntre(2, 4);
		this.Actif = true;
	}
	
	public Piege(boolean actif) {
		this.Niveau_Difficulte = Alea.EntierEntre(2, 4);
		this.Actif = actif;
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
	
	public String toString() {
		return "Vous perdez "+this.Niveau_Difficulte+" PV.";
	}
}
