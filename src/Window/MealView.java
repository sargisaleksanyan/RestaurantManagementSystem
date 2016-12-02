package Window;

import DataBaseManagment.DataList;
import Item.Item;
import Meal_Menu.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.util.*;

/**
 * Created by sargis on 12/2/16.
 */
public class MealView implements MenuItemListener {


    private  JTextField  nameField;
    private  JTextField  priceField;
    private  JCheckBox   meatCheckBox;
    private  JCheckBox   veganCheckBox;
    private  JCheckBox   dishCheckBox;
    private  JCheckBox   saladCheckBox;
    private  JTextField  amountField;
    private  JButton     ingredientAddButton;

    private  java.awt.List itemList;
    private  DataList dataList;
    public MealView(JPanel jpanel)
    {
        makeView(jpanel);

    }
    public void makeView(JPanel jpanel)
    {

        dataList=new DataList();
        itemList=new java.awt.List();
        java.util.List<Item> items= dataList.getAllItems();
        addItemsList(items);

        JPanel jp=new JPanel();
        meatCheckBox=new JCheckBox("Meat");
        veganCheckBox=new JCheckBox("Vegen");
        dishCheckBox=new JCheckBox("Dish");
        saladCheckBox=new JCheckBox("Salad");

        ingredientAddButton=new JButton("AddIngredient");
        JTextField nameLabel=new JTextField("Name");
        nameLabel.setEditable(false);
        JTextField priceLabel=new JTextField("PriceLabel");
        priceLabel.setEditable(false);

        nameField=new JTextField();
        priceField=new JTextField();
        amountField=new JTextField();
        jp.add(nameLabel);
        jp.add(nameField);
        jp.add(priceLabel);
        jp.add(priceField);
        jp.add(meatCheckBox);
        jp.add(veganCheckBox);
        jp.add(dishCheckBox);
        jp.add(saladCheckBox);

        jp.setLayout(new GridLayout(9,1));
        JTextField jLabel=new JTextField();
        jLabel.setText("Amount");
        jLabel.setEditable(false);
        //jp.add(new JTextField());

        jpanel.add(jp);

        jpanel.add(itemList);
        jpanel.add(jLabel);
        jpanel.add(amountField);

       // jpanel.add(amountField);
        MenuItemWindow.buttonsPanel.add(ingredientAddButton);
    }

    public void addItemsList(java.util.List<Item> items)
    {
        for(int i=0;i<items.size();i++)
        {
            itemList.add(items.get(i).getItemName());
        }
    }
    @Override
    public MenuItem getMenuItem() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
