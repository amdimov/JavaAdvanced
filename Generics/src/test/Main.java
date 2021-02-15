package test;

import java.util.Scanner;

public class Main {
    public static class MyClass{
        String test;
        String name;

        public MyClass(String test, String name) {
            this.test = test;
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Test cars = new Test();
        cars.addObject(new Car("Tesla", "E34A"));
        cars.addObject(new Car("Mercedes", "AMG 90"));
        cars.addObject(new Car("test.Test", "test"));

        Car car = new Car("Lada", "Niva");
        MyClass myClass = new MyClass("Hey", "You");

        Car[] newArray = Test.<Car>createNewArray(Car.class, 5, car);

        System.out.println((Object)car instanceof MyClass);
        Test.print(car);

    }
}
