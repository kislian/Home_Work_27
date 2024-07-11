package sky.pro.Employee.model;

import java.util.Objects;

public class Employee {
    //оздаём две приватные стринговые переменные
    private final String  firstName;
    private final String  lastName;
    private final Integer  salary;

    private final Integer  department;
//создаём конструктор чтоб иметь возможность  их заполнять
    public Employee(String firstName, String lastName, Integer salary, Integer department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    //геттеры чтоб иметь лоступ к полям

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }
}
