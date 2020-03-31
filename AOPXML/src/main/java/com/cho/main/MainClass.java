package com.cho.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cho.beans.TestBean1;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("com/cho/config/beans.xml");
		
		TestBean1 bean1 = ctx.getBean("xml1", TestBean1.class);
		int a1 = bean1.method1();
		System.out.printf("a1 %d\n" , a1);
		ctx.close();
	}
}
