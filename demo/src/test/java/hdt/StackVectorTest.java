package hdt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackVectorTest {
    @Test
    void testIsEmpty() {
        System.out.println("isEmpty");
        StackVector instance = new StackVector();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    void testPop() {
        System.out.println("pop");
        StackVector instance = new StackVector();
        int expResult = 5;
        instance.push(expResult);
        Object result = instance.pop();
        assertEquals(expResult, result);
    }

    @Test
    void testPush() {
        System.out.println("push");
        Object dato = null;
        StackVector instance = new StackVector();
        instance.push(dato);
    }
}
