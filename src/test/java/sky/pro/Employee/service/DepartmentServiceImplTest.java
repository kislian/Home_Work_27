package sky.pro.Employee.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.Employee.model.Employee;
import sky.pro.Employee.service.impl.DepartmentServicesImpl;
import sky.pro.Employee.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    private final List<Employee> employeeList=new ArrayList()
    {{
        add(new Employee("Ivan", "Petrov1", 100_000, 1));
        add(new Employee("Ivan", "Petrov2", 200_000, 1));
        add(new Employee("Ivan", "Petrov3", 300_000, 1));
        add(new Employee("Ivan", "Petrov4", 100_000, 2));
        add(new Employee("Ivan", "Petrov5", 100_000, 3));
        }};
    private final Map<String,Employee> employees= new HashMap<>();
    @BeforeEach
    public void initMap(){
        for (Employee employee:employeeList){
            employees.put(employee.getFirstName()+employee.getLastName(),employee);
        }
    }
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServicesImpl departmentServices;
    @Test
    public void shouldGetEmployees() {
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        List<Employee> expectedEmployees = List.of(employeeList.get(0), employeeList.get(1), employeeList.get(2));
        List<Employee> actualEmployees = departmentServices.getEmployees(departmentId);
        Assertions.
                assertThat(actualEmployees).
                containsExactlyInAnyOrderElementsOf(expectedEmployees);
    }

    public void shouldGetSalarySum() {
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        Integer expectedSalarySum = employeeList.get(0).getSalary() + employeeList.get(1).getSalary() + employeeList.get(2).getSalary();
        Integer actualSalarySum = departmentServices.getSalarySum(departmentId);
        Assertions.
                assertThat(actualSalarySum).
                isEqualTo(expectedSalarySum);
    }
    public void shouldGetSalaryMin() {
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        Employee expectedEmpoyeeWithMinSalary = employeeList.get(0);
        Employee actualEmpoyeeWithMinSalary = departmentServices.getEmployeeWithMinSalary(departmentId);
        Assertions
                .assertThat(actualEmpoyeeWithMinSalary)
                .isEqualTo(expectedEmpoyeeWithMinSalary);
    }
    public void shouldGetSalaryMax() {
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        Employee expectedEmpoyeeWithMaxSalary = employeeList.get(2);
        Employee actualEmpoyeeWithMaxSalary = departmentServices.getEmployeeWithMaxSalary(departmentId);
        Assertions
                .assertThat(actualEmpoyeeWithMaxSalary)
                .isEqualTo(expectedEmpoyeeWithMaxSalary);
    }
    @Test
    public void shouldGetGroupedByDepartmentEmployees(){
        Map<Integer,List<Employee>> expectedGroupedEmployees=new HashMap<>(){{
            put(1,List.of(employeeList.get(0),employeeList.get(1),employeeList.get(2)));
            put(2,List.of(employeeList.get(3)));
            put(3,List.of(employeeList.get(4)));
        }};
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        Map<Integer,List<Employee>> actualGroupedEmployees=departmentServices.getGroupedByDepartmentEmployees();
        Assertions.assertThat(actualGroupedEmployees).isEqualTo(expectedGroupedEmployees);
    }
}
