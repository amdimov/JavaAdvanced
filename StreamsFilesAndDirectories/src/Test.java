import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String[] fileName = scanner.nextLine().split("[.]");
            boolean check = fileName[0].equalsIgnoreCase("STOP");
            if (check){
                return;
            }
            while (!fileName[0].equalsIgnoreCase("STOP")) {
                File newFile = new File("C:\\Users\\User\\Desktop\\" + fileName[0] + "." + fileName[1]);
                if (newFile.createNewFile()) {
                    System.out.println("New file created with the name " + newFile.getName());
                    FileInputStream inputStream = new FileInputStream(newFile.getAbsolutePath());
                    FileWriter fileWriter = new FileWriter(newFile.getAbsolutePath());
                    String input = scanner.nextLine();
                    fileWriter.write(input);
                    fileWriter.close();
                    int oneByteOutput = inputStream.read();
                    System.out.print("You wrote in the file: ");
                    while (oneByteOutput >= 0) {
                        System.out.print((char) oneByteOutput);
                        oneByteOutput = inputStream.read();
                    }
                    System.out.println();
                    fileName = scanner.nextLine().split("[.]");
                } else {
                    System.out.println("File already exist");
                    fileName = scanner.nextLine().split("[.]");
                }
            }
            //FileInputStream fileInputStream = new FileInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
