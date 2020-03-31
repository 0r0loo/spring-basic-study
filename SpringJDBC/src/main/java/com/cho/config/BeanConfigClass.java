package com.cho.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages= {"com.cho.beans","com.cho.db"})
public class BeanConfigClass {

	// DataSource
	@Bean
	public BasicDataSource source() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("oracle.jdbc.OracleDriver");
		source.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		source.setUsername("scott");
		source.setPassword("tiger");
		
		return source;
	}
	
	
	// 데이터 베이스 접속해서 쿼리를 전달하는 빈을 등록한다.
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		JdbcTemplate db = new JdbcTemplate(source);
		return db;
	}
}
