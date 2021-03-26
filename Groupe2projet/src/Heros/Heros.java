package Heros;

import Objets.*;

public class Heros {
	
	private int PV;
	private final int PV_Depart;
	private boolean Objets = false;
	
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

	public boolean getObjets() {
		
		return this.Objets;
	}

	public void setObjets(boolean objets) {
		
		Objets = objets;
		
	}
	
	public String degatsPieges (Piege P) {
		int degats = P.get_Niveau();
		
		if (P.get_Actif()) {
			return "le piege est actif, le heros perd" + degats + " pv"; 
		}
		else
			return "le piège est inactif";
		//("il reste "  + (PV - degats) + " pv ");
	}
	
	public String toString () {
		return ("Nombre de pv : "+ getPV());
	}


}
