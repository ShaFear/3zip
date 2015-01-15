package compression.bzip2;

import compression.CompressionState;

import java.io.*;

import myutils.IOUtils;
import org.itadaki.bzip2.BZip2InputStream;
import org.itadaki.bzip2.BZip2OutputStream;


public class Bzip2 implements CompressionState{

    @Override
    public void decode(String pathIn, String pathOut){
        try {
            InputStream fileInputStream = new BufferedInputStream (new FileInputStream (pathIn));
            BZip2InputStream inputStream = new BZip2InputStream(fileInputStream, false);
            OutputStream fileOutputStream = new BufferedOutputStream (new FileOutputStream (pathOut), 524288);

            byte[] decoded = new byte [524288];
            int bytesRead;
            while ((bytesRead = inputStream.read (decoded)) != -1) {
                fileOutputStream.write (decoded, 0, bytesRead) ;
            }
            fileOutputStream.close();

        }
        catch(IOException e){
            System.out.print(e);
        }
    }

    @Override
    public void encode(String pathIn, String pathOut){

        try {
            InputStream fileInputStream = new BufferedInputStream(new FileInputStream(pathIn));
            OutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(pathOut), 524288);
            BZip2OutputStream outputStream = new BZip2OutputStream(fileOutputStream);

            byte[] buffer = new byte[524288];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
        }
        catch(IOException e){
            System.out.print(e);
        }
    }

    @Override
    public boolean search(String pathIn, String keyword) {
        this.decode(pathIn, "src/tmp2");
        String input = IOUtils.getStringFromFile(new File("src/tmp2"));
        return input.contains(keyword);
    }
}