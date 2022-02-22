package main.java;

/*
 * Universidad del Valle de Guatemala.
 * Aaron Beltrán 21092
 * Diana Díaz 21066
 * Mariel Guamuche 21150
 * NodoDoble.java
 * Clase que representa un Nodo Doble
 * NodoDoble.java
*/


public class NodoDoble<T> extends BaseNodo{

    //los demás métodos y atributos están en la clase BaseNodo
    private NodoDoble<T> _anterior;
    
    public NodoDoble()
    //post: crea un nodo vacío
    {
        _valor=null;
        _siguiente=null;
        _anterior=null;
    }
    
    public NodoDoble(T valor)
    //post: construye un nodo solo con un valor
    {
        _valor=valor;
        _siguiente = null;
        _anterior = null;
    }
    public NodoDoble (T valor, NodoDoble<T> siguiente, NodoDoble<T> anterior)
    //post: construye un nodo con su cabeza y cola
    {
      _valor = valor;
      _siguiente = siguiente;
      _anterior=anterior;
     
    }
    
    @Override
    public int compareTo(Object other) {
        return (((Comparable)this._valor)).compareTo(other);
        
    }

    
    public NodoDoble<T> getAnterior() {
        return _anterior;
    }

    public void setAnterior(NodoDoble<T> _anterior) {
        this._anterior = _anterior;
    }
    
    public void setSiguiente(NodoDoble<T> _siguiente) {
        this._siguiente = _siguiente;
    }
    
}
