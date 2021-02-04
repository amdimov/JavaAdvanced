import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestElementFunc = e -> {
          Integer min = e.stream()
          .min(Integer::compareTo).orElse(-1);
          return e.lastIndexOf(min);
        };

        int smallestNumber = smallestElementFunc.apply(integerList);
        System.out.println(smallestNumber);

    }
}
