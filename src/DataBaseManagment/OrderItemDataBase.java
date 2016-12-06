package DataBaseManagment;

import Meal_Menu.MenuItem;
import Order.Order;
import Restaurant.Entity;
import Order.OrderMenuItem;
import java.sql.SQLException;
import java.util.List;


public class OrderItemDataBase extends EntityDataBase {

    public static final String ORDERITEM_TABLE="OrderItem";
    public static final String ORDER_ID="orderId";
    public static final String ORDER_MENUITEM="menuItemName";
    public static final String QUNTITY="quntity";
    @Override
    public boolean insert(Entity e) {
         Order o= (Order) e;
        List<OrderMenuItem> orderItemList=o.getOrderMenuItems();
        try {
            for(int i=0;i<orderItemList.size();i++) {
                OrderMenuItem orderItem=orderItemList.get(i);
                statement.executeUpdate("INSERT INTO " + ORDERITEM_TABLE + "(" + ORDER_ID + "," + ORDER_MENUITEM +
                        "," + QUNTITY + ") VALUES ("
                        + "'" + o.getOrderId() + "', '" + orderItem.getMenuItem().getMenuitemName() + "', '"
                        + orderItem.getAmount() + "');");

            }
        }
        catch (SQLException e1) {
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
}
