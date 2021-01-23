import java.util.Collections;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        int[][] matrix = fillMatrix(rows, cols, scanner);

        int[][] maxMatrix = scanMatrix(matrix, rows, cols);
        int bestSum = sumMatrix(maxMatrix);
        System.out.println("Sum = " + bestSum);
        printMatrix(maxMatrix);
    }

    private static int sumMatrix(int[][] maxMatrix) {
        int sum = 0;

        for (int[] matrix : maxMatrix) {
            for (int i : matrix) {
                sum += i;
            }
        }
        return sum;
    }

    private static void printMatrix(int[][] maxMatrix) {
        for (int[] matrix : maxMatrix) {
            for (int i : matrix) {
                System.out.print(String.format("%d ", i));
            }
            System.out.println();
        }
    }

    private static int[][] scanMatrix(int[][] matrix, int rows, int cols) {
        int[][] newMatrix = (rows > 3 && cols > 3) ? new int[3][3] : new int[rows][cols];
        int[][] bestMatrix = copyMatrix(newMatrix);
        int maxMatrix;
        int indexRows = 0;
        int indexCols = 0;
        int minValue = Integer.MIN_VALUE;
        while (true) {
            for (int i = 0; i < newMatrix.length; i++) {
                for (int j = 0; j < newMatrix[i].length; j++) {
                    newMatrix[i][j] = matrix[i + indexRows][j + indexCols];
                }
            }
            maxMatrix = sumMatrix(newMatrix);
            if (minValue < maxMatrix){
                minValue = sumMatrix(newMatrix);
                bestMatrix = copyMatrix(newMatrix);
            }
            if (rows >= 3 && cols >= 3) {
                if (newMatrix.length + indexRows <= rows - 1) {
                    indexRows++;
                } else if (newMatrix.length + indexCols <= cols - 1) {
                    indexCols++;
                } else {
                    break;
                }
            }else {
                bestMatrix = copyMatrix(newMatrix);
                return bestMatrix;
            }
        }
        return bestMatrix;
    }

    private static int[][] copyMatrix(int[][] newMatrix) {
        int[][] matrixCopied = new int[newMatrix.length][newMatrix.length];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                matrixCopied[i][j] = newMatrix[i][j];
            }
        }
        return matrixCopied;
    }

    private static int[][] fillMatrix(int row, int col, Scanner scanner) {
        int[][] matrix = new int[row][col];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
