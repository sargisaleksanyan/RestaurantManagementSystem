package Restaurant.FrontPage;

import Restaurant.FrontPage.FrontPage;
import Restaurant.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import  Window.MenuItemWindow;
import  Window.MenuWindow;
import  Customer.CustomerWindow;
import  Window.EmployeeWindow;
import  Window.SupplierWindow;
import  Window.ItemsWindow;
import  Window.*;
import  DataBaseManagment.*;
/**
 * Created by sargis on 12/3/16.
 */
public class ManagerPage implements FrontPage {

    private JButton menu ;
    private JButton customer ;
    private JButton order;
    private JButton item;
    private JButton employee;
    private JButton supplier;
    private JButton storage;
    private JButton menuItem;


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(menu))
        {
            MenuWindow m=new MenuWindow();
        }
        else if(e.getSource().equals(customer))
        {
            CustomerWindow c=new CustomerWindow ();
        }
        else if(e.getSource().equals(item))
        {
            new ItemsWindow(new ItemDataBase(),0.3,0.7);
        }
        else if(e.getSource().equals(order))
        {
            //OrderWindow orderWindow=new OrderWindow(new OrderDataBase());
        }
        else if(e.getSource().equals(supplier))
        {
            new SupplierWindow(new SupplierDataBase(),0.3,0.7);
        }
        else if(e.getSource().equals(storage))
        {
            new PurchaseWindow(new PurchaseItemDataBase(),0.3,0.7);
        }
        else if(e.getSource().equals(menuItem))
        {
            new MenuItemWindow(new MenuItemDataBase(),0.3,0.7);
        }
    }


    @Override
    public void initlizeView(JPanel menuPanel) {
        menu    =new JButton("Menu");

        customer=new JButton("Customers");

        order   =new JButton("Orders");
        menuItem=new JButton("MenuItem");
        employee=new JButton("Empoyee");
        supplier=new JButton("Supplier");

        item    =new JButton("Items");
        storage=new JButton("Storage");


        menuPanel.setLayout(new GridLayout(8,1));
        menuPanel.add(menu);
        menuPanel.add(menuItem);
        menuPanel.add(storage);
        menuPanel.add(customer);
        menuPanel.add(order);
        menuPanel.add(item);
        menuPanel.add(employee);
        menuPanel.add(supplier);
        //   add(menuPanel);
        menuItem.addActionListener(this);
        item.addActionListener(this);
        customer.addActionListener(this);
        menu.addActionListener(this);
        order.addActionListener(this);
        employee.addActionListener(this);
        supplier.addActionListener(this);
        storage.addActionListener(this);
    }
}
