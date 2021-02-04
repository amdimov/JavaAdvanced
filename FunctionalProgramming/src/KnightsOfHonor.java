import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> consumer = e -> System.out.println("Sir " + e);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(consumer);

    }
}
