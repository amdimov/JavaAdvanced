import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("input.txt"));

        int sum = 0;
        String line = bufferedReader.readLine();
        while (line != null){
            //System.out.println(line);
            for (char c : line.toCharArray()) {
                sum += c;
            }
            line = bufferedReader.readLine();
        }
        fileReader.close();
        FileOutputStream fileWriter = new FileOutputStream("input.txt");
        String result = String.valueOf(sum);
        fileWriter.write((char)sum);
        fileWriter.close();
    }
}
