package com.ssafy.board.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@ComponentScan(basePackages = {"com.ssafy"})
public class applicationConfig {
	
	@Bean
	public DataSource getDataSource() {
		SimpleDriverDataSource SDDS = new SimpleDriverDataSource();
		
		SDDS.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		SDDS.setUrl("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8");
		SDDS.setUsername("ssafy");
		SDDS.setPassword("ssafy");
		
		// SDDS를 Bean으로 등록
		return SDDS;
	}
	
}
