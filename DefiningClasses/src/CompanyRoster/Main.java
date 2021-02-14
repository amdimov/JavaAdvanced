package CompanyRoster;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departmentMap = new TreeMap<>();
        double bestAvarage = Integer.MIN_VALUE;
        String tempBestDepartment = "";
        for (int i = 0; i < N; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = null;
            Department depObj = departmentMap.get(department);
            if(tokens.length == 4){
                employee = new Employee(name, salary, position, department);
            }else if (tokens.length == 5){
                if(Character.isDigit(tokens[4].charAt(0))) {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                }else{
                    String email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }else{
                if (tokens[5].matches("^[\\d]+$")) {
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                }

            }

            if (depObj == null){
                depObj = new Department(employee);
            }else {
                depObj.addEmployee(employee);
            }
            depObj.setDepartmentSalaray(salary);
            depObj.setAvarage();
            departmentMap.put(department, depObj);
            if (depObj.getAvarage() > bestAvarage){
                bestAvarage = depObj.getAvarage();
                tempBestDepartment = depObj.getBestDepartment();
            }
        }
        final String bestDepartment = tempBestDepartment;

        System.out.println("Highest Average Salary: " + bestDepartment);
        departmentMap.get(bestDepartment).getDepartmentList()
                .stream()
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .forEach(e -> System.out.printf("%s %.2f %s %d%n"
                        , e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
    }
}
