package App.Infrastructure;

import App.Domain.Department;
import App.Domain.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DepartmentRepository extends BaseRepository<Department>{

    public DepartmentRepository(JdbcTemplate databaseConnection){
        super(databaseConnection);
    }

    @Override
    public Department get(String id) throws Exception {
        String sql = "SELECT * FROM DEPARTMENT WHERE Number = " + id + ";";
        List<Department> departments = this.getDatabaseConnection().query(sql, BeanPropertyRowMapper.newInstance(Department.class));
        if (departments.size() == 1) {
            return departments.getFirst();
        }
        throw new Exception();
    }

    @Override
    public List<Department> get() {
        String sql = "SELECT * FROM DEPARTMENT;";
        return this.getDatabaseConnection().query(sql, BeanPropertyRowMapper.newInstance(Department.class));
    }

    @Override
    public void create(Department department) {
        String sql = "SELECT MAX(Number)+1 FROM DEPARTMENT;";
        Integer nextNumber = this.getDatabaseConnection().queryForObject(sql, Integer.class);
        sql = "INSERT INTO DEPARTMENT VALUES (" + nextNumber + ",'" + department.getName() + "','" + department.getManagerSsn() + "','" + department.getStartDate() + "');";
        this.getDatabaseConnection().execute(sql);
    }
}
