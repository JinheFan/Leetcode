package MaShiBing;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        String separater = File.separator;
        String fileName = "myFile.txt";
        String directory = "C:" + separater + "Users" + separater + "28102" + separater + "Desktop" + separater + "马士兵";
        File f = new File(directory, fileName);
        if(f.exists()){
            System.out.println(f.getAbsolutePath());
            System.out.println(f.length());
        }else{
            f.getParentFile().mkdirs();
            try{
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
