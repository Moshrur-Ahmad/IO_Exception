import java.io.*;
import java.util.Scanner;
public class FileStatistics {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        int lineCount = 0, wordCount = 0, charCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                wordCount += line.split("\\s+").length;
            }
        }

        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Characters: " + charCount);
    }
}
