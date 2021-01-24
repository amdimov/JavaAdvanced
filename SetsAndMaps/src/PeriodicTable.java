import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        Set<String> compounds = new TreeSet<>();

        for (int i = 0; i < num; i++) {
            String[] compoundsInput = scanner.nextLine().split(" ");
            for (String s : compoundsInput) {
                compounds.add(s);
            }
        }
        compounds.forEach(e -> System.out.print(e + " "));
    }
}
