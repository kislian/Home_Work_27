package sky.pro.Employee.service;

import sky.pro.Employee.model.Employee;

import java.util.Map;

public interface EmployeeService {
    //объявляем три метода
    //возвращать мы будем объект типа Employee
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    //public EmployeeServiceImpl() {     this.employees =new HashMap<>();    }
    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);

    String getEmployeeKey(String firstName, String lastName);
    Map<String,Employee> getAllEmployees();
}
