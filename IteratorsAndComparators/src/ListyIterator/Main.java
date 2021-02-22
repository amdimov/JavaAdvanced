package ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ListyIterator listyIterator = null;
        while (!input[0].equalsIgnoreCase("END")){
            switch (input[0]){
                case "Create":
                    listyIterator = new ListyIterator(getValues(input));
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
            input = scanner.nextLine().split("\\s+");
        }
    }
    private static String[] getValues(String[] input){
        return Arrays.copyOfRange(input, 1, input.length);
    }
}
