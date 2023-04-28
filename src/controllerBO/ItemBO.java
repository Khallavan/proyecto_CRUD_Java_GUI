package controllerBO;

import java.util.List;
import modelVO.ItemVO;
import objectsDAO.*;

public class ItemBO {
    private InterfaceItemDAO iDao;
    public ItemBO(){
        iDao = new ItemDAO();
    }
    public boolean insertItems(ItemVO item){
        return iDao.insertNewItem(item);
    }
    public boolean updateItems(ItemVO item){
        return iDao.updateItem(item);
    }
    public boolean deleteItems(ItemVO item){
        return iDao.deleteItem(item.getModel());
    }
    public List<ItemVO> getItems(){
        return iDao.consultAllItems();
    }
    public ItemVO getItem(String model){
        return iDao.consultPerModel(model);  
    }

}
