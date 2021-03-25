package main;

import Heros.*;
import Objets.*;
import Outils.*;
import Plateau.*;

public class Main {
	private static Plateau pla;
	private static Heros he;
	private static int lon = 2;
	private static int lar = 2;
	private static double vide = 1/2;
	private static double mur = 1/6;
	private static double pot = mur;
	private static double pge = mur;
	
	private static void init_Default(){
		Main.he = new Heros();
	}
	
	private static void creer_Donjon()
	{
		boolean bon = false;
		
		do
		{
			System.out.println( "_______________Creation du donjon_______________" );
			System.out.println( "Saisir tout d'abord la longueur du donjon (minimum 2)" );
			Main.lon = Clavier.lire_Int();
			System.out.println( "Saisir tout d'abord la largeur du donjon (minimum 2)" );
			Main.lar = Clavier.lire_Int();
			
			bon = ( (Main.lon >= 2) && (Main.lar >= 2) );
			if(! bon)
			{
				System.out.println( "Attention valeurs anormales :o( !" );
			}
		}while(! bon); 
		
		bon = false;
	}
	
	private static void creer_Heros() {
		String nom;
		
		System.out.println( "________________Creation du heros________________" );
		System.out.println( "Saisir votre nom");
		nom = Clavier.lire_Chaine();
		
		
		System.out.println(Main.he);
	}
	private static void Afficher(Object ch){
		System.out.println(ch);
	}

}
