package Meal_Menu.MenuItemBuilder;
import Item.Item;
import Meal_Menu.MenuItem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sargis on 11/30/16.
 */
public class Meal extends MenuItem {
    private  String foodType;
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    private static HashMap<Item,Double> ingredient;// =new HashMap<Item,Double>();
    public Meal(String menuitemName, double price, String menuCategoryName)
    {
      super(menuitemName,price,menuCategoryName);
    }
    public Meal()
    {

    }
    public HashMap<Item,Double> getIngredient()
    {
        return ingredient;
    }

   public void addItem(Item item,Double amount)
   {
       if(ingredient==null)
       {
           ingredient =new HashMap<Item,Double>();
       }
      ingredient.put(item,amount);
   }

    @Override
    public double getCost()
    {
        Set<Item> set= ingredient.keySet();
        Iterator iterator=set.iterator();
        double sum=0;
        while(iterator.hasNext())
        {
            Item i= (Item) iterator.next();
            sum=sum+i.getPrice()*ingredient.get(i);
        }
      return sum;
        //Set<Item> items=
    }

    public static void main(String[] args) {

    }

}
