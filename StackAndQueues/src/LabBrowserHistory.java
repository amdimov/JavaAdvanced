import java.util.ArrayDeque;
import java.util.Scanner;

public class LabBrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> urlStack = new ArrayDeque<>();
        String currentUrl = "";

       while (!input.equals("Home")){
           if (input.equals("back")){
                if (urlStack.isEmpty()){
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }else {
                    currentUrl = urlStack.pop();
                }
           }else {
               if (!currentUrl.equals("")) {
                   urlStack.push(currentUrl);
               }
               currentUrl = input;
           }
           System.out.println(currentUrl);
           input = scanner.nextLine();
       }

    }
}
