import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[][] matrix = new String[tokens[0]][tokens[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String regex = "^swap (\\d+) (\\d+) (\\d+) (\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        String command = scanner.nextLine();


        while (!command.equals("END")){
            boolean isValid = true;
            Matcher matcher = pattern.matcher(command);
            if (matcher.matches()){
                int row1 = Integer.parseInt(matcher.group(1));
                int col1 = Integer.parseInt(matcher.group(2));
                int row2 = Integer.parseInt(matcher.group(3));
                int col2 = Integer.parseInt(matcher.group(4));
                boolean isInBounds = row1 >= 0 && row1 < tokens[0]
                        && row2 >= 0 && row2 < tokens[0]
                        && col1 >= 0 && col1 < tokens[1]
                        && col2 >= 0 && col2 < tokens[1];
                if (isInBounds){
                    String holder = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = holder;
                    printMatrix(matrix);
                }else {
                    isValid = false;
                }
            }else {
                isValid = false;
            }
            if (!isValid){
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }



    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.printf("%s " , string);
            }
            System.out.println();
        }
    }
}
