package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryClient {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("factory.xml");
		System.out.println(ctx.getBean("p1"));
		System.out.println(ctx.getBean("p1"));
		System.out.println(ctx.getBean("p1"));
		System.out.println(ctx.getBean("p1") == ctx.getBean("p1"));
		
		System.out.println(ctx.getBean("p2"));
	}

}
