package com.happy.main;

//import com.cho.beans.HelloWorldEn;
import com.cho.beans.HelloWorldKo;

public class MainClass {

	public static void main(String[] args) {
//		HelloWorldEn helloWorldEn = new HelloWorldEn();		
//		callMethod(helloWorldEn);
		
		HelloWorldKo helloWorldKo = new HelloWorldKo();
		callMethod(helloWorldKo);

	}

	//public static void callMethod(HelloWorldEn hello) {
	public static void callMethod(HelloWorldKo hello) {
		hello.sayHello();
	}
}
