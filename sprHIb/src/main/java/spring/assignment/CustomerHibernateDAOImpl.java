package spring.assignment;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class CustomerHibernateDAOImpl implements CustomerDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Customer c) {
		new HibernateTemplate(sessionFactory).save(c);
		
	}

	@Override
	public void update(Customer c) {
		new HibernateTemplate(sessionFactory).update(c);
		
	}

	@Override
	public void delete(int cid) {
		new HibernateTemplate(sessionFactory).delete(get(cid));
	}

	@Override
	public Customer get(int cid) {
		return new HibernateTemplate(sessionFactory).load(Customer.class, cid);
		
	}

	@Override
	public List<Customer> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Customer c ");
	}


}
