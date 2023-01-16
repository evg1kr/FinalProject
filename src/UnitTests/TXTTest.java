package UnitTests;

import org.junit.jupiter.api.Test;
import ReadingAndWriting.TXT;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TXTTest {
TXT a = new TXT();
    @Test
    void read() throws IOException {
        assertEquals(a.Read("Test.txt"),"just testing here\n some features nearly added\nfffafafqaf");
    }
}