package main.java;/*
 * Universidad del Valle de Guatemala.
 * Aaron Beltrán 21092
 * Diana Díaz 21066
 * Mariel Guamuche 21150

*/



public class SingletonException extends RuntimeException {
    
    //new exception type for singleton classes
    public SingletonException()
    {
        super();
    }
    //-----------------------------------------------
    public SingletonException(String s)
    {
        super(s);
    }    
}
