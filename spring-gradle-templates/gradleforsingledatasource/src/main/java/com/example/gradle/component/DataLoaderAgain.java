package com.example.gradle.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@Slf4j
public class DataLoaderAgain implements CommandLineRunner {

    @Resource
    private DataSource dataSource;

    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    private void showConnection() throws SQLException {
        log.info("Dataloader: " + dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info("Dataloader connection: " + conn.toString());
        conn.close();
    }

    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM FOO")
                .forEach(row -> log.info(row.toString()));
    }

}
