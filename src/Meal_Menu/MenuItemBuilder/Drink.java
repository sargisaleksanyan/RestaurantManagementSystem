package Meal_Menu.MenuItemBuilder;
import Item.Item;
import Meal_Menu.MenuItem;

public class Drink extends MenuItem{

     private Item item;
    public Drink(String menuitemName, double price) {
        super(menuitemName, price);
    }
    public  void setItem(Item item)
    {
        this.item=item;
    }
    @Override
    public double getCost() {
        return item.getPrice();
    }

}
