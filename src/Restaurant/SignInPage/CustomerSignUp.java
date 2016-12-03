package Restaurant.SignInPage;

import Customer.Customer;
import DataBaseManagment.CustomerDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sargis on 12/3/16.
 */
public class CustomerSignUp implements ActionListener{
    private JButton insertCustomer ;

    private JPanel jpanel;
    private CustomerDataBase customerDB;

    private JTextField name;
    private JTextField lastname;
    private JTextField phone;
    private JTextField creditCard;
    private boolean isAddClicked=false;
    public CustomerSignUp(JPanel jpanel)
    {
         this.jpanel=jpanel;

         initButtons();
        customerDB=new CustomerDataBase();
    }
    public void initButtons()
    {
        jpanel.setLayout(new GridLayout(10,1));
        name =new JTextField();
        name.setPreferredSize(new Dimension(100,20));
        lastname =new JTextField();
        lastname.setPreferredSize(new Dimension(100,20));
        phone =new JTextField();
        phone.setPreferredSize(new Dimension(100,20));
        JTextField nameLabel=new JTextField("Name");
        nameLabel.setEditable(false);
        JTextField lastnameLabel=new  JTextField("LastName");
        lastnameLabel.setEditable(false);
        JTextField phonelabel=new  JTextField("Phone");
        phonelabel.setEditable(false);
        JTextField creditCardLable=new  JTextField("CreditCard");
        creditCardLable.setEditable(false);
        creditCard=new JTextField();
        insertCustomer=new JButton("Insert");
        insertCustomer.addActionListener(this);
       // jpanel.setLayout(new GridLayout(5,1));
        jpanel.add(nameLabel);
        jpanel.add(name);
        jpanel.add(lastnameLabel);
        jpanel.add(lastname);
        jpanel.add(phonelabel);
        jpanel.add(phone);
        jpanel.add(creditCardLable);
        jpanel.add(creditCard);
        jpanel.add(insertCustomer);
      //  jpanel.validate();
    }
  public void enterTheMainPage()
  {
      String firstName=name.getText().toString();
      String surName= lastname.getText().toString();
      String phoneNumber=phone.getText().toString();
      String credit=creditCard.getText().toString();
      Customer customer=new Customer(firstName,surName,phoneNumber);
      customer.setCreditCard(credit);
      if(customerDB.insert(customer))
      {
            jpanel.removeAll();
      }
  }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       enterTheMainPage();
    }
}
