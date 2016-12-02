package DataBaseManagment;


import Restaurant.Entity;
import Item.Item;
import Meal_Menu.MenuItemBuilder.Meal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sargis on 12/2/16.
 */
public class IngredientDataBase extends EntityDataBase{

    public static final String INGREDIENT_TABLE="Ingredient";
    public static final String MENU_ITEM_NAME="menuItemName";
    public static final String ITEM_ID="itemId";
    public static final String AMOUNT="amount";
    @Override
    public boolean insert(Entity e) {
        Meal meal=(Meal)e;
        HashMap<Item,Double> ingredients=meal.getIngredient();
        Set<Item> items=ingredients.keySet();
        Iterator iterator=items.iterator();
        while(iterator.hasNext()) {
            Item item= (Item) iterator.next();
            try {
                statement.executeUpdate("INSERT INTO " + INGREDIENT_TABLE + "(" + MENU_ITEM_NAME + "," + ITEM_ID +
                        "," + AMOUNT + ") VALUES ("
                        + "'" + meal.getMenuitemName() + "', '" + item.getItemId() + "', '"
                         + ingredients.get(item) + "');");
            }

            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        //menuItem.

        return true;
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
