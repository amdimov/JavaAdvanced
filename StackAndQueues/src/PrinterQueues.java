import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> prints = new ArrayDeque<>();

        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (prints.isEmpty()){
                    System.out.println("Printer is on standby");
                    input = scanner.nextLine();
                    continue;
                }
                System.out.println("Canceled " + prints.poll());
            }else {
                prints.offer(input);
            }
            input = scanner.nextLine();
        }

        for (String n :
                prints) {
            System.out.println(n);
        }
    }
}
