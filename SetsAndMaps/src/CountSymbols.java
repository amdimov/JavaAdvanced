import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> sentenceMap = new TreeMap<>();
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            Integer occurrence = sentenceMap.get(currentChar);
            if (occurrence == null){
                occurrence = 1;
            }else {
                ++occurrence;
            }
            sentenceMap.put(currentChar, occurrence);
        }
        sentenceMap.forEach((key, value) -> System.out.printf("%s: %d time/s%n", key, value));
    }
}
