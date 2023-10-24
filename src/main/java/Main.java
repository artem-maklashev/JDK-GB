import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("1", "John", 2.5f);
        Employee e2 = new Employee("2", "Mary", 3.5f);
        Employee e3 = new Employee("3", "John", 4.5f);
        Employee e4 = new Employee("4", "Jane", 5.5f);
        e1.addPhoneNumber("123");
        e2.addPhoneNumber("456");
        e3.addPhoneNumber("789");
        e4.addPhoneNumber("101112");
        e1.addPhoneNumber("131415");

        EmployeesRepository employeesRepository = new EmployeesRepository();
        employeesRepository.addEmployee(e1);
        employeesRepository.addEmployee(e2);
        employeesRepository.addEmployee(e3);
        employeesRepository.addEmployee(e4);

        //Поиск сотрудника по стажу
        System.out.println("сотрудники со стажем 2.5 лет");
        employeesRepository.findByExperience(2.5f).forEach(System.out::println);
        //Вывод номера телефона сотрудника по имени
        System.out.println("номера телефона сотрудников  с именем John");
        employeesRepository.findPhoneNumbersByName("John").forEach(System.out::println);
        //Поиск сотрудника по табельному номеру
        System.out.println("сотрудник с табельным номером 2");
        System.out.println(employeesRepository.findByServiceNumber("2"));
        //Добавление нового сотрудника
        System.out.println("справочник до добавления сотрудника");
        System.out.println(employeesRepository);
        Employee e5 = new Employee("5", "Jack", 2.5f);
        employeesRepository.addEmployee(e5);
        System.out.println("справочник после добавления сотрудника");
        System.out.println(employeesRepository);
        //Поиск сотрудника по стажу
        System.out.println("сотрудники со стажем 2.5 лет");
        employeesRepository.findByExperience(2.5f).forEach(System.out::println);
    }
}
