package DataBaseManagment;

import Item.PurchasedItem;
import Restaurant.Entity;

import java.sql.SQLException;


public class PurchaseItemDataBase extends EntityDataBase {

    public static final String PURCHASE_ID ="purchaseItemId";
    public static final String PURCHASE_DATE="purchaseDate";
    public static final String PURCHASED_AMOUNT="purchaseAmount";
    public static final String CURRENT_AMOUNT="currentAmount";
    public static final String PURCHASED_TABLE="PurchaseItem";
    public static final String _ITEM_ID="itemId";

    @Override
    public boolean insert(Entity e)
    {
        PurchasedItem purchasedItem= (PurchasedItem) e;
        try {
            statement.executeUpdate("INSERT INTO " + PURCHASED_TABLE + "(" + _ITEM_ID + "," +PURCHASE_DATE  + "," + PURCHASED_AMOUNT +
                    ","+CURRENT_AMOUNT +") VALUES ("
                    + "'" + purchasedItem.getItem().getItemId() + "', '" + purchasedItem.getPurchaseDate() + "', '"
                    + purchasedItem.getPurchaseAmount() +"', '"+purchasedItem.getCurrentAmount()+ "');");
            return true;
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
            return false;
        }



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
