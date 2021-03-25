package Outils;

public class Mort extends Exception{

    /**
     * C'est l'exception par défaut qui n'envoie pas de message
     * @see vivants.Heros
     */
    public Mort ()
    {
        super();
    }
    
    /**
     * C'est l'exception qui envoie un message pour la mort du héros
     * @param Message Le message envoie pour la mort du héros
     */
    public Mort ( String Message )
    {
        super(Message);
    }
}
