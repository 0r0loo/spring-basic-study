package com.cho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cho.beans.DataBean3;
import com.cho.beans.DataBean4;
import com.cho.beans.DataBean5;
import com.cho.beans.TestBean3;

@Configuration
@ComponentScan(basePackages="com.cho.beans")
public class BeanConfigClass {

	@Bean
	public DataBean3 obj4() {
		return new DataBean3();
	}
	
	@Bean
	public DataBean3 obj5() {
		return new DataBean3();
	}
	
	@Bean
	public TestBean3 java2() {
		TestBean3 t2 = new TestBean3(200, "문자열2", new DataBean4(), new DataBean5());
		return t2;
	}
}
