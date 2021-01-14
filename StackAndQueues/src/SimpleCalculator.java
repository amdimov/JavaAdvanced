import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            char item = input[i].charAt(0);

            if (Character.isDigit(item)){
                numbers.push(Integer.parseInt(input[i]));
            }else {
                if (input[i].equals("+")) {
                    numbers.push(numbers.peek() + Integer.parseInt(input[++i]));

                }else {
                    numbers.push(numbers.peek() - Integer.parseInt(input[++i]));
                }
            }
        }
        System.out.println(numbers.peek());
    }
}
