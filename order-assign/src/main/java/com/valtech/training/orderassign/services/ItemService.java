package com.valtech.training.orderassign.services;

import java.util.List;

import com.valtech.training.orderassign.entities.Item;
import com.valtech.training.orderassign.vos.ItemVO;

public interface ItemService {

	ItemVO save(ItemVO i);

	ItemVO update(ItemVO i);

	void delete(int id);

	ItemVO get(int id);

	List<ItemVO> getAll();

}