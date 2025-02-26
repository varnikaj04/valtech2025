package spring.assignment;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OrderHibernateDAOImpl implements OrderDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Order o) {
		new HibernateTemplate(sessionFactory).save(o);
		
	}

	@Override
	public void update(Order o) {
		new HibernateTemplate(sessionFactory).update(o);
		
	}

	@Override
	public void delete(int oid) {
		new HibernateTemplate(sessionFactory).delete(get(oid));
	}

	@Override
	public Order get(int oid) {
		return new HibernateTemplate(sessionFactory).load(Order.class, oid);
		
	}

	@Override
	public List<Order> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Order o ");
	}

}
