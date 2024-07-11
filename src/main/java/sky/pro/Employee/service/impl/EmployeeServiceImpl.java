package sky.pro.Employee.service.impl;

import jakarta.annotation.PostConstruct;
import sky.pro.Employee.exception.EmployeeAllreadyAddException;
import sky.pro.Employee.exception.EmployeeNoFoundException;
import sky.pro.Employee.exception.EmployeeStorageIsFullException;
import sky.pro.Employee.model.Employee;
import sky.pro.Employee.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    private final int EMPLOYEES_STORAGE_SIZE=5;
    private final Map<String,Employee> employees=new HashMap<>();
    @PostConstruct
    private void init(){
        addEmployee("Ivan","Petrov1",100_000,1);
        addEmployee("Ivan","Petrov2",200_000,1);
        addEmployee("Ivan","Petrov3",300_000,1);
    }


    //public EmployeeServiceImpl() {     this.employees =new HashMap<>();    }
    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department){
                String employeeKey=getEmployeeKey(firstName,lastName);
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAllreadyAddException("Сотрудник уже есть в хранилище");
        }
        if (employees.size()==EMPLOYEES_STORAGE_SIZE){
            throw new EmployeeStorageIsFullException("Хранилище полное!");
        }
       employees.put(
            employeeKey,
        new Employee(firstName, lastName, salary, department)
       );
        return employees.get(employeeKey);
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String employeeKey=getEmployeeKey(firstName,lastName);
        if(!employees.containsKey(employeeKey)){
            throw new EmployeeNoFoundException("Такого сотрудника нет в хранилище!");
        }
        employees.remove(employeeKey);
        return null;
    }
    @Override
    public Map<String,Employee> getAllEmployees(){
        return employees;
    }
    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if(!employees.containsKey(employeeKey)){
            throw new EmployeeNoFoundException("Такого сотрудника нет в хранилище!");
        }

        return employees.get(employeeKey);
    }
    @Override
    public String getEmployeeKey(String firstName, String lastName){
        return firstName +lastName;    }
}
