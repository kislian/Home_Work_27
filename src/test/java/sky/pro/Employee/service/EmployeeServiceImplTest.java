package sky.pro.Employee.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.Employee.exception.EmployeeAllreadyAddException;
import sky.pro.Employee.exception.EmployeeNoFoundException;
import sky.pro.Employee.exception.EmployeeStorageIsFullException;
import sky.pro.Employee.model.Employee;
import sky.pro.Employee.service.impl.EmployeeServiceImpl;

public class EmployeeServiceImplTest {
    private  EmployeeServiceImpl employeeService;
    @BeforeEach
    public void clear(){
        employeeService=new EmployeeServiceImpl();
    }
    private final int EMPLOYEES_STORAGE_SIZE=5;
   @Test
   public void shouldCorrectlyAddEmployee(){
       Employee expectedEmployee =new Employee("Ivan", "Petrov", 100_000, 1);
       Employee actialEmployee =employeeService.addEmployee(
               expectedEmployee.getFirstName(),
               expectedEmployee.getLastName(),
               expectedEmployee.getSalary(),
               expectedEmployee.getDepartment()
       );
       Assertions.assertEquals(expectedEmployee,actialEmployee);
   }
    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenSuchEmployeeIsAlreadyPresented() {
        employeeService.addEmployee("Ivan", "Petrov", 100_000, 1);
        Assertions.assertThrows(
                EmployeeAllreadyAddException.class,
        () -> employeeService.addEmployee("Ivan", "Petrov", 100_000, 1)
      );
    }
    @Test
    public void shouldThrowEmployeeStorageIsFullExceptionWhenStorageIsFull(){
       for(int i=0;i<EMPLOYEES_STORAGE_SIZE;i++){
           employeeService.addEmployee("Ivan"+i, "Petrov", 100_000, 1);
       }
      Assertions.assertThrows(
              EmployeeStorageIsFullException.class,
              ()->employeeService.addEmployee("Ivan", "Petrov", 100_000, 1)
      );
    }
   @Test
    public void shouldTrowEmployeeNotFoundExceptionWhenThereIsNoSuchEmployeeDuringRemoving(){
        Assertions.assertThrows(
                EmployeeNoFoundException.class,
                ()->employeeService.removeEmployee("Ivan","Petrov")
        );
     }
    @Test
     public void shouldTrowEmployeeNotFoundExceptionWhenThereIsNoSuchEmployeeDuringFinding(){
        Assertions.assertThrows(
                EmployeeNoFoundException.class,
                ()->employeeService.findEmployee("Ivan","Petrov")
        );
    }
    @Test
    public void shouldFindEmployee(){
        Employee expectedEmployee =employeeService.addEmployee("Ivan", "Petrov", 100_000, 1);
        Employee actualEmployee=employeeService.findEmployee(expectedEmployee.getFirstName(),expectedEmployee.getLastName());
        Assertions.assertEquals(expectedEmployee,actualEmployee);
    }

}
