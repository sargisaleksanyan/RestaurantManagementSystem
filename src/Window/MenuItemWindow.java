package Window;

import DataBaseManagment.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by sargis on 11/30/16.
 */
public class MenuItemWindow extends Gui {

    private  JTextField nameField;
    private  JTextField priceField;
    private  JButton insertButton;
    //private  JCheckBox
    private  java.awt.List categoryList;
    private  JCheckBox   jCheckBox1;
    private  JCheckBox   jCheckBox2;
    private  String menuItemCategory[]={"dish","salad","drink"};
    public MenuItemWindow(DataBase db, double w, double h)
    {
        super(db, w, h);
    }

    @Override
    public void insert() {

    }
    public void setNameField()
    {
        JTextField nameLabel=new JTextField("Name");
        nameLabel.setEditable(false);
        JTextField priceLabel=new JTextField("PriceLabel");
        priceLabel.setEditable(false);
        JPanel fieldPanel=new JPanel();
        nameField=new JTextField();
        priceField=new JTextField();
        insertButton=new JButton("Insert");
        insertButton.addActionListener(this);
        fieldPanel.setLayout(new GridLayout(6,1));
        jCheckBox1=new JCheckBox("Meat");
        jCheckBox2=new JCheckBox("Veget");
        categoryList=new java.awt.List();
        categoryList.add("Dish");
        categoryList.add("Salad");
        categoryList.add("Drink");
        fieldPanel.add(nameLabel);
        fieldPanel.add(nameField);
        fieldPanel.add(priceLabel);
        fieldPanel.add(priceField);
        fieldPanel.add(jCheckBox1);
        fieldPanel.add(jCheckBox2);
        subPanel.add(categoryList);

        subPanel.add(fieldPanel);
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent act) {

        if(act.getSource()==addButton)
        {
          setNameField();
        }
    }
}
