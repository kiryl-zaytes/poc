package uk.ee.framework.business_objects.dao;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hsqldb.jdbc.JDBCDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

/**
 * Created by kiryl_zayets on 1/11/16.
 */

@Configuration
@EnableJpaRepositories
public class JpaConfig {

    @Value("${database.url}")
    String dbUrl;

    @Value("${database.user}")
    String dbUser;

    @Value("${database.password}")
    String dbPassword;

    @Value("${db.init.source}")
    String dbSource;

    @Value("${db.init.action}")
    String dbAction;


    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(JDBCDriver.class.getName());
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emFactory = new
                LocalContainerEntityManagerFactoryBean();
        emFactory.setDataSource(getDataSource());
        emFactory.setPersistenceProviderClass(HibernatePersistenceProvider
                .class);
        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect" +
                ".HSQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("javax.persistence.schema-generation.database" +
                ".action", dbAction); //"none"  "drop-and-create"
        properties.setProperty("javax.persistence.sql-load-script-source", dbSource);
        emFactory.setJpaProperties(properties);
        emFactory.setPackagesToScan("uk.ee.framework.business_objects");
        return emFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new
                JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory()
                .getObject());
        return jpaTransactionManager;
    }
}
