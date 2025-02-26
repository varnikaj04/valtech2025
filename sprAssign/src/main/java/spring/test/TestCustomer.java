package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.files.Customer;
import spring.files.CustomerService;
import spring.files.Item;
import spring.files.ItemHibernateDAOImpl;
import spring.files.OrderHibernateDAOImpl;




public class TestCustomer {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("order.xml");
//		CustomerService cs = ctx.getBean(CustomerService.class);
//		System.out.println(cs.getClass().getName());
//		cs.save(new Customer("varn", 21, "Blr", "Ahm"));
//		
//		Customer customer = cs.get(4);
//		customer.setAge(25);
//		cs.update(customer);
//		cs.getAll().forEach(e -> System.out.println(e)); 
		
		
		ItemHibernateDAOImpl is = ctx.getBean(ItemHibernateDAOImpl.class);
		System.out.println(is.getClass().getName());
		is.save(new Item("laptop", "updated ram", 6, 3, 12));
		
		
		
		ctx.close();
	}

}
