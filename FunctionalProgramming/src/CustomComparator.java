import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> sortOddsAndEven = (a, b) ->{
            if (a % 2 == 0 && b % 2 != 0){
                return -1;
            }else if (a % 2 != 0 && b % 2 == 0){
                return 1;
            }
            return a.compareTo(b);
        };
        Arrays.sort(numbers, sortOddsAndEven);
        Arrays.stream(numbers).forEach(e-> System.out.printf("%d ", e));
    }

}
