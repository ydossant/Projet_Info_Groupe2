package Heros;


public class Heros {
	
	private int PV;
	private final int PV_Depart;
	private boolean Objets = false;
	
	public Heros() 
	{
		
	setPV(PV);
	this.PV_Depart= this.PV;
	
	
	
	
	
	}

	public int getPV() {
		
		return this.PV;
	}

	public void setPV(int pV) {
		
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

	public int getPV_Depart() {
		
		return PV_Depart;
	}
	
	
	
	
	
	public String toString () {
		return ("Nombre de pv : "+ getPV());
	}
	
	
}
