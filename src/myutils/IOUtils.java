package myutils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class IOUtils {
    public static String getStringFromFile(File in) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Reader reader = new FileReader(in);
            char c;
            while(true){
                c = (char)reader.read();
                if(c == '\uFFFF' ) break;
                stringBuilder.append(c);

            }
        }
        catch (IOException e){
            System.err.print(e);
        }
        return stringBuilder.toString();
    }
}
