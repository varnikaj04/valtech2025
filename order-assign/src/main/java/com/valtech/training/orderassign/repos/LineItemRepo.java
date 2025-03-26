package com.valtech.training.orderassign.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.orderassign.entities.LineItem;

@Repository
public interface LineItemRepo extends JpaRepository<LineItem, Integer> {

}
