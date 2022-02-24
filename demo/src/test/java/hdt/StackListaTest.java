package hdt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackListaTest {
    @Test
    void testIsEmpty() {
        System.out.println("isEmpty");
        StackArrayList instance = new StackArrayList(null);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    void testPop() {
        System.out.println("pop");
        StackArrayList instance = new StackArrayList(null);
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
    }

    @Test
    void testPush() {
        System.out.println("push");
        Integer t = 5;
        StackArrayList instance = new StackArrayList(t);
        instance.push(t);
    }
}
