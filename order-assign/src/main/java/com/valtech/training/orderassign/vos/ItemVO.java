package com.valtech.training.orderassign.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.orderassign.entities.Item;

public record ItemVO(int id, String name, String description, int currentQuan, int reorderQuan, int maxQuan) {
	
	public static ItemVO from(Item i) {
		return new ItemVO(i.getId(), i.getName(), i.getDescription(), i.getCurrentQuan(), i.getReorderQuan(), i.getMaxQuan());
	}
	
	public Item to() {
		Item i = new Item(id, name, description, currentQuan, reorderQuan, maxQuan);
		return i;
	}
	
	public static List<ItemVO> from(List<Item> item){
		return item.stream().map(i -> ItemVO.from(i)).collect(Collectors.toList());
	}

}
