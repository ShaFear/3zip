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
    public File getCompressedFrom(File in) {
        return compressionState.getCompressedFrom(in);
    }

    @Override
    public File getUncompressedFrom(File in) {
        return compressionState.getUncompressedFrom(in);
    }

    @Override
    public boolean searchAt(File in, String keywoard) {
        return compressionState.searchAt(in, keywoard);
    }
}
