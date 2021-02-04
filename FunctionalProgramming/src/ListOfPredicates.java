import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = Integer.parseInt(scanner.nextLine());


        List<Integer> inputList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> checkDivision = e -> {
            for (Integer divider : inputList) {
                if (e % divider != 0){
                    return false;
                }
            }
            return true;
        };
        for (int i = 1; i <= N; i++) {
            boolean checkNum = checkDivision.test(i);
            if (checkNum){
                System.out.printf("%d ", i);
            }
        }
    }
}
