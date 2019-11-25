package com.test.shardingsphere;

import javax.sql.DataSource;
import org.apache.shardingsphere.shardingjdbc.orchestration.internal.datasource.OrchestrationMasterSlaveDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class);
    }

    @Bean
    @ConditionalOnBean({OrchestrationMasterSlaveDataSource.class})
    @ConditionalOnClass({DataSourceTransactionManager.class})
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
