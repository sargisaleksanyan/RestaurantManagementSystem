package DataBaseManagment;

import Restaurant.Entity;
import Order.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sargis on 11/29/16.
 */
public class OrderDataBase extends EntityDataBase {
    public  final static String ORDER_TABLE="OrderT";
    public  final static String ORDER_ID="orderId";
    public  final static String CUSTOMER_ID="customerId";
    public  final static String ORDER_DATE="orderDate";
    public  final static String BILL="bill";

    @Override
    public boolean insert(Entity e) {
        Order o=(Order)e;

        try {
            statement.executeUpdate("INSERT INTO " +ORDER_TABLE+ "(" + ORDER_DATE + "," + CUSTOMER_ID +
                    "," +BILL+ ") VALUES ("
                    + "'" + o.getOrderDate() + "', '" + o.getCustomer().getCustomerId() + "', '"
                    + o.getBill() + "');");
        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public <T> boolean update(T... t) {
        return false;
    }

    @Override
    public <T> boolean check(T... t) {
        return false;
    }


    public synchronized Order getOrder(int customerID,String orderDate)
    {
        CustomerDataBase db=new CustomerDataBase();
        Order order=null;
        ResultSet resultSet;
        try {
            resultSet=statement.executeQuery("select * from "+ORDER_TABLE+" where "+CUSTOMER_ID
                    +"="+"'"+customerID+"'"+" and "+ORDER_DATE+"='"+orderDate+"'");
            while(resultSet.next())
            {
                double bill=resultSet.getDouble(BILL);
                int id=resultSet.getInt(ORDER_ID);
                order=new Order();
                order.setCustomer(db.signIn(id));
                order.setOrderId(id);
                order.setOrderDate(orderDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

}
