package ReadingAndWriting;

import java.util.Scanner;
import java.io.*;
public class TXT implements file {
    @Override
  public  String Read(String file_name) throws IOException {
    String result;
        FileReader fr = new FileReader(file_name);
        Scanner in = new Scanner(fr);
        result=in.nextLine()+"\n";
        while(in.hasNextLine()){
        result+=in.nextLine();
        result+="\n";
        }
        in.close();
        return result;
    }
    @Override
   public void Write(String file_name, String a) throws IOException {
        FileWriter fw = new FileWriter(file_name);
        fw.write(a);
        fw.close();
    }
}
