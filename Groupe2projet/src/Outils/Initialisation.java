package Outils;

// Classe gérant l'ensemble des noms des différents composants
public class Initialisation {
	
	private static String[] nomObjets = {"Potion"};
	
	
	
	// Permet de savoir combien il y a de noms d'objets
	public static final int get_NBnomObjets()
	{
		return Initialisation.nomObjets.length;
	}
	
	
	//Accesseur satique d'un nom d'objet
	public static final String get_nomObjets(int i)
	{
		String ch = null;
		
		if( (i < 0) || (i >= Initialisation.nomObjets.length) )
		{		i = 0;
		}
		ch = Initialisation.nomObjets[i];
		
		return ch;
	}
	
	
	
}
