package DataBaseManagment;
import Item.Item;
import Restaurant.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sargis on 11/29/16.
 */
public class ItemDataBase extends DataBase{

    private static final String ITEMID="itemId";
    private static final String ITEMTABLE="Item";
    private static final String ITEMNAME="itemName";
    private static final String LIFETIME="lifeTime";
    private static final String PRICE="price";
    private static final String idSuppler="idSuppler";
    private static final String Supplier="Supplier";
    private static final String SupplierName="name";



    @Override
    public boolean insert(Entity e) {
        Item item=(Item)e;
        ResultSet resultSet=null;
        try
        {

            statement.executeUpdate("INSERT INTO "+ITEMTABLE +"("+ITEMNAME+","+LIFETIME+","+PRICE+") VALUES ("
                    + "'" + item.getItemName() + "', '" + item.getLifeTime() + "', '"
                    + item.getPrice() + "');");;


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
    public List<String> getAllSuppliers()
    {
        ResultSet resultSet=null;
        List<String> supplier=new ArrayList<String>();
        try {
             resultSet=statement.executeQuery("Select * from "+Supplier);
            while(resultSet.next())
            {
                supplier.add(resultSet.getString(SupplierName));
            }
          }
         catch (SQLException e)
          {
            e.printStackTrace();
          }
        return supplier;
    }
}
