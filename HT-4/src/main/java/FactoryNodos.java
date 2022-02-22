package main.java;
/**
* Universidad Del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Diana Díaz 21066
 * @author Mariel Guamuche 21150
*/

/**
 *
 */
public class FactoryNodos<T> {

    public BaseNodo<T> getNodo(String entry, T valor, NodoDoble<T> Cola){
        switch (entry) {
            case "1":
                return new Nodo<>(valor);//post: regresa un nodo simple
            default:
                return new NodoDoble<>(valor, null, Cola);//post: regresa un nodo doble

        }
    }
}
