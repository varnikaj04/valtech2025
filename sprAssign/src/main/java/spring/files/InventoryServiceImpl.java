package spring.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl {
	
	@Autowired
	private ItemDAO itemDAO;
	private Item item;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	public void addInventory(Item i) {
		
		
	}

	public void checkInventory() {
		if(item.getCurrentQuan() < item.getReorderQuan()) {
//			addInventory(item){
//				itemDAO.update(item.getCurrentQuan());
//			}
		}
	}
	
}
