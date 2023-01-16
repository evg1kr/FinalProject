package Archives;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.*;

public class ZipFiles {
    public void write_to_zip(String path){
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path));
            FileInputStream fis= new FileInputStream(path);)
        {
            ZipEntry entry1=new ZipEntry(path);
            zout.putNextEntry(entry1);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void input_from_zip(String path){

        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(path)))
        {
            ZipEntry entry;
            String name;
            long size;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName();

                FileOutputStream fout = new FileOutputStream(path);

                int c;

                while((c = zin.read()) != -1) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}