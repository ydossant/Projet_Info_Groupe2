package Outils;

import Plateau.Plateau;


public class InvalidCoordException extends Exception{
	
	public InvalidCoordException()
	{
		super();
	}
	
	public InvalidCoordException(String message)
	{
		super(message);
	}
}