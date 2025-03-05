package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.files.Customer;
import spring.files.CustomerDAO;
import spring.files.CustomerHibernateDAOImpl;
import spring.files.CustomerService;
import spring.files.Item;
import spring.files.ItemDAO;
import spring.files.ItemHibernateDAOImpl;
import spring.files.LineItems;
import spring.files.LineItemsDAO;
import spring.files.LineItemsDAOImpl;
import spring.files.Order;
import spring.files.Order.Status;
import spring.files.OrderDAO;
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
		
		
//		ItemHibernateDAOImpl is = ctx.getBean(ItemHibernateDAOImpl.class);
//		System.out.println(is.getClass().getName());
//		is.save(new Item("laptop", "updated ram", 6, 3, 12));
		
		CustomerDAO cs = ctx.getBean(CustomerHibernateDAOImpl.class);
		OrderDAO os = ctx.getBean(OrderHibernateDAOImpl.class);
		ItemDAO is = ctx.getBean(ItemHibernateDAOImpl.class);
		LineItemsDAO ls = ctx.getBean(LineItemsDAOImpl.class);
		
		Customer c = cs.get(3);
		
		Order o = new Order();
		o.setCustomer(c);
		o.setStatus(Status.ONTHEWAY);
		
		os.save(o);
		
		Item i = is.get(4);
		
		LineItems li = new LineItems();
		li.setQuantity(3);
		li.setOrder(o);
		li.setItem(i);
		
		ls.save(li);
		
		ctx.close();
	}

}
