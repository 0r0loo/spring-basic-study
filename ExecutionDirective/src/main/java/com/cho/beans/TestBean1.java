package com.cho.beans;

public class TestBean1 {
	
	public void method1() {
		System.out.println("beans.TestBean1.method1()");
	}
	
	public void method1(int a1) {
		System.out.println("beans.TestBean1.method1(int)");
	}
	
	public void method1(String a2) {
		System.out.println("beans.TestBean1.method1(java.lang.String)");
	}
	
	public void method1(int a1, int a2) {
		System.out.println("beans.TestBean1.method1(int, int)");
	}
	
	public void method1(int a1, String a2) {
		System.out.println("beans.TestBean1.method1(int, java.lang.String)");
	}
	
	public void method2() {
		System.out.println("beans.TestBean1.method2()");
		
	}
	
	public int method3() {
		System.out.println("beans.TestBean1.method3()");
		return 100;
	}
}
