import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        int[][] matrix = fillMatrix(input, scanner);

        int primaryDiagonalSum = sumPrimaryDiagonal(matrix);
        int secondaryDiagonalSum = sumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static int sumPrimaryDiagonal(int[][] matrix) {
        int diagonalSum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col){
                    diagonalSum+=matrix[row][col];
                }
            }
        }
        return diagonalSum;
    }
    private static int sumSecondaryDiagonal(int[][] matrix) {
        int diagonalSum = 0;
        int col = matrix.length-1;
        for (int row = 0; row < matrix.length; row++) {
            diagonalSum += matrix[row][col];
            col--;
        }
        return diagonalSum;
    }

    private static int[][] fillMatrix(int input, Scanner scanner) {
        int[][] matrix = new int[input][input];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
