package test;

public class Car {
    String name;
    String model;

    public Car(String name, String model){
        this.name = name;
        this.model = model;
    }

    @Override
    public String toString() {
        return "test.Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
