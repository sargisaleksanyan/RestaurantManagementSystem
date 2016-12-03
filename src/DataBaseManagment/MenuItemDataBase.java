package DataBaseManagment;

import Meal_Menu.MenuItem;

import Meal_Menu.MenuItemBuilder.Meal;
import Meal_Menu.MenuItemCategory;
import Restaurant.Entity;

import java.sql.SQLException;

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

    @Override
    public <T> boolean update(T... t) {
        return false;
    }

    @Override
    public <T> boolean check(T... t) {
        return false;
    }
}
