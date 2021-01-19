import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numberSequenceStack = new ArrayDeque<>();

        int numOfElements = Integer.parseInt(input[0]);
        int numOfPops = Integer.parseInt(input[1]);
        int checkIfPresent = Integer.parseInt(input[2]);
        boolean isItValid = false;

        for (int i = 0; i < numOfElements; i++) {
            numberSequenceStack.offer(scanner.nextInt());
        }
        for (int i = 0; i < numOfPops; i++) {
            numberSequenceStack.poll();
        }
        if (numberSequenceStack.isEmpty()){
            System.out.println(0);
            return;
        }
        if (numberSequenceStack.contains(checkIfPresent)){
            isItValid = true;
        }
        if (isItValid){
            System.out.println(true);
        }else {
            System.out.println(Collections.min(numberSequenceStack));
        }
    }
}
