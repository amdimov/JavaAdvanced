package RawData;

public class Car {
    private String carName;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;
    private boolean lowPressure;
    private boolean highEnginePower;

    public Car(String[] input){
        this.carName = input[0];
        this.engine = new Engine(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        this.cargo = new Cargo(Integer.parseInt(input[3]), input[4]);
        this.tire = new Tire(extractTirePressure(input), extractTireAge(input));
        //TODO Check again booleans
        this.lowPressure = checkLowPressure(this.tire.getTirePressure());
        this.highEnginePower = checkHighEnginePower(this.engine.getEnginePower());
    }
    private double[] extractTirePressure(String[] input){
        double[] tirePressure = new double[4];
        int index = 0;
        for (int i = 5; i < input.length; i++) {
            if (i % 2 != 0){
                tirePressure[index] = Double.parseDouble(input[i]);
                index++;
            }
        }
        return tirePressure;
    }
    private int[] extractTireAge(String[] input){
        int[] tireAge = new int[4];
        int index = 0;
        for (int i = 6; i < input.length; i++) {
            if (i % 2 == 0){
                tireAge[index] = Integer.parseInt(input[i]);
                index++;
            }
        }
        return tireAge;
    }
    private boolean checkLowPressure(double[] pressure){
        for (double v : pressure) {
            if (v < 1) {
                return true;
            }
        }
        return false;
    }
    private boolean checkHighEnginePower(int engPower){
        return engPower > 250;
    }

    public String getCarName() {
        return carName;
    }

    public Engine getEngine() {
        return engine;
    }

    /**
     * @return {@code Cargo class}
     */
    public Cargo getCargo() {
        return cargo;
    }

    public Tire getTire() {
        return tire;
    }
    /**
     * @return {@code true} if there is a tire lower
     */
    public boolean isLowPressure() {
        return lowPressure;
    }

    public boolean isHighEnginePower() {
        return highEnginePower;
    }

}
