package Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by sargis on 10/16/16.
 */
public class CustomerWindow extends JFrame implements ActionListener{


    private JButton addCustomer ;
    private JButton findCustomer;
    private JPanel  customerAction;
    private JPanel  registeration;
    private JButton action;
    JTextField name;
    JTextField lastname;
    JTextField phone;
    boolean isAddClicked=false;
    public CustomerWindow()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        int x=dim.width*5/10;
        int y=dim.height*8/10;
        this.setLocation(dim.width/2-x/2, dim.height/2-y/2);
        dim.setSize(x, y);
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(dim);
        setTitle("Customer");
        initalButton();

    }
    public void initalButton()
    {
        customerAction=new JPanel();
        addCustomer =new JButton("Add a Customer");
        addCustomer.setPreferredSize(new Dimension(150,40));
        findCustomer=new JButton("Find Customer");
        findCustomer.setPreferredSize(new Dimension(150,40));
        findCustomer.addActionListener(this);
        customerAction.setLayout(new GridLayout(3,1));


        customerAction.add(addCustomer);
        customerAction.add(findCustomer);
        add(customerAction);
        addCustomer.addActionListener(this);

    }
    public void initalRegister()
    {

        name =new JTextField();
        name.setPreferredSize(new Dimension(150,20));
        lastname =new JTextField();
        lastname.setPreferredSize(new Dimension(150,20));
         phone =new JTextField();
        phone.setPreferredSize(new Dimension(150,20));
        JLabel nameLabel=new JLabel("FirstName");
        JLabel lastnameLabel=new JLabel("LastName");
        JLabel phonelabel=new JLabel("Phone");

        registeration=new JPanel();
        registeration.setLayout(new GridLayout(4,1));
        registeration.add(nameLabel);
        registeration.add(name);
        registeration.add(lastnameLabel);
        registeration.add(lastname);
        registeration.add(phonelabel);
        registeration.add(phone);
        action=new JButton();
        registeration.add(action);
        action.addActionListener(this);
        add(registeration);

        validate();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
          new CustomerWindow();
    }
     public void find(String name,String surName,int phone)
     {
         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection mycon= DriverManager.getConnection("jdbc:mysql://95.140.195.69:3306/A09155126","A09155126","A09155126");
             Statement myStmt=mycon.createStatement();
             ResultSet myRs=myStmt.executeQuery("select * from Customer where firstName="+"'"+name+"'AND " +
                     "lastName="+"'"+surName+"'AND phone"+"="+phone);
            // (" + "'" + name + "', '" + surName + "', '" + phone+  "');");
             while(myRs.next())
             {
                 System.out.println(myRs.getString("firstName")+myRs.getString("phone"));
             }
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }//'A09155126@37.157.220.18'
         catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
     public void addToDb(String name,String surName,int phone)
     {

         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection mycon= DriverManager.getConnection("jdbc:mysql://95.140.195.69:3306/A09155126","A09155126","A09155126");
             Statement myStmt=mycon.createStatement();

          //  myStmt.executeUpdate("insert into Customer (firstName,lastName,phone) values(sqlName,sqlLastName,+phone+");");
             myStmt.executeUpdate("INSERT INTO Customer (firstName,lastName,phone) VALUES ("
                     + "'" + name + "', '" + surName + "', '" + phone+  "');");
           //  while(myRs.next())

         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }//'A09155126@37.157.220.18'
         catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(addCustomer))
        {

            initalRegister();
            action.setText("Add");
            isAddClicked=true;
            validate();
        }
        else if (e.getSource().equals(findCustomer))
        {
            initalRegister();
            action.setText("Find");
            validate();
            isAddClicked=false;
        }
        else
        {
            if(isAddClicked)
            {
                String firstName=name.getText().toString();
                String surName= lastname.getText().toString();
                int number=Integer.parseInt(phone.getText().toString());
                name.setText("");
                lastname.setText("");
                 phone.setText("");
                addToDb(firstName,surName,number);
            }
            else
            {
                String firstName=name.getText().toString();
                String surName= lastname.getText().toString();
                int number=Integer.parseInt(phone.getText().toString());
                name.setText("");
                lastname.setText("");
                phone.setText("");
                find(firstName,surName,number);
            }
        }
       }
    }

