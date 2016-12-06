package Restaurant.FrontPage;

import Customer.Customer;
import DataBaseManagment.CustomerDataBase;
import DataBaseManagment.DataList;
import Meal_Menu.*;
import Meal_Menu.MenuItem;
import Restaurant.*;
import Window.Menu.MenuWindow;
import Window.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class CustomerPage implements FrontPage  {


    private JButton orderButton;
    private JButton menuButton;
    private Customer customer;

    private  java.util.List<MenuItem> menuItemList;
    public Customer getCustomer() {
        return customer;
    }

    public void setEntity(Entity customer) {
        this.customer = (Customer) customer;
    }




    @Override
    public void initlizeView(JPanel jPanel)
    {

        orderButton=new JButton("Order");
        menuButton=new JButton("Menu");
        jPanel.setLayout(new GridLayout(2,1));
        orderButton.addActionListener(this);
        menuButton.addActionListener(this);
        jPanel.add(orderButton);
        jPanel.add(menuButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==menuButton) {
            new MenuWindow(customer, 0.4, 0.75);
        }
        else if(e.getSource()==orderButton)
        {
            new CustomerOrderWindow(customer,0.4,0.75);
        }

    }
}
