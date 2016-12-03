package Restaurant.SignInPage;

import DataBaseManagment.EntityDataBase;
import DataBaseManagment.SigninListener;
import Employee.Employee;
import Restaurant.Entity;
import Restaurant.Restaurant;
import Restaurant.ConstantName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by sargis on 12/3/16.
 */
public class EmployeeSignIn extends SignInPage {

    JTextField phoneField;
    JTextField phoneLabel;
    public EmployeeSignIn(SigninListener db, JPanel jPanel)
    {
        super(db, jPanel);
        setView();
    }

    @Override
    public void setView()
    {
        phoneLabel=new JTextField("Phone");
        phoneLabel.setEditable(false);
        phoneField=new JTextField();
        jPanel.add(phoneLabel);
        jPanel.add(phoneField);
        jPanel.setLayout(new GridLayout(3,1));
    }

   public Entity getEntity()
   {
       String phone=phoneField.getText().toString();
       Employee empoyee= (Employee) signinListener.signIn(phone);
       if(Restaurant.isManagerClciked && empoyee.getPosition()!= ConstantName.MANAGER) {
           return null;
       }
       return empoyee;
   }



}
