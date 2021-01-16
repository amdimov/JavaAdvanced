import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersStack = parseInputToStack(scanner, scanner.nextLine().split("\\s+"));
        printStackInt(numbersStack);

    }

    public static ArrayDeque<Integer> parseInputToStack(Scanner scanner, String[] input){
        ArrayDeque<Integer> parsedArrayStack = new ArrayDeque();
        for (String n :
                input) {
            parsedArrayStack.push(Integer.parseInt(n));
        }
        return parsedArrayStack;
    }

    public static void printStackInt(ArrayDeque<Integer> arrayDequeStack){
        for (int n :
             arrayDequeStack) {
            System.out.print(n + " ");
        }
    }
}
