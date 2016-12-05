package DataBaseManagment;

import Meal_Menu.MenuItem;
import Meal_Menu.MenuItemBuilder.Drink;
import Meal_Menu.MenuItemBuilder.Meal;
import Meal_Menu.MenuItemBuilder.MealBuilder;
import Meal_Menu.MenuItemCategory;
import Supplier.Supplier;
import Item.Item;
import Order.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sargis on 11/29/16.
 */
public class DataList  {
    protected Statement statement;
    protected Connection connection;
    private  final String SERVER_IP="95.140.195.69";
    private  final String SERVER_PORT="3306";
    private  final String DATABASE_NAME="A09155126";
    private  final String USER_NAME="A09155126";
    private  final String USER_PASSWORD="A09155126";
    private static final String Supplier="Supplier";

   public DataList()
   {
       Connection mycon;
       try {
           Class.forName("com.mysql.jdbc.Driver");
           // mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant?useSSL=false", "root", "hovik2011");
           connection = DriverManager.getConnection("jdbc:mysql://"+SERVER_IP+":"+SERVER_PORT+
                   "/"+DATABASE_NAME+"?useSSL=false",USER_NAME,USER_PASSWORD);
           //mycon = DriverManager.getConnection("jdbc:mysql://95.140.195.69:3306/A09155126?useSSL=false", "A09155126", "A09155126");
           statement = connection.createStatement();

       } catch (ClassNotFoundException e) {
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
            resultSet=statement.executeQuery("Select * from "+ItemDataBase.ITEM_TABLE);
            while(resultSet.next())
            {
                String name=resultSet.getString(ItemDataBase.ITEM_NAME);
                int itemId=resultSet.getInt(ItemDataBase.ITEM_ID);
                int  lifetime=resultSet.getInt(ItemDataBase.LIFE_TIME);
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
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    public synchronized List<MenuItem> getAllMenuItems()
    {

        ResultSet resultSet=null;
        List<MenuItem> menuItems=new ArrayList<>();
        try {
            resultSet=statement.executeQuery("Select * from "+MenuItemDataBase.MENU_ITEM_TABLE);
            while(resultSet.next())
            {
                String name=resultSet.getString(MenuItemDataBase.MI_NAME);
                String menuItemCategoryName=resultSet.getString(MenuItemDataBase.MI_CATEGORYNAME);
                String foodType=resultSet.getString(MenuItemDataBase.MI_FOODTYPE);
                double price =resultSet.getDouble(MenuItemDataBase.MI_PRICE);
                MenuItem menuItem=null;
                if(menuItemCategoryName== MenuItemCategory.DRINK)
                {
                    menuItem=new Drink(name,price);
                    menuItem.setMenuCategoryName(menuItemCategoryName);

                }
                else
                {
                    MealBuilder mealBuilder=new MealBuilder(name, price, menuItemCategoryName);
                    if(foodType!=null)
                    {
                        mealBuilder.setFoodType(foodType);
                    }
                    menuItem=mealBuilder.build();

                }
              menuItems.add(menuItem);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  menuItems;
    }


    public synchronized  List<Order> getAllOrders()
    {
        ResultSet resultSet=null;
        CustomerDataBase customerDataBase=new CustomerDataBase();
        List<Order> orders=new ArrayList<Order>();
        HashMap<Order,Integer> orderIds=new HashMap<>();
        try {
            resultSet=statement.executeQuery("Select * from "+OrderDataBase.ORDER_TABLE);

          /*  if(resultSet.isClosed()) {
                resultSet = statement.executeQuery("Select * from " + OrderDataBase.ORDER_TABLE);
            }*/
                while (resultSet.next()) {
                    int order_id = resultSet.getInt(OrderDataBase.ORDER_ID);
                    int cusomer_id = resultSet.getInt(OrderDataBase.CUSTOMER_ID);
                    String orderDate = resultSet.getString(OrderDataBase.ORDER_DATE);
                    double bill = resultSet.getDouble(OrderDataBase.BILL);
                  //  List<OrderMenuItem> orderMenuItems = getGivenOrderItems(order_id);
                    Order order = new Order();
                    order.setOrderDate(orderDate);
                    order.setOrderId(order_id);
                    order.setCustomer(customerDataBase.signIn(cusomer_id));
                 //   order.setOrderMenuItems(getGivenOrderItems(order_id));
                    orders.add(order);
                    orderIds.put(order,order_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<orders.size();i++)
        {
            Order or=orders.get(i);
            int id=orderIds.get(or);
            or.setOrderMenuItems(getGivenOrderItems(id));
        }

        return orders;
    }


    public  synchronized List<OrderMenuItem> getGivenOrderItems(int order_id)
    {
        ResultSet resultSet=null;
        MenuItemDataBase menuItemDataBase=new MenuItemDataBase();
        List<OrderMenuItem> orders=new ArrayList<OrderMenuItem>();

        try {
           // resultSet=statement.executeQuery("Select * from "+ OrderItemDataBase.ORDERITEM_TABLE+" where "+
         //   OrderItemDataBase.ORDER_ID+ "="+order_id);
            resultSet=statement.executeQuery("Select * from "+ OrderItemDataBase.ORDERITEM_TABLE+" where "+
                     OrderItemDataBase.ORDER_ID+ "="+order_id);
            while(resultSet.next()) {
                String menuItemName = resultSet.getString(OrderItemDataBase.ORDER_MENUITEM);
                int amount = resultSet.getInt(OrderItemDataBase.QUNTITY);
                MenuItem menuItem = menuItemDataBase.getMenuItem(menuItemName);
                OrderMenuItem orderMenuItem = new OrderMenuItem(menuItem, amount);
                orders.add(orderMenuItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
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
