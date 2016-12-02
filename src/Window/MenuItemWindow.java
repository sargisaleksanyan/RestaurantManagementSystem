package Window;

import DataBaseManagment.DataList;
import DataBaseManagment.EntityDataBase;
import Item.Item;
import Meal_Menu.MenuItemBuilder.MealBuilder;
import Meal_Menu.MenuItemCategory;
import Window.Ingrediant.Ingrediant;


import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

/**
 * Created by sargis on 11/30/16.
 */
public class MenuItemWindow extends Gui {

    private  JTextField  nameField;
    private  JTextField  priceField;

    private  JButton     insertButton;
    private  JButton     drinkButton;
    private  JButton     mealButton;
    private  java.awt.List itemList;
    private  DataList    dataList;
    private  String      selectedCategory;
    private  JPanel      menuItemPanel;
    boolean  isDrinkadd = false;
    private  JTextField  itemField;
    private  MealBuilder mealBuilder;

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
        menuItemListener=new MealView(subPanel);
        insertButton=new JButton("Insert");
        buttonsPanel.add(insertButton);
        subPanel.add(buttonsPanel);
      //  menuItemListener.makeView(subPanel);
        validate();
    }
    public void setDrinkFiled()
    {
        subPanel.remove(menuItemPanel);
        menuItemPanel=null;
        isDrinkadd=true;
        menuItemPanel=new JPanel();
        insertButton=new JButton("Insert");
        menuItemPanel.setLayout(new GridLayout(6,1));
        JTextField nameLabel=new JTextField("Name");
        nameLabel.setEditable(false);
        JTextField priceLabel=new JTextField("PriceLabel");
        priceLabel.setEditable(false);
        JTextField itemNameLabel=new JTextField("ItemName");
        priceLabel.setEditable(false);
        nameField=new JTextField();
        priceField=new JTextField();
        itemField=new JTextField();
        menuItemPanel.add(nameLabel);
        menuItemPanel.add(nameField);

        menuItemPanel.add(priceLabel);
        menuItemPanel.add(priceField);

        menuItemPanel.add(itemNameLabel);
        menuItemPanel.add(itemField);
        subPanel.add(menuItemPanel);
        subPanel.add(insertButton);
        insertButton.addActionListener(this);
        validate();
    }


    @Override
    public void actionPerformed(ActionEvent act) {

        if(act.getSource()==addButton)
        {
            // setNameField();
            setMenuItemChoice();
        }
        else if (act.getSource()==mealButton)
        {
           setView();
        }
        else if (act.getSource()==drinkButton)
        {
           // setMealNameField();
            setDrinkFiled();
        }
    }
}
