package objectsDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import modelVO.ItemVO;
import connection.DBConnect;

public class ItemDAO extends DBConnect implements InterfaceItemDAO{

    @Override
    public List<ItemVO> consultAllItems() {
        try {
            List<ItemVO> items = new ArrayList<>();
            connect();
            PreparedStatement statement = connection.prepareStatement("select * from inventory");
            ResultSet data = statement.executeQuery();
            while(data.next()){
                ItemVO item = new ItemVO();
                item.setName(data.getString("item_name"));
                item.setModel(data.getString("model"));
                item.setQuantity(data.getInt("quantity"));
                item.setIva(data.getFloat("iva"));
                item.setBrute(data.getFloat("brute_value"));
                item.setNeto(data.getFloat("neto_value"));
                items.add(item);
            }
            disconnect();
            return items;
        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
        }
        
    }
    
    @Override
    public ItemVO consultPerModel(String model){
        try {
            List<ItemVO> items = new ArrayList<>();
            connect();
            PreparedStatement statement = connection.prepareStatement("select * from inventory where model=?");
            statement.setString(1, model);
            ResultSet data = statement.executeQuery();
            if(data.next()){
                ItemVO item = new ItemVO();
                item.setName(data.getString("item_name"));
                item.setModel(data.getString("model"));
                item.setQuantity(data.getInt("quantity"));
                item.setIva(data.getFloat("iva"));
                item.setBrute(data.getFloat("brute_value"));
                item.setNeto(data.getFloat("neto_value"));
                items.add(item);
                disconnect();
                return item;
            } else {
                disconnect();
                return null;       
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
            return null;
            
        }
    }
    
    @Override
    public boolean deleteItem(String model) {
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("delete from inventory where model=?");
            statement.setString(1, model);
            statement.executeUpdate();
            disconnect();
            return true;
        } catch (Exception e) {
            System.err.println("Error: " + e);
            return false;
        }
    }
    
    @Override
    public boolean insertNewItem(ItemVO item) {
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("insert into inventory (item_name, model, quantity, iva, neto_value, brute_value) value (?, ?, ?, ?, ?, ?)");
            statement.setString(1, item.getName());
            statement.setString(2, item.getModel());
            statement.setInt(3, item.getQuantity());
            statement.setFloat(4, item.getIva());
            statement.setFloat(5, item.getNeto());
            statement.setFloat(6, item.getBrute());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error: " + e);
            return false;
        }
    }

    @Override
    public boolean updateItem(ItemVO item) {
        try {
            connect();
            PreparedStatement statement = connection.prepareStatement("update inventory set item_name=?, quantity=?, iva=?, neto_value=?, brute_value=? where model=?");
            statement.setString(1, item.getName());
            statement.setString(6, item.getModel());
            statement.setInt(2, item.getQuantity());
            statement.setFloat(3, item.getIva());
            statement.setFloat(4, item.getNeto());
            statement.setFloat(5, item.getBrute());
            statement.executeUpdate();
            disconnect();
            return true;
        } catch (Exception e) {
            System.err.println("Error: " + e);
            return false;
        }
    }
    
}
