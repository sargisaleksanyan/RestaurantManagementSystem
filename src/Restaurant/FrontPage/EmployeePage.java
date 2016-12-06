package Restaurant.FrontPage;

import Restaurant.Entity;
import Employee.Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import Window.*;

public class EmployeePage implements FrontPage {
    private JButton orderButton;
    private JButton ingredientButton;
    private Employee employee;

    //private  java.util.List<MenuItem> menuItemList;
    @Override
    public void initlizeView(JPanel jPanel)
    {

        orderButton=new JButton("Current Order");
        ingredientButton=new JButton("Ingredients");
        jPanel.setLayout(new GridLayout(2,1));
        orderButton.addActionListener(this);
        ingredientButton.addActionListener(this);
        jPanel.add(orderButton);
        jPanel.add(ingredientButton);
    }

    @Override
    public void setEntity(Entity entity) {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==orderButton) {
        new EmployeeOrdersWindow(0.3, 0.75);
        }
        else if(e.getSource()==ingredientButton)
        {
           // new CustomerOrderWindow(customer,0.4,0.75);
        }

    }
}
