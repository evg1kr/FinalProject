package encryption;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * PBE Coder<br/>
 * Algorithm/secret key length/default secret key length/<br/>
 * 1.PBEWithMD5AndDES/56/56
 * 2.PBEWithMD5AndTripleDES/112,168/168
 * 3.PBEWithSHA1AndDESede/112,168/168
 * 4.PBEWithSHA1AndRC2_40/40 to 1024/128
 * mode:	CBC <br/>
 * padding:	PKCS5Padding
 * @author Aub
 *
 */
public class Encryption {

    public static final String ALGORITHM = "PBEWITHMD5andDES";

    public static final int ITERATION_COUNT = 100;

    /**
     * Начальная соль <br/>
     * Длина соли должна быть 8 цифр
     * @return byte [] соль
     * @throws Exception
     */
    public static byte[] initSalt() throws Exception{
        // Создание безопасных случайных чисел
        byte[] a = new byte[8];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        a[3]=4;
        a[4]=5;
        a[5]=6;
        a[6]=7;
        a[7]=8;
        // Производство соли
        return a;
    }

    /**
     * Ключ преобразования
     *
     * @парам пароль пароль
     * @return Key
     */
    private static Key toKey(String password) throws Exception{
        // Ключевые материалы
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        // Instantiate
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        // Генерируем ключ
        return keyFactory.generateSecret(keySpec);
    }

    /**
     * Шифрование
     *
     * @ данные данных для шифрования
     * ключ @param
     * соль соли @param
     * @return byte [] зашифрованные данные
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,String password,byte[] salt) throws Exception{
        // Преобразовать ключ
        Key key = toKey(password);
        // Создание материала параметров PBE
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
        // Instantiate
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // Инициализировать
        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        // Выполнить операцию
        return cipher.doFinal(data);
    }

    /**
     * Расшифровать
     *
     * @param data Резервные секретные данные
     * ключ @param
     * соль соли @param
     * @return byte [] расшифровывает данные
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data,String password,byte[] salt)throws Exception{
        // Преобразовать ключ
        Key key = toKey(password);
        // Создание материала параметров PBE
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
        // Instantiate
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // Инициализировать
        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        // Выполнить операцию
        return cipher.doFinal(data);
    }

    private static String  showByteArray(byte[] data){
        if(null == data){
            return null;
        }
        StringBuilder sb = new StringBuilder("{");
        for(byte b:data){
            sb.append(b).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        byte[] salt = initSalt();
        System.out.println("salt："+showByteArray(salt));
        // Пароль должен быть ASCII-кодом, иначе будет сообщено об исключении
        String password = "1111";
        String data = "5721957+61957";
        System.out.println ( "Пароль:" + password);

        System.out.println ("Данные перед шифрованием byte []:" + showByteArray (data.getBytes()));
        System.out.println();
        byte[] encryptData = encrypt(data.getBytes(), password,salt);
        System.out.println ("Зашифрованные данные: byte []:" + showByteArray (encryptData));
        byte[] decryptData = decrypt(encryptData, password,salt);
        System.out.println ("Расшифрованные данные: byte []:" + new String(decryptData));
    }
}

