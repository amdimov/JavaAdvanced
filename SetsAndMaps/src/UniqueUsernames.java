import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernameSet = new LinkedHashSet<>();
        int numberOfUsers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfUsers; i++) {
            String inputUser = scanner.nextLine();
            usernameSet.add(inputUser);
        }

        usernameSet.stream().forEach(System.out::println);
    }
}
