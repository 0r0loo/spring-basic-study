package com.cho.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cho.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
					= new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
	}

}
