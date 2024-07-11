package sky.pro.Employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.Employee.model.Employee;
import sky.pro.Employee.service.EmployeeService;

import java.util.Map;

@RestController
//если есть общая часть пути
@RequestMapping("/employee")
public class EmployeeController {
    //реализуем поле по которому будет инжектиться наш сервис
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstname") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") Integer salary,
                                @RequestParam("department") Integer department
    ) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }


    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }
    //список всех сотрудников
    //возвращаем родительский тип листа
    @GetMapping
    //public Collection<Employee> findAll(){        return employeeService.findAll();    }
    public Map<String, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
