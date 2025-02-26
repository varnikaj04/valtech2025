package spring.files;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerService {

	void save(Customer c);

	void update(Customer c);

	void delete(int id);

	Customer get(int id);

	List<Customer> getAll();

}