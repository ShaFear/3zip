package compression.lzw;

import compression.CompressionState;

import java.io.*;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class Lzw implements CompressionState {

    @Override
    public File getCompressedFrom(File in) {
        String fileIn = getStringFromFile(in);
        System.out.print(fileIn);
        return null;
    }

    private String getStringFromFile(File in) {
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

    @Override
    public File getUncompressedFrom(File in) {
        return null;
    }

    @Override
    public boolean searchAt(File in, String keywoard){
        return false;
    }
}
