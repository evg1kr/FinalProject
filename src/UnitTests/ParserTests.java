package UnitTests;
import parser.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTests {

    @Test
    void evaluate() {
        Parser a = new Parser();
        assertEquals("2.0","5-3");
    }
}