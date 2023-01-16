package UnitTests;

import ReadingAndWriting.XML;
import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XMLTest {

    XML a = new XML();
    @Test
    void read() throws IOException, ParserConfigurationException {
        assertEquals(a.Read("test.xml"),"just testing here some features nearly added fffafafqaf");
    }
}