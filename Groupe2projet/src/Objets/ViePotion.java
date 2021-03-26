package Groupe2projet.src.Objets;

public class ViePotion<String> {
	// Attributs
	
	private int vie;
	
	
	// Constructeurs
	
	public ViePotion() {
		vie= 100;
	}
	
	public ViePotion(int v){
		vie= v;
		
	}
	
	// Accesseurs
	
	public int getViePotion( ) {
		return vie;
	}
	
	// Setters
	
	public void setViePotion(int v) {
		vie = v;
	}

	// Service
	
	public void seReposer(int i) { //le joueur se repose 1 ou 2 minutes
		if (i<1) {
			i = 1;
		}
		if (i>2) {
			i = 2;
		}
		
		if (i == 1) {
			vie += 2;
			if(vie>100) {
				vie = 100;
		}
	}

		
		if (i == 1) {
			vie += 5;
			if(vie>100) {
				vie = 100;
			}
}
	}
	
	// Surcharge
	
	public String toString() {
	return "Le personnage a: " + vie;
	
}
}
