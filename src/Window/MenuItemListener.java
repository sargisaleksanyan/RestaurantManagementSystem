package Window;

import Meal_Menu.MenuItem;

import javax.swing.*;
import java.awt.event.ActionListener;


public interface MenuItemListener extends ActionListener {

   // public void add();
    public MenuItem getMenuItem();
    public void makeView(JPanel jPanel);
}
