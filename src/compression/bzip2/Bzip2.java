package compression.bzip2;

import compression.CompressionState;

/**
 * Created by shafe_000 on 2015-01-10.
 */
public class Bzip2 implements CompressionState{
    /*
     * pathIn   - sciezka pliku wejsciowego niezakodowanego
     * pathOut  - sciezka pluku wyjsciowego zakodowanego
     */
    @Override
    public void encode(String pathIn, String pathOut) {
        System.err.println("Bzip2 kodowanie niezaimplementowne");
    }

    /*
     * pathIn   - sciezka pliku wejsciowego zakodowanego
     * pathOut  - sciezka pluku wyjsciowego niezakodowanego
     */
    @Override
    public void decode(String pathIn, String pathOut) {
        System.err.println("Bzip2 dekodowanie niezaimplementowne");
    }

    /*
     * pathIn   - sciezka pliku wejsciowego zakodowanego
     * keword   - slowo/wzorzec do wyszukania
     * zwraca true gdy znajdzie wzorzec w pliki
     * zwraca false gdy nie znajdzie
     */
    @Override
    public boolean search(String pathIn, String keyword) {
        System.err.println("Bzip2 wyszukiwanie niezaimplementowne");
        return false;
    }
}
