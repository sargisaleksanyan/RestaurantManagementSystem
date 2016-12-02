package DataBaseManagment;
import Item.Item;
import Restaurant.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sargis on 11/29/16.
 */
public class ItemDataBase extends EntityDataBase {

    public static final String ITEMID="itemId";
    public static final String ITEMTABLE="Item";
    public static final String ITEMNAME="itemName";
    public static final String LIFETIME="lifeTime";
    public static final String PRICE="price";
    public static final String idSuppler="supplierId";




    @Override
    public boolean insert(Entity e) {
        Item item=(Item)e;
        ResultSet resultSet=null;
        try
        {
            if(item.getSupplier()==null) {
                statement.executeUpdate("INSERT INTO " + ITEMTABLE + "(" + ITEMNAME + "," + LIFETIME + "," + PRICE + ") VALUES ("
                        + "'" + item.getItemName() + "', '" + item.getLifeTime() + "', '"
                        + item.getPrice() + "');");

            }
          else
            {
                statement.executeUpdate("INSERT INTO " + ITEMTABLE + "(" + ITEMNAME + "," + LIFETIME + ","  + PRICE+ "," +idSuppler+ ") VALUES ("
                        + "'" + item.getItemName() + "', '" + item.getLifeTime() + "', '"
                        + item.getPrice() +"', '"+item.getSupplier().getSupplierID()+ "');");
            }
         /* statement.executeUpdate("INSERT INTO Customer ("+NAME+","+LASTNAME+","+PHONE+") VALUES ("
                    + "'" + customer.getName() + "', '" + customer.getLastName() + "', '"
                    + customer.getPhoneNumber() + "');");*/
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return  true;
    }

    @Override
    public <T> boolean update(T... t) {
        return false;
    }

    @Override
    public <T> boolean check(T... t) {
        return false;
    }

}
