import java.util.Scanner;
import java.io.*;
public class ReadingFromTxt {
    String result;
    ReadingFromTxt(){
        result="";
    }
    void Read(String file_name) throws FileNotFoundException {
        FileReader fr = new FileReader(file_name);
        Scanner in = new Scanner(fr);
        result=in.nextLine()+"\n";
        while(in.hasNextLine()){
        result+=in.nextLine();
        result+="\n";
        }
        in.close();
        System.out.println(result);
    }
}
