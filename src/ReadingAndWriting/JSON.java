package ReadingAndWriting;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSON implements file {
    @Override
    public String Read(String file_name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file_name));
        String result = new Gson().fromJson(br, String.class);
        br.close();
        return result;
    }
    @Override
    public void Write(String file_name, String a) throws IOException {
        FileWriter fw = new FileWriter(file_name);
        fw.write(new Gson().toJson(a));
        fw.close();
    }
}
