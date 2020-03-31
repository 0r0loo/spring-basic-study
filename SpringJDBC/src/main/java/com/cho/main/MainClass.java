package com.cho.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cho.beans.JdbcBean;
import com.cho.config.BeanConfigClass;
import com.cho.db.JdbcDAO;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		// dao를 가져온다
		JdbcDAO dao = ctx.getBean(JdbcDAO.class);
		
		
		// insert
		/*JdbcBean bean1 = new JdbcBean();
		bean1.setInt_data(100);
		bean1.setStr_data("문자열1");
		dao.insert_data(bean1);
		
		JdbcBean bean2 = new JdbcBean();
		bean2.setInt_data(200);
		bean2.setStr_data("문자열2");
		dao.insert_data(bean2);
		
		System.out.println("저장 완료");*/
		
		
		// update
		/*JdbcBean bean4 = new JdbcBean();
		bean4.setInt_data(100);
		bean4.setStr_data("문자열3");
		dao.update_data(bean4);*/
		
		// delete
		/*dao.delete_data(100);*/
		
		
		
		// select
		List<JdbcBean> list = dao.select_data();
		for(JdbcBean bean3 : list) {
			System.out.printf("int_data : %d\n", bean3.getInt_data());
			System.out.printf("str_data : %s\n", bean3.getStr_data());
		}
		
		
		
		
		ctx.close();
	}

}
