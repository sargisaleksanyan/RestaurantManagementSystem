package Order;

import Customer.Customer;
import Restaurant.Entity;

import java.util.ArrayList;
import java.util.List;

public class Order  implements Entity{

    private int OrderId;
    private Customer customer;
    private String orderDate;
    private boolean approved;

    public List<OrderMenuItem> getOrderMenuItems() {
        return orderMenuItems;
    }



    private List<OrderMenuItem> orderMenuItems;
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }



    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getBill() {
        double bill=0;
        for(OrderMenuItem o:orderMenuItems )
        {
            bill+=o.getMenuItem().getPrice()*o.getAmount();
        }
        return bill;
    }

    /*public void setBill(double bill) {
        this.bill = bill;
    }*/

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }


    public Order()
    {

    }
    public Order(Customer customer)
    {
        this.customer=customer;
    }
    public void addItem(OrderMenuItem orderMenuItem)
    {
        if(orderMenuItem==null)
        {
            orderMenuItems= new ArrayList<OrderMenuItem>();
        }
        orderMenuItems.add(orderMenuItem);
    }

}
