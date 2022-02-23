//package main.java;

/*
 * Universidad del Valle de Guatemala
 * Aaron Beltrán 21092
 * Diana Díaz 21066
 * Mariel Guamuche 21150
 * Clase que tiene los diferentes algoritmos de ordenamiento
 * Todos utilizan una lista de tipo Comparable para ordenar objetos
 */



public class Sorting<T> {
    /**
     * @param list
     * Algoritmo selection sort:
     * Se busca el index del valor más grande
     * Se coloca el valor del index hasta el final del arreglo
     * Se actualiza el index si se encuentra un valor más grande en el arreglo
     * 
     */
   public static void selectionSort (Comparable[] list)
   //pre: recibe una lista de tipo comparabale desordenada
   //post: ordena la lista enviada como parametro con el algoritmo de 
   //selection sort de forma descendente
   {
      int min;
      Comparable temp;

      for (int index = 0; index < list.length-1; index++)
      {
         min = index;
         for (int scan = index+1; scan < list.length; scan++)
            if (list[scan].compareTo(list[min]) < 0)
               min = scan;

         // intercambio de valores
         temp = list[min];
         list[min] = list[index];
         list[index] = temp;
      }
   }//termina selection sort
        /**
         * @param list 
         * Algoritmo que compara valores adyacentes
         * y los va intercambiando en caso que no esten ordenados
         * poniendo el mayor en el index atual
         *  
         */
     public static void bubbleSort (Comparable[] list)
      //pre:recibe una lista de tipo comparabale desordenada
      //post:los valores son ordenados ascendentemente
      {
       int numSorted=0;//almacena la cantidad de numeros ordenados
       Comparable temp;
       
       while (numSorted<list.length)
       {
           for (int index=1;index<(list.length-numSorted);index ++)
           {
               //compara el valor proximo y el anterior
               //si es mayor el valor del index anterior
               //realiza el swap
               if (list[index-1].compareTo(list[index]) > 0)
               {
                    // intercambio de valores
                    temp = list[index-1];
                    list[index-1] = list[index];
                    list[index] = temp;
               }
                   
           }
           numSorted++;//aumenta la cantidad de valores ordenados
       }//termina while
   }//termina bubble sort
       
       
  
    /**
     * @param list 
     *
     */
   public static void insertionSortDescendente (Comparable[] list)
   //pre: recibe un arreglo de tipo comparable desordenado
   //post: ordena el arreglo de forma descendente
   {
      for (int index = 1; index < list.length; index++)
      {
         Comparable key = list[index];
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list[position-1]) < 0)
         {
            list[position] = list[position-1];
            position--;
         }
            
         list[position] = key;
      }//termina for
   }//termina selection sort descendente
   /**
    * 
    * @param list 
      * En este algortimo los valores ordenados se mantienen en la parte baja 
     * del arreglo y los valores no ordenadas se mantienen en la parte alta.
     * El algoritmo consiste en insertar el valor no ordenado en el menor index,
     * al hacer esto el numero de valores ordenados aumenta por uno. El algortimo
     * termina cuando los valores no ordenados pasan a la parte ordenada. 
    */
   
   public static void insertionSortAscendente(Comparable[] list)
   //pre: recibe un arreglo de tipo comparable desordenado
   //post: ordena el arreglo de forma ascendente
   {
      
       int numSorted =1;
       Comparable temp;
       int index;
       while(numSorted<list.length)
       {
           //se toma el primer valor no ordenado
           temp=list[numSorted];
           //se inserta en la parte del arreglo ordenado
           for(index=numSorted;index>0;index--)
           {
               if (temp.compareTo(list[index-1])>0)
               {
                   list[index]=list[index-1];
               }
               else
                   break;
           }
           //se reinserta el valor
           list[index]=temp;
           numSorted++; //aumenta la cantidad de números ordenados
       }//termina while
   }//termina insertion sort ascendente
   
   private static void MergeSortRecursive(Comparable[] list, Comparable temp[],int low, int high){
      
      int n = high-low+1;
      int middle=low+n/2;
      int i;
      if (n<2) return;
      
      for(i=low;i<middle;i++)
      {
          temp[i]=list[i];
      }
      MergeSortRecursive(temp,list,low,middle-1);
      MergeSortRecursive(list,temp,middle,high);
      merge(list, temp,low, middle, high);
      
   } 
    private static void merge(Comparable[] list, Comparable temp[], int low, int middle, int high){
         int ri=low;
         int ti=low;
         int di=middle;
         while(ti < middle && di <= high){
             if (list[di].compareTo(temp[ti])<0)
                 list[ri++]=list[di++];
             else
                 list[ri++]=temp[ti++];
         }
         while (ti < middle)
             list[ri++]=temp[ti++];
     }
          
      
      
      
  
    public static void  MergeSort(Comparable[] list)
    {
        MergeSortRecursive(list,new Comparable[list.length],0,list.length-1);
    }
}