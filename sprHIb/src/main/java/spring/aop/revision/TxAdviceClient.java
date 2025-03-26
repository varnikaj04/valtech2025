package spring.aop.revision;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee.Gender;

public class TxAdviceClient {

	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("txAdvice.xml");
		EmployeeDAO dao = (EmployeeDAO) appCtx.getBean("employeeDAO");
		SessionFactory factory = appCtx.getBean(SessionFactory.class);
		dao.save(factory.openSession(), new Employee(5, "TxGuy", 23, Gender.MALE, 30000, 4, 2));
	}
	
}
