package compression.lzw.dictionary;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class Alphabet {
    private final char[] characters;

    public Alphabet() {
        characters = new char[128];
        for(int j=0; j<128; j++){
            characters[j] = (char) j;
        }
    }

    public char[] getCharacters() {
        return characters;
    }
}
