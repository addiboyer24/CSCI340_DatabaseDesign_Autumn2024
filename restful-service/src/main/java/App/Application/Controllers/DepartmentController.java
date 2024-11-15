package App.Application.Controllers;

import App.Domain.Department;
import App.Infrastructure.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// URI uniform resource identifier
// http://localhost:8080/Department/1 (GET)
// http://localhost:8080/Department (POST) {}
// http://localhost:8080/Department/1 (DELETE)

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

    @GetMapping("")
    public List<Department> getAllDepartments(){
        return this.departmentRepository.get();
    }

    @PostMapping("")
    public void create(@RequestBody() Department department){
        this.departmentRepository.create(department);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        this.departmentRepository.delete(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable("id") String id, @RequestBody() Department department) throws Exception {
        Department existingDepartment = this.departmentRepository.get(id);
        existingDepartment.setName(department.getName());
        existingDepartment.setManagerSsn(department.getManagerSsn());
        existingDepartment.setStartDate(department.getStartDate());

        this.departmentRepository.update(id, existingDepartment);
    }

}
