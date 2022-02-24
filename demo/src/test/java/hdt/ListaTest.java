package hdt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ListaTest {
    @Test
    void testAgregar() {
       System.out.println("Agregar");
       Object valor = null;
        int posicion = 0;
        Lista instance = new Lista();
        instance.Agregar(valor, posicion);
    }

    @Test
    void testAgregarFinal() {
        System.out.println("AgregarFinal");
        Object valor = null;
        Lista instance = new Lista();
        instance.AgregarFinal(valor);
    }

    @Test
    void testAgregarPrincipio() {
        System.out.println("AgregarPrincipio");
        Object valor = null;
        Lista instance = new Lista();
        instance.AgregarPrincipio(valor);
    }

    @Test
    void testCabeza() {
        System.out.println("Cabeza");
        Lista instance = new Lista();
        Object expResult = null;
        Object result = null;
        assertEquals(expResult, result);
    }

    @Test
    void testRemover() {
        System.out.println("Remover");
        Object valor = null;
        Lista instance = new Lista();
        Object expResult = null;
        Object result = instance.Remover(valor);
        assertEquals(expResult, result);
    }

    @Test
    void testRemoverPrimero() {
        System.out.println("RemoverPrimero");
        Lista instance = new Lista();
        int num = 5;
        instance.AgregarPrincipio(num);
        int expResult = 5;
        Object result = instance.RemoverPrimero();
        assertEquals(expResult, result);
    }

    @Test
    void testRemoverUltimo() {
        System.out.println("RemoverUltimo");
        Lista instance = new Lista();
        int num = 5;
        instance.AgregarFinal(num);
        int expResult = 5;
        Object result = instance.RemoverUltimo();
        assertEquals(expResult, result);
    }

    @Test
    void testContieneValor() {
        System.out.println("contieneValor");
        Object valor = null;
        Lista instance = new Lista();
        boolean expResult = false;
        boolean result = instance.contieneValor(valor);
        assertEquals(expResult, result);
    }

    @Test
    void testGetTamanio() {
        System.out.println("getTama\u00f1o");
        Lista instance = new Lista();
        int expResult = 0;
        int result = instance.getTamanio();
        assertEquals(expResult, result);
    }

    @Test
    void testIndexOf() {
        System.out.println("indexOf");
        Object inputData = null;
        Lista instance = new Lista();
        int expResult = -1;
        int result = instance.indexOf(inputData);
        assertEquals(expResult, result);
    }

    @Test
    void testSet() {
        System.out.println("set");
        int valor = 5;
        int posicion = 0;        
        Lista instance = new Lista();
        instance.AgregarPrincipio(valor);
        instance.set(valor, posicion);
    }
}
