import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input;

        while (!"end".equals(input = scanner.nextLine())){
            switch (input){
                case "add":
                    numbers = Arrays.stream(numbers).map(e ->e+1)
                            .toArray();
                    break;
                case "multiply":
                    numbers = Arrays.stream(numbers).map(e ->e*2)
                            .toArray();
                    break;
                case "subtract":
                    numbers = Arrays.stream(numbers).map(e ->e-1)
                            .toArray();
                    break;
                case "print":
                    System.out.println(Arrays.stream(numbers).mapToObj(Integer::toString)
                            .collect(Collectors.joining(" ")));
                    break;
            }
        }

    }
}
