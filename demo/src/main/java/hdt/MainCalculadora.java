package hdt;


/*
 * Universidad del valle de Guatemala
* Aaron Beltrán 21092
 * Diana Díaz 21066
 * Mariel Guamuche 21150
*/


import java.util.Scanner;

public class MainCalculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Scanner entradaDatos  = new Scanner(System.in); // lector de objetos
        FileProject archivo = new FileProject();
        
        int opcion = 0;
        int opcion2 = 0;        
        FactoryStack factory, factoryP;
        AbstractStack stack;
        System.out.println("Ingrese el tipo de stack");
        System.out.print("1. ArrayList\n");
        System.out.print("2. Vector\n");
        System.out.print("3. Lista\n");        
        opcion = entradaDatos.nextInt();     
        if (opcion == 3)
        {
            System.out.println("Ingrese el tipo de lista");
            System.out.print("1. Lista\n");
            System.out.print("2. Lista Doble\n");
            opcion2 = entradaDatos.nextInt();
        }        
        System.out.println("Creando stack...");
        try 
        {
            factory = new FactoryStack();
            stack = factory.getStack(opcion, opcion2);
            System.out.println("Leyendo expresión: ");
            String exp = archivo.LeerArchivo();
            double res = 0;
            res = stack.eval(exp,stack);
            System.out.println("Resultado: " + res);
        }
        catch (SingletonException e)
        {
            System.out.println(e.getMessage());
        }        
        // Se trata de crear otro stack - debería fallar
        System.out.println("Creando stack...");
        try 
        {
            factoryP = new FactoryStack();            
            stack = factoryP.getStack(opcion, opcion2);
            System.out.println("Leyendo expresión: ");
            String exp = archivo.LeerArchivo();
            double res = 0;
            res = stack.eval(exp,stack);        
            System.out.println("Resultado: " + res);
        }
        catch (SingletonException e)
        {
            System.out.println(e.getMessage());
        }
        entradaDatos.close();
    }
    
}
