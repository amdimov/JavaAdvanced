import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> minFunc = e -> Arrays.stream(e).mapToInt(Integer::intValue).min().getAsInt();

        int min = minFunc.apply(
                Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                .toArray(Integer[]::new)
        );
        System.out.println(min);

    }
}
