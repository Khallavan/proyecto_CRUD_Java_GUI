package objectsDAO;

import java.util.List;
import modelVO.ItemVO;

public interface InterfaceItemDAO {
    public boolean insertNewItem(ItemVO item);
    public boolean deleteItem(String model);
    public boolean updateItem(ItemVO item);
    public List<ItemVO> consultAllItems();
    public ItemVO consultPerModel(String model);
}
