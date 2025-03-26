package com.valtech.training.orderassign.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.orderassign.entities.Customer;
import com.valtech.training.orderassign.entities.LineItem;
import com.valtech.training.orderassign.entities.Order;

public record OrderVO(int oid, Customer customer, List<LineItem> lineItem) {
	
	public static OrderVO from(Order o) {
		return new OrderVO(o.getOid(), o.getCustomer(), o.getLineItem());
	}
	
	public static List<OrderVO> from(List<Order> orders){
		return orders.stream().map(o -> OrderVO.from(o)).collect(Collectors.toList());
	}
	
	public Order to() {
		Order o = new Order(oid, customer, lineItem);
		return o;
	}

}
