
/**
* Universidad Del Valle de Gautemala
* @author Aaron Beltrán 21092
 * @author Diana Díaz 21066
 * @author Mariel Guamuche 21150
* 
*/

/**
 *
 */
public class FactoryListas<T> {

    public AbstractList<T> getLista(int  entry,int entry2){
        switch (entry2) {
            case 1:
                if (entry == 1)
                    return (AbstractList<T>) new Lista<Integer>();//post: regresa una lista enlazada
                 if (entry==2)
                    return (AbstractList<T>) new ListaDoble<Integer>();//post: regresa una lista doblemente

            case 2:
                if (entry==1)
                    return (AbstractList<T>) new Lista<String>();//post: regresa una lista enlazada
                if (entry==2)
                    return (AbstractList<T>) new ListaDoble<String>();//post: regresa una lista doblemente

            case 3:
                if (entry==1)
                    return (AbstractList<T>) new Lista<Double>();//post: regresa una lista enlazada
                else
                    return (AbstractList<T>) new ListaDoble<Double>();//post: regresa una lista doblemente

            default: 
                System.out.println("Ha escogido una opción incorrecta");
                return null;
                    }
    }
}
