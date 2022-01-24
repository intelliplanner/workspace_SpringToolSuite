package com.ipssi.ppgcl.dbconfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "userEntityManager", 
		transactionManagerRef = "userTransactionManager", 
		basePackages = "com.ipssi.ppgcl.repository"
)
public class DataSourceConfig1 {
	@Autowired Environment env;
	@Bean
	@ConfigurationProperties(prefix = "spring.user.datasource")
	public DataSource postgresqlDataSource() {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName(env.getProperty("spring.user.datasource.driver-class-name"));
		    dataSource.setUrl(env.getProperty("spring.user.datasource.jdbc-url"));
		    dataSource.setUsername(env.getProperty("spring.user.datasource.username"));
		    dataSource.setPassword(env.getProperty("spring.user.datasource.password"));
		    Properties prop = new Properties();
		    prop.put("initialSize", env.getProperty("spring.user.datasource.dbcp2.initial-size"));
		    prop.put("maxTotal", env.getProperty("spring.user.datasource.dbcp2.max-total"));
		    prop.put("poolPreparedStatements", env.getProperty("spring.user.datasource.dbcp2.pool-prepared-statements"));
		    dataSource.setConnectionProperties(prop);
		return DataSourceBuilder
					.create()
					.build();
	}

	@Bean(name = "userEntityManager")
	public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(postgresqlDataSource())
					.properties(hibernateProperties())
					.packages("com.ipssi.ppgcl.entity")
					.persistenceUnit("userPU")
					.build();
	}

	@Bean(name = "userTransactionManager")
	public PlatformTransactionManager postgresqlTransactionManager(@Qualifier("userEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map hibernateProperties() {

		Resource resource = new ClassPathResource("application.properties");
		
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			
			return properties.entrySet().stream()
											.collect(Collectors.toMap(
														e -> e.getKey().toString(),
														e -> e.getValue())
													);
		} catch (IOException e) {
			return new HashMap();
		}
	}
}
