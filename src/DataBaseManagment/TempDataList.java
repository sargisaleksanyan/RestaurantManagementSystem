package DataBaseManagment;

import Meal_Menu.MenuItem;
import Order.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sargis on 12/5/16.
 */
public class TempDataList {
    protected Statement statement;
    protected Connection connection;
    private  final String SERVER_IP="95.140.195.69";
    private  final String SERVER_PORT="3306";
    private  final String DATABASE_NAME="A09155126";
    private  final String USER_NAME="A09155126";
    private  final String USER_PASSWORD="A09155126";
    private static final String Supplier="Supplier";

    public TempDataList()
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
    public synchronized List<Order> getAllOrders()
    {
        ResultSet resultSet=null;
        CustomerDataBase customerDataBase=new CustomerDataBase();
        List<Order> orders=new ArrayList<Order>();
        HashMap<Order,Integer> orderIds=new HashMap<>();
        try {
            resultSet=statement.executeQuery("Select * from "+TemporaryOrderDataBase.ORDER_TABLE);

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
            resultSet=statement.executeQuery("Select * from "+ TemporaryOrderItemDataBase.ORDERITEM_TABLE+" where "+
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
}
