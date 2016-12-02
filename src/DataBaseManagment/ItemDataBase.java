package DataBaseManagment;
import Item.Item;
import Restaurant.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sargis on 11/29/16.
 */
public class ItemDataBase extends EntityDataBase {

    public static final String ITEM_ID ="itemId";
    public static final String ITEM_TABLE="Item";
    public static final String ITEM_NAME ="itemName";
    public static final String LIFE_TIME ="lifeTime";
    public static final String PRICE="price";
    public static final String idSuppler="supplierId";




    @Override
    public boolean insert(Entity e) {
        Item item=(Item)e;
        ResultSet resultSet=null;
        try
        {
            if(item.getSupplier()==null) {
                statement.executeUpdate("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + "," + LIFE_TIME + "," + PRICE + ") VALUES ("
                        + "'" + item.getItemName() + "', '" + item.getLifeTime() + "', '"
                        + item.getPrice() + "');");

            }
          else
            {
                statement.executeUpdate("INSERT INTO " + ITEM_TABLE + "(" + ITEM_NAME + "," + LIFE_TIME + ","  + PRICE+ "," +idSuppler+ ") VALUES ("
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
    public Item getItemByName(String itemName)
    {
        ResultSet resultSet=null;
        Item item=null;
        try
        {
            resultSet=statement.executeQuery("select * from "+ITEM_TABLE+" where "+ITEM_NAME+"="+"'"+itemName+"'");

            while(resultSet.next())
            {
              // Item item =new Item()
                String iName=resultSet.getString(ITEM_NAME);
                double price=resultSet.getDouble(PRICE);
                int id=resultSet.getInt(ITEM_ID);
                int lifeTime=resultSet.getInt(LIFE_TIME);
                item=new Item(iName,price,lifeTime);

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return item;
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
