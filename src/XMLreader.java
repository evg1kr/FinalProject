import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLreader {
    String Result;
    private void writeDocument(Document document, String path)
            throws TransformerFactoryConfigurationError {
        Transformer trf = null;
        DOMSource src = null;
        FileOutputStream fos = null;
        try {
            trf = TransformerFactory.newInstance()
                    .newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public XMLreader(){
        Result="";
    }
    public void output(String path) throws ParserConfigurationException {
        DocumentBuilderFactory dbf;
        DocumentBuilder db;
        Document doc;

        dbf = DocumentBuilderFactory.newInstance();
        db  = dbf.newDocumentBuilder();
        doc = db.newDocument();
        Element root = doc.createElement("Strings");

        Element user = doc.createElement("string");
        user.setTextContent(Result);
        root.appendChild(user);
        doc.appendChild(root);
        writeDocument(doc,path);
    }
     public void read(String path) throws ParserConfigurationException, TransformerException {
        File xmlFile = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("String");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Result=nodeList.item(i).getChildNodes().item(0).getTextContent();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }


    }
}
