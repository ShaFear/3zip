package compression.lzw;

import compression.CompressionState;
import myutils.*;
import myutils.StringReader;

import java.io.*;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class Lzw implements CompressionState {

    @Override
    public File getCompressedFrom(File in) {
        String input = IOUtils.getStringFromFile(in);
        System.out.println(input);
        myutils.StringReader stringReader = new StringReader(input);
        while(stringReader.hasNextChar()){
            System.out.print(stringReader.nextChar());
        }
        return null;
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
