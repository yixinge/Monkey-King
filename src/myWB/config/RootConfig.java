package myWB.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"myWB"},excludeFilters= {@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
@MapperScan(basePackages = "myWB.dao")
public class RootConfig {
	@Autowired
	Environment env;
	@Bean
	public DataSource dataSource() {
//		ComboPooledDataSource dSource = new ComboPooledDataSource();
//		dSource.setDriverClass(driverClass);
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/hrm_db3?useUnicode=true&amp;characterEncoding=UTF-8");
		ds.setUsername("root");
		ds.setPassword("123456");
		ds.setInitialSize(2);
		ds.setMaxTotal(10);
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		sqlSessionFactoryBean.setConfiguration(configuration);
		return sqlSessionFactoryBean;
	}
	
	@Bean
	DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager dstm = new DataSourceTransactionManager();
		dstm.setDataSource(dataSource);
		return dstm;
	}
	
	@Bean
	MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
