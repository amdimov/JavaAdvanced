import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotationInput = scanner.nextLine();
        String regex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rotationInput);
        int rotationDegrees = 0;
        if (matcher.find()){
            rotationDegrees = Integer.parseInt(matcher.group(1)) % 360;
        }
        String wordsInput = scanner.nextLine();
        ArrayList<String> wordsList = new ArrayList<>();
        while (!wordsInput.equals("END")){
            wordsList.add(wordsInput);
            wordsInput = scanner.nextLine();
        }
        int matrixMaximumSize = findLongestInList(wordsList);
        char[][] charsMatrix = new char[wordsList.size()][matrixMaximumSize];
        for (int row = 0; row < wordsList.size(); row++) {
            for (int col = 0; col < matrixMaximumSize; col++) {
                if (wordsList.get(row).length() > col){
                    charsMatrix[row][col] = wordsList.get(row).charAt(col);
                }else {
                    charsMatrix[row][col] = ' ';
                }
            }
        }

        if (rotationDegrees == 0){
            rotate0(charsMatrix, matrixMaximumSize);
        }else if (rotationDegrees == 90){
            rotate90(charsMatrix, matrixMaximumSize);
        }else if (rotationDegrees == 180){
            rotate180(charsMatrix, matrixMaximumSize);
        }else if(rotationDegrees == 270){
            rotate270(charsMatrix, matrixMaximumSize);
        }
    }
    public static void rotate0(char[][] matrix, int maximumSize){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s", matrix[row][col]);
            }
            System.out.println();
        }
    }
    public static void rotate90(char[][] matrix, int maximumSize){
        for (int col = 0; col < maximumSize; col++) {
            for (int row = matrix.length-1; row >= 0; row--) {
                System.out.printf("%s", matrix[row][col]);
            }
            System.out.println();
        }
    }
    public static void rotate180(char[][] matrix, int maximumSize) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = maximumSize - 1; col >= 0; col--) {
                System.out.printf("%s", matrix[row][col]);
            }
            System.out.println();

        }
    }
    //TODO
    public static void rotate270(char[][] matrix, int maximumSize) {
        for (int col = maximumSize-1; col >= 0; col--) {
            for (int row = 0; row < matrix.length; row++) {
                System.out.printf("%s", matrix[row][col]);
            }
            System.out.println();

        }
    }
    public static int findLongestInList(ArrayList<String> wordsList){
        int wordsCounter = Integer.MIN_VALUE;
        for (int i = 0; i < wordsList.size(); i++) {
            if (wordsList.get(i).length() > wordsCounter){
                wordsCounter = wordsList.get(i).length();
            }
        }
        return wordsCounter;
    }
}
