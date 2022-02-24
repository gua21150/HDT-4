package hdt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ListaDobleTest {
    @Test
    void testAgregar() {
        System.out.println("Agregar");
        Object valor = null;
        int posicion = 0;
        ListaDoble instance = new ListaDoble();
        instance.Agregar(valor, posicion);
    }

    @Test
    void testAgregarFinal() {
        System.out.println("AgregarFinal");
        Object valor = null;
        ListaDoble instance = new ListaDoble();
        instance.AgregarFinal(valor);
    }

    @Test
    void testAgregarPrincipio() {
        System.out.println("AgregarPrincipio");
        Object valor = null;
        ListaDoble instance = new ListaDoble();
        instance.AgregarPrincipio(valor);
    }

    @Test
    void testRemover() {
        System.out.println("Remover");
        Object valor = null;
        ListaDoble instance = new ListaDoble();
        Object expResult = null;
        Object result = instance.Remover(valor);
        assertEquals(expResult, result);
    }

    @Test
    void testRemoverUltimo() {
        System.out.println("RemoverUltimo");
        ListaDoble instance = new ListaDoble();
        int expResult = 5;
        instance.AgregarFinal(5);
        Object result = instance.RemoverUltimo();
        assertEquals(expResult, result);
    }

    @Test
    void testGetTamanio() {
        ListaDoble instance = new ListaDoble();
        int expResult = 0;
        int result = instance.getTamanio();
        assertEquals(expResult, result);
    }
}
