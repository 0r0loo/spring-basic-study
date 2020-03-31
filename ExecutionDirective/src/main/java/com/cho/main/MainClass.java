package com.cho.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cho.beans.TestBean1;
import com.cho.beans.TestBean2;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("com/cho/config/beans.xml");
		
		TestBean1 xml1 = ctx.getBean("xml1", TestBean1.class);
		TestBean2 xml2 = ctx.getBean("xml2", TestBean2.class);
		com.cho.beans2.TestBean1 xml3 = ctx.getBean("xml3", com.cho.beans2.TestBean1.class);
		
		xml1.method1();
		System.out.println("---------------------------");
		
		xml1.method1(100);
		System.out.println("---------------------------");
		
		xml1.method1("문자열");
		System.out.println("---------------------------");
		
		xml1.method1(100, 200);
		System.out.println("---------------------------");

		xml1.method1(100, "문자열2");
		System.out.println("---------------------------");
		
		xml1.method2();
		System.out.println("---------------------------");
		
		xml2.method1();
		System.out.println("---------------------------");

		xml3.method1();
		
		int a1 = xml1.method3();
		System.out.printf("a1 : %d\n", a1);
		
		ctx.close();
	}

}
