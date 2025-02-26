package spring.files;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public void save(Customer c) {
		customerDAO.save(c);
//		throw new RuntimeException("Checking Rollback");
//		TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
	}

	@Override
	@Transactional
//	(propagation = Propagation.REQUIRED)
	public void update(Customer c) {
		customerDAO.update(c);
//		TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
	}

	@Override
//	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		customerDAO.delete(id);
	}

	@Override
	public Customer get(int id) {
		return customerDAO.get(id);
		
	}

	@Override
	public List<Customer> getAll() {
		return customerDAO.getAll();
		
	}
	
	

}
