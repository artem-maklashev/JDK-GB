import java.util.ArrayList;
import java.util.List;

public class EmployeesRepository {
    private final List<Employee> employeeRepository;

    public EmployeesRepository(List<Employee> employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findByExperience(float experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee e :
                employeeRepository) {
            if (e.getExperience() == experience) {
                result.add(e);
            }
        }
        return result;
    }

    public List<String> findPhoneNumbersByName(String name) {
        List<String> result = new ArrayList<>();
        for (Employee e : employeeRepository) {
            if (e.getName().equals(name)) {
                result.addAll(e.getPhoneNumbers());
            }
        }
        return result;
    }

    public Employee findByServiceNumber(String serviceNumber) {
        return employeeRepository.stream().filter(e -> e.getServiceNumber().equals(serviceNumber)).findFirst().orElse(null);
        //        for (Employee e :
//                employeeRepository) {
//            if (e.getServiceNumber().equals(serviceNumber)) {
//                return e;
//            }
//        }
//        return null;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.add(employee);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Employee e :
                employeeRepository) {
            sb.append(e.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
