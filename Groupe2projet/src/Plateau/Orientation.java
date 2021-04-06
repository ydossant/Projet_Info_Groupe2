package Plateau;

import Outils.HorsPlateau;
import Plateau.Orientation;

public class Orientation{
	private int i, j;

	private static int MAX_I = -1;
	private static int MAX_J = -1;

	public final static int MIN_ORD = 0;

	public final static int MIN_ABS = 0;
	
	
	public Orientation(int i, int j)
	{
		this.i = i;
		this.j = j;
	}
	
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
	
	public void a_Gauche() throws HorsPlateau
	{
		int j = this.get_coordJ() - 1;
		this.set_J(j);
	}

	public void a_Droite() throws HorsPlateau
	{
		int j = this.get_coordJ() + 1;
		this.set_J(j);
	}

	public void en_Bas() throws HorsPlateau
	{
		int i = this.get_coordI() + 1;
		this.set_I(i);
	}

	public void en_Haut() throws HorsPlateau
	{
		int i = this.get_coordI() - 1;
		this.set_I(i);
	}

	public int get_coordI()
	{
		return this.i;
	}

	public int get_coordJ()
	{
		return this.j;
	}

	public static int MAX_ORD()
	{
		return (int)Orientation.MAX_I;
	}

	public static int MAX_ABS()
	{
		return (int)Orientation.MAX_J;
	}

	public void set_I(int i) throws HorsPlateau
	{
		if( (i >= Orientation.MIN_ORD) && (i <= Orientation.MAX_ORD()) )
		{
			this.i = i;
		}
		else if( i < Orientation.MIN_ORD)
		{
			throw new HorsPlateau("En dehors de la zone (trop en haut)");
		}
		else
		{
			throw new HorsPlateau("En dehors de la zone (trop en bas)");
		}
	}

	public void set_J(int j) throws HorsPlateau
	{
		if( (j >= Orientation.MIN_ABS) && (j <= Orientation.MAX_ABS()) )
		{
			this.j = j;
		}
		else if( j < Orientation.MIN_ABS)
		{
			throw new HorsPlateau("En dehors de la zone (trop à gauche)");
		}
		else
		{
			throw new HorsPlateau("En dehors de la zone (trop à droite)");
		}
	}

	public final static void set_MAX_ORD(int maxI)
	{
		if( Orientation.MAX_I == -1 )
		{
			Orientation.MAX_I = maxI;
		}
	}

	public final static void set_MAX_ABS(int maxJ)
	{
		if( Orientation.MAX_J == -1 )
		{
			Orientation.MAX_J = maxJ;
		}
	}

	public static void raz_ValsMaxs()
	{
		Orientation.MAX_I = -1;
		Orientation.MAX_J = -1;
	}

	public String toString()
	{
		StringBuffer buf = new StringBuffer("\nPosition : ").append("\nAbscisse : ")
														 .append(this.get_coordJ())
															 .append("\nOrdonn�e : ")
															 .append(this.get_coordI() );
		return buf.toString();
	}
    
}

