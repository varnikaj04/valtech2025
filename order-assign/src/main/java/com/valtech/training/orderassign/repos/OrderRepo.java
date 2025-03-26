package com.valtech.training.orderassign.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.orderassign.entities.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
