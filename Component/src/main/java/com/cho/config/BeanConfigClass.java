package com.cho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cho.beans.TestBean1;
import com.cho.beans.TestBean2;
import com.cho.beans2.TestBean4;

@Configuration
// 지정된 패키지의 Bean 클래스의 어노테이션을 분석하여 Bean을 등록하고 지정한다.
@ComponentScan(basePackages="com.cho.beans2")
@ComponentScan(basePackages="com.cho.beans3")
public class BeanConfigClass {
	
	@Bean
	public TestBean1 java1() {
		return new TestBean1();
	}
	
	// 메소드 이름이 빈의 이름
	@Bean
	public TestBean2 java2() {
		return new TestBean2();
	}
	
	@Bean
	public TestBean2 java3() {
		return new TestBean2();
	}
	
	@Bean
	public TestBean4 java100() {
		return new TestBean4();
	}

	@Bean
	public TestBean4 java200() {
		return new TestBean4();
	}
	
}
