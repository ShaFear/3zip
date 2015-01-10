import compression.Compression;
import compression.CompressionState;
import compression.lzw.Lzw;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Compression compression = new Compression();
        CompressionState lzw = new Lzw();

        compression.setState(lzw);
        compression.encode("test.txt", "test.lzw");
        System.out.println();
        compression.decode("test.lzw", "test_.txt");




        /*byte []bajt = {(byte)100, (byte)512};
        FileOutputStream fileOutputStream = new FileOutputStream("plik");
        fileOutputStream.write(bajt);
        fileOutputStream.close();*/
    }
}
