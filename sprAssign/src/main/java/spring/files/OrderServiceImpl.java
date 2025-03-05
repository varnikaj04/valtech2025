package spring.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.files.Order.Status;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	private ItemDAO itemDAO;
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	
	@Override
	public void checkAndAddInventory(Item item) {
		
		item.setCurrentQuan(item.getMaxQuan());
		item.setReorderQuan(0);
		itemDAO.update(item);	
	}
	
	
	
	@Override
	public void placeOrder(Order o) {
		
		boolean isValid = true;
		for( LineItems lineItem : o.getLineItems()) {
			if(lineItem.getQuantity() > lineItem.getItem().getCurrentQuan()) {
				isValid = false;
				o.setStatus(Status.NOTDELIVERED);
				break;
			}
		}
		
		if(isValid) {
			o.setStatus(Status.PACKED);
			orderDAO.save(o);
			Item item;
			for(LineItems lineItem : o.getLineItems()) {
				item = itemDAO.get(lineItem.getItem().getId());
				item.setCurrentQuan(item.getCurrentQuan() - lineItem.getQuantity());
				item.setReorderQuan(item.getReorderQuan() + lineItem.getQuantity());
				
				itemDAO.update(item);
				if(item.getCurrentQuan() == 0) {
					checkAndAddInventory(item);
				}
			}
		}
		
		
		
//		Integer(item.getCurrentQuan() - 1 ;
	}

}
