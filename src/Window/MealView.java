package Window;

import DataBaseManagment.DataList;
import Item.Item;
import Meal_Menu.MenuItem;
import Meal_Menu.MenuItemBuilder.MealBuilder;
import Meal_Menu.MenuItemCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

/**
 * Created by sargis on 12/2/16.
 */
public class MealView implements MenuItemListener,ItemListener {


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
    private  HashMap <String,Item> itemMaps;
    private MealBuilder mealBuilder;
    private String selectedItem;
    public MealView(JPanel jpanel)
    {
        itemMaps=new HashMap<String,Item>();
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
        jpanel.add(jp);
        jpanel.add(itemList);
        jpanel.add(jLabel);
        itemList.addItemListener(this);
        jpanel.add(amountField);
        ingredientAddButton.addActionListener(this);
        MenuItemWindow.buttonsPanel.add(ingredientAddButton);

    }

    public void addItemsList(java.util.List<Item> items)
    {
        for(int i=0;i<items.size();i++)
        {
            String itemName=items.get(i).getItemName();
            itemList.add(itemName);
            itemMaps.put(itemName,items.get(i));
        }
    }
    public void getValues()
    {
        String foodType=null;
        String menuCategoryName=null;
        if(meatCheckBox.isSelected())
        {
            foodType= MenuItemCategory.MEAT;
        }
        else if(veganCheckBox.isSelected())
        {
            foodType=MenuItemCategory.VEAGAN;
        }
        if(dishCheckBox.isSelected())
        {
            menuCategoryName=MenuItemCategory.MAIN_DISH;
        }
        else if(saladCheckBox.isSelected())
        {
            menuCategoryName=MenuItemCategory.SALAD;
        }
        mealBuilder.setMenuCategoryName(menuCategoryName);
        mealBuilder.setFoodType(foodType);
        mealBuilder.setPrice(Double.parseDouble(priceField.getText().toString()));
        mealBuilder.setMeanuItemName(nameField.getText().toString());

    }
    @Override
    public MenuItem getMenuItem() {
      //  mealBuilder.set
        getValues();
        return mealBuilder.build();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(mealBuilder==null)
        {
            mealBuilder=new MealBuilder();
        }
        double amount=Double.parseDouble(amountField.getText().toString());

        Item item=itemMaps.get(selectedItem);
        mealBuilder.addIgredient(item,amount);
        clearIngredient();
    }
    public void clearIngredient()
    {
        itemList.deselect(itemList.getSelectedIndex());
        amountField.setText("");
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {


        selectedItem=itemList.getSelectedItem();

    }
}
