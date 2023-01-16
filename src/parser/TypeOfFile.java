package parser;
import ReadingAndWriting.JSON;
import ReadingAndWriting.TXT;
import ReadingAndWriting.XML;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;
import java.util.regex.*;
import encryption.Encryption;
import org.xml.sax.SAXException;

public class TypeOfFile {
public void Start(String in, String out, boolean mode) throws IOException, ParserException, ParserConfigurationException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, TransformerException, SAXException {
    StringTokenizer st = new StringTokenizer(in,".");
    String t = st.nextToken();
    String sequence;
    if(mode){
        Encryption enc = new Encryption();
        enc.decrypt(in,"AES");
    }
    Parser pars = new Parser();
    while(st.hasMoreTokens()){
        t = st.nextToken();
    }
    boolean result = t.matches("txt");
        if(result){
            TXT file = new TXT();
            sequence = file.Read(in);
            double M = pars.evaluate(sequence);
            file.Write(out, Double.toString(M));
        }
        else{
            result=t.matches("json");
            if(result) {
                JSON file = new JSON();
                sequence = file.Read(in);
                double M = pars.evaluate(sequence);
                file.Write(out, Double.toString(M));
            }
            else{
                result=t.matches("xml");
                if(result){
                    XML file = new XML();
                    sequence = file.Read(in);
                    double M = pars.evaluate(sequence);
                    file.Write(out, Double.toString(M));
                }
                else{
          /*          result=t.matches("zip");
                    if(result){
                    }*/
                }
            }
        }

}
}
