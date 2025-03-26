package com.valtech.training.orderassign.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.orderassign.entities.Item;
import com.valtech.training.orderassign.entities.LineItem;
import com.valtech.training.orderassign.entities.Order;

public record LineItemVO(int lid, int quantity, Item item, Order order) {

	public static LineItemVO from(LineItem li) {
		return new LineItemVO(li.getLid(), li.getQuantity(), li.getItem(), li.getOrder());
	}
	
	public static List<LineItemVO> from(List<LineItem> li){
		return li.stream().map(lis -> LineItemVO.from(lis)).collect(Collectors.toList());
	}
	
	public LineItem to() {
		return new LineItem(lid, quantity, item, order);
	}
	
}
