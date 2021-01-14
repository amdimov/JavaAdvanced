import java.util.ArrayDeque;
import java.util.Scanner;

public class BinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();

        if (number != 0) {
            while (number != 0) {
                binaryStack.push(number % 2);
                number /= 2;
            }
            while (!binaryStack.isEmpty()) {
                System.out.print(binaryStack.pop());
            }
        }else {
            System.out.println(0);
        }
    }
}
