import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        List<String> lines = fillLines("C:\\Users\\Owner\\Desktop\\Skool\\Data Structures\\Homework\\code\\words_alpha.txt");
        List<String> palindromes = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String word = lines.getFirst();
            lines.removeFirst();
            if (word.length() % 2 == 0) {
                for (int j = 0; j < word.length() / 2; j++) {
                    if (word.charAt(j) == word.charAt(word.length() - j)) {
                        palindromes.add(word);
                        System.out.println(word);
                    } 
                }
             } 
            //else {
            //     for (int j = 0; j < (word.length() - 1) / 2; j++) {
            //         if (word.charAt(j) == word.charAt(word.length() - j)) {
            //             palindromes.add(word);
            //         } 
            //     }
            //}
        }   
        // System.out.println("haiii");
    }

    public static List<String> fillLines(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<String> lines = new ArrayList<>();
            int i = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() >= 3) {
                    lines.add(line);
                }
            }
            
            return lines;

                
        } catch (IOException e) {
            e.printStackTrace();
            List<String> empty = new ArrayList<>();
            return empty;
        }
    }
}
