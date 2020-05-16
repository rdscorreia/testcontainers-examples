package it.robfrank.testcontainers;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaSingletonContainerTest extends JavaSingletonContainerTemplate {
    
    
    @Test
    void someTestMethod() throws SQLException {
        var conn = DriverManager.getConnection(POSTGRE_SQL_CONTAINER.getJdbcUrl(),
                POSTGRE_SQL_CONTAINER.getUsername(),
                POSTGRE_SQL_CONTAINER.getPassword());
        
        var stmt = conn.createStatement();
        stmt.execute("SELECT 1");
        
        var resultSet = stmt.getResultSet();
        resultSet.next();
        
        assertThat(resultSet.getInt(1)).isEqualTo(1);
        
        
    }
}
