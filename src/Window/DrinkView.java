package Window;

import DataBaseManagment.ItemDataBase;
import Meal_Menu.MenuItem;
import Item.Item;
import Meal_Menu.MenuItemBuilder.Drink;
import Meal_Menu.MenuItemCategory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class DrinkView implements MenuItemListener {
    private JTextField  nameField;
    private JTextField  priceField;
    private JTextField  itemField;
    private ItemDataBase itemDataBase;

    public DrinkView(JPanel jPanel)
    {
        makeView(jPanel);
    }


    @Override
    public MenuItem getMenuItem() {
     ;
        String name=nameField.getText().toString();
        double price=Double.parseDouble(priceField.getText().toString());
        String itemName=itemField.getText().toString();
        Item item =itemDataBase.getItemByName(itemName);
        Drink drink=new Drink(name,price);
        drink.setMenuCategoryName(MenuItemCategory.DRINK);
        drink.setItem(item);
        clearFields();
        return drink;
    }
   public void clearFields()
   {
         nameField.setText("");
         priceField.setText("");
         itemField.setText("");
   }

    @Override
    public void makeView(JPanel jPanel) {
        nameField=new JTextField();
        priceField=new JTextField();
        itemField=new JTextField();
        itemDataBase=new ItemDataBase();
        JPanel jp=new JPanel();
        JTextField nameLabel=new JTextField("Name");
        nameLabel.setEditable(false);
        JTextField priceLabel=new JTextField("Price");
        priceLabel.setEditable(false);
        JTextField itemNameLabel=new JTextField("ItemName");
        itemNameLabel.setEditable(false);
        nameField=new JTextField();
        priceField=new JTextField();
        itemField=new JTextField();
        jp.setLayout(new GridLayout(6,1));
        jp.add(nameLabel);
        jp.add(nameField);

        jp.add(priceLabel);
        jp.add(priceField);

        jp.add(itemNameLabel);
        jp.add(itemField);
        jPanel.add(jp);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
