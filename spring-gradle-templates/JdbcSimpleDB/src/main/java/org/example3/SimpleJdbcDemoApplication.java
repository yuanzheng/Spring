package org.example3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@SpringBootApplication
@Slf4j
public class SimpleJdbcDemoApplication implements CommandLineRunner {
    @Autowired
    private FooDao fooDao;
    @Autowired
    private BatchFooDao batchFooDao;

    public static void main(String[] args) {
        log.info("Start main .... ");
        SpringApplication.run(SimpleJdbcDemoApplication.class, args);
    }

    @Bean
    @Lazy
    @Autowired
    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
        log.info("Start simpleJdbcInsert .... ");
        return new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("FOO").usingGeneratedKeyColumns("ID");
    }

    @Bean
    @Lazy
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        log.info("Start namedParameterJdbcTemplate .... ");
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start run .....");
        fooDao.insertData();
        batchFooDao.batchInsert();
        fooDao.listData();
    }

}

