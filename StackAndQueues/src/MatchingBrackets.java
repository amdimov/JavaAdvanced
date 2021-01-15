import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Integer> resultStack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '('){
                resultStack.push(i);

            }else if(currentChar == ')'){
                System.out.println(expression.substring(resultStack.pop(), i+1));
            }

        }
    }
}
