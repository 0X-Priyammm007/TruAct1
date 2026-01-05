package com.truact.config;

import com.truact.dao.FraudAlertDao;
import com.truact.dao.TransactionDao;
import com.truact.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    // DataSource will be auto-configured by Spring Boot from application.properties

    @Bean
    @SuppressWarnings("null")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @SuppressWarnings("null")
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public UserDao userDao(JdbcTemplate jdbcTemplate) {
        return new UserDao(jdbcTemplate);
    }

    @Bean
    public TransactionDao transactionDao(JdbcTemplate jdbcTemplate) {
        return new TransactionDao(jdbcTemplate);
    }

    @Bean
    public FraudAlertDao fraudAlertDao(JdbcTemplate jdbcTemplate) {
        return new FraudAlertDao(jdbcTemplate);
    }
}