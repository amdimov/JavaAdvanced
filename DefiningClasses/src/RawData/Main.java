package RawData;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        HashSet<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < N; i++) {
            //TODO
            String[] inputLine = scanner.nextLine().split("\\s+");
            Car car = new Car(inputLine);
            cars.add(car);
        }
        String cargoType = scanner.nextLine();
        cars.stream().filter(e -> (e.getCargo().getCargoType().equals(cargoType) && e.isLowPressure())
        || ((e.getCargo().getCargoType().equals(cargoType) && e.isHighEnginePower())))
                .forEach(e -> System.out.println(e.getCarName()));

    }
}
