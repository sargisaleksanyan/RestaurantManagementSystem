package DataBaseManagment;

import Meal_Menu.MenuItem;

import Meal_Menu.MenuItemBuilder.Drink;
import Meal_Menu.MenuItemBuilder.Meal;
import Meal_Menu.MenuItemBuilder.MealBuilder;
import Meal_Menu.MenuItemCategory;
import Order.Order;
import Restaurant.Entity;
import Item.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sargis on 11/29/16.
 */
public class MenuItemDataBase extends EntityDataBase {
    public static final String MI_NAME="name";
    public static final String MI_PRICE="price";
    public static final String MI_CATEGORYNAME="categoryName";
    public static final String MI_FOODTYPE="foodtype";
    public static final String MENU_ITEM_TABLE="MenuItem";
    private IngredientDataBase ingredientDataBase;
    @Override
    public boolean insert(Entity e)
    {
        MenuItem mi= (MenuItem) e;

            try
            {
                if(mi.getMenuCategoryName()== MenuItemCategory.DRINK) {
                    statement.executeUpdate("INSERT INTO " + MENU_ITEM_TABLE + "(" + MI_NAME + "," + MI_PRICE +
                            "," + MI_CATEGORYNAME + ") VALUES ("
                            + "'" + mi.getMenuitemName() + "', '" + mi.getPrice() + "', '"
                            + mi.getMenuCategoryName() + "');");
                    return true;
                }
                else
                {
                    Meal m=(Meal)mi;
                    ingredientDataBase=new IngredientDataBase();

                    statement.executeUpdate("INSERT INTO " + MENU_ITEM_TABLE + "(" + MI_NAME + "," + MI_PRICE +
                            "," + MI_CATEGORYNAME +","+MI_FOODTYPE+ ") VALUES ("
                            + "'" + m.getMenuitemName() + "', '" + m.getPrice() + "', '"
                            + m.getMenuCategoryName() +"', '"+m.getFoodType()+ "');");
                    ingredientDataBase.insert(m);

                    return true;
                }
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }

        return false;
    }
    public synchronized MenuItem getMenuItem(String menuItemName)
    {
        MenuItem menuItem=null;
        ResultSet resultSet;
        MealBuilder mealBuilder=null;

        try {
            resultSet=statement.executeQuery("select * from "+MENU_ITEM_TABLE+" where "+MI_NAME
                    +"="+" '"+menuItemName+"'");
            while(resultSet.next())
            {
                String menuItemCategory=resultSet.getString(MI_CATEGORYNAME);
                double price=resultSet.getDouble(MI_PRICE);
                if(menuItemCategory.equals(MenuItemCategory.DRINK))
                {
                    menuItem=new Drink(menuItemName,price);
                    menuItem.setMenuCategoryName(menuItemCategory);
                    return  menuItem;
                }
                else
                {

                 mealBuilder =new MealBuilder();
                    String foodtype=resultSet.getString(MI_FOODTYPE);
                    if(foodtype!=null)
                    {
                        mealBuilder.setFoodType(foodtype);
                    }
                    mealBuilder.setMenuCategoryName(menuItemCategory);
                    mealBuilder.setMeanuItemName(menuItemName);
                    mealBuilder.setPrice(price);


                    //menuItem=mealBuilder.build();

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HashMap<Item,Double> ingredients=getIngredients(menuItemName);
        Set<Item> items=ingredients.keySet();
        Iterator iterator=items.iterator();
        while(iterator.hasNext())
        {
            Item item= (Item) iterator.next();
            mealBuilder.addIgredient(item,ingredients.get(item));
        }
        menuItem=mealBuilder.build();

        return menuItem;
    }


    public  synchronized HashMap<Item,Double> getIngredients(String menuItemName)
    {
       HashMap<Item,Double> ingredients=new HashMap<Item, Double>();
        ItemDataBase itemDataBase=new ItemDataBase();
        ResultSet resultSet;
        try {
            resultSet=statement.executeQuery("select * from "+IngredientDataBase.INGREDIENT_TABLE+" where "+
                    IngredientDataBase.MENU_ITEM_NAME
                    +"="+" '"+menuItemName+"'");
            while(resultSet.next())
            {
                int item_id=resultSet.getInt(IngredientDataBase.ITEM_ID);
                double amount=resultSet.getDouble(IngredientDataBase.AMOUNT);
                Item item=itemDataBase.getItemByID(item_id);
                ingredients.put(item,amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredients;
    }
    @Override
    public <T> boolean update(T... t) {
        return false;
    }

    @Override
    public <T> boolean check(T... t) {
        return false;
    }
}
