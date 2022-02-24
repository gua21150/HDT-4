package hdt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InfixPostfixTest {
    @Test
    void testConversion() {
        InfixPostfix InfixPostfix = new InfixPostfix();
        assertEquals("56+", InfixPostfix.conversion("5+6"));
        assertEquals("56*2+", InfixPostfix.conversion("(5*6)+2"));
    }
}
