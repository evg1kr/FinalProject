import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLreader {

    public XMLreader() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().newDocument();
        Element root = doc.createElement("root");
        root.setAttribute("xmlns", "xmltesting");
        doc.appendChild(root);

        Element item1 = doc.createElement("String");
        item1.setAttribute("String", "just testing here\n" +
                "some features nearly added\n" +
                "fffafafqaf");
        root.appendChild(item1);
        File file = new File("test.xml");

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(file));
    }
}
