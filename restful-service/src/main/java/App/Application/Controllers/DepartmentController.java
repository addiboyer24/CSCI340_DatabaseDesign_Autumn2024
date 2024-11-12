package App.Application.Controllers;

import App.Domain.Department;
import App.Infrastructure.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/Department")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(@Autowired JdbcTemplate databaseConnection){
        this.departmentRepository = new DepartmentRepository(databaseConnection);
    }
    @GetMapping("/{id}")
    public Department get(@PathVariable("id") String id) throws Exception {
        return this.departmentRepository.get(id);
    }
}
