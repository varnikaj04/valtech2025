package spring.assignment;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LineItemsDAOImpl implements LineItemsDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(LineItems l) {
		new HibernateTemplate(sessionFactory).save(l);
		
	}

	@Override
	public void update(LineItems l) {
		new HibernateTemplate(sessionFactory).update(l);
		
	}

	@Override
	public void delete(int lid) {
		new HibernateTemplate(sessionFactory).delete(get(lid));
	}

	@Override
	public LineItems get(int lid) {
		return new HibernateTemplate(sessionFactory).load(LineItems.class, lid);
		
	}

	@Override
	public List<LineItems> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LineItems l ");
	}

}
