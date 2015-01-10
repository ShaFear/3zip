package compression;

import java.io.File;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public interface CompressionState {
    public File getCompressedFrom(File in) ;

    public File getUncompressedFrom(File in) ;

    boolean searchAt(File in, String keywoard) ;
}
