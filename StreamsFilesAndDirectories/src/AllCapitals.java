import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

       FileReader fileReader = new FileReader("input.txt");
       BufferedReader bufferedReader = new BufferedReader(fileReader);
       StringBuilder line = new StringBuilder(bufferedReader.readLine());

       while (line != null){
           line.replace(0, line.length(), line.substring(0, line.length()).toUpperCase());
           System.out.println(line);
           line = new StringBuilder(bufferedReader.readLine());
       }

    }
}
