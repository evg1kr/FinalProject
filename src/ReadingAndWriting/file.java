package ReadingAndWriting;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface file {
    String Read(String file_name) throws IOException, SAXException, ParserConfigurationException;
    void Write(String file_name, String text) throws IOException, ParserConfigurationException, SAXException, TransformerException;

}