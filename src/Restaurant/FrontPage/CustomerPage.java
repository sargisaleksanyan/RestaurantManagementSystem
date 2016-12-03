package Restaurant.FrontPage;

import DataBaseManagment.CustomerDataBase;
import Restaurant.Restaurant;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by sargis on 12/3/16.
 */
public class CustomerPage implements FrontPage  {

    private JButton addCustomer ;
    private JButton findCustomer;
    private JPanel  customerAction;
    private JPanel  registeration;
    private JPanel mainPanel;
    private CustomerDataBase customerDB;
    private JButton action;
    private JTextField name;
    private JTextField lastname;
    private JTextField phone;
    private JTextField creditCard;
    private boolean isAddClicked=false;

    @Override
    public void initlizeView(JPanel jPanel)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
