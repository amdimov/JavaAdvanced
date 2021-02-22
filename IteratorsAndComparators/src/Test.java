import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car("Suzuki", 4, 2, 1, 3, 5, 6, 7);
        car.forEach(System.out::println);

    }
}
