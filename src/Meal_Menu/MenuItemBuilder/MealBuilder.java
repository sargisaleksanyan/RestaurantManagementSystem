package Meal_Menu.MenuItemBuilder;
import Item.Item;
/**
 * Created by sargis on 12/1/16.
 */
public class MealBuilder {

    private  Meal meal;
    public MealBuilder( String menuitemName, double price,String menuCategoryName)
    {
        meal=new Meal(menuitemName,price,menuCategoryName);
    }

    public MealBuilder()
    {
       meal=new Meal();
    }
    public void setMeanuItemName(String meanuItemName)
    {
        meal.setMenuitemName(meanuItemName);
    }
    public void setPrice(double price)
    {
        meal.setPrice(price);
    }
    public void setMenuCategoryName(String menuCategoryName)
    {
        meal.setMenuCategoryName(menuCategoryName);
    }
    public Meal setMenuItemId(int menuItemId)
    {
        meal.setMenuItemId(menuItemId);
        return meal;
    }
    public Meal setFoodType(String foodtype)
    {
        meal.setFoodType(foodtype);
        return  meal;
    }
    public void addIgredient(Item item,double amount)
    {
      meal.addItem(item,amount);
    }

    public Meal build()
    {
        return meal;
    }
}
