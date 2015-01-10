package myutils;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class StringReader {
    private String string;
    private int characterIndex;

    public StringReader(String string){
        characterIndex = 0;
        this.string = string;
    }

    public boolean hasNextChar(){
        return !(characterIndex == string.length());
    }

    public char nextChar(){
        return string.charAt(characterIndex++);
    }

    public String nextCharAsString(){
        return new StringBuilder().append(this.nextChar()).toString();
    }
}
