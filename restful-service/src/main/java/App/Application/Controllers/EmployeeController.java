package App.Application.Controllers;

import App.Domain.Employee;
import App.Infrastructure.EmployeeRepository;
import App.Infrastructure.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController( @Autowired JdbcTemplate databaseConnection){
        this.employeeRepository = new EmployeeRepository(databaseConnection);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") String id) throws Exception {
        Integer numberOfEmployees = this.employeeRepository.getNumberOfEmployees(id);
        if (numberOfEmployees == 1){
            return this.employeeRepository.get(id);
        }
        throw new Exception();
    }

    @GetMapping("")
    public List<Employee> getEmployees(@RequestParam(value = "fName", required = false, defaultValue = "") String fName){
        List<Employee> employees = this.employeeRepository.get();
        if (!"".equals(fName)){
            employees.removeIf(x -> !x.getFName().equals(fName));
        }

        return employees;
    }

}
