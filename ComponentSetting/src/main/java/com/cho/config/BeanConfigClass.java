package com.cho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cho.beans.TestBean2;
import com.cho.beans.TestBean3;

@Configuration
@ComponentScan(basePackages="com.cho.beans")
public class BeanConfigClass {
	
	
	@Bean
	public TestBean2 t5() {
		return new TestBean2();
	}
	
	@Bean
	public TestBean2 t6() {
		return new TestBean2();
	}
	
}



