package Plateau;

import java.util.LinkedList;
import java.util.ListIterator;

import plateau.Donjon;
import utilitaires.InvalidCoordException;
import utilitaires.Orientation;

public class Orientation implements Cloneable, java.io.Serializable
{
	private int i, j;

	private static int MAX_I = -1;
	private static int MAX_J = -1;
	
	/**
	 * Valeur minimale de l'ordonnée
	 */
	public final static int MIN_ORD = 0;
	/**
	 * Valeur minimale de l'abscisse
	 */
	public final static int MIN_ABS = 0;
	
	
	/**
	 * Constructeur par défaut de la classe
	 * @param i Coordonnée initiale ordonnée 
	 * @param j Coordonnée intiale abscisse
	 */
	public Orientation(int i, int j)
	{
		this.i = i;
		this.j = j;
	}
	
	/**
	 * Redéfinition de la classe clone
	 * @return Renvoie un object à caster en Tresor
	 * @see Object
	 */
	public Object clone()
	{
		Orientation or = null;
		
		try
		{
			or = (Orientation)super.clone();
		}
		catch(Exception ex)
		{/**/}
		
		return or;
	}
	
	/**
	 * Permet de tester l'égalité entre les 2 instances
	 * @param o Objet à comparer avec l'intance en cours
	 * @return Booléen indiquant si les deux instances sont égales
	 */
	public boolean equals(Object o)
	{
		boolean bon = false;
		
		if( o instanceof Orientation)
		{
			Orientation or = (Orientation)o;
			bon = ( (or.i == this.i) && (or.j == this.j) );
		}
		
		return bon;
	}
	
	/**
	 * Permet de déplacer les coordonnées vers la gauche (abscisse - 1)
	 * @throws InvalidCoordException une exception indiquant qu'on est au-dehors des valeurs limites.
	 * @see InvalidCoordException
	 */
	public void a_Gauche() throws InvalidCoordException
	{
		/* On enlève 1 à l'abscisse */
		int j = this.get_coordJ() - 1;
		this.set_J(j);
	}
	
	/**
	 * Permet de déplacer les coordonnées vers la droite (abscisse + 1)
	 * @throws InvalidCoordException une exception indiquant qu'on est au-dehors des valeurs limites.
	 * @see InvalidCoordException
	 */
	public void a_Droite() throws InvalidCoordException
	{
		/* On ajoute 1 à l'abscisse */
		int j = this.get_coordJ() + 1;
		this.set_J(j);
	}
	
	/**
	 * Permet de déplacer les coordonnées vers le bas (ordonnée + 1)
	 * @throws InvalidCoordException une exception indiquant qu'on est au-dehors des valeurs limites.
	 * @see InvalidCoordException
	 */
	public void en_Bas() throws InvalidCoordException
	{
		/* On ajoute 1 à l'ordonnée */
		int i = this.get_coordI() + 1;
		this.set_I(i);
	}
	
	/**
	 * Permet de déplacer les coorodnnées vers le haut (ordonnée - 1)
	 * @throws InvalidCoordException une exception indiquant qu'on est au-dehors des valeurs limites.
	 * @see InvalidCoordException
	 */
	public void en_Haut() throws InvalidCoordException
	{
		/* On enlève 1 à l'ordonnée */
		int i = this.get_coordI() - 1;
		this.set_I(i);
	}
	
	
	/*----------------------------------------------------------*/
	/*----------------  ACCESSEURS & MUTATEURS -----------------*/
	/*----------------------------------------------------------*/
		
	/**
	 * Accesseur de l'ordonnée
	 * @return Valeur (entière) de l'ordonnée
	 */
	public int get_coordI()
	{
		return this.i;
	}
	
	/**
	 * Accesseur de l'abscisse
	 * @return Valeur (entière) de l'abscisse
	 */
	public int get_coordJ()
	{
		return this.j;
	}
	
	/**
	 * Accesseur statique de la borne maximale de l'ordonnée
	 * @return Renvoie un entier représentant la valuer maximale des ordonnées
	 */
	public static int MAX_ORD()
	{
		return (int)Orientation.MAX_I;
	}
	
	/**
	 * Accesseur statique de la borne maximale de l'abscisse
	 * @return Renvoie un entier représentant la valuer maximale des abscisses
	 */
	public static int MAX_ABS()
	{
		return (int)Orientation.MAX_J;
	}
	
	/**
	 * Mutateur de l'ordonnée
	 * @param i Nouvelle valeur de l'ordonnée
	 * @throws InvalidCoordException Exception représentant une coordonnée au-dehors des bornes
	 */
	public void set_I(int i) throws InvalidCoordException
	{
		if( (i >= Orientation.MIN_ORD) && (i <= Orientation.MAX_ORD()) )
		{
			this.i = i;
		}
		else if( i < Orientation.MIN_ORD)
		{
			throw new InvalidCoordException("En dehors de la zone (trop en haut)");
		}
		else
		{
			throw new InvalidCoordException("En dehors de la zone (trop en bas)");
		}
	}
	
	/**
	 * Mutateur de l'abscisse
	 * @param j Nouvelle valeur de l'abscisse
	 * @throws InvalidCoordException Exception représentant une coordonnée au-dehors des bornes
	 */
	public void set_J(int j) throws InvalidCoordException
	{
		if( (j >= Orientation.MIN_ABS) && (j <= Orientation.MAX_ABS()) )
		{
			this.j = j;
		}
		else if( j < Orientation.MIN_ABS)
		{
			throw new InvalidCoordException("En dehors de la zone (trop à gauche)");
		}
		else
		{
			throw new InvalidCoordException("En dehors de la zone (trop à droite)");
		}
	}
	
	/**
	 * <h4>Première étape à effectuer pour definir les bornes à ne pas dépasser</h4>
	 * <h5>Si ce n'est pas défini, les bornes sont à -1</h5>
	 * @param maxI Ordonnée maximale qu'on peut atteindre 
	 * @serialField public final static void set_MAX_ABS(int maxJ)
	 */
	public final static void set_MAX_ORD(int maxI)
	{
		if( Orientation.MAX_I == -1 )
		{
			Orientation.MAX_I = maxI;
		}
	}
	
	/**
	 * <h4>Première étape à effectuer pour definir les bornes à ne pas dépasser</h4>
	 * <h5>Si ce n'est pas défini, les bornes sont à -1</h5>
	 * @param maxJ Abscisse maximale qu'on peut atteindre 
	 * @serialField public final static void set_MAX_ABS(int maxJ)
	 */
	public final static void set_MAX_ABS(int maxJ)
	{
		if( Orientation.MAX_J == -1 )
		{
			Orientation.MAX_J = maxJ;
		}
	}
	
	/**
	 * <li>Cette méthode est utilisée pour remettre à zéro</li>
	 * <li>Des valeurs maximales des Orientations</li>
	 * <li>Doit être utilisée lors de la destruction du donjon</li>
	 * @see Donjon
	 * @see plateau.DonjonAmeliore
	 */
	public static void raz_ValsMaxs()
	{
		Orientation.MAX_I = -1;
		Orientation.MAX_J = -1;
	}
	
	/**
	 * Re-définition de la méthode toString
	 * @return Retourne une chaîne représentant les coordonnées abscisse et ordonnée
	 */
	public String toString()
	{
		StringBuffer buf = new StringBuffer("\nPosition : ").append("\nAbscisse : ")
														 .append(this.get_coordJ())
															 .append("\nOrdonnée : ")
															 .append(this.get_coordI() );
		return buf.toString();
	}
    
}

