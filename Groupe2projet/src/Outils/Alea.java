package Groupe2projet.src.Outils;

import java.util.Random;

public class Alea {
	
	static private Random R = new Random();
	
	static public int EntierEntre( int min, int max )
	{
		int valeur = R.nextInt(max-min+1) + min;
		
		return valeur;
	}
}

