package com.order.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableJpaRepositories(basePackages={"com.order.repository"},entityManagerFactoryRef="localEntityManagerFactoryBean")
@EnableTransactionManagement
@PropertySource("classpath:application-local.properties")
public class JpaVendorConfig {
	 	private static final String PROPERTY_NAME_DATABASE_DRIVER = "spring.datasource.driverClassName";
	 	private static final String PROPERTY_NAME_DATABASE_URL = "spring.datasource.url";
	 	private static final String PROPERTY_NAME_DATABASE_USERNAME = "spring.datasource.username";
	 	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "spring.datasource.password";
	    

	    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	    private static final String PROPERTY_NAME_HIBERNATE_ID_NEW_GENERATOR = "hibernate.id.new_generator_mappings";
	    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	  
	    @Resource
	    private Environment environment;

	    @Bean
	    @Order(1)
	    public DataSource dataSource() {

	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        
	        dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
	        dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
	        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
	        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

	        return dataSource;
	    }

	    @Bean
	    @Order(1)
	    public JpaTransactionManager transactionManager() throws ClassNotFoundException {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(localEntityManagerFactoryBean().getObject());
	        return transactionManager;
	    }

	    @Bean
	    @Order(1)
	    public LocalContainerEntityManagerFactoryBean localEntityManagerFactoryBean() throws ClassNotFoundException {
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

	        entityManagerFactoryBean.setDataSource(dataSource());
	        entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
	        //entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
	        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
	        Properties jpaProperties = new Properties();
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL));
	        jpaProperties.put(PROPERTY_NAME_HIBERNATE_ID_NEW_GENERATOR,environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_ID_NEW_GENERATOR));
	        entityManagerFactoryBean.setJpaProperties(jpaProperties);

	        return entityManagerFactoryBean;
	    }
	    
}
