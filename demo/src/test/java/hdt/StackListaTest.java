package hdt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackListaTest {
    @Test
    void testIsEmpty() {
        System.out.println("isEmpty");
        StackLista instance = new StackLista(0, null);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }


    @Test
    void testPush() {
        System.out.println("push");
        Integer dato = 5;
        StackLista instance = new StackLista(0, null);
        instance.push(dato);
    }
}
