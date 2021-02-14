package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        ArrayList<Person> personArrayList = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String addName = tokens[0];
            int addAge = Integer.parseInt(tokens[1]);
            Person person = new Person(addName, addAge);
            personArrayList.add(person);
        }

        personArrayList.stream().filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
        .forEach(e -> System.out.printf("%s - %d%n", e.getName(), e.getAge()));
    }
}
