package encryption;
import Facade.Facade;
import ReadingAndWriting.FileType;
import ReadingAndWriting.TXT;
import ReadingAndWriting.file;
import org.xml.sax.SAXException;

import javax.crypto.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    public void encrypt(String file_name,String algo) throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, ParserConfigurationException, SAXException, IllegalBlockSizeException, BadPaddingException, TransformerException {
        KeyGenerator keygenerator = KeyGenerator.getInstance(algo);
        SecretKey myDesKey = keygenerator.generateKey();
        // Creating object of Cipher
        Cipher desCipher;
        desCipher = Cipher.getInstance("DES");
        Facade factory_text = new Facade();
        file Txt = factory_text.getFile(FileType.TXT);
        String temp = Txt.Read(file_name);
        // Creating byte array to store string
        byte[] text = temp.getBytes("UTF8");
        byte[] textEncrypted = desCipher.doFinal(text);
        String s = new String(textEncrypted);
        new File(file_name);
        Txt.Write("encrypted.txt",s);
    }
    public void decrypt(String file_name, String algo) throws NoSuchAlgorithmException, NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException, ParserConfigurationException, SAXException, IllegalBlockSizeException, BadPaddingException, TransformerException {
        KeyGenerator keygenerator = KeyGenerator.getInstance(algo);
        SecretKey myDesKey = keygenerator.generateKey();
        Cipher desCipher = null;
        Facade factory_text = new Facade();
        file txt = factory_text.getFile(FileType.TXT);
        // Decrypting text
        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        String text = txt.Read(file_name);
        byte[] textEncrypted = desCipher.doFinal(text.getBytes());
        String s = new String(textEncrypted);
        new File(file_name);
        txt.Write("decrypted.txt",s);
    }
}