package spring.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
	
	@Autowired
	private OrderDAO orderDAO;
	private Item item;
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public void placeOrder(Order o) {
		orderDAO.save(o);
//		Integer(item.getCurrentQuan() - 1 ;
	}

}
