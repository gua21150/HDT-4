//package main.java;

/***
* Universidad del Valle de Guatemala
* @author Aaron Beltrán 21092
* @author Diana Díaz 21066
* @author Mariel Guamuche 21150
*/

public class Lista<T> extends AbstractList<T>{

    private Nodo<T> Cabeza;
    private int tamanio;
    FactoryNodos _nFactory = new FactoryNodos();

    public Lista(){
        //constructor pone la lista vacía
        Cabeza = null;
        tamanio = 0;
    }

    @Override
    public void AgregarFinal(T valor){
        //post: agrega un nodo al final de la lista

        BaseNodo _newNodo = _nFactory.getNodo("1", valor,null);

        if (Cabeza != null){

            Nodo<T> NodoActual = Cabeza;
            while(NodoActual.getSiguiente()!=null){
                NodoActual = (Nodo<T>) NodoActual.getSiguiente();
            }
            NodoActual.setSiguiente((Nodo<T>) _newNodo);
        }
        else
            Cabeza = (Nodo<T>) _newNodo;

        tamanio++;
    }

    @Override
    public int getTamanio()
    //post: regresa el tamanio de la lista
    {
        int elemento=0;
        Nodo<T> NodoActual = Cabeza;
        while (NodoActual!=null)
        {
            elemento++;
            NodoActual=(Nodo<T>) NodoActual.getSiguiente();
        }
        return elemento;
    }

    public boolean contieneValor(T valor){
        //pre: valor no es nulo
        //post: regrsa true si el valor es encontrado en la lista
        Nodo<T> NodoActual=Cabeza;
        while(NodoActual!=null&&!NodoActual.getValor().equals(valor))
        {
            NodoActual= (Nodo<T>) NodoActual.getSiguiente();
        }
        return NodoActual!=null;
    }

    public T Cabeza()
    //pre: lista no esta vacía
    //post: regresa el primer valor de la lista
    {
        return (T) Cabeza.getValor();
    }

    @Override
    public void AgregarPrincipio(T valor)
    //post: valor es agregado la principio de la lista
    {
        //primero Cabeza es asignado y despues es instanciado
        Cabeza = new Nodo(valor, Cabeza);
        tamanio++;
    }
    @Override
    public void Agregar (T valor, int posicion)
    //pre: la posicion esta dentro el rango de la lista creada
    //post: añade valor en la posicion de la lista
    {
        if (!(0<=posicion||posicion>= getTamanio())){
            System.out.println("Out of bounds");
        }

        if (posicion== getTamanio()-1)
            AgregarFinal(valor);
        else if (posicion==0){
            AgregarPrincipio(valor); tamanio++;
        }
        else
        {

            Nodo<T> NodoActual = Cabeza;
            //buscar a la posicion
            for (int i = 0;i<posicion-1;i++)
            {
                NodoActual = (Nodo<T>) NodoActual.getSiguiente();
            }//cierra for
            //el nodo actual es el nodo anterior
            NodoActual.setSiguiente(new Nodo(valor, (Nodo) NodoActual.getSiguiente()));
            tamanio++;
        }//cierra else

    }

    @Override
    public void set(T valor, int posicion)
    //pre: no esta vacia
    //post: intercambia un valor dentro la lista
    {
        if (!(0<=posicion||posicion>= getTamanio())){
            System.out.println("Out of bounds");
        }
        Nodo<T> NodoActual = Cabeza;

        for (int i = 0; i<posicion;i++)
        {

            NodoActual = (Nodo<T>) NodoActual.getSiguiente();
        }
        NodoActual.setValor(valor);
    }

    public T RemoverPrimero()
    //pre: lista no esta vacia
    //post: remueve y regresa el valor del principio de la lista
    {
        Nodo<T> temp = Cabeza;
        Cabeza = (Nodo<T>) Cabeza.getSiguiente();
        tamanio--;
        return (T) temp.getValor();
    }


    @Override
    public T RemoverUltimo()
    //pre: lista no esta vacia
    //post: remueve el ultimo valor de la lista
    {
        Nodo<T> NodoActual = Cabeza;
        Nodo<T> NodoAnterior = null;
        while (NodoActual.getSiguiente()!=null)
        {
            NodoAnterior= NodoActual;
            NodoActual = (Nodo<T>) NodoActual.getSiguiente();
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
        tamanio--;
        return (T) NodoActual.getValor();

    }

    public T Remover (T valor)
    //pre: valor es no nulo
    //post: remueve valor elegido
    {
        Nodo<T> NodoActual = Cabeza;
        Nodo<T> NodoAnterior = null;
        while (NodoActual != null&&!NodoActual.getValor().equals(valor)){
            NodoAnterior = NodoActual;
            NodoActual = (Nodo<T>) NodoActual.getSiguiente();
        }
        if (NodoActual != null){
            //si se encuentra e valor
            if (NodoAnterior  == null)//es el primero
                Cabeza = (Nodo<T>) NodoActual.getSiguiente();
            else
                NodoAnterior.setSiguiente(NodoActual.getSiguiente());
            tamanio--;
            return (T) NodoActual.getValor();
        }

        return null;
    }





    @Override
    public T get(int pos)
    {
        if (pos<0||pos>= getTamanio()){
            System.out.println("position out of bounds");
            System.out.println(pos);

        }

        Nodo<T> NodoActual = Cabeza;
        for (int i = 0; i<pos;i++)
        {

            NodoActual = (Nodo<T>) NodoActual.getSiguiente();
        }
        return (T) NodoActual.getValor();


    }

    public int indexOf(Object inputData) {
        Nodo<T> currentNode = this.Cabeza;
        int position = 0;
        boolean found = false;

        for (; ; position++) {
            if (currentNode == null) {
                break;
            }

            if (inputData.equals(currentNode.getValor())) {
                found = true;
                break;
            }

            currentNode = (Nodo<T>) currentNode.getSiguiente();
        }

        if (!found) {
            position = -1;
        }

        return position;
    }
    @Override
    public Comparable[] toArray()
    //post: regresa un arreglo con el valor de los nodos
    {
        Nodo<T> NodoActual = Cabeza;
        Comparable[] arreglo = new Comparable[getTamanio()];
        int i=0;
        while (NodoActual.getSiguiente()!=null)
        {
            arreglo[i]=(Comparable) NodoActual.getValor();
            NodoActual = (Nodo<T>) NodoActual.getSiguiente();
            i++;
        }
        arreglo[i]=(Comparable) NodoActual.getValor();
        return arreglo;
    }


    @Override
    public String toString(){
        Nodo Inicio = Cabeza;
        String strLista = "";
        System.out.println("Lista simple:");
        StringBuilder _sb = new    StringBuilder();
        _sb.append("[");
        if (Inicio != null){
            while (true)
            {
                _sb.append(Inicio.getValor());
                _sb.append("  -> ");

                if (Inicio.getSiguiente()==null)
                    break;
                Inicio = (Nodo) Inicio.getSiguiente();
            }
        }


        _sb.append(" null");
        _sb.append("]");
        return _sb.toString();
    }
}