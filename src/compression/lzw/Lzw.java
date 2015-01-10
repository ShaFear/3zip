package compression.lzw;

import compression.CompressionState;

import java.io.File;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class Lzw implements CompressionState {

    @Override
    public File getCompressedFrom(File in) {
        return null;
    }

    @Override
    public File getUncompressedFrom(File in) {
        return null;
    }

    @Override
    public boolean searchAt(File in, String keywoard) {
        return false;
    }
}
