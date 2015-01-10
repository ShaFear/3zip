package compression;

import java.io.File;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public interface CompressionState {
    public void encode(String pathIn, String pathOut) ;

    public void decode(String pathIn, String pathOut) ;

    boolean search(String pathIn, String keyword) ;
}
