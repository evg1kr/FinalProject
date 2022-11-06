import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
            // получаем узлы с именем Language
            // теперь XML полностью загружен в память
            // в виде объекта Document
            NodeList nodeList = doc.getElementsByTagName("String");

            String Result="";
            for (int i = 0; i < nodeList.getLength(); i++) {
                Result=nodeList.item(i).getChildNodes().item(0).getTextContent();
            }

            // печатаем в консоль информацию по каждому объекту Language
            System.out.println(Result);
        } catch (Exception exc) {
            exc.printStackTrace();
        }


    }
}
