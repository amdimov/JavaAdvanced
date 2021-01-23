import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumSU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e ->Integer.parseInt(e))
                .toArray();
        int[][] matrix = new int[tokens[0]][tokens[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int bestSum = Integer.MIN_VALUE;
        int[] bestVector = new int[2];

        for (int row = 0; row < matrix.length-2; row++) {
            for (int col = 0; col < matrix[row].length-2; col++) {
                int[] start = new int[]{row, col};
                if (findSum(start, matrix) > bestSum){
                    bestSum = findSum(start, matrix);
                    bestVector = start;
                }
            }
        }
        System.out.println("Sum = " + bestSum);
        printMatrix(bestVector, matrix);
    }

    private static int findSum(int[] start, int[][] matrix) {
        int sum = 0;
        for (int i = start[0]; i < start[0]+3; i++) {
            for (int j = start[1]; j < start[1]+3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    private static void printMatrix(int[] start, int[][] matrix) {
        for (int i = start[0]; i < start[0]+3; i++) {
            for (int j = start[1]; j < start[1]+3; j++) {
                System.out.print(String.format("%d ", matrix[i][j]));
            }
            System.out.println();
        }
    }
}
