package Meal_Menu;
import Item.Item;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sargis on 11/30/16.
 */
public class Meal extends MenuItem{
    private  String foodType;
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


    private static HashMap<Item,Double> ingredient =new HashMap<Item,Double>();

    private Meal(String menuitemName, double price, String menuCategoryName)
    {
        super(menuitemName, price, menuCategoryName);
    }
   public void addItem(Item item,Double amount)
   {
      ingredient.put(item,amount);
   }

    @Override
    public double getCost()
    {
      return 1;
        //Set<Item> items=
    }

    public static void main(String[] args) {
        Set<Item> set= ingredient.keySet();
    }

}
