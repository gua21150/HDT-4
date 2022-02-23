import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InfixPostfixTest {
    InfixPostfix pruebaInfix;
    @BeforeAll
    void setUp() {
        pruebaInfix = new InfixPostfix();
    }

    @Test
    void conversion() {
        assertEquals("5  6+", pruebaInfix.conversion("5 + 6"));
    }
}