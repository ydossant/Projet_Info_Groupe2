package Outils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clavier{

	public static String lire_Chaine()
	{
		String ch = null;
		
		try
		{
			InputStreamReader sp = new InputStreamReader( System.in );
			BufferedReader br    = new BufferedReader( sp );
			ch = br.readLine();
		}
		catch(Exception e)
		{ 
			ch = new String("");
		}
		
		return ch;
	}

	public static int lire_Int()
	{
		int val = 0;
		
		try
		{
			val = Integer.parseInt( Clavier.lire_Chaine() );
		}
		catch(Exception e)
		{/**/}
		
		return val;
	}
	
	public static float lire_Reel()
	{
		float val = 0;
		
		try
		{
			val = Float.parseFloat( Clavier.lire_Chaine() );
		}
		catch(Exception e)
		{/**/}
		
		return val;
	}
}