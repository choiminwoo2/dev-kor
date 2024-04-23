package org.ruu.developerkorea.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class MysqlConnectionTest {

    @Test
    public void testConnection() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setUsername("test");
        config.setPassword("1234");

        try (HikariDataSource ds = new HikariDataSource(config);) {
            Connection connection = ds.getConnection();
            Assertions.assertThat(connection).isNotNull();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.assertThat(e).hasCauseInstanceOf(Exception.class);
        }
    }
}
