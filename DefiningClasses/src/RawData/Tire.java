package RawData;

public class Tire {
    private double[] tirePressure;
    private int[] tireAge;

    public Tire(double[] tirePressure, int[] tireAge) {
        try {
            this.tirePressure = new double[4];
            this.tireAge = new int[4];
            this.tirePressure = tirePressure;
            this.tireAge = tireAge;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Tire constructor problem - " + e.getMessage());
        }
    }

    public double[] getTirePressure() {
        return tirePressure;
    }

    public int[] getTireAge() {
        return tireAge;
    }
}
