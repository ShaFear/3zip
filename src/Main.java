import compression.Compression;
import compression.CompressionState;
import compression.lzw.Lzw;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        System.out.println("Tu będzie program kompresujący!");

        Compression compression = new Compression();
        CompressionState lzw = new Lzw();

        compression.setState(lzw);
        compression.getCompressedFrom(new File("test.txt"));
    }
}
