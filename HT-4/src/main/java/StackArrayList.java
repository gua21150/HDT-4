//package main.java; 
/**
* Universidad Del Valle 
 * @author Aaron Beltrán 21092
 * @author Diana Díaz 21066
 * @author Mariel Guamuche 21150
*/



import java.util.ArrayList;


public class StackArrayList<T> extends AbstractStack<T> {

    private int sp;
    private ArrayList<T> pila;
    
    public StackArrayList(T valor)
    {           
        pila = new ArrayList(100);
        for (int i = 0; i < 100; i++)
            pila.add(valor);        
        sp = pila.size() - 1;
    }
    
    /**
     *
     * @param t
     */
    public StackArrayList(int t)
    {
        // inica el ArrayList con un tamaño t de parámetro
        T valorT = null;
        pila = new ArrayList(t);
        for (int i = 0; i < t; i++)
            pila.add(valorT);        
        sp = 1;
    }
    
    @Override
    public T pop() 
    {
        T dato = null;
        if ((this.sp <= pila.size()) && (this.sp > 0))
        {           
            sp--;            
            dato = pila.remove(sp);            
        }
        else
        {
            System.out.println("Stack out of bounds");
            dato = null;
        }
        return dato;
    }

    @Override
    public void push(T t) {
        if ((this.sp <= pila.size()) && (this.sp > 0))
        {              
            pila.add(t);
            sp++;
        }
        else
            System.out.println("Stack out of bounds");
    }

    @Override
    public boolean isEmpty() {
        return pila.isEmpty();
    }
    
}
