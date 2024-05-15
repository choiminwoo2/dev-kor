package org.ruu.developerkorea.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class InMemoryConnectionTest {

    @Test
    public void testConnection() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        config.setUsername("sa");

        try (HikariDataSource ds = new HikariDataSource(config);) {
            Connection connection = ds.getConnection();
            Assertions.assertThat(connection).isNotNull();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assertions.assertThat(e).hasCauseInstanceOf(Exception.class);
        }
    }
}
