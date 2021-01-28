import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestTwo {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream =
                    new FileInputStream("C:\\Users\\User\\Desktop\\14° McLaren Order-Season2020.xlsx");
            int oneByte = inputStream.read();
            while (oneByte >= 0){
                System.out.print((char) oneByte);
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
