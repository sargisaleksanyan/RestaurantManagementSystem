package Window;

import DataBaseManagment.EntityDataBase;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class MenuItemWindow extends Gui {

    private  JButton     insertButton;
    private  JButton     drinkButton;
    private  JButton     mealButton;
    private  JPanel      menuItemPanel;
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
