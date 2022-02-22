package main.java;

/*
 * Universidad del Valle de Guatemala
 * Aaron Beltrán 21092
 * Diana Díaz 21066
 * Mariel Guamuche 21150
 * Nodo.java
 */

public class Nodo<T> extends BaseNodo {
   
    
    public Nodo()
    //post: nodo vacío
    {
        _valor = null;
        _siguiente = null;
    }
    
    public Nodo(T valor, Nodo<T> siguiente)
    {
    //pre: se recibe un valor generico y el siguiente nodo a referenciar
    //post: un nuevo elemento es contruido como la cabeza de la lista
        _valor = valor;
        _siguiente = siguiente;
    }
    
    
    public Nodo(T valor){
        _valor = valor;
        _siguiente = null;
//        
    }
   
    public void setSiguiente(Nodo<T> _siguiente) {
        this._siguiente = _siguiente;
    }
    
    
}