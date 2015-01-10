import compression.Compression;
import compression.CompressionState;
import compression.lzw.Lzw;
import compression.lzw.dictionary.Dictionary;

import java.io.*;
import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) throws IOException {
        Compression compression = new Compression();
        CompressionState lzw = new Lzw();

        compression.setState(lzw);
        compression.getCompressedFrom(new File("test.txt"));
        System.out.println();
        compression.getUncompressedFrom(new File("test.txt.lzw"));




        /*byte []bajt = {(byte)100, (byte)512};
        FileOutputStream fileOutputStream = new FileOutputStream("plik");
        fileOutputStream.write(bajt);
        fileOutputStream.close();*/
    }
}
