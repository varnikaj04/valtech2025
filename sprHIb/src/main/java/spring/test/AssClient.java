package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AssClient {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("order.xml");
		
	}

}
