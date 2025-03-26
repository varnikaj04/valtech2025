package com.valtech.training.orderassign.services;

import java.util.List;

import com.valtech.training.orderassign.entities.Customer;
import com.valtech.training.orderassign.vos.CustomerVO;

public interface CustomerService {

	CustomerVO save(CustomerVO c);

	CustomerVO update(CustomerVO c);

	void delete(int id);

	CustomerVO get(int id);

	List<CustomerVO> getAll();


}