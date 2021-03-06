package main;

import Heros.*;
import Objets.*;
import Outils.*;
import Plateau.*;

public class Main {
	private static Plateau pla;
	private static Heros he;
	private static int lon = 5;
	private static int lar = 5;

	
	private static void init_Default(){
		Main.he = new Heros();
	}
	
	private static void creer_Donjon()
	{
		boolean bon = false;
		
		do
		{
			System.out.println( "Creation du donjon" );
			System.out.println( "Saisir la longueur du donjon (minimum 4)" );
			Main.lon = Clavier.lire_Int();
			System.out.println( "Saisir la largeur du donjon (minimum 4)" );
			Main.lar = Clavier.lire_Int();
			
			bon = ( (Main.lon >= 4) && (Main.lar >= 4) );
			if(! bon)
			{
				System.out.println( "Mauvaises valeurs" );
			}
		}while(! bon); 
		
		bon = false;
	}
	
	private static void creer_Heros() {
		String nom;
		
		System.out.println( "Creation du heros" );
		System.out.println( "Saisir votre nom");
		nom = Clavier.lire_Chaine();
		
		
		System.out.println(Main.he);
	}
	
	private static void Afficher(Object ch){
		System.out.println(ch);
	}
	
	private static boolean initialisation_Jeu()
	{
		boolean bon = true;
		int saisie  = 1;
		boolean saisie1 = false;
		boolean quitter = false;
		boolean saisie2 = false;
		boolean saisie3 = false;
		
		Main.init_Default();;
		
		Afficher( "*MENU*" );
		do
		{
			Afficher( "1) Jouer" );
			Afficher( "0) Quitter\n" );
			
			saisie = Clavier.lire_Int();
			
			switch(saisie)
			{
				
				case 1 :
				{
					Main.creer_Donjon();
					saisie1 = true;
					Main.creer_Heros();
					saisie2 = true;
					Main.pla = Plateau.Nouveau(Main.lon, Main.lar);
					Orientation ori = new Orientation(0,0);
					bon = false;
				}break;
				
				case 0 : 
				{
					Afficher( "Fin de la partie\n" );
					bon = false;
					quitter = true;
				}break;
				
				default : 
				{
					Afficher( "Vous avez saisi un mauvais chiffre" );
				}break;
			}
			if(! quitter)
			{
				if( (! bon) && ((! saisie1) || (! saisie2) ) && (! saisie3) )
				{
					int dac = 0;
					boolean partir = true;
					do
					{
						Afficher( "Tout n'est pas initialis?" );
						Afficher( "Voici vos valeurs par d?faut : " );
						Afficher( "Nombre de cases : " + (Main.lon * Main.lar) );
						Afficher( "Voulez-vous jouer (avec les valeurs par d?faut) ? \n(1 pour oui, 0 pour non)\n" );
						dac = Clavier.lire_Int();
						switch( dac )
						{
							case 0:
								bon = true;
							break;
						
							case 1:
								Afficher( "Creation du donjon" );
							break;
						
							default:
								Afficher( "Veuillez saisir soit 1, soit 0" );
							break;
						}
						partir = ( (dac == 0) | (dac == 1) );
					}while(! partir);
				}	
			}
		}while(bon);
		
		return (! quitter);
	}
	
	private static void gestion_Piege(Piece pi) throws Mort
	{
		Piege p = new Piege();
		Heros h = Main.he;
		int Vie = 0;

		Vie = h.degatsPieges(p);
		Afficher(p);
		Afficher("Il vous reste "+Vie+" PV.");
		h.setPV(Vie);			
		
	}
	
	private static void gestion_Potion(Piece pi)
	{
		Heros h = Main.he;
		int nb = Main.he.getNBpotion();
		int Vie = 0;
		int saisie = 1;
		boolean bon = false;
		
		
		if( nb>0 )
		{
			do {
				Afficher( "Voulez-vous prendre une potion ? :" );
				Afficher("1 : oui");
				Afficher("0 : non");
				saisie = Clavier.lire_Int();
				
				switch(saisie) {
				
					case 1 :
					{
						Objets Po = new Objets();
						Vie = h.soinPotion(Po);
						Afficher(Po);
						Afficher ("Vous avez "+Vie+" PV.");
						h.setPV(Vie);
						Main.he.suprimePotion();
						bon = true;
					}break;
				
					case 0 :
					{
						bon = true;
					}break;
				
				}		
			}while(!bon || nb==0);
		}
		else
		{
			Afficher( "Vous n'avez rien dans votre sac" );
		}
	}

