
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        File file = new File("test.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                Map< Character, Integer> letters = new HashMap<>();
                for ( int i = 0; i < line.length(); i++ ) {
                    char c = line.charAt( i );
                    if(!Character.isSpaceChar(c)) {
                        if(  letters.containsKey(c)) {
                            int ii = letters.get(c);
                            letters.put(c, ii+1 );
                        }
                        else
                            letters.put(c, 1 );
                    }}


                letters.forEach((k, v) -> System.out.println(k + ": " + v));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }
}