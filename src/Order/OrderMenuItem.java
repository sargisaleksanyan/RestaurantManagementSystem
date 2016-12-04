package Order;

import Meal_Menu.MenuItem;

/**
 * Created by sargis on 12/4/16.
 */
public class OrderMenuItem {

    private MenuItem menuItem;
    private int amount;
    public OrderMenuItem(MenuItem menuItem, int amount)
    {
       this.menuItem=menuItem;
       this.amount=amount;
    }
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
