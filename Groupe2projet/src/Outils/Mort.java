package Outils;

public class Mort extends Exception{

    public Mort ()
    {
        super();
    }
    
    public Mort ( String Message )
    {
        super(Message);
    }
}
