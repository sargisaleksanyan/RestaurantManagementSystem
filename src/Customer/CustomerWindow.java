package Customer;

import DataBaseManagment.CustomerDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerWindow extends JFrame implements ActionListener{


    private JButton addCustomer ;
    private JButton findCustomer;
    private JPanel  customerAction;
    private JPanel  registeration;
    private JPanel mainPanel;
    private CustomerDB customerDB;
    private JButton action;
    private JTextField name;
    private JTextField lastname;
    private JTextField phone;
    private boolean isAddClicked=false;
    JLabel errorMessage;
    public CustomerWindow()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.getHeight();
        int x=dim.width*5/10;
        int y=dim.height*8/10;
        this.setLocation(dim.width/2-x/2, dim.height/2-y/2);
        mainPanel=new JPanel();
        customerAction=new JPanel();
        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.add(customerAction);
        customerDB=new CustomerDB();
        add(mainPanel);
        dim.setSize(x, y);
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(dim);
        setTitle("Customer");
        initalButton();

    }
    public void initalButton()
    {

        addCustomer =new JButton("Sign Up");
        addCustomer.setPreferredSize(new Dimension(150,40));
        findCustomer=new JButton("Log in");
        findCustomer.setPreferredSize(new Dimension(150,40));
        findCustomer.addActionListener(this);
        customerAction.setLayout(new GridLayout(3,1));
        customerAction.add(addCustomer);
        customerAction.add(findCustomer);
        addCustomer.addActionListener(this);

    }
    public void initalRegister()
    {

        name =new JTextField();
        name.setPreferredSize(new Dimension(100,20));
        lastname =new JTextField();
        lastname.setPreferredSize(new Dimension(100,20));
        phone =new JTextField();
        phone.setPreferredSize(new Dimension(100,20));
        JLabel nameLabel=new JLabel("FirstName *");
        JLabel lastnameLabel=new JLabel("LastName *");
        JLabel phonelabel=new JLabel("Phone *");
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
        mainPanel.add(registeration);
        validate();
    }
    public void logIn()
    {
        if(registeration!=null)
        {
            mainPanel.remove(registeration);
            registeration=null;
        }

        registeration=new JPanel();
        name =new JTextField();
        name.setPreferredSize(new Dimension(100,20));
        lastname =new JTextField();
        lastname.setPreferredSize(new Dimension(100,20));
        phone =new JTextField();
        phone.setPreferredSize(new Dimension(100,20));
        JLabel nameLabel=new JLabel("FirstName ");
        JLabel lastnameLabel=new JLabel("LastName ");
        JLabel phonelabel=new JLabel("Phone *");
        registeration=new JPanel();
        registeration.setLayout(new GridLayout(5,1));
        registeration.add(nameLabel);
        registeration.add(name);
        registeration.add(lastnameLabel);
        registeration.add(lastname);
        registeration.add(phonelabel);
        registeration.add(phone);
        action=new JButton();
        action.setText("LogIn");
        registeration.add(action);
        action.addActionListener(this);
        mainPanel.add(registeration);

        validate();


    }
    public static void main(String[] args) {

          new CustomerWindow();
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


            logIn();
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

             boolean check =customerDB.signUp(firstName,surName,number);

                if(!check)
                {
                    errorMessage=new    JLabel();
                    errorMessage.setText("Phone number already exists");
                    mainPanel.add(errorMessage);
                    validate();
                }
            }
            else
            {

                int number=0;
                try {
                   number = Integer.parseInt(phone.getText().toString());
                }
                catch (NumberFormatException n)
                {

                }
                name.setText("");
                lastname.setText("");
                phone.setText("");
                String check=customerDB.customerLogIn(number);
                if(check!=null)
               {
                   mainPanel.remove(registeration);
                   registeration=null;
                   this.setTitle(check);
                   validate();
               }
               else
               {
                   errorMessage=new    JLabel();
                   errorMessage.setText("Input is Incorrect");
                   mainPanel.add(errorMessage);
                   validate();
               }
            }
        }
       }
    }

