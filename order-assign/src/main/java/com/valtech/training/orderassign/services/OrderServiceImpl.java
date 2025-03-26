package com.valtech.training.orderassign.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.orderassign.entities.Customer.CustomerStatus;
import com.valtech.training.orderassign.entities.Item;
import com.valtech.training.orderassign.entities.LineItem;
import com.valtech.training.orderassign.entities.Order;
import com.valtech.training.orderassign.entities.Order.Status;
import com.valtech.training.orderassign.repos.ItemRepo;
import com.valtech.training.orderassign.repos.OrderRepo;
import com.valtech.training.orderassign.vos.PlaceOrderVO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ItemService itemService;

	public void checkAndAddInventory(Item item) {
		item.setCurrentQuan(item.getMaxQuan());
		item.setReorderQuan(0);
		itemRepo.save(item);

	}

	@Override
	public void save(PlaceOrderVO placeOrderVO) {
		
		int cid = placeOrderVO.cid();
		int id = placeOrderVO.id();
		int quantity = placeOrderVO.quantity();
		
		LineItem li = new LineItem();
		li.setItem(itemService.get(id).to());
		li.setQuantity(quantity);
		
		Order o = new Order();
		o.setCustomer(customerService.get(cid).to());
		o.addLineItem(li);
		

		boolean isValid = true;
		
		for (LineItem lineItem : o.getLineItem()) {
			if (lineItem.getQuantity() > lineItem.getItem().getCurrentQuan() || o.getCustomer().getCusStatus() == CustomerStatus.DISABLE) {
				isValid = false;
				o.setStatus(Status.RETURNED);
				orderRepo.save(o);
				break;
			}
		}

		if (isValid) {
			o.setStatus(Status.PACKED);
			orderRepo.save(o);
			Item item;
			for (LineItem lineItem : o.getLineItem()) {
				item = itemRepo.getReferenceById(lineItem.getItem().getId());
				item.setCurrentQuan(item.getCurrentQuan() - lineItem.getQuantity());
				item.setReorderQuan(item.getReorderQuan() + lineItem.getQuantity());

				itemRepo.save(item);
				if (item.getCurrentQuan() == 0) {
					checkAndAddInventory(item);
				}
			}
		}

	}

	@Override
	public void update(Order o) {
		orderRepo.save(o);

	}

	@Override
	public void delete(int id) {
		orderRepo.deleteById(id);

	}

	@Override
	public Order get(int id) {
		return orderRepo.getReferenceById(id);
	}

	@Override
	public List<Order> getAll() {
		return orderRepo.findAll();
	}

}
