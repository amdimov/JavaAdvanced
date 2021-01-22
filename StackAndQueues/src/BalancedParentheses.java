import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> leftStack = new ArrayDeque<>();
        ArrayDeque<Character> rightQueue = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if (i + 1 > input.length()/2){
                rightQueue.offer(input.charAt(i));
            }else {
                leftStack.push(input.charAt(i));
            }
        }
        if (leftStack.isEmpty() || rightQueue.isEmpty()){
            System.out.println("NO");
            return;
        }
        Map<Character, Character> combinationsMap = new HashMap<>();
        combinationsMap.put('(', ')');
        combinationsMap.put('[', ']');
        combinationsMap.put('{', '}');

        boolean isItValid = false;
        for (int i = 0; i < input.length()/2; i++) {
            char atLeft = leftStack.pop();
            char atRight = rightQueue.poll();
            Character getRightFromMap = combinationsMap.get(atLeft);
            if (getRightFromMap == null){
                isItValid = false;
                break;
            }
            if (getRightFromMap == atRight){
                isItValid = true;
            }else {
                isItValid = false;
                break;
            }
        }
        if (isItValid){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
