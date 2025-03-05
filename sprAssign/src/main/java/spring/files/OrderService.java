package spring.files;

public interface OrderService {

	void checkAndAddInventory(Item item);

	void placeOrder(Order o);

}