package App.Infrastructure;

import App.Domain.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository extends BaseRepository<Employee> {


    public EmployeeRepository(JdbcTemplate databaseConnection){
        super(databaseConnection);
    }

    @Override
    public Employee get(String id) throws Exception {
        String sql = "SELECT * FROM EMPLOYEE WHERE Ssn = '" + id + "'";
        List<Employee> employees = this.getDatabaseConnection().query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
        if (employees.size() == 1){
            return employees.getFirst();
        }
        throw new Exception();
    }

    public Integer getNumberOfEmployees(String id){
        String sql = "SELECT COUNT(*) FROM EMPLOYEE WHERE Ssn = '" + id + "'";
            return this.getDatabaseConnection().queryForObject(sql, Integer.class);
    }

    @Override
    public List<Employee> get() {
        String sql = "SELECT * FROM EMPLOYEE;";
        return this.getDatabaseConnection().query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public void create(Employee employee) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(String id, Employee employee) {

    }
}
