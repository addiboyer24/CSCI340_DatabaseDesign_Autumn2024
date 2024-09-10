package App.Infrastructure;

import App.Domain.IStudentRepository;
import App.Domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.PreparedStatement;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private JdbcTemplate databaseConnection;

    public void setDatabaseConnection(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }
    @Override
    public Student create(Student student) {
        return student;
    }

    @Override
    public int update(Student student) {
        int rows = this.databaseConnection.update("UPDATE Student SET name = " + student.getName() + "WHERE id = " + student.getName());
        return rows;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Student WHERE Id = " + id + ";";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public Student get(int id) throws Exception {
        String sql = "SELECT * FROM STUDENT WHERE Id = " + id + ";";
        List<Student> students = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
        if (students.size() == 1){
            return students.get(0);
        }
        throw new Exception();
    }

    @Override
    public List<Student> get() {
        String sql = "SELECT * FROM STUDENT;";
        List<Student> students = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
        return students;
    }
}
