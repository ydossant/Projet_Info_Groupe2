package Heros;

import Objets.*;
import Outils.*;

public class Heros {
	
	private int PV;
	private final int PV_Depart;
	private boolean Objets = false;
	private Sac sac;
	
	public Heros() 
	{
		
	this.PV = Alea.EntierEntre(5,10);
	this.PV_Depart= this.PV;
	
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

	public Sac getSac() {
		
		return this.sac;
	}
	
	public boolean getObjets() {
		return this.Objets;
	}

	public void setObjets(boolean objets) {
		
		Objets = objets;
		
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
