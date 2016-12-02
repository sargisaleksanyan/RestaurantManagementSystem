package Window;

import DataBaseManagment.EntityDataBase;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * Created by sargis on 11/30/16.
 */
public class MenuItemWindow extends Gui {

  //  private  JTextField  nameField;
  //  private  JTextField  priceField;
    private  JButton     insertButton;
    private  JButton     drinkButton;
    private  JButton     mealButton;
    private  JPanel      menuItemPanel;
//  boolean  isDrinkadd = false;
//  private  JTextField  itemField;
    public static JPanel buttonsPanel;
    public MenuItemWindow(EntityDataBase db, double w, double h)
    {
        super(db, w, h);
        buttonsPanel=new JPanel();
        buttonsPanel.setLayout(new GridLayout(2,1));
    }
    MenuItemListener menuItemListener;
    @Override
    public void insert() {
        db.insert(menuItemListener.getMenuItem());

    }

    public void setMenuItemChoice()
    {
        menuItemPanel=new JPanel();
        menuItemPanel.setLayout(new GridLayout(3,1));
        JTextField space=new JTextField();
        space.setEditable(false);
        mealButton=new JButton("Meal");
        drinkButton=new JButton("Drink");
        mealButton.addActionListener(this);
        drinkButton.addActionListener(this);
        menuItemPanel.add(space);
        menuItemPanel.add(mealButton);
        menuItemPanel.add(drinkButton);
        subPanel.add(menuItemPanel);
        validate();
    }
    public void setView()
    {
        subPanel.remove(menuItemPanel);
        menuItemPanel=null;
        insertButton=new JButton("Insert");
        buttonsPanel.add(insertButton);
        subPanel.add(buttonsPanel);
        insertButton.addActionListener(this);
      //  menuItemListener.makeView(subPanel);
        validate();
    }
    /*public void setDrinkFiled()
    {
        subPanel.remove(menuItemPanel);
        menuItemPanel=null;
     //   isDrinkadd=true;
        menuItemPanel=new JPanel();
        insertButton=new JButton("Insert");
        menuItemPanel.setLayout(new GridLayout(6,1));
        JTextField nameLabel=new JTextField("Name");
        nameLabel.setEditable(false);
        JTextField priceLabel=new JTextField("PriceLabel");
        priceLabel.setEditable(false);
        JTextField itemNameLabel=new JTextField("ItemName");
        priceLabel.setEditable(false);
     //   nameField=new JTextField();
    //    priceField=new JTextField();
    //    itemField=new JTextField();
        menuItemPanel.add(nameLabel);
     //   menuItemPanel.add(nameField);

        menuItemPanel.add(priceLabel);
     //   menuItemPanel.add(priceField);

        menuItemPanel.add(itemNameLabel);
     //   menuItemPanel.add(itemField);
        subPanel.add(menuItemPanel);
        subPanel.add(insertButton);
        insertButton.addActionListener(this);
        validate();
    }*/


    @Override
    public void actionPerformed(ActionEvent act) {

        if(act.getSource()==addButton)
        {
            // setNameField();
            setMenuItemChoice();
        }
        else if (act.getSource()==mealButton)
        {
            menuItemListener=new MealView(subPanel);
           setView();
        }
        else if (act.getSource()==drinkButton)
        {
           // setMealNameField();
            menuItemListener=new DrinkView(subPanel);
            setView();
        }
        else if(act.getSource()==insertButton)
        {
            insert();
        }

    }
}
