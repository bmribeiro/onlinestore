package com.onlinestore.javarest.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Bean
	public DataSource getDataSource() {
		return DataSourceBuilder.create().driverClassName("[driver_class_name]").url("[db_url]/[schema]")
				.username("[db_username]").password("[db_password]").build();
	}

}