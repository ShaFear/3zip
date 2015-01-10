package compression.lzw.dictionary;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class Position {
    private final String word;
    private final String code;

    public Position(String word, String code) {
        this.word = word;
        this.code = code;
    }

    public String getWord() {
        return word;
    }


    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "\tsłowo: " + word + "\tkod:" + code + "\n";
    }
}
