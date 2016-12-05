package Order;

import Customer.Customer;
import Restaurant.Entity;

import java.util.ArrayList;
import java.util.List;

public class Order  implements Entity{

    private int orderId;
    private Customer customer;
    private String orderDate;
    public int approved;

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    private int table ;
    public List<OrderMenuItem> getOrderMenuItems() {
        return orderMenuItems;
    }
    public void setOrderMenuItems(List<OrderMenuItem> orderMenuItems)
    {
        this.orderMenuItems=orderMenuItems;
    }
    private List<OrderMenuItem> orderMenuItems;
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

   /* public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }*/

    @Override
    public int hashCode() {
        return orderId;
    }
    public boolean equals(Object o)
    {
       /* if(this.hashCode()==o.hashCode())
        {
            return true;
        }
        */
        return this.hashCode()==o.hashCode();
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
        if(orderMenuItems==null)
        {
            orderMenuItems= new ArrayList<OrderMenuItem>();
        }
        orderMenuItems.add(orderMenuItem);
    }

}
