import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {
    private final String serviceNumber;
    private final String name;
    private final Set<String> phoneNumbers;
    private final Float experience;

    public Employee(String serviceNumber, String name, float experience) {
        this.serviceNumber = serviceNumber;
        this.name = name;
        this.phoneNumbers = new HashSet<>();
        this.experience = experience;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public String getName() {
        return name;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Float getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee{" + "serviceNumber='" + serviceNumber + '\'' + ", name='" + name + '\'' + ", " +
                "phoneNumbers=" + phoneNumbers + ", experience=" + experience + "}";
    }
}