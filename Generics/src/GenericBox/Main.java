package GenericBox;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            GenericBox<Integer> genericBox = new GenericBox<>(Integer.parseInt(scanner.nextLine()));
            System.out.println(genericBox);
        }
    }
}
