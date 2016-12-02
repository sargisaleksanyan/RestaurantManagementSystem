package Window;

import DataBaseManagment.EntityDataBase;
import Supplier.Supplier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by sargis on 11/29/16.
 */
public class SupplierWindow extends Gui {

    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField phoneField;
    private JPanel supplerPanel;

    private  JButton insertButton;
    public SupplierWindow(EntityDataBase db, double w, double h)
    {

        super(db, w, h);
        setTitle("Supplier");
    }
    @Override
    public void insert()
    {
        String name=nameField.getText().toString();
        String lastName=lastNameField.getText().toString();
        String  phone=phoneField.getText().toString();
        Supplier supplier=new Supplier(name,lastName,phone);
        db.insert(supplier);
        clearFields();
        validate();

    }


    public void clearFields()
    {
        nameField.setText("");
        lastNameField.setText("");
        phoneField.setText("");
    }
   public void addFieldToSupplier()
   {
       supplerPanel=new JPanel();
       supplerPanel.setLayout(new GridLayout(4,1));
       JLabel nameLabel=new JLabel("Name");
       JLabel lastNameLabel=new JLabel("LastName");
       JLabel phoneLabel=new JLabel("Phone");
       nameField=new JTextField();
       lastNameField=new JTextField();
       phoneField=new JTextField();
       insertButton=new JButton("Insert");
       supplerPanel.add(nameLabel);
       supplerPanel.add(nameField);
       supplerPanel.add(lastNameLabel);
       supplerPanel.add(lastNameField);
       supplerPanel.add(phoneLabel);
       supplerPanel.add(phoneField);
       supplerPanel.add(insertButton);
       insertButton.addActionListener(this);
       subPanel.add(supplerPanel);
       validate();
       mainPanel.repaint();
       clearFields();
   }

    @Override
    public void actionPerformed(ActionEvent act) {
        if(act.getSource()==addButton)
        {
            addFieldToSupplier();
        }
        else if(act.getSource()==insertButton)
        {
          insert();
        }
    }
}
