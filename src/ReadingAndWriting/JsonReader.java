package ReadingAndWriting;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JsonReader {
    String result;
    public JsonReader(){
        result="15";
    }

    public void Read(String file_name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file_name));
        result = new Gson().fromJson(br, String.class);
        br.close();
    }
    public void Write(String file_name) throws IOException {
        FileWriter fw = new FileWriter(file_name);
        fw.write(new Gson().toJson(result));
        fw.close();
    }
}
