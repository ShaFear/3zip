import compression.Compression;
import compression.CompressionState;
import compression.lzw.Lzw;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String in = "";
        String out = "";
        String search = "";
        Integer compression = 0;
        Integer operation = 0;

        String instrukcja =
                "OPCJE WYWOŁANIA PROGRAMU\n" +
                        "-i [plik] - plik wejsciowy\n" +
                        "-o [plik] - nazwa pliku wyjsciowego\n" +
                        "-w [wzorzec] - ciag znakow do wyszukania\n" +
                        "-k [kompresja] - 0: lzw, 1: bzip2\n" +
                        "-t [tryb] - 0: kompresuj, 1: dekompresuj, 2: wyszukaj";

        boolean isArgumentEntered[] = {false, false, false, false, false};

        for (int j = 0; j < args.length - 1; j++) {
            if (args[j].contains("-i")) {
                in = args[j + 1];
                isArgumentEntered[0] = true;
            } else if (args[j].contains("-o")) {
                isArgumentEntered[1] = true;
                out = args[j + 1];
            } else if (args[j].contains("-w")) {
                isArgumentEntered[2] = true;
                search = args[j + 1];
            } else if (args[j].contains("-k")) {
                isArgumentEntered[3] = true;
                compression = Integer.parseInt(args[j + 1]);
            }else if (args[j].contains("-t")) {
                isArgumentEntered[4] = true;
                operation = Integer.parseInt(args[j + 1]);
            }
        }

        if((isArgumentEntered[4] == false)||(isArgumentEntered[3] == false)) {
            System.out.println(instrukcja);
            return;
        }

        Compression cmp = new Compression();

        switch (compression){
            case 0: {
                cmp.setState(new Lzw());
                break;
            }
            case 1: {
                cmp.setState(new Lzw()); //zmienić na Bzip2 gdy bedzie zrobione
                break;
            }
            default:{
                System.out.println(instrukcja);
                return;
            }
        }

        switch (operation){
            case 0: {
                if((isArgumentEntered[0] == false) || (isArgumentEntered[1] == false)){
                    System.out.println(instrukcja);
                    return;
                }
                cmp.encode(in,out);
                return;
            }
            case 1: {
                if((isArgumentEntered[0] == false) || (isArgumentEntered[1] == false)){
                    System.out.println(instrukcja);
                    return;
                }
                cmp.decode(in, out);
                return;
            }
            case 2:{
                if((isArgumentEntered[0] == false) || (isArgumentEntered[2] == false)){
                    System.out.println(instrukcja);
                    return;
                }
                if(cmp.search(in, search)){
                    System.out.print("Znaleziono wzorzec w pliku\n");
                }else{
                    System.out.print("Nie znaleziono wzorca w pliku\n");
                }
                return;
            }
            default:{
                    System.out.println(instrukcja);
                    return;
            }

        }


    }
}
