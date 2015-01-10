package compression.lzw.dictionary;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class Alphabet {
    private final char[] characters;

    public Alphabet() {
        characters = new char[]{'a', 'b', 'c'};
    }

    public char[] getCharacters() {
        return characters;
    }
}