	private static boolean gestion_Choix(Piece pi)
	{
		boolean bon = false;
		boolean continu = true;
		int val;
		
		do
		{
			do
			{
				Afficher( Main.pla );
				Afficher( "\nQue voulez-vous faire ?\n" );
				Afficher( "1) Prendre une potion" );
				Afficher( "2) Avancer dans le donjon" );
				val = Clavier.lire_Int();
				
				bon = ( (val == 1) || (val == 2) );
				if(! bon)
				{
					Afficher( "Vous avez saisi une mauvaise valeur" );
				}
			}while(! bon);
			
			switch(val)
			{
				case 1:
				{
					Main.gestion_Potion(pi);
				}break;	
				
				case 2:
				{
					Afficher( "Continuons.\n" );
				}break;
			}
			
		}while(val == 0);
		
		return continu; 
	}
	
	private static Piece gestion_Saisie()
	{
		Afficher( Main.pla);
		Piece pi = null;
	
	    boolean Boucle ;
	    do 
	    {
	        Boucle = true;
	        Afficher("Quelle direction voulez-vous prendre ?");
            Afficher("H : haut, B : bas, G : gauche, D : droite ");
            String chSaisie = Clavier.lire_Chaine();
		
            if( chSaisie.equalsIgnoreCase("G") )
            {
                pi = Main.pla.Avance_Gauche();
            }
            else if( chSaisie.equalsIgnoreCase("D") )
            {
                pi = Main.pla.Avance_Droite();
            }
            else if( chSaisie.equalsIgnoreCase("B") )
            {
                pi = Main.pla.Avance_Bas();
            }
            else if( chSaisie.equalsIgnoreCase("H") )
            {
                pi = Main.pla.Avance_Haut();
            }
            else
            {
                Afficher ("Destination non valide !");
                Afficher ("Vous ne pouvez mettre que G, D, H, B !");
                Boucle = false;
            }
	    }while(! Boucle);
	    
		return pi;
	}
	
	private static boolean avancer_DansDonjon(Piece pi)
	{
		boolean envie = true;
		
		try
		{
			if(! pi.est_Vide() )
			{
				if( pi.A_Potions() )
				{
					Main.he.ajoutPotion();
					Afficher("Vous avez trouv? une potion");
					pi.setNbPotions(0);
				}
				
				if( pi.A_Pieges() )
				{
					gestion_Piege(pi);
					pi.setNbPieges(0);
				}
				envie = Main.gestion_Choix(pi);
			}
			else
			{
				if( pi.est_LaPieceSortie() )
				{
					Afficher( "Vous avez trouv? la sortie !\n" );
				}
				else
				{
					Afficher( "Cette pi?ce est vide" );
				Main.gestion_Choix(pi);
				}
			}			
		}
		catch(Exception ex)
		{
			if( ex instanceof Mort )
			{
				envie = false;
				Afficher( "Vous ?tes mort" );
			}
			else
			{
				Afficher( "Erreur inconnue (Mais vous pouvez continuer ?? jouer)\n" );
			}
		}
		
		return envie;
	}
	
	private static boolean veut_Jouer(){
		Piece pi = null;
		boolean enVie = true;
		boolean rejoue = false;
		String saisie;
		
		boolean joue = Main.initialisation_Jeu();
		if( joue )
		{
			boolean sortie = false;
			while( (! sortie) & enVie ) 
			{
				pi = Main.gestion_Saisie();
				if(! pi.est_LaPieceSortie() )
				{
					enVie = Main.avancer_DansDonjon( pi );
				}
				else
				{
					sortie = true;
				}
			}
			if( enVie )
			{
				Afficher( "Bravo!\nVous avez gagn? !" );
			}
		}
		boolean bon = false;
		do{
			Afficher( "Une autre partie? (O : oui, N : non)" );
			saisie = Clavier.lire_Chaine();
		
			bon = ( (saisie.equals("O")) | (saisie.equals("N")) );
			if(! bon)
			{
				Afficher( "Vous avez saisi(e) une mauvaise valeur" );
			}
		}while(! bon);
		rejoue = (saisie.equals("O"));
	
		return rejoue;
	}
	
	
	public static void main(String[] args){
		boolean joue;

		do
		{
			joue = Main.veut_Jouer();
			Plateau.detruire_Plateau();
		}while( joue );		
	}
}

