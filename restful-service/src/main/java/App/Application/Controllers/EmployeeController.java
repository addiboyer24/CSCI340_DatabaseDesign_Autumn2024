package App.Application.Controllers;

import App.Domain.Employee;
import App.Infrastructure.EmployeeRepository;
import App.Infrastructure.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/Employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController( @Autowired JdbcTemplate databaseConnection){
        this.employeeRepository = new EmployeeRepository(databaseConnection);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable("id") String id) throws Exception {
        return this.employeeRepository.get(id);
    }

}
