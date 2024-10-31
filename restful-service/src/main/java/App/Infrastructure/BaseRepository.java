package App.Infrastructure;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseRepository<Item> {
    private final JdbcTemplate databaseConnection;
    public BaseRepository(JdbcTemplate databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    public abstract Item get(String id) throws Exception;

    public JdbcTemplate getDatabaseConnection(){
        return this.databaseConnection;
    }
}
