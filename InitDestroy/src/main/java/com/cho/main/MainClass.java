package com.cho.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cho.beans.TestBean1;
import com.cho.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx1 = 
				new ClassPathXmlApplicationContext("com/cho/config/beans.xml");
		
		TestBean1 xml1 = ctx1.getBean("xml1", TestBean1.class);
		System.out.printf("xml1 : %s\n", xml1);
		
		
		ctx1.close();
	
		System.out.println("===========================");
	
		AnnotationConfigApplicationContext ctx2 =
				new AnnotationConfigApplicationContext(BeanConfigClass.class);
	
		TestBean1 java1 = ctx2.getBean("java1", TestBean1.class);
		
		
		
		
		ctx2.close();
	
	}

}
