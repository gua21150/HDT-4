//package main.java;
 /**
* Universidad Del Valle de Gautemala
* @author Aaron Beltrán 21092
 *  @author Diana Díaz 21066
 * @author Mariel Guamuche 21150
*/


/**
 *
 */
public class FactoryStack<T> {
    
    //such that only one instance can ever exist
    static boolean instance_flag=false; //true if 1 instance
    
    public FactoryStack() throws SingletonException
    {
        if (instance_flag)
            throw new SingletonException("Solo se acepta un Stack");
        else
            instance_flag = true; //set flag for 1 instance
        
        System.out.println("Stack creado");
    }
    
    public void finalize()
    {
        instance_flag = false; //clear if destroyed
    }
    
    public AbstractStack<T> getStack(int entry, int tipoLista)
    {
        switch (entry)
        {
            case 1:
                return new StackArrayList<>(1);                                            
            case 2:
                return new StackVector<>();                    
            case 3:
                return new StackLista(tipoLista,0);
                         
            default:
                System.out.println("Ha escogido una opción incorrecta");
                return null;
        }
    }
}
