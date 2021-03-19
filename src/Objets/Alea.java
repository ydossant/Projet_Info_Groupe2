package Objets;

import java.util.*;

public class Alea 
{

	static private Random R = new Random();
	

	static public int EntierEntre( int min, int max )
	{
		int val = R.nextInt(max-min+1) + min;
		
		return val;
	}
}