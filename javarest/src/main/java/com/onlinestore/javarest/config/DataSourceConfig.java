package com.onlinestore.javarest.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource getDataSource() {
		return DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver")
				.url("jdbc:mysql://database.cdm044sim9ew.us-east-1.rds.amazonaws.com:3306/trendyurbano").username("admin")
				.password("adminadmin").build();
	}
}