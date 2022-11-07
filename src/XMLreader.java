import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.File;

public class XMLreader {

    public XMLreader() throws ParserConfigurationException, TransformerException {
        String filepath = "test.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("String");

            String Result="";
            for (int i = 0; i < nodeList.getLength(); i++) {
                Result=nodeList.item(i).getChildNodes().item(0).getTextContent();
            }

            System.out.println(Result);
        } catch (Exception exc) {
            exc.printStackTrace();
        }


    }
}
