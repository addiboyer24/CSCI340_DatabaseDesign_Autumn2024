package App.Application.Controllers;

import App.Domain.Student;
import App.Infrastructure.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private StudentRepository studentRepository;

    public StudentController(){
        this.studentRepository = new StudentRepository();
    }


    @PostMapping("/")
    public void create(@RequestBody() List<Student> students)
    {
        for (Student student : students){
            this.studentRepository.create(student);
        }
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") @RequestBody() int id, Student student){
    }
    @GetMapping("/{id}")
    public Student get(@PathVariable("id") int id) throws Exception {
        this.studentRepository.setDatabaseConnection(this.databaseConnection);
        return this.studentRepository.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        this.studentRepository.setDatabaseConnection(this.databaseConnection);
        this.studentRepository.delete(id);
    }

    @GetMapping("/")
    public List<Student> get(){
        this.studentRepository.setDatabaseConnection(this.databaseConnection);
        return this.studentRepository.get();
    }
}
