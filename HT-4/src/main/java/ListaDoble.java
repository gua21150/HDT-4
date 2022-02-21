

/*
 * Universidad del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Diana Díaz 21066
 * @author Mariel Guamuche 21150
 * ListaDoble.java
 */

/**
 * @param <T>
 */
public class ListaDoble<T> extends AbstractList<T>{

    private NodoDoble<T> Cabeza;
    private NodoDoble<T> Cola;
    private int tamaño;
    FactoryNodos _nFactory = new FactoryNodos();

    public ListaDoble ()
    //post: construye una lista vacia
    {
        Cabeza = null;
        Cola = null;
        tamaño = 0;
    }

    @Override
    public int getTamaño()
    //post: regresa un entero con el tamaño de la lista
    {
        return tamaño;
    }

    @Override
    public void AgregarFinal(T valor)
    //pre: el valor es no nulo
    //post: añade un elemento al final de la lista
    {
        BaseNodo _newNodo = _nFactory.getNodo("2", valor,Cola);

        Cola = (NodoDoble<T>) _nFactory.getNodo("2",valor,Cola);
        if (Cabeza != null){

            NodoDoble<T> NodoActual = Cabeza;
            while(NodoActual.getSiguiente()!=null){
                NodoActual = (NodoDoble<T>) NodoActual.getSiguiente();
            }
            NodoActual.setSiguiente((NodoDoble<T>) _newNodo);
        }
        else
            Cabeza = (NodoDoble<T>) _newNodo;

        tamaño++;
    }
    @Override
    public void AgregarPrincipio(T valor)
    //pre: recibe un valor no nulo
    //post: añade un valor al prinicipio de la lista
    {
        Cabeza = new NodoDoble<> (valor, Cabeza, null);
        if (Cola==Cabeza)
            Cola=Cabeza;
        tamaño++;
    }

    @Override
    public T RemoverUltimo()
    //pre: lista no esta vacia
    //post: remueve el ultimo valor de la lista
    {
        NodoDoble<T> NodoActual = Cabeza;
        NodoDoble<T> NodoAnterior = Cola;
        while (NodoActual.getSiguiente()!=null)
        {
            NodoAnterior= NodoActual;
            NodoActual = (NodoDoble<T>) NodoActual.getSiguiente();
        }
        //nodo actual no esta vacio
        if (NodoAnterior == null)
        {
            //tiene un solo elemento
            Cabeza= null;
        }
        else
        {
            NodoAnterior.setSiguiente(null);
        }
        tamaño--;
        return (T) NodoAnterior.getValor();
    }

    @Override
    public T Remover(T valor)
    //pre: valor ingresado no es nulo
    //post: remueve el valor de la lista
    {
        NodoDoble<T> NodoActual = (NodoDoble<T>) Cola;
        NodoDoble<T> NodoAnterior = null;
        while (NodoActual != null&&!NodoActual.getValor().equals(valor)){
            NodoAnterior = NodoActual;
            NodoActual = (NodoDoble<T>) NodoActual.getSiguiente();
        }
        if (NodoActual != null){
            //si se encuentra e valor
            if (NodoAnterior  == null)//es el primero
                Cola = (NodoDoble<T>) NodoActual.getSiguiente();
            else
                NodoAnterior.setSiguiente(NodoActual.getSiguiente());
            tamaño--;
            return (T) NodoActual.getValor();
        }

        return null;
    }

    @Override
    public void Agregar (T valor, int posicion)
    //pre: la posicion esta dentro el rango de la lista creada
    //post: añade valor en la posicion de la lista
    {
        if (!(0<=posicion||posicion>=getTamaño())){
            System.out.println("Out of bounds");
        }

        if (posicion==getTamaño()-1)
            AgregarFinal(valor);
        else if (posicion==0){
            AgregarPrincipio(valor); tamaño++;
        }
        else
        {

            NodoDoble<T> NodoActual = Cabeza;
            //buscar a la posicion
            for (int i = 0;i<posicion-1;i++)
            {
                NodoActual = (NodoDoble<T>) NodoActual.getSiguiente();
            }
            //el nodo actual es el nodo anterior
            NodoActual.setSiguiente(new NodoDoble(valor, (NodoDoble) NodoActual.getSiguiente(),NodoActual.getAnterior()));
            tamaño++;
        }//cierra else

    }

    @Override
    public void set(T valor, int posicion)
    //pre: no esta vacia
    //post: intercambia un valor dentro la lista
    {
        if (!(0<=posicion||posicion>=getTamaño())){
            System.out.println("Out of bounds");
        }//cierra if
        NodoDoble<T> NodoActual = Cabeza;

        for (int i = 0; i<posicion;i++)
        {

            NodoActual = (NodoDoble<T>) NodoActual.getSiguiente();
        }//cierra for
        NodoActual.setValor(valor);
    }

    @Override
    public T get(int pos)
    //pre: recibe entero con la posicion del valor
    //post: regresa el valor en la posicion ingresada
    {
        if (pos<0||pos>=getTamaño()){
            System.out.println("position out of bounds");
            System.out.println(pos);

        }

        NodoDoble<T> NodoActual = Cabeza;
        for (int i = 0; i<pos;i++)
        {

            NodoActual = (NodoDoble<T>) NodoActual.getSiguiente();
        }//cierra for
        return (T) NodoActual.getValor();
    }

    @Override
    public Comparable[] toArray()
    //post: regresa un arreglo con el valor de los nodos
    {
        NodoDoble<T> NodoActual = Cabeza;
        Comparable[] arreglo = new Comparable[getTamaño()];
        int i=0;
        while (NodoActual.getSiguiente()!=null)
        {
            arreglo[i]=(Comparable) NodoActual.getValor();
            NodoActual = (NodoDoble<T>) NodoActual.getSiguiente();
            i++;
        }
        arreglo[i]=(Comparable) NodoActual.getValor();
        return arreglo;
    }

    @Override
    public String toString(){
        System.out.println("Lista Doble");
        NodoDoble<T> Inicio = Cabeza;
        String strLista = "";
        StringBuilder _sb = new    StringBuilder();
        _sb.append("[");
        if (Inicio != null){
            while (true)
            {
                _sb.append(Inicio.getValor());
                _sb.append("  -> ");

                if (Inicio.getSiguiente()==null)
                    break;
                Inicio = (NodoDoble<T>) Inicio.getSiguiente();
            }
        }

        _sb.append(" null");
        _sb.append("]");
        return _sb.toString();
    }
}