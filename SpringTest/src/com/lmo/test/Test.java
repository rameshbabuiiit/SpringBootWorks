package com.lmo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lmo.beans.HelloWorld;

public class Test {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hw = (HelloWorld)context.getBean("helloWorld");
		System.out.println(hw.getName());
	}
}

