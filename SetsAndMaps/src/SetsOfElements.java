import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> n = new LinkedHashSet<>();
        Set<Integer> m = new LinkedHashSet<>();

        int[] setSizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int nSize = setSizes[0];
        int mSize = setSizes[1];

        for (int i = 0; i < nSize; i++) {
            n.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < mSize; i++) {
            m.add(Integer.parseInt(scanner.nextLine()));
        }

        n.forEach(e ->{
            if (m.contains(e)){
                System.out.print(e + " ");
            }
        });
    }
}
