package com.app.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate jt=ac.getBean("jtObj",JdbcTemplate.class);
		//String sql="insert into student values(?,?,?)";
		//int count=jt.update(sql,216,"Uday",19900);
		String sql="delete from student where sid=?";
		int count=jt.update(sql,216);
		System.out.println(count);
	}
}
