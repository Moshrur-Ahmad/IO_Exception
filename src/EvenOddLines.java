import java.io.*;
public class EvenOddLines {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File evenFile = new File("even.txt");
        File oddFile = new File("odd.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             PrintWriter evenWriter = new PrintWriter(new FileWriter(evenFile));
             PrintWriter oddWriter = new PrintWriter(new FileWriter(oddFile))) {

            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                if (lineNumber % 2 == 0) {
                    evenWriter.println(line);
                } else {
                    oddWriter.println(line);
                }
                lineNumber++;
            }
        }

        System.out.println("Lines separated successfully!");
    }
}

