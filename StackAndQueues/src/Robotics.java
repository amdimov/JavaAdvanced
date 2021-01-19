import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");
        String[] timeInput = scanner.nextLine().split(":");

        ArrayDeque<String> productFlowQueue = new ArrayDeque<>();

        String[] robotNames = new String[input.length];
        int[] robotTime = new int[input.length];
        int[] processTime = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            robotNames[i] = input[i].split("-")[0];
            robotTime[i] = Integer.parseInt(input[i].split("-")[1]);
        }
        
        int timeInSeconds = (Integer.parseInt(timeInput[0]) * 3600) + (Integer.parseInt(timeInput[1]) * 60) + (Integer.parseInt(timeInput[2]));

        String productInput = scanner.nextLine();
        while (!productInput.equals("End")){
            productFlowQueue.offer(productInput);
            productInput = scanner.nextLine();
        }
        int time = 0;
        while (!productFlowQueue.isEmpty()){
            time++;
            String currentProduct = productFlowQueue.poll();
            boolean isItBusy = false;

            for (int i = 0; i < input.length; i++) {
                if (processTime[i] == 0 && !isItBusy){
                    processTime[i] = robotTime[i];
                    printTask(robotNames[i], time + timeInSeconds, currentProduct);
                    isItBusy = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }
            if (!isItBusy){
                productFlowQueue.offer(currentProduct);
            }
        }
    }
    private static void printTask(String robot, int time, String product) {
        int hours = (time / 3600) % 24;
        int minutes = time % 3600 / 60;
        int seconds = time % 60;

        DecimalFormat df = new DecimalFormat("00");
        System.out.println(String.format("%s - %s [%s:%s:%s]", robot, product,
                df.format(hours), df.format(minutes), df.format(seconds)));
    }
}
