package com.cho.beans;

import javax.annotation.Resource;


public class TestBean6 {
	
	// 변수의 이름과 동일한 이름의 Bean이ㅣ 주입된다.
	@Resource(name="data1")
	private DataBean1 data100;
	@Resource(name="data2")
	private DataBean2 data200;
	
	public DataBean1 getData100() {
		return data100;
	}
	public DataBean2 getData200() {
		return data200;
	}
	

}

