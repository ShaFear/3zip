package compression.lzw.dictionary;

import java.util.ArrayList;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class Dictionary {
    private ArrayList<Position> positions;
    private Integer code;

    public Dictionary() {
        code = 0;
        Alphabet alphabet = new Alphabet();
        positions = new ArrayList<Position>();
        for (char character : alphabet.getCharacters()) {
            positions.add(new Position(Character.toString(character), code.toString()));
            code++;
        }
    }

    public void addPosition(String newWord) {
        if((code < 2147483000 ) && (newWord.length() < 12)){
        positions.add(new Position(newWord, code.toString()));
        code++;
        }
    }

    public void printPositionsToDictionaryOut() {
        System.out.println("-== Pozycje w słowniku =--");
        System.out.println(positions.toString());
        System.out.println("-=======================--");
    }


    public boolean searchWord(String word) {
        for(int j= 0; j<positions.size(); j++){
            if(word.compareTo(positions.get(j).getWord()) == 0) return true;
        }
        return false;
    }

    public boolean searchCode(String code) {
        for(int j= 0; j<positions.size(); j++){
            if(code.compareTo(positions.get(j).getCode()) == 0) return true;
        }
        return false;
    }

    public String getWordsCode(String word) {
        for(int j= 0; j<positions.size(); j++){
            if(word.compareTo(positions.get(j).getWord()) == 0) return positions.get(j).getCode();
        }
        return "-1";
    }

    public String getCodesWord(String code) {
        for(int j= 0; j<positions.size(); j++){
            if(code.compareTo(positions.get(j).getCode()) == 0) return positions.get(j).getWord();
        }
        return "-1";
    }


}
