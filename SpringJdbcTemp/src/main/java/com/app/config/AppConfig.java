package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("jdbc.properties")
public class AppConfig {
	@Autowired
	private Environment env;
	@Bean
	public DriverManagerDataSource dsObj() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("dc"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("un"));
		ds.setPassword(env.getProperty("pwd"));
		return ds;
	}
	@Bean
	public JdbcTemplate jtObj() {
		JdbcTemplate j=new JdbcTemplate();
		j.setDataSource(dsObj());
		return j;
	}
}

