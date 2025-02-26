package spring.tx;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeHibernateDAOImpl implements EmployeeDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Employee e) {
		new HibernateTemplate(sessionFactory).save(e);
		
	}

	@Override
	public void update(Employee e) {
		new HibernateTemplate(sessionFactory).update(e);
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
	}

	@Override
	public Employee get(int id) {
		return new HibernateTemplate(sessionFactory).load(Employee.class, id);
		
	}

	@Override
	public List<Employee> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Employee e ");
	}
	

}
