package main;

import Heros.*;
import Objets.*;
import Outils.*;
import Plateau.*;

public class TestMain {
	public static void main(String[]args) {
		Heros he = new Heros();
		System.out.println(he); 
		Plateau pla = new Plateau(4,5);
		System.out.println(pla);
	}
	
}
