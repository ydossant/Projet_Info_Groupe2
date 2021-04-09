package Plateau;

public class Test {
	public static void main(String args[]) {
		Plateau plateau = new Plateau(4,5);
		plateau.coordHeros= new Orientation (0,2);
		Piece pi = new Piece(plateau.coordHeros);
		Orientation ori= new Orientation (1,2);
		Piece arrive = new Piece(ori);
		plateau.setArrive(arrive);
		System.out.println(plateau);
		/*Orientation or = new Orientation(3,4);
		System.out.println(or);
		Piece pi = new Piece(or,1,0,0);
		System.out.println(pi);
		*/
	}

}