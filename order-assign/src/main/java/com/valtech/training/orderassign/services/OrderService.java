package com.valtech.training.orderassign.services;

import java.util.List;

import com.valtech.training.orderassign.entities.Order;
import com.valtech.training.orderassign.vos.PlaceOrderVO;

public interface OrderService {

	void update(Order o);

	void delete(int id);

	Order get(int id);

	List<Order> getAll();

	void save(PlaceOrderVO placeOrderVO);

}