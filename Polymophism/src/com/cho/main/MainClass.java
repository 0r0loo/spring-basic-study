package com.cho.main;

import com.cho.beans.HelloWorld;
import com.cho.beans.HelloWorldEn;
import com.cho.beans.HelloWorldKo;

public class MainClass {

	public static void main(String[] args) {
		HelloWorld hello1 =  new HelloWorldEn();
		callMethod(hello1);

		HelloWorld hello2 = new HelloWorldKo();
		callMethod(hello2);
		
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
