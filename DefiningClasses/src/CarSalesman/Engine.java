package CarSalesman;

import java.util.Map;

public class Engine {
    //Engine - "<Model> <Power>     <Displacement> <Efficiency>"
    //           V4-33    140            28             B
    private String model;
    private int power;
    //TODO parse displacement
    private String dispacement;
    private String efficiency;

    public Engine(String model, int power, String dispacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.dispacement = dispacement;
        this.efficiency = efficiency;
    }
    public Engine(String model, int power, String thirdValue){
        this.model = model;
        this.power = power;
        if (thirdValue.matches("^[0-9]+$")){
            this.dispacement = thirdValue;
            this.efficiency = "n/a";
        }else {
            this.dispacement = "n/a";
            this.efficiency = thirdValue;
        }
    }
    public Engine(String model, int power) {
        this(model, power, "n/a", "n/a");
    }

    @Override
    public String toString() {
        return String
                .format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%n"
                        , model, power, dispacement, efficiency);

    }
}
