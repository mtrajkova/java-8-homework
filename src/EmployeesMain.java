import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesMain {
    public static void main(String[] args) {
        List<Employee> employeeList = GenerateEmployees.generateEmployees(30);

        System.out.println("NUMBER OF BITOLA EMPLOYEES WITH SALARY > 800");
        System.out.println(employeeList.stream().filter(e -> e.getCity().equals("Bitola") && e.getSalary() > 800).count());

        System.out.println("\nTOTAL SALARY OF SKOPJE EMLOYEES");
        int salary = employeeList.stream().filter(e -> e.getCity().equals("Skopje")).mapToInt(Employee::getSalary).sum();
        System.out.println(salary);

        System.out.println("\nEMPLOYEES SORTED BY SALARY");
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList()).forEach(System.out::println);


        System.out.println("\nEMPLOYEE FROM SKOPJE WITH THE LARGEST SALARY");
        Employee richestSkopjeEmployee = employeeList.stream().filter(e -> e.getCity().equals("Skopje")).sorted(Comparator.comparingInt(Employee::getSalary).reversed()).findFirst().get();
        //OR
        employeeList.stream().filter(e -> e.getCity().equals("Skopje")).max(Comparator.comparingInt(Employee::getSalary)).ifPresent(e -> System.out.println(e.getSalary()));
        System.out.println(richestSkopjeEmployee.getSalary());
    }

}
