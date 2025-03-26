package com.valtech.training.orderassign.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.orderassign.entities.Customer;
import com.valtech.training.orderassign.repos.CustomerRepo;
import com.valtech.training.orderassign.vos.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public CustomerVO save(CustomerVO customerVO) {
		return CustomerVO.from(customerRepo.save(customerVO.to()));
		
	}

	@Override
	public CustomerVO update(CustomerVO customerVO) {
		return CustomerVO.from(customerRepo.save(customerVO.to()));
		
	}

	@Override
	public void delete(int id) {
		customerRepo.deleteById(id);
		
	}

	@Override
	public CustomerVO get(int id) {
		return CustomerVO.from(customerRepo.getReferenceById(id)) ;
	}

	@Override
	public List<CustomerVO> getAll() {
		return CustomerVO.from(customerRepo.findAll()) ;
	}
	
}
	


