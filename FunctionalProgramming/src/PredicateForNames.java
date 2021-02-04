import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLength = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");
        Predicate<String> stringLength = e -> e.length() <= maxLength;

        System.out.println(Arrays.stream(names)
                .filter(stringLength)
                .collect(Collectors.joining(System.lineSeparator())));

    }
}
