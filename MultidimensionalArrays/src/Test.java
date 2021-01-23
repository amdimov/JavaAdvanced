import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[3][3];

        int number = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = number++;
            }
        }

        System.out.println("---------A---------");

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(String.format("%d ", element));
            }
            System.out.println();
        }
        System.out.println("--------B---------");
        int[][] matrixB = new int[3][3];
        int numberB = 1;
        for (int row = 0; row < matrixB.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrixB[row].length; col++) {
                    matrixB[col][row] = numberB++;
                }
            }else {
                for (int col = matrixB[row].length-1; col >= 0; col--) {
                    matrixB[col][row] = numberB++;
                }
            }
        }

        for (int[] row : matrixB) {
            for (int element : row) {
                System.out.print(String.format("%d ", element));
            }
            System.out.println();
        }
    }
}
