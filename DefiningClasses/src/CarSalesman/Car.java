package CarSalesman;

import java.util.stream.Stream;

public class Car {
    //Car - "<Model> <Engine>     <Weight> <Color>"
    private String carName;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String carName, Engine engine, String weight, String color) {
        this.carName = carName;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public Car(String carName, Engine engine, String thirdValue){
        this.carName = carName;
        this.engine = engine;
        if (thirdValue.matches("^[0-9]+$")){
            this.weight = thirdValue;
            this.color = "n/a";
        }else {
            this.weight = "n/a";
            this.color = thirdValue;
        }
    }
    public Car(String carName, Engine engine) {
        this(carName, engine, "n/a", "n/a");
    }

    @Override
    public String toString() {
        return String.format("%s:%n", carName)
                + engine + String.format("Weight: %s%nColor: %s", weight, color);

    }
}
