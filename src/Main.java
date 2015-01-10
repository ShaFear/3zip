import compression.Compression;
import compression.bzip2.Bzip2;
import compression.lzw.Lzw;

public class Main {
    private String in;
    private String out;
    private String search;
    private Integer compression;
    private Integer operation;
    private String instructions;
    private boolean []isArgumentEntered;
    private Compression cmp;

    public Main(String []args){
        in = "";
        out = "";
         search = "";
         compression = 0;
         operation = 0;
         instructions =
                "OPCJE WYWOŁANIA PROGRAMU\n" +
                        "-i [plik] - plik wejsciowy\n" +
                        "-o [plik] - nazwa pliku wyjsciowego\n" +
                        "-w [wzorzec] - ciag znakow do wyszukania\n" +
                        "-k [kompresja] - 0: lzw, 1: bzip2\n" +
                        "-t [tryb] - 0: kompresuj, 1: dekompresuj, 2: wyszukaj";
        isArgumentEntered = new boolean[5];
        for(int j=0; j<5; j++){
            isArgumentEntered[j] = false;
        }
        checkIfArgumentsWereEntered(args);
        runProgramWithArguments();
    }
    private void checkIfArgumentsWereEntered(String[] args){
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
    }
    private void runProgramWithArguments(){


        setCompression();

        switch (operation){
            case 0: {
                runEncoding();
                break;
            }
            case 1: {
                runDecoding();
                break;
            }
            case 2:{
                runSearch();
                break;
            }
            default:{
                System.out.println(instructions);
                break;
            }

        }
    }
    private void setCompression() {
        if((isArgumentEntered[4] == false)||(isArgumentEntered[3] == false)) {
            System.out.println(instructions);
            return;
        }

        cmp = new Compression();

        switch (compression){
            case 0: {
                cmp.setState(new Lzw());
                break;
            }
            case 1: {
                cmp.setState(new Bzip2());
                break;
            }
            default:{
                System.out.println(instructions);
                return;
            }
        }
    }
    private void runEncoding(){
        if((isArgumentEntered[0] == false) || (isArgumentEntered[1] == false)){
            System.out.println(instructions);
            return;
        }
        cmp.encode(in,out);
        return;
    }
    private void runDecoding(){
        if((isArgumentEntered[0] == false) || (isArgumentEntered[1] == false)){
            System.out.println(instructions);
            return;
        }
        cmp.decode(in, out);
        return;
    }
    private void runSearch(){
        if((isArgumentEntered[0] == false) || (isArgumentEntered[2] == false)){
            System.out.println(instructions);
            return;
        }
        if(cmp.search(in, search)){
            System.out.print("Znaleziono wzorzec w pliku\n");
        }else{
            System.out.print("Nie znaleziono wzorca w pliku\n");
        }
        return;
    }

    public static void main(String[] args){
        new Main(args);
        /*
        OPCJE WYWOŁANIA PROGRAMU
                        -i [plik] - plik wejsciowy
                        -o [plik] - nazwa pliku wyjsciowego
                        -w [wzorzec] - ciag znakow do wyszukania
                        -k [kompresja] - 0: lzw, 1: bzip2
                        "t [tryb] - 0: kompresuj, 1: dekompresuj, 2: wyszukaj

        -==Przykładowe argumenty=--

        Kompresja
            LZW
                -i test.txt -o test.lzw -k 0 -t 0
            BZIP2
                -i test.txt -o test.bzip2 -k 1 -t 0

        Dekompresja
            LZW
                -i test.lzw -o testlzw.txt -k 0 -t 1
            BZIP2
                -i test.bzip2 -o testbzip2.lzw -k 1 -t 1

        Wyszukiwanie wzorca
            LZW
                -i test.lzw -w Psychosocial -k 0 -t 2
            BZIP2
                -i test.bzip2 -w Psychosocial -k 1 -t 2
        */
    }
}
