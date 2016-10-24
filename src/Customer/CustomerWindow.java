package Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sargis on 10/16/16.
 */
public class CustomerWindow extends JFrame implements ActionListener{


    private JButton addCustomer ;
    private JButton findCustomer;
    private JPanel  customerAction;
    private JPanel  registeration;
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
        customerAction.setLayout(new GridLayout(2,1));

        customerAction.add(addCustomer);
        customerAction.add(findCustomer);
        add(customerAction);
        addCustomer.addActionListener(this);

    }
    public void initalRegister()
    {

        JTextField name =new JTextField();
        name.setPreferredSize(new Dimension(150,20));
        JTextField lastname =new JTextField();
        lastname.setPreferredSize(new Dimension(150,20));
        JTextField phone =new JTextField();
        phone.setPreferredSize(new Dimension(150,20));
        JLabel nameLabel=new JLabel("FirstName");
        JLabel lastnameLabel=new JLabel("LastName");
        JLabel phonelabel=new JLabel("Phone");

        registeration=new JPanel();
        registeration.setLayout(new GridLayout(3,2));
        registeration.add(nameLabel);
        registeration.add(name);
        registeration.add(lastnameLabel);
        registeration.add(lastname);
        registeration.add(phonelabel);
        registeration.add(phone);
        add(registeration);

        validate();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
          new CustomerWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

          initalRegister();


        }
    }

