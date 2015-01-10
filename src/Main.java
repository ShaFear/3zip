import compression.Compression;
import compression.CompressionState;
import compression.lzw.Lzw;
import compression.lzw.dictionary.Dictionary;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        Compression compression = new Compression();
        CompressionState lzw = new Lzw();

        compression.setState(lzw);
        compression.getCompressedFrom(new File("test.txt"));
        System.out.println();
        compression.getUncompressedFrom(new File("slipknot.txt"));
    }
}
