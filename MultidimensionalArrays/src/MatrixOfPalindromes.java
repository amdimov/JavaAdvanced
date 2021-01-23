import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];
        char currentChar;
        int firstCharValue = 'a';
        int secondCharValue = 'a';
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String result = String.format("%s%s%s ", (char)firstCharValue, (char)secondCharValue, (char)firstCharValue);
                secondCharValue++;
                System.out.print(result);
            }
            secondCharValue = 'a' + i;
            System.out.println();
            firstCharValue++;
            secondCharValue++;
        }
    }
}
