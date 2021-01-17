import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < commands; i++) {
            String[] commandLine = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(commandLine[0]);

            if (command == 1){
                int numberToPush = Integer.parseInt(commandLine[1]);
                numbersStack.push(numberToPush);
            }else if (command == 2){
                numbersStack.pop();
            }else if (command == 3){
                Integer max = Collections.max(numbersStack);
                System.out.println(max);
            }
        }

    }
}
