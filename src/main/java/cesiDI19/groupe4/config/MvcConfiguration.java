package cesiDI19.groupe4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@ComponentScan(basePackages="cesiDI19.groupe4")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean  
	public javax.sql.DataSource dataSource() 
	    {  
 
	        MysqlDataSource dataSource2 = new MysqlDataSource();
	        dataSource2.setUrl("jdbc:mysql://mysql-louvel.alwaysdata.net/louvel_crmjava?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC");
	        dataSource2.setUser("louvel");
	        dataSource2.setPassword("Vuxec654");
	        return dataSource2;
	      
	    }

	 @Bean  
	 public JdbcTemplate jdbcTemplate(final javax.sql.DataSource dataSource) 
	    {  
	        final JdbcTemplate jdbcTemplate= new JdbcTemplate();
	        jdbcTemplate.setDataSource(dataSource);
	        return jdbcTemplate;
	    }
	
}
