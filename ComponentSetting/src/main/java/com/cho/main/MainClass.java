package com.cho.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cho.beans.TestBean1;
import com.cho.beans.TestBean2;
import com.cho.beans.TestBean3;
import com.cho.beans.TestBean4;
import com.cho.beans.TestBean5;
import com.cho.config.BeanConfigClass;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		
		TestBean1 t1 = ctx.getBean(TestBean1.class);
		System.out.printf("t1 : %s\n", t1);
		
		TestBean1 t2 = ctx.getBean(TestBean1.class);
		System.out.printf("t2 : %s\n", t2);
		
		TestBean2 t3 = ctx.getBean("t3", TestBean2.class);
		System.out.printf("t3 : %s\n", t3);
		
		TestBean2 t4 = ctx.getBean("t3", TestBean2.class);
		System.out.printf("t4 : %s\n", t4);
		
		
		TestBean2 t5 = ctx.getBean("t5", TestBean2.class);
		System.out.printf("t5 : %s\n", t5);
		
		TestBean2 t6 = ctx.getBean("t6", TestBean2.class);
		System.out.printf("t6 : %s\n", t6);
		
		TestBean3 t7 = ctx.getBean(TestBean3.class);
		System.out.printf("t7 : %s\n", t7);
		
		TestBean3 t8 = ctx.getBean(TestBean3.class);
		System.out.printf("t8 : %s\n", t8);
		
		TestBean4 t9 = ctx.getBean(TestBean4.class);
		System.out.printf("t9 : %s\n", t9);
		
		TestBean4 t10 = ctx.getBean(TestBean4.class);
		System.out.printf("t10 : %s\n", t10);
		
		TestBean5 t11 = ctx.getBean(TestBean5.class);
		System.out.printf("t11 : %s\n", t11);
		
		ctx.close();
	}

}
