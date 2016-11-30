package DataBaseManagment;

import Supplier.Supplier;
import Item.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sargis on 11/29/16.
 */
public class DataList {
    protected Statement statement;
    private static final String Supplier="Supplier";
    private static final String SupplierName="name";
    public DataList() {
        Connection mycon;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant?useSSL=false", "root", "hovik2011");
            statement = mycon.createStatement();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Item> getAllItems()
    {
        ResultSet resultSet=null;
        List<Item> items=new ArrayList<Item>();
        try {
            resultSet=statement.executeQuery("Select * from "+ItemDataBase.ITEMTABLE);
            while(resultSet.next())
            {
                String name=resultSet.getString(ItemDataBase.ITEMNAME);
                int itemId=resultSet.getInt(ItemDataBase.ITEMID);
                int  lifetime=resultSet.getInt(ItemDataBase.LIFETIME);
                double  price=resultSet.getInt(ItemDataBase.PRICE);

                 Item item=new Item(name,price,lifetime);
                 item.setItemId(itemId);
                 items.add(item);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return items;
    }

    public List<Supplier> getAllSuppliers()
    {
        ResultSet resultSet=null;
        List<Supplier> supplier=new ArrayList<Supplier>();
        try {
            resultSet=statement.executeQuery("Select * from "+Supplier);
            while(resultSet.next())
            {
                String name=resultSet.getString(SupplierDataBase.NAME);
                String lastName=resultSet.getString(SupplierDataBase.SURNAME);
                String phone=resultSet.getString(SupplierDataBase.PHONE);
                int id=resultSet.getInt(SupplierDataBase.IDSupplier);
                Supplier s=new Supplier(name,lastName,phone);
                s.setSupplierID(id);
                supplier.add(s);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return supplier;
    }
}
