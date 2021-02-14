package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int engLines = Integer.parseInt(scanner.nextLine());
        HashMap<String, Engine> engines = new HashMap<>();

        for (int i = 0; i < engLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String engineModel = tokens[0];
            Engine engine = engines.get(engineModel);
            if (tokens.length == 2){
                engine = new Engine(engineModel, Integer.parseInt(tokens[1]));
            }else if (tokens.length == 3){
                engine = new Engine(engineModel, Integer.parseInt(tokens[1]), tokens[2]);
            }else if (tokens.length == 4){
                engine = new Engine(engineModel, Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            }
            engines.putIfAbsent(engineModel, engine);
        }

        int carLines = Integer.parseInt(scanner.nextLine());
        HashSet<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < carLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String carName = tokens[0];
            Car car = null;
            if (tokens.length == 2){
                car = new Car(carName, engines.get(tokens[1]));
            }else if (tokens.length == 3){
                car = new Car(carName, engines.get(tokens[1]), tokens[2]);
            }else if (tokens.length == 4){
                car = new Car(carName, engines.get(tokens[1]), tokens[2], tokens[3]);
            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }

//        for (Map.Entry<String, Engine> stringEngineEntry : engines.entrySet()) {
//            System.out.println(stringEngineEntry.getValue());
//        }
    }
}
