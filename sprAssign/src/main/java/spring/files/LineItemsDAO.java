package spring.files;

import java.util.List;

public interface LineItemsDAO {

	void save(LineItems l);

	void update(LineItems l);

	void delete(int lid);

	LineItems get(int lid);

	List<LineItems> getAll();

}