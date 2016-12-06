package DataBaseManagment;

import Order.Order;
import Restaurant.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TemporaryOrderDataBase extends EntityDataBase{

    public  final static String ORDER_TABLE="TempOrder";
    public  final static String ORDER_ID="orderId";
    public  final static String CUSTOMER_ID="customerId";
    public  final static String ORDER_DATE="orderDate";
    public  final static String ISAPPROVED="isapproved";
    public  final static String TABLE_NUMBER="tablenum";
    public  final static String BILL="bill";

    @Override
    public boolean insert(Entity e) {
        Order o=(Order)e;

        try {
            statement.executeUpdate("INSERT INTO " +ORDER_TABLE+ "(" + ORDER_DATE + "," + CUSTOMER_ID +
                    "," +BILL+","+ISAPPROVED+","+TABLE_NUMBER+ ") VALUES ("
                    + "'" + o.getOrderDate() + "', '" + o.getCustomer().getCustomerId() + "', '"
                    + o.getBill() +"', '"+o.approved+"', '"+o.getTable()+ "');");
            return true;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }
        

    }

    @Override
    public <T> boolean update(T... t) {



        return false;
    }
    public void approve(Order o)
    {
        try {
            statement.executeUpdate("UPDATE "+ORDER_TABLE+" set "+ISAPPROVED+"=1"+" where "+ORDER_ID+"="+o.getOrderId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                int table=resultSet.getInt(TABLE_NUMBER);
                order.setCustomer(db.signIn(id));
                order.setTable(table);
                order.setOrderId(id);
                order.setOrderDate(orderDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}
