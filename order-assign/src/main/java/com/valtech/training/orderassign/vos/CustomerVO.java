package com.valtech.training.orderassign.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.orderassign.entities.Customer;
import com.valtech.training.orderassign.entities.Customer.CustomerStatus;

public record CustomerVO(int cid, String cname, int age, String address, String permaddress, String cusStatus) {

	public static CustomerVO from(Customer c) {
		String status = c.getCusStatus().name();
		return new CustomerVO(c.getCid(), c.getCname(), c.getAge(), c.getAddress(), c.getPermaddress(), status);
		
	}
	
	public Customer to() {
		CustomerStatus status = CustomerStatus.valueOf(cusStatus);
		Customer c = new Customer(cid, cname, age, address, permaddress, status);
		return c;
	}
	
	public static List<CustomerVO> from(List<Customer> customer){
		return customer.stream().map(c -> CustomerVO.from(c)).collect(Collectors.toList());
	}
	
}
