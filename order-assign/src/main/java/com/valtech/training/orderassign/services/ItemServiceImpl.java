package com.valtech.training.orderassign.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.orderassign.entities.Item;
import com.valtech.training.orderassign.repos.ItemRepo;
import com.valtech.training.orderassign.vos.ItemVO;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepo itemRepo;

	@Override
	public ItemVO save(ItemVO itemVO) {
		return ItemVO.from(itemRepo.save(itemVO.to())) ;
	}

	@Override
	public ItemVO update(ItemVO itemVO) {
		return ItemVO.from(itemRepo.save(itemVO.to())) ;
	}

	@Override
	public void delete(int id) {
		itemRepo.deleteById(id);
	}

	@Override
	public ItemVO get(int id) {
		return ItemVO.from(itemRepo.getReferenceById(id));
	}

	@Override
	public List<ItemVO> getAll() {
		return ItemVO.from(itemRepo.findAll());
	}

}
