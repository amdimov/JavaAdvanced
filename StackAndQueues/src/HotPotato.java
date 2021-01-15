import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> kidsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        int numOfTolls = Integer.parseInt(scanner.nextLine());

        while (kidsQueue.size() > 1) {
            for (int i = 1; i < numOfTolls; i++) {
                kidsQueue.offer(Objects.requireNonNull(kidsQueue.poll()));
            }
            System.out.println("Removed "+kidsQueue.poll());
        }
        System.out.println("Last is " + kidsQueue.poll());

    }
}
