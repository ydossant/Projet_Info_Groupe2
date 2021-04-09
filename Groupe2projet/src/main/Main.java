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
	private static double vide = 1/2;
	private static double pot = 1/4;
	private static double pge = pot;
	
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
	
	private static boolean initialisation_Jeu()
	{
		boolean bon = true;
		int saisie  = 1;
		boolean saisie1 = false;
		boolean quitter = false;
		boolean saisie2 = false;
		boolean saisie3 = false;
		
		/** On initialise tout par défaut */
		Main.init_Default();;
		
		Afficher( "****************MENU**********************" );
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
					//Donjon.detruire_Donjon();
					Main.pla = Plateau.Nouveau(Main.lon, Main.lar);
					Orientation ori = new Orientation(0,0);
					
					Afficher( "Prêt(e) pour jouer ?\nC'est parti !!\nVous êtes envoyé(e) en direct dans le donjon !!\n" );
					Afficher(he);
					bon = false;
				}break;
				
				case 0 : 
				{
					Afficher( "Au revoir !!\nA bientôt!!\n" );
					bon = false;
					quitter = true;
				}break;
				
				default : 
				{
					Afficher( "Aïe !! Vous avez saisi(e) un mauvais chiffre !!" );
				}break;
			}
			if(! quitter)
			{
				/* La personne a appuyÃ© sur la touche 3 et n'est passÃ©e par le 1 et/ou le 2 */
				if( (! bon) && ((! saisie1) || (! saisie2) ) && (! saisie3) )
				{
					int dac = 0;
					boolean partir = true;
					do
					{
						Afficher( "Attention, vous n'avez pas tout initialisé !!" );
						Afficher( "Voici vos valeurs par défaut : " );
						Afficher( "Nombre de cases : " + (Main.lon * Main.lar) );
						Afficher( "Voulez-vous vraiment partir jouer (avec les valeurs par dÃ©faut) ? \n(1 pour oui, 0 pour non)\n" );
						dac = Clavier.lire_Int();
						switch( dac )
						{
							case 0:
								bon = true;
							break;
						
							case 1:
								Afficher( "Tant pis pour vous => C'est parti !!!" );
							break;
						
							default:
								Afficher( "Veuillez saisir soit 1, soit 0 :o@!! " );
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

		if( p.get_Actif() )
		{
			Main.he.degatsPieges(p);
		}
		else
		{
			Afficher( "Vous voyez un piège ...\n" );
			Afficher( "Mais il est désactivé ... Heureusement !! )" );
		}
	}
	
	private static void gestion_Potion(Piece pi)
	{
		boolean tress = he.getObjets();
		
		if( tress==true )
		{			
			Afficher( "Voulez-vous prendre une potion ? :" );
			for(int i = 0; i < nb; i ++)
			{
				Potion t = new Potion();
				String potion = t.toString();
			}
			Afficher( "N°" + nb + " : " + "Quitter ce menu" );
			
		}
		else
		{
			Afficher( "Vous n'avez plus rien dans votre sac à  dos (retour au jeu) !" );
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
				Afficher( "1) Voir la carte magique" );
				Afficher( "2) Prendre une potion" );
				Afficher( "4) Retour au jeu" );
				Afficher( "0) Quitter le jeu" );
				val = Clavier.lire_Int();
				
				bon = ( (val == 1) || (val == 2) || (val == 0) || (val == 3) || (val == 4) );
				if(! bon)
				{
					Afficher( "Attention, vous avez saisi une mauvaise valeur" );
				}
			}while(! bon);
			
			switch(val)
			{
				case 1: 
				{
					Afficher( Main.pla );
				}break;
				
				case 2:
				{
					Main.gestion_Potion(pi);
				}break;	
				
				case 4:
				{
					Afficher( "Et c'est reparti !!\n" );
				}break;
				
				case 0:
				{
					boolean bienS = false;
					String saisie = null;
					do
					{
						Afficher( "Etes-vous sûr de vouloir quitter le jeu en cours ?" );
						Afficher( "O : Oui, N : Non" );
						saisie = Clavier.lire_Chaine();
						
						bienS = ( saisie.equals("O") || saisie.equals("N") );
					}while(! bienS );
					if( saisie.equals("O") )
					{
						Afficher( "Tant pis pour vous !" );
						continu = false;
					}
				}break;
			}
			
		}while(val != 0);
		
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
	        try
	        {
	            Afficher("Quelle direction voulez-vous prendre ?");
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
	                Afficher ("Destination non comprise !");
	                Afficher ("Vous ne pouvez mettre que G, D, H, B !");
	                Boucle = false;
	            }
	        }
	        catch(HorsPlateau ex)
	        {
	            Afficher( "C'est impossible !\nVous vous cognez à  un mur!" );
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
					gestionPotion(pi);
				}
				
				if( pi.A_Pieges() )
				{
					gestion_Piege(pi);
				}
				envie = Main.gestion_Choix(pi);
			}
			else
			{
				if( pi.est_LaPieceSortie() )
				{
					Afficher( "Vous avez trouvé la sortie !!!\n" );
				}
				else
				{
					Afficher( "Cette pièce est vide !! Vous vous reposer !!" );
				Main.gestion_Choix(pi);
				}
			}			
		}
		catch(Exception ex)
		{
			if( ex instanceof Mort )
			{
				envie = false;
				Afficher( "Vous êtes mort !!" );
			}
			else
			{
				Afficher( "Erreur inconnue (Mais vous pouvez continuer à  jouer) !!\n" );
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
				Afficher( "Bravo!!\nVous avez gagné !!" );
			}
		}
		boolean bon = false;
		do{
			Afficher( "Une autre partie? (O : oui, N : non)" );
			saisie = Clavier.lire_Chaine();
		
			bon = ( (saisie.equals("O")) | (saisie.equals("N")) );
			if(! bon)
			{
				Afficher( "Attention !! Vous avez saisi(e) une mauvaise valeur !" );
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

