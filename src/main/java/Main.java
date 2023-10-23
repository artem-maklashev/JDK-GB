import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("1", "John", 2.5f);
        Employee e2 = new Employee("2", "Mary", 3.5f);
        Employee e3 = new Employee("3", "Bob", 4.5f);
        Employee e4 = new Employee("4", "Jane", 5.5f);
        e1.addPhoneNumber("123");
        e2.addPhoneNumber("456");
        e3.addPhoneNumber("789");
        e4.addPhoneNumber("101112");
        e1.addPhoneNumber("131415");
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        EmployeesRepository employeesRepository = new EmployeesRepository(employees);

        //Поиск сотрудника по стажу
        System.out.println(employeesRepository.findByExperience(2.5f));
        //Вывод номера телефона сотрудника по имени
        System.out.println(employeesRepository.findPhoneNumbersByName("John"));
        //Поиск сотрудника по табельному номеру
        System.out.println(employeesRepository.findByServiceNumber("2"));
        //Добавление нового сотрудника
        System.out.println("справочник до добавления сотрудника");
        System.out.println(employeesRepository.toString());
        Employee e5 = new Employee("5", "Jack", 1.5f);
        employeesRepository.addEmployee(e5);
        System.out.println("справочник после добавления сотрудника");
        System.out.println(employeesRepository.toString());

    }
}
