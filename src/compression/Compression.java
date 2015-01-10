package compression;

import java.io.File;


/**
 * Created by shafe_000 on 2015-01-10.
 */
public class Compression implements CompressionState {

    private CompressionState compressionState;

    public void setState(CompressionState compressionState) {
        this.compressionState = compressionState;
    }

    @Override
    public void encode(String pathIn, String pathOut) {
        compressionState.encode(pathIn, pathOut);
    }

    @Override
    public void decode(String pathIn, String pathOut) {
        compressionState.decode(pathIn, pathOut);
    }

    @Override
    public boolean search(String pathIn, String keywoard) {
        return compressionState.search(pathIn, keywoard);
    }
}
