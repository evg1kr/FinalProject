package UnitTests;

import ReadingAndWriting.JSON;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JSONTest {

    JSON a = new JSON();
    @Test
    void read() throws IOException {
        assertEquals(a.Read("Test.json"),"just testing here some features nearly added fffafafqaf");
    }
}