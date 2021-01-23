import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(tokens[0]);
        String matrixType = tokens[1];

        int[][] matrix = fillMatrix(matrixSize, matrixType);

        if (matrixType.equals("A")){
            printMatrix(matrix);
        }else if (matrixType.equals("B")){
            printMatrix(matrix);
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int matrixSize, String matrixPattern) {
        int[][] matrix = new int[matrixSize][matrixSize];

        if (matrixPattern.equals("A")){
            fillMatrixA(matrix);
        }else if (matrixPattern.equals("B")){
            fillMatrixB(matrix);
        }
        return matrix;
    }

    private static void fillMatrixA(int[][] matrix) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = number++;
            }
        }
    }
    private static void fillMatrixB(int[][] matrix) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[col][row] = number++;
                }
            }else {
                for (int col = matrix[row].length-1; col >= 0; col--) {
                    matrix[col][row] = number++;
                }
            }
        }
    }
}
