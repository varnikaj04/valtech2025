package spring.assignment;

import java.util.List;

public interface OrderDAO {

	void save(Order o);

	void update(Order o);

	void delete(int oid);

	Order get(int oid);

	List<Order> getAll();

}