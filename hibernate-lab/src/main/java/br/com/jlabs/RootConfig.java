/**
 * 
 */
package br.com.jlabs;

import java.util.Properties;

import javax.naming.NamingException;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.jlabs.core.orm.H2Dialect;

/**
 * @author sebastiao.santos
 *
 */
@Configuration
@EnableTransactionManagement( mode = AdviceMode.PROXY )
@ComponentScan( 
		basePackages = {"br.com.jlabs.business"}
	)
public class RootConfig {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	public Environment env;

	@Bean
	public TransactionAwareDataSourceProxy orDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:mem:jlabstestdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
		ds.setUsername("sa");
		ds.setPassword("");
		
		return new TransactionAwareDataSourceProxy( ds );
	}

//  USADO NO INFRA-BATCH
//	@Bean
//	public SpringBeanJobFactory springBeanJobFactory() {
//		AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
//
//		jobFactory.setApplicationContext(applicationContext);
//		return jobFactory;
//	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory( sessionFactory );
		return transactionManager;
	}
	
	@Bean
	@Autowired
	public AnnotationSessionFactoryBean sessionFactory() throws NamingException {
		
		AnnotationSessionFactoryBean factoryBean = new AnnotationSessionFactoryBean();
		factoryBean.setDataSource( orDataSource() );
		factoryBean.setPackagesToScan( new String[] {"br.com.jlabs.model"});
		factoryBean.setHibernateProperties( hibernateProperties() );

		factoryBean.setEntityInterceptor( new EventInterceptor() );

		return factoryBean;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		
        properties.put("hibernate.bytecode.use_reflection_optimizer", "true");
        properties.put("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
        properties.put("hibernate.cache.provider_configuration_file_resource_path", "ehcache-model.xml");
        properties.put("hibernate.cache.use_query_cache", "true");
        properties.put("hibernate.cache.use_second_level_cache", "true");
        properties.put("hibernate.dialect", H2Dialect.class.getCanonicalName() );
        properties.put("hibernate.jdbc.fetch_size", "200");
        properties.put("hibernate.jdbc.use_get_generated_keys", "true");
        properties.put("hibernate.max_fetch_depth", "100");
        properties.put("hibernate.show_sql", "true" );
        properties.put("hibernate.jdbc.use_scrollable_resultset", "true" );

        // Thread bound transaction
//        properties.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory" );
//        properties.put("hibernate.current_session_context_class", "thread" );
        
		return properties;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer() throws NamingException {
	    final DataSourceInitializer initializer = new DataSourceInitializer();
	    initializer.setDataSource(orDataSource());
	    initializer.setDatabasePopulator(databasePopulator());
	    return initializer;
	}

	private DatabasePopulator databasePopulator() {
	    final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.addScript(new ClassPathResource("ddl.sql"));
	    populator.addScript(new ClassPathResource("dml.sql"));
	    return populator;
	}
	
}
