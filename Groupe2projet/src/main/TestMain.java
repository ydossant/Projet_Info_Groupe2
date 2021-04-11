package main;

import Heros.*;
import Objets.*;
import Outils.*;
import Plateau.*;

public class TestMain {
	public static void main(String[]args) {
		Heros he = new Heros();
		System.out.println(he); 
		Plateau pla = new Plateau(9,9);
		System.out.println(pla);
		Objets po = new Objets();
		System.out.println(po);
		pla.Avance_Bas();
		System.out.println(pla);
		pla.Avance_Droite();
		System.out.println(pla);
		Piege P = new Piege();
		System.out.println(he.degatsPieges(P));
	}
	
}
