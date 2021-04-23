package Heros;

import Objets.*;
import Outils.*;

public class Heros {
	
	private int PV;
	private final int PV_Depart;
	private boolean Objets = false;
	private int NBpotion = 0;
	
	public Heros() 
	{
		
	this.PV = Alea.EntierEntre(5,10);
	this.PV_Depart= this.PV;
	
	}

	public int getPV_Depart() {
		
		return this.PV_Depart;
	}
	
	public int getPV() {
		return this.PV;
	}

	public void setPV(int PV) {
		
		if ( PV <= 0 )
	    {
	        System.out.println("Le heros est mort.");
	    }
	    else
	    {
	    	if ( PV <= this.PV_Depart )
	    		this.PV = PV;
	    	
	    	else 
	    		this.PV = this.PV_Depart;
	    }
			
	}

	public int getNBpotion() {
		
		return this.NBpotion;
	}
	
	public boolean getObjets() {
		return this.Objets;
	}

	public void setObjets(boolean objets) {
		
		Objets = objets;
		
	}
	
	public void ajoutPotion() {
		this.NBpotion += 1 ;
	}
	
	public void suprimePotion() {
		this.NBpotion -= 1 ;
	}
	
	public int soinPotion (Potion Po) {
		int PV = this.PV;
		PV = PV + Po.get_Soin();
		return PV;
	}
	
	public int degatsPieges (Piege P) {
		int PV = this.PV;
		PV = PV - P.get_Niveau();
		return PV;
	}
	
	public String toString () {
		return "Nombre de pv : "+ getPV();
	}


}
