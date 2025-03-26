package com.valtech.training.orderassign.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.orderassign.entities.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

}
