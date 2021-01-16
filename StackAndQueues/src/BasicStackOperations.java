import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numberSequenceStack = new ArrayDeque<>();

        int numOfElements = Integer.parseInt(input[0]);
        int numOfPops = Integer.parseInt(input[1]);
        int checkIfPresent = Integer.parseInt(input[2]);
        boolean isItValid = false;

        for (int i = 0; i < numOfElements; i++) {
            numberSequenceStack.push(scanner.nextInt());
        }

        for (int i = 0; i < numOfPops; i++) {
            numberSequenceStack.pop();
        }
        if (numberSequenceStack.contains(checkIfPresent)){
            isItValid = true;
        }
        if (numberSequenceStack.isEmpty()){
            System.out.println(0);
            return;
        }
        if (isItValid){
            System.out.println("true");
        }else {
            int smallestNumber = Integer.MAX_VALUE;
            for (int i = 0; i < numberSequenceStack.size(); i++) {
                if (numberSequenceStack.peek() < smallestNumber){
                    smallestNumber = numberSequenceStack.pop();
                }
            }
            System.out.println(smallestNumber);
        }

    }

}
