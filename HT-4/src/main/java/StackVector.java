/**
* Universidad Del Valle de Guatemala
* @author Aaron Beltrán 21092
 * @author Diana Díaz 21066
 * @author Mariel Guamuche 21150
*/



import java.util.Vector;


public class StackVector<T> extends AbstractStack<T> {
    
    private int sp;
    private Vector pila;
    
    public StackVector()
    {
        pila = new Vector();
        pila.setSize(10);
        sp = pila.size()-1;
    }

    public StackVector(int tamaño)
    {
        pila = new Vector(tamaño);               
        sp =  pila .size()-1;
    }
    @Override
    public T pop() 
   /**
    * post: regresa como entero el valor el valor que esta apuntando el puntero
    */
    {
        T dato = null;
        if ((this.sp <  pila .size()) && (this.sp > 0))
        {            
            sp++;
            dato = (T)  pila .get(sp);
        }
        else
        {
            System.out.println("Stack out of bounds");
            dato = null;
        }
        return dato;
    }

    @Override
    public void push(T dato) 
    //pre: el parametro dato no es nulo
    //post: mete valor generico a la pila
    {
        
         if ((this.sp <  pila.size() ) && (this.sp >0))
        {           
            pila .set(sp, dato);           
            sp--;
        }
        else
            System.out.println("Stack out of bounds");
    
    }

    @Override
    public boolean isEmpty() 
    //post: devuelve true si la lista esta vacia
    {
        return  pila.isEmpty();
    }

}
